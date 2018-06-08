package com.cloud.service.B;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Import;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@Import({com.liumapp.redis.operator.Main.class,
  com.liumapp.redis.operator.config.RedisConfig.class})
public class AppB{
  public static void main(String[] args) {
    SpringApplication.run(AppB.class,args);
  }
}
