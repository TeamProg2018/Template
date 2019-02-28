package com.template.demo.Repository;

import com.template.demo.Entity.Goods;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarketRepository extends JpaRepository<Goods,Long> {

}
