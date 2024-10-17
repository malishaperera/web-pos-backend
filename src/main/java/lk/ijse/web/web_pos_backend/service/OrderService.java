package lk.ijse.web.web_pos_backend.service;

import lk.ijse.web.web_pos_backend.dto.impl.OrderDTO;

public interface OrderService {
    void saveOrder(OrderDTO orderDTO);
}
