package com.example.coinapi.model;


import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity
@Data
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


}
