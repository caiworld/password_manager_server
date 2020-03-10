package com.caihao.password_manager.controller;

import com.caihao.password_manager.entity.MailBean;
import com.caihao.password_manager.service.MailService;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @author caihao
 * @date 2020/2/15 22:24
 */
@RestController
@RequestMapping("/mail")
@Slf4j
public class MailController {

  @Autowired
  private MailService mailService;

  @RequestMapping("/send")
  public Map<String, Object> sendMessage(@RequestBody MailBean mailBean) {
    Map<String, Object> map = new HashMap<>();
    try {
      mailService.sendSimpleMail(mailBean);
      map.put("success", true);
      map.put("msg", "同步密码成功");
      log.info("发送邮件成功");
    } catch (Exception e) {
      map.put("success", false);
      map.put("msg", "同步密码失败");
      log.error("发送邮件失败：\n{}", e.getMessage());
    }
    return map;
  }
}
