package spring.cloud.gateway.fifter;

import com.netflix.zuul.ZuulFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 */
public class AccessFilter extends ZuulFilter {

  private static Logger log = LoggerFactory.getLogger(AccessFilter.class);

  /**
   *  pre : before
   *  routing : while routing
   *  post : after routing and error
   *  error : catch exception
   * @return String
   */
  @Override
  public String filterType() {
    return "pre";
  }

  @Override
  public int filterOrder() {
    return 1;
  }

  @Override
  public boolean shouldFilter() {
    return true;
  }

  @Override
  public Object run() {
    return null;
  }
}
