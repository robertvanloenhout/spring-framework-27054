package com.calitha.spring27054;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api")
public class MyController {

  @GetMapping("/hello")
  void hello() {
    throw new IllegalArgumentException("Illegal request in controller");
  }
}
