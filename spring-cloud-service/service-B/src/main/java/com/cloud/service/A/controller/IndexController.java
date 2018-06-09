package com.cloud.service.A.controller;

import com.liumapp.redis.operator.string.StringUtil;
import com.model.domain.User;
import com.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
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

  @Value("${suyu.basedir}")
  private String path;

  @RequestMapping(value = "index")
  public String index() {
    if (stringUtil.get("times") == null) {
      //放入redis中 30分钟自动过期
      stringUtil.set("times","1",30,TimeUnit.MINUTES);
    }
    String times =  stringUtil.get("times").toString();
    stringUtil.set("times",Integer.parseInt(times)+1 + "",30,TimeUnit.MINUTES);
    User firstData = userService.selectFirstData();
    String json = "this is form server A : "+word +" Redis: "+times+"\n"+"MySql："+firstData;
    write(json,path);
    return json;
  }

  private void write(String json, String path) {
    FileOutputStream outSTr = null;
    BufferedOutputStream Buff = null;
    File file = new File(path);
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd  hh:mm:ss");
    try {
      if (!file.exists()) {
        file.createNewFile();
      }
      outSTr = new FileOutputStream(new File(path));
      Buff = new BufferedOutputStream(outSTr);
        Buff.write((simpleDateFormat.format(new Date())+": "+json+"\r\n").getBytes());
      Buff.flush();
      Buff.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}
