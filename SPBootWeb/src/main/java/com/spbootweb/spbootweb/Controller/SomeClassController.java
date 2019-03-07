package com.spbootweb.spbootweb.Controller;

import com.spbootweb.spbootweb.entity.SomeClassModel;
import com.spbootweb.spbootweb.repository.SomeClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;
@Controller
public class SomeClassController {
  @Autowired
  SomeClassRepository someClassRepository;


    @RequestMapping({"/","index"})
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World")
                                       String name, Model model) {
      model.addAttribute("name", name);
      return "index";
    }




  @GetMapping("/pg")
  public String getSomeClassList(Map<String, Object> model) {
    model.put("getSomeClassList", someClassRepository.findAll());
    return "SomeClass";
  }

  @PostMapping("/pg")
  public String addSomeClassEntity(
          Map<String, Object> model,
          @RequestParam(value = "FormName") String setFromFormName,
          @RequestParam (value = "FormPrice") Float setFromFormPrice) {

    SomeClassModel addSomeClassEntity = new SomeClassModel();

    addSomeClassEntity.setSome_name(setFromFormName);
    addSomeClassEntity.setSome_price(setFromFormPrice);

    someClassRepository.save(addSomeClassEntity);
    model.put("getSomeClassList", someClassRepository.findAll());
    return "SomeClass";
  }




}
