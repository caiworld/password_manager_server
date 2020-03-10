package com.caihao.password_manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
///mail/send?recipient=1310027798@qq.com&subject=test_send_mail&content=this_is_content
public class PasswordManagerApplication {

  /**
   * springboot 打war包形式放到tomcat下运行时，使用下面代码
   */
//public class PasswordManagerApplication extends SpringBootServletInitializer {
//  @Override
//  protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//    return builder.sources(PasswordManagerApplication.class);
//  }

  public static void main(String[] args) {
    SpringApplication.run(PasswordManagerApplication.class, args);
  }

}
