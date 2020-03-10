package com.caihao.password_manager.service.impl;

import com.caihao.password_manager.service.TestService;
import org.springframework.stereotype.Service;

/**
 * TODO
 *
 * @author caihao
 * @date 2020/2/15 23:11
 */
@Service
public class TestServiceImpl implements TestService {

  @Override
  public String doSomething() {
    return "do something";
  }
}
