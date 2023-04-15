package com.example.coinapi.model;


import jdk.nashorn.internal.runtime.Debug;
import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity
@Data
@Builder
public class Coin{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String code;
    private String symbol;
    private String rate;
    private String description;
    public double rate_float;


    public Coin() {

    }
    public Coin(long id, String code, String symbol, String rate, String description, double rate_float) {
    this.id = id;
    this.code = code;
    this.symbol = symbol;
    this.rate = rate;
    this.description = description;
    this.rate_float = rate_float;
   }
}
