package com.example.coinapi.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CoinControllerTest {

    @Autowired
    private MockMvc mockMvc;



    //測試呼叫查詢幣別對應表資料 API,並顯示其內容。
    @Test
    void queryCoins() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/QueryCoins");
        mockMvc.perform(requestBuilder)
                .andDo(print())
                .andExpect(status().is(200))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].code", equalTo("USD")))
                .andReturn();
    }

    //測試呼叫新增幣別對應表資料 API。
    @Transactional
    @Test
    void createCoin() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/createCoin")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "\"code\": \"UBD\",\n" +
                        "\"symbol\": \"&#36;\",\n" +
                        "\"rate\": \"21,606.8744\",\n" +
                        "\"description\": \"United States Dollar\",\n" +
                        "\"rate_float\": 21606.7412\n" +
                        "}");
        ;
        mockMvc.perform(requestBuilder)
                .andDo(print())
                .andExpect(status().is(201))
                .andExpect(jsonPath("$.code", equalTo("UBD")))
                .andExpect(jsonPath("$.id", equalTo(2)));
    }

    //測試呼叫更新幣別對應表資料 API,並顯示其內容。
    @Transactional
    @Test
    void updateCoin() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .put("/updateCoin/{id}", 1)
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "\"code\": \"UAB\",\n" +
                        "\"symbol\": \"&#36;\",\n" +
                        "\"rate\": \"21,606.9999\",\n" +
                        "\"description\": \"United States Dollar\",\n" +
                        "\"rate_float\": 21606.9999\n" +
                        "}");
        mockMvc.perform(requestBuilder)
                .andDo(print())
                .andExpect(status().is(201))
                .andExpect(jsonPath("$.code", equalTo("UAB")))
                .andReturn();
    }

    //測試呼叫刪除幣別對應表資料 API。
    @Transactional
    @Test
    void deleteCoin() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete("/deleteCoin/{id}", 1);
        mockMvc.perform(requestBuilder)
                .andDo(print())
                .andExpect(status().is(204))
                .andReturn();
    }

    //測試呼叫 coindesk API,並顯示其內容。
    @Test
    void callTheCoindeskAPI() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/CallTheCoindeskAPI").accept(MediaType.APPLICATION_JSON);
            mockMvc.perform(request)
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.time").exists())
                    .andExpect(jsonPath("$.bpi").exists())
                    .andExpect(jsonPath("$.bpi.usd").exists())
                    .andExpect(jsonPath("$.bpi.gbp").exists())
                    .andExpect(jsonPath("$.bpi.eur").exists())
                    .andDo(print());

    }
    //測試呼叫資料轉換的 API,並顯示其內容。
    @Test
    void dataConversionCoindeskAPI() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/DataConversionCoindeskAPI");
        mockMvc.perform(requestBuilder)
                .andDo(print())
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.bpi.EUR.幣別", equalTo("EUR")))
                .andReturn();
    }
}
