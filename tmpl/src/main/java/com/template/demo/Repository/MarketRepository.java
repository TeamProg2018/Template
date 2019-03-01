package com.example11.demo11.Repository;

import com.example11.demo11.Entity.MarketModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MarketRepository extends JpaRepository<MarketModel,Long> {
    List<MarketModel>findAllByMarketName(String name);
    List<MarketModel>findByMarketName(String name);
}
