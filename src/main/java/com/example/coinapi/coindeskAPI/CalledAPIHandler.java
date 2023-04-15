package com.example.coinapi.coindeskAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CalledAPIHandler {
//    @Autowired
//    private RestTemplateUtil restTemplateUtil;


    public ResultAPI handler(String url){
        ResultAPI resultAPI = getInstance().getForObject(url,ResultAPI.class);
        return  resultAPI;
    }

    public static RestTemplate getInstance(){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new Json2HttpMessageConverter());
        return restTemplate;
    }
}
