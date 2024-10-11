package lk.ijse.web.web_pos_backend.dto.impl;


import lk.ijse.web.web_pos_backend.customObj.CustomerResponse;
import lk.ijse.web.web_pos_backend.dto.SuperDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO implements SuperDTO, CustomerResponse{
    private String customerId;
    private String customerName;
    private String customerAddress;
    private String customerMobile;
}
