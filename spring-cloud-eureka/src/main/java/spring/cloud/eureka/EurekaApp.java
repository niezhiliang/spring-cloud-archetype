package spring.cloud.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 */

@EnableEurekaServer
@SpringBootApplication
public class EurekaApp {
  public static void main(String[] args) {
    SpringApplication.run(EurekaApp.class,args);
  }
}
