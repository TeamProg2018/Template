package com.template.demo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@org.springframework.stereotype.Controller
public class Controller {

    @GetMapping("/index")
    public String getIndex(){
        return "index";
    }

    @PostMapping("/index")
    public String postIndex(){
        return "index";
    }
}
