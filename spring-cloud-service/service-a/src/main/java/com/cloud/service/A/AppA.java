package com.cloud.service.A;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class AppA {
  public static void main(String[] args) {
    SpringApplication.run(AppA.class,args);
  }
}
