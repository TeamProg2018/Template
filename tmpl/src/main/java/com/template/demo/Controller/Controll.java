package com.template.demo.Controller;

import com.template.demo.Entity.Goods;
import com.template.demo.Entity.Market;
import com.template.demo.Repository.GoodsRepository;
import com.template.demo.Repository.MarketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class Controll {

//    @GetMapping("/index")
//    public String getIndex(){
//        return "index";
//    }

    @Autowired
    private GoodsRepository goodsRepository;
    @Autowired
    private MarketRepository  marketRepository;


    @GetMapping("/gs")
    public String getGoods(Map<String, Object> model) {
        model.put("getAllGoods", goodsRepository.findAll());
        return "market";
    }

    @PostMapping("/gs")
    public String addGoods(
            Map<String, Object> model,
            @RequestParam(value = "name1") String setFromFormName,
            @RequestParam(value = "name2") Float setFromFormPrice,
            @RequestParam(value = "name3") String setFromFormMarket) {

        Goods goods = new Goods();
        goods.setName(setFromFormName);
        goods.setPrice(setFromFormPrice);

        Market market =new Market();
        market.setName(setFromFormMarket);

        goodsRepository.save(goods);
        model.put("getAllGoods", goodsRepository.findAll());

        return "market";
    }
}


