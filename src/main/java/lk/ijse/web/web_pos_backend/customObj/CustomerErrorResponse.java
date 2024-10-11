package lk.ijse.web.web_pos_backend.customObj;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerErrorResponse implements CustomerResponse,Serializable {
    private int errorCode;
    public String errorMessage;
}
