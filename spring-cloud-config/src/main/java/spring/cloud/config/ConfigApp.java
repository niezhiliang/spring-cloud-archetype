package spring.cloud.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 */
@SpringBootApplication
@EnableConfigServer
@EnableDiscoveryClient
public class ConfigApp {
  public static void main(String[] args) {
    SpringApplication.run(ConfigApp.class,args);
  }
}
