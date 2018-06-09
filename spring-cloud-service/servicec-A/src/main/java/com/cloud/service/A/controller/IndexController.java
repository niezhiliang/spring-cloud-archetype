package com.cloud.service.A.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 */
@RestController
@RequestMapping(value = "/")
public class IndexController {

  @Value("${suyu.name}")
  private String word;

  @RequestMapping(value = "index")
  public String index() {
    return "this is form server A : "+word;
  }
}
