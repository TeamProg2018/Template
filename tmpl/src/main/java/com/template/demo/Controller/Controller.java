package com.template.demo.Controller;

import com.template.demo.Entity.Goods;
import com.template.demo.Repository.GoodsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@org.springframework.stereotype.Controller
public class Controller {

//    @GetMapping("/index")
//    public String getIndex(){
//        return "index";
//    }

    @Autowired
    GoodsRepository goodsRepository;


    @GetMapping("/gs")
    public String getGoods(Map<String, Object> model) {
        model.put("getAllGoods", goodsRepository.findAll());
        return "market";
    }

    @PostMapping("/gs")
    public String addGoods(
            Map<String, Object> model,
            @RequestParam(value = "FormName") String setFromFormName,
            @RequestParam(value = "FormPrice") Float setFromFormPrice) {
        Goods goods = new Goods();
        goods.setName(setFromFormName);
        goods.setPrice(setFromFormPrice);

        goodsRepository.save(goods);
        model.put("getAllGoods", goodsRepository.findAll());

        return "market";
    }
}


