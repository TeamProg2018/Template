package com.template.demo.Entity;

import javax.persistence.*;

@Entity
@Table(name="goods_table", catalog = "template_db")
public class Goods {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="good_id")
    private Long id;

    @Column(name="good_name")
    private String name;

    @Column(name="good_price")
    private Float price;

    public Goods() {
    }

    public Goods(String name, Float price) {
        this.name = name;
        this.price = price;
    }

    public Long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
