package lk.ijse.web.web_pos_backend.entity;

import jakarta.persistence.*;
import lk.ijse.web.web_pos_backend.embedded.OrderDetailsPK;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import java.sql.Timestamp;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "order_details")
public class OrderDetailsEntity {

    @EmbeddedId
    private OrderDetailsPK orderDetailsPK;

    @ManyToOne
    @MapsId("orderId")
    @JoinColumn(name = "orderId")
    private OrderEntity order;

    @ManyToOne
    @MapsId("itemId")
    @JoinColumn(name = "itemId")
    private ItemEntity item;

    private int itemQuantity;

    private double itemPrice;

    private double totalPrice;

    private int discount;


}