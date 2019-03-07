package com.spbootweb.spbootweb.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class PatternController {

  @GetMapping("/pt")
  public String getPattern() {
    return "pattern";
  }

  @PostMapping("/pt")
  public String postPattern(@RequestParam String setPattern, Map<String, String> model) {
    System.out.println("pattern: " + setPattern);
    model.put("outPattern", setPattern);
    return "pattern";
  }

}
