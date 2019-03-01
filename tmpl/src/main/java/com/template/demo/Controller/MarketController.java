package com.example11.demo11.Controller;

import com.example11.demo11.Entity.GoodModel;
import com.example11.demo11.Entity.MarketModel;
import com.example11.demo11.Repository.GoodsRepository;
import com.example11.demo11.Repository.MarketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MarketController {
    @Autowired
    private GoodsRepository goodsRepository;
    @Autowired
    private MarketRepository marketRepository;
    @GetMapping("/market")
    public String getPage(){
        return "market";
    }

    @PostMapping("/addMarket")

    public String addMarket(@RequestParam String name1){
        boolean flag=true;
        List<MarketModel>marketModelList=marketRepository.findByMarketName(name1);
        for (MarketModel marketModel : marketModelList) {
            if(marketModel.getMarketName().equals(name1)){
                flag=false;
            }
        }
        if(flag){
            MarketModel marketModel=new MarketModel();
            marketModel.setMarketName(name1);
            marketRepository.save(marketModel);
        }
        return "market";
    }

    @PostMapping("/addGood")
    private String addGood(@RequestParam String name1,
                           @RequestParam String name2,
                           @RequestParam String name3){
        List<MarketModel>marketModelList=marketRepository.findAllByMarketName(name3);
        for (MarketModel markets : marketModelList) {
            if(markets.getMarketName().equals(name3)){
                markets.setMarketName(name3);
                GoodModel goodModel=new GoodModel();
                goodModel.setGoodName(name1);
                goodModel.setGoodPrice(Integer.parseInt(name2));
                goodModel.setMarketModel(markets);
                goodsRepository.save(goodModel);
            }
//            else {
//                GoodModel goodModel=new GoodModel();
//                MarketModel marketModel=new MarketModel();
//
//                marketModel.setMarketName(name3);
//                goodModel.setGoodName(name1);
//                goodModel.setGoodPrice(Integer.parseInt(name2));
//                goodModel.setMarketModel(marketModel);
//                goodsRepository.save(goodModel);
//            }
        }

        return "market";
    }



}
