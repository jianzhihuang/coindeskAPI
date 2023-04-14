package com.example.coinapi.coindeskAPI;


import com.example.coinapi.model.Coin;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class Bpi {
    private Coin usd;
    private Coin gbp;
    private Coin eur;

}
