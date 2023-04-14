package com.example.coinapi.coindeskAPI;

import com.alibaba.fastjson.JSON;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.InputStream;

@Component
public class RestTemplateUtil {

    public static RestTemplate getInstance(){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new Json2HttpMessageConverter());
        return restTemplate;
    }

}


