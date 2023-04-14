package com.example.coinapi.coindeskAPI;

import com.alibaba.fastjson.JSON;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.io.InputStream;

class Json2HttpMessageConverter extends AbstractHttpMessageConverter {


    public Json2HttpMessageConverter(){
        super(new MediaType("application","javascript"));
    }

    @Override
    protected Object readInternal(Class clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        InputStream body = inputMessage.getBody();
        return JSON.parseObject(body,clazz);
    }

    @Override
    protected void writeInternal(Object o, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {

    }

    @Override
    protected boolean supports(Class clazz) {
        return true;
    }
}
