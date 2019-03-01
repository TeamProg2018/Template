package com.example11.demo11.Repository;

import com.example11.demo11.Entity.GoodModel;
import com.example11.demo11.Entity.MarketModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodsRepository extends JpaRepository<GoodModel,Long> {
}
