package com.example.coinapi.model;


import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class CoinRowMapper implements RowMapper<Coin> {


    @Override
    public Coin mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Coin.builder()
                .id(rs.getLong("id"))
                .code(rs.getString("code"))
                .symbol(rs.getString("symbol"))
                .rate(rs.getString("rate"))
                .description(rs.getString("description"))
                .rate_float(rs.getDouble("rate_float"))
                .build();
    }
}
