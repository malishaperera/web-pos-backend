package lk.ijse.web.web_pos_backend.dao;

import lk.ijse.web.web_pos_backend.entity.OrderDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailsDao extends JpaRepository<OrderDetailsEntity, String> {
}
