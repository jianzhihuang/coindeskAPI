package com.example.coinapi.coindeskAPI;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Component
@Data
public class Time {
    private String updated;
    private String updatedISO;
    private String updateduk;

     public String updatedTimeTransfer(String stringDateTime){
         DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("MMM dd, yyyy HH:mm:ss z", Locale.US);
         LocalDateTime localDateTime = LocalDateTime.parse(stringDateTime, inputFormat);
         DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss").withZone(ZoneOffset.UTC);
         return localDateTime.format(outputFormat);
    }

    public String updatedISOTimeTransfer(String stringDateTime){
        ZonedDateTime result = ZonedDateTime.parse(stringDateTime, DateTimeFormatter.ISO_DATE_TIME);
        LocalDateTime localDateTime = result.toLocalDateTime();
        DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        return localDateTime.format(outputFormat);
    }

    public String updatedukTimeTransfer(String stringDateTime){

         String str = stringDateTime.replace("at","").replace("BST","");
         DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("MMM dd, yyyy  HH:mm ",Locale.US).withZone(ZoneId.of("Asia/Dhaka"));
         ZonedDateTime zdt = ZonedDateTime.parse(str, inputFormat);
         DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss").withZone(ZoneId.of("Asia/Dhaka"));
         return zdt.format(outputFormat);
    }

}
