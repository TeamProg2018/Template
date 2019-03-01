package com.example11.demo11.Entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "markets_model", catalog = "db07")
public class MarketModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String marketName;
    @OneToMany(mappedBy = "marketModel", cascade = CascadeType.ALL)
    private Set<GoodModel> goodModelList=new HashSet<>();

    public MarketModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    public Set<GoodModel> getGoodModelList() {
        return goodModelList;
    }

    public void setGoodModelList(Set<GoodModel> goodModelList) {
        this.goodModelList = goodModelList;
    }
}
