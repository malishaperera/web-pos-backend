package lk.ijse.web.web_pos_backend.util;

import java.util.Base64;

public class AppUtil {
    private static int customerCounter = 0;
    private static int itemCounter = 0;

    public static String createCustomerID(){
        customerCounter++;
        return String.format("CUS-%03d", customerCounter);
    }


    public static String createItemID(){
        itemCounter++;
        return String.format("ITE-%03d", itemCounter);
    }

    public static String toBase64ProfilePic(String profilePic){
        return Base64.getEncoder().encodeToString(profilePic.getBytes());//used to java Base64 class, and profilePic convert Base64 encode
    }
    //mapping
}
