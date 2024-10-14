package lk.ijse.web.web_pos_backend.util;

import lk.ijse.web.web_pos_backend.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Base64;

@Component
public class AppUtil {

    private static ItemService itemService;


    public static String generateNextCustomerId(String lastCustomerId) {
        if (lastCustomerId != null && lastCustomerId.startsWith("CUS-")) {
            int lastIdNumber = Integer.parseInt(lastCustomerId.substring(4));
            return String.format("CUS-%03d", lastIdNumber + 1);
        }
        return "CUS-001";
    }


    public static String generateNextItemId(String lastItemId) {
        if (lastItemId != null && lastItemId.startsWith("ItE-")) {
            int lastIdNumber = Integer.parseInt(lastItemId.substring(4));
            return String.format("ItE-%03d", lastIdNumber + 1);
        }
        return "ItE-001";
    }

    public static String toBase64ProfilePic(String profilePic){
        //used to java Base64 class, and profilePic convert Base64 encode
        return Base64.getEncoder().encodeToString(profilePic.getBytes());
    }
}
