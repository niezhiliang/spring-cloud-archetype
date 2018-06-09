package com.cloud.service.B.controller;

import com.liumapp.redis.operator.string.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 */
@RestController
@RequestMapping(value = "/")
public class IndexController {
  @Autowired
  private StringUtil stringUtil;
  @Autowired
  private UserService userService;

  @Value("${suyu.name}")
  private String word;

  @RequestMapping(value = "index")
  public String index() {
    if (stringUtil.get("times") == null) {
      //放入redis中 30分钟自动过期
      stringUtil.set("times","1",30,TimeUnit.MINUTES);
    }
    String times =  stringUtil.get("times").toString();
    stringUtil.set("times",Integer.parseInt(times)+1 + "",30,TimeUnit.MINUTES);
    User firstData = userService.selectFirstData();
    return "this is form server B : "+word +" Redis: "+times+"\n"+firstData;
  }
}
