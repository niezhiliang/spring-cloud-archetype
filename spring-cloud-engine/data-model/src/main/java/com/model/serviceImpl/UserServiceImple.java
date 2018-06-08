package com.model.serviceImpl;

import com.model.domain.User;
import com.model.domain.UserExample;
import com.model.mapper.UserMapper;
import com.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author NieZhiLiang
 * @Email nzlsgg@163.com
 */
@Service
public class UserServiceImple implements UserService {
  @Autowired
  private UserMapper userMapper;

  @Override
  public User selectFirstData() {
    UserExample example = new UserExample();
    example.createCriteria().andIdIsNotNull();
    return userMapper.selectByExample(example).get(0);
  }
}
