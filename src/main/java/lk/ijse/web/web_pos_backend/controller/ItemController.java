package lk.ijse.web.web_pos_backend.controller;


import lk.ijse.web.web_pos_backend.customObj.ItemResponse;
import lk.ijse.web.web_pos_backend.dto.impl.ItemDTO;
import lk.ijse.web.web_pos_backend.exception.DataPersistFailedException;
import lk.ijse.web.web_pos_backend.exception.ItemNotFoundException;
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
import java.util.List;

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

    //Update Item
    @PatchMapping(value = "/{itemId}",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> updateItem(
            @PathVariable("itemId") String  itemId,
            @RequestPart("updateItemName") String updateItemName,
            @RequestPart("updateItemPrice") String updateItemPrice,
            @RequestPart("updateItemQuantity") String updateItemQuantity,
            @RequestPart("updateItemCategory") String updateItemCategory,
            @RequestPart("updateItemImage") MultipartFile updateItemImage)
    {
        try {
             byte[] useImage = updateItemImage.getBytes();
             String base64ItemPic = AppUtil.toBase64ProfilePic(Arrays.toString(useImage));
             var updateItem = new ItemDTO();
             updateItem.setItemId(itemId);
             updateItem.setItemName(updateItemName);
             updateItem.setItemPrice(Integer.parseInt(updateItemPrice));
             updateItem.setItemQuantity(Integer.parseInt(updateItemQuantity));
             updateItem.setItemCategory(updateItemCategory);
             updateItem.setItemImage(base64ItemPic);
             itemService.updateItem(updateItem);
             return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (ItemNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Delete Item
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") String itemId) {
        try {
            itemService.deleteItem(itemId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (ItemNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Get Item
    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ItemResponse getSelectedItem(@PathVariable ("id") String itemId){
        return itemService.getSelectItem(itemId);
    }

    //Get All Item
    @GetMapping(value = "allItems", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ItemDTO> getAllItems() {
        return itemService.getAllItems();
    }
}