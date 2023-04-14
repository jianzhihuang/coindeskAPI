package com.example.coinapi.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CoinRepository extends JpaRepository<Coin,Long> {

}
