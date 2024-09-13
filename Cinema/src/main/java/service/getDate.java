package service;

import java.text.SimpleDateFormat;
import java.util.Date;

public class getDate {

    public static String toDateTime(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return dateFormat.format(date);
    }

   
    public static void main(String[] args) {       
        Date now = new Date();  
        String formattedDateTime = toDateTime(now);
        System.out.println("Formatted Date and Time: " + formattedDateTime);
    }
}

