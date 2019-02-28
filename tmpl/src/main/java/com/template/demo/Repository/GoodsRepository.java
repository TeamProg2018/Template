package com.template.demo.Repository;

import com.template.demo.Entity.Goods;
import com.template.demo.Entity.Market;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodsRepository extends JpaRepository<Goods,Long> {

    public Goods findByName(String name);
}

