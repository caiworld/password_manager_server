package com.caihao.password_manager.controller;

import com.caihao.password_manager.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试
 *
 * @author caihao
 * @date 2020/2/15 21:27
 */
@RestController
public class TestController {

  @Autowired
  TestService testService ;

  @RequestMapping("/test")
  public String test() {
    return "test success2";
  }
}
