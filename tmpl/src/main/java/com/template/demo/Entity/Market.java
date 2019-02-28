package com.template.demo.Entity;

import org.springframework.stereotype.Controller;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="market_table", catalog = "template_db")
public class Market {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "market_id")
    private Long id;
    @Column(name="market_name")
    private String name;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Goods> goodsList;

    public Market() {
    }

    public Market(String name) {
        this.name = name;
        this.goodsList=new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }

    public void addGood(Goods g){
        this.goodsList.add(g);
    }
}
