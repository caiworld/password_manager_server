package com.caihao.password_manager.controller;

import com.caihao.password_manager.service.MailService;
import com.sun.net.httpserver.Authenticator.Success;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * TODO
 *
 * @author caihao
 * @date 2020/2/27 15:48
 */
@RestController
@RequestMapping("/password_manager/app")
public class AppController {

  @Autowired
  private MailService mailService;

  @GetMapping("/getAppVersion")
  public String getAppVersion() {
    return "1.1.0";
  }

  @RequestMapping("/sendFeedback")
  public Map<String, Object> sendFeedback(@RequestParam("content") String content,
      @RequestParam("file") MultipartFile file) {
    boolean success = mailService.sendAttachmentFile("1310027798@qq.com", "反馈意见", content, file);
    Map<String, Object> result = new HashMap<>();
    if (success) {
      result.put("success", true);
      result.put("msg", "反馈成功");
    } else {
      result.put("success", false);
      result.put("msg", "反馈失败");
    }
    return result;
  }

  @RequestMapping("/sendFeedback2")
  public Map<String, Object> sendFeedback2(@RequestParam("content") String content,
      @RequestParam("files") List<MultipartFile> files) {
    boolean success = mailService.sendAttachmentFiles("1310027798@qq.com", "反馈意见", content, files);
    Map<String, Object> result = new HashMap<>();
    if (success) {
      result.put("success", true);
      result.put("msg", "反馈成功");
    } else {
      result.put("success", false);
      result.put("msg", "反馈失败");
    }
    return result;
  }


}
