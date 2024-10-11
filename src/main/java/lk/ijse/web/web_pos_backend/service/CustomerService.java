package lk.ijse.web.web_pos_backend.service;

import lk.ijse.web.web_pos_backend.customObj.CustomerResponse;
import lk.ijse.web.web_pos_backend.dto.impl.CustomerDTO;

import java.util.List;

public interface CustomerService {
    void saveCustomer(CustomerDTO customerDTO);

    void updateCustomer(String customerId, CustomerDTO customerDTO);

    void deleteCustomer(String customerId);

    CustomerResponse getSelectCustomer(String customerId);

    List<CustomerDTO> getAllCustomers();

}
