package lk.ijse.web.web_pos_backend.dto.impl;

import lk.ijse.web.web_pos_backend.customObj.OrderResponse;
import lk.ijse.web.web_pos_backend.dto.SuperDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.validation.annotation.Validated;


import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO implements SuperDTO, OrderResponse {
    private String orderId;
    private String customerId;


    private List<OrderDetailsDTO> orderDetails;
}