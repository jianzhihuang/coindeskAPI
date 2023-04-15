package com.example.coinapi.coindeskAPI;

import com.example.coinapi.model.Coin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

@Component
public class CoinListHandler {

    public Map<String,Object> transfer(Bpi bpi){
        CoinListHandler coinListHandler = new CoinListHandler();
        Map<String,Object> map = new HashMap<>();
        map.put(bpi.getEur().getCode(),coinListHandler.coinHandler(bpi.getEur()));
        map.put(bpi.getUsd().getCode(),coinListHandler.coinHandler(bpi.getUsd()));
        map.put(bpi.getGbp().getCode(),coinListHandler.coinHandler(bpi.getGbp()));
        return map;
    }

    public Map<String ,String> coinHandler(Coin coin){
        Map<String, String> map = new TreeMap<>();
        String currencyName = getCurrencyName(coin.getCode());
        if (currencyName != null) {
            map.put("幣別中文名稱", currencyName);
            map.put("幣別", coin.getCode());
        }
        map.put("匯率", coin.getRate());
        return map;
    }
    private String getCurrencyName(String code) {
        switch (code) {
            case "USD":
                return "美金";
            case "GBP":
                return "英鎊";
            case "EUR":
                return "歐元";
            default:
                return null;
        }
    }
}
