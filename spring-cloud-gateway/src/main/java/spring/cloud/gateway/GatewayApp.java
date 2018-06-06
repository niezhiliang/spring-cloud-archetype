package spring.cloud.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 */
@EnableZuulProxy
@SpringCloudApplication
@EnableDiscoveryClient
public class GatewayApp {
  public static void main(String[] args) {
    SpringApplication.run(GatewayApp.class,args);
  }
}
