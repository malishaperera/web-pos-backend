package lk.ijse.web.web_pos_backend.dto.impl;

import lk.ijse.web.web_pos_backend.dto.SuperDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailsDTO implements SuperDTO {
    private String itemId;
    private String itemName;
    private int itemQuantity;
    private double itemPrice;
    private double totalPrice;
    private int discount;
}
