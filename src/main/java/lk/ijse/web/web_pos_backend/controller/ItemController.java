package lk.ijse.web.web_pos_backend.controller;


import lk.ijse.web.web_pos_backend.dto.impl.ItemDTO;
import lk.ijse.web.web_pos_backend.exception.DataPersistFailedException;
import lk.ijse.web.web_pos_backend.service.ItemService;
import lk.ijse.web.web_pos_backend.util.AppUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.util.Arrays;

@RestController
@RequestMapping("/api/v1/items")
@RequiredArgsConstructor
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/health")
    public String healthCheck(){
        return "Item is running";
    }


    //Save Item
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> sveItem(

            @RequestPart("itemName") String itemName,
            @RequestPart("itemPrice") String itemPrice,
            @RequestPart("itemQuantity") String itemQuantity,
            @RequestPart("itemCategory") String itemCategory,
            @RequestPart("itemImage") MultipartFile itemImage) {

        // Handle profile pic
        try {
            byte[] imageByteCollection = itemImage.getBytes();
            String base64ProfilePic = AppUtil.toBase64ProfilePic(Arrays.toString(imageByteCollection));
            // build the user object
            ItemDTO buildUserDTO = new ItemDTO();
            buildUserDTO.setItemName(itemName);
            buildUserDTO.setItemPrice(Integer.parseInt(itemPrice));
            buildUserDTO.setItemQuantity(Integer.parseInt(itemQuantity));
            buildUserDTO.setItemCategory(itemCategory);
            buildUserDTO.setItemImage(base64ProfilePic);

            //send to the service layer
            itemService.saveItem(buildUserDTO);

            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (DataPersistFailedException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
