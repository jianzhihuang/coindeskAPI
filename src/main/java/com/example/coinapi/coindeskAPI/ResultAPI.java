package com.example.coinapi.coindeskAPI;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class ResultAPI {
    private Time time;
    private Bpi bpi;
    private String disclaimer;
    private String chartName;

}
