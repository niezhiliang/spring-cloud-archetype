package spring.cloud.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.cloud.gateway.fifter.AccessFilter;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 */
@Configuration
public class GatewayConf {
  @Bean
  public AccessFilter accessFilter () {
    return new AccessFilter();
  }
}
