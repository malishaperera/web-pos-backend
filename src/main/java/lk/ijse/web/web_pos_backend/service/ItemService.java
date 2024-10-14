package lk.ijse.web.web_pos_backend.service;

import lk.ijse.web.web_pos_backend.customObj.ItemResponse;
import lk.ijse.web.web_pos_backend.dto.impl.ItemDTO;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemService {

    void saveItem(ItemDTO itemDTO);

    List<ItemDTO> getAllItems();


    void updateItem(ItemDTO updateItem);

    void deleteItem(String itemId);

    ItemResponse getSelectItem(String itemId);
}