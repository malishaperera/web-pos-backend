package lk.ijse.web.web_pos_backend.dao;

import lk.ijse.web.web_pos_backend.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemDao extends JpaRepository<ItemEntity,String> {
    ItemEntity getItemEntityByItemId(String itemId);
}