package com.caihao.password_manager.service;

import com.caihao.password_manager.entity.MailBean;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

/**
 * TODO
 *
 * @author caihao
 * @date 2020/2/15 23:21
 */
public interface MailService {

  /**
   * 发送邮件
   *
   * @param mailBean 简单邮件的bean
   * @return void
   * @author 蔡浩
   * @date 2020/2/15 23:22
   * @since 1.0.0
   */
  void sendSimpleMail(MailBean mailBean);

  boolean sendAttachmentFile(String to,String subject,String content,MultipartFile file);

  boolean sendAttachmentFiles(String to,String subject,String content, List<MultipartFile> files);

}
