package com.template.demo.Controller;

import com.template.demo.Entity.Goods;
import com.template.demo.Entity.Market;
import com.template.demo.Repository.GoodsRepository;
import com.template.demo.Repository.MarketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@org.springframework.stereotype.Controller
public class Controller {



    @Autowired
    GoodsRepository goodsRepository;
    @Autowired
    MarketRepository marketRepository;

    @GetMapping("/gs")
    public String getGoods() {

        return "market";
    }


    @PostMapping("/am")
    public String postMarket(@RequestParam String name) {

        Market mk=new Market(name);
        marketRepository.save(mk);

        return "market";
    }


    @PostMapping("/ag")
    public String addGoods(
            Map<String, Object> model,
            @RequestParam(value = "name") String setFromFormName,
            @RequestParam(value = "price") Float setFromFormPrice,
            @RequestParam(value="market") String market) {
        Goods goods = new Goods();
        goods.setName(setFromFormName);
        goods.setPrice(setFromFormPrice);



       Market mk= marketRepository.findByName(market);
        goods.setMarket(mk);
        mk.addGood(goods);
        marketRepository.save(mk);
        goodsRepository.save(goods);
        return "market";
    }



    @PostMapping("/chm")
    public String changeMarket(
                              @RequestParam(value = "good") String good,
                              @RequestParam(value="market") String market) {

      Goods g=goodsRepository.findByName(good);
      g.setMarket(marketRepository.findByName(market));
      goodsRepository.save(g);

        return "market";
    }


    @PostMapping("/sha")
    public String showAll(@RequestParam(value="market") String market,
                          Model model) {

   model.addAttribute("getAllGoods",marketRepository.findByName(market).getGoodsList());
 //  model.addAttribute("getAllGoods",goodsRepository.findAll());

      //  System.out.println(marketRepository.findByName(market).getGoodsList().get(0).getName());
        return "market";
    }

}


