package com.example11.demo11.Entity;

import javax.persistence.*;

@Entity
@Table(name = "goods_table", catalog = "db07")
public class GoodModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String goodName;
    private Integer goodPrice;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "market_id")
    private MarketModel marketModel;

    public GoodModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public Integer getGoodPrice() {
        return goodPrice;
    }

    public void setGoodPrice(Integer goodPrice) {
        this.goodPrice = goodPrice;
    }

    public MarketModel getMarketModel() {
        return marketModel;
    }

    public void setMarketModel(MarketModel marketModel) {
        this.marketModel = marketModel;
    }
}
