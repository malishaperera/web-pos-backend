package lk.ijse.web.web_pos_backend.customObj;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderErrorResponse implements Serializable,OrderResponse {
    private int errorCode;
    public String errorMessage;
}
