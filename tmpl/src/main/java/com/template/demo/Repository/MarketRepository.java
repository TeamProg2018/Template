package com.template.demo.Repository;

import com.template.demo.Entity.Market;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarketRepository extends JpaRepository<Market,Long> {
    public Market findByName(String name);
}
