package lk.ijse.web.web_pos_backend.service;


import lk.ijse.web.web_pos_backend.dao.ItemDao;
import lk.ijse.web.web_pos_backend.dto.impl.ItemDTO;
import lk.ijse.web.web_pos_backend.entity.ItemEntity;
import lk.ijse.web.web_pos_backend.exception.DataPersistFailedException;
import lk.ijse.web.web_pos_backend.util.AppUtil;
import lk.ijse.web.web_pos_backend.util.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    @Autowired
    private final ItemDao itemDao;

    @Autowired
    private final Mapping mapping;

    @Override
    public void saveItem(ItemDTO itemDTO) {

        itemDTO.setItemId(AppUtil.createItemID());
        ItemEntity saveItem = itemDao.save(mapping.convertToItemEntity(itemDTO));

        if (saveItem == null) {
            throw new DataPersistFailedException("Cannot data saved");
        }
        System.out.println("Saving ItemEntity:"+saveItem.getItemId()+saveItem.getItemName()+saveItem.getItemPrice()+saveItem.getItemQuantity()+saveItem.getItemCategory());

    }
}