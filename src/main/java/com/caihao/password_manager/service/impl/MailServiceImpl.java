package com.caihao.password_manager.service.impl;

import com.caihao.password_manager.entity.MailBean;
import com.caihao.password_manager.service.MailService;
import java.io.File;
import java.util.List;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * TODO
 *
 * @author caihao
 * @date 2020/2/15 23:22
 */
@Service
@Slf4j
public class MailServiceImpl implements MailService {

  // 邮件发送者
  @Value("${spring.mail.username}")
  private String MAIL_SENDER;

  /**
   * Spring Boot 提供了一个发送邮件的简单抽象，使用的是下面这个接口，这里直接注入即可使用
   */
  @Autowired
  private JavaMailSender mailSender;

  @Autowired
  private JavaMailSender javaMailSender;

  /**
   * 发送邮件
   *
   * @param mailBean 简单邮件的bean
   * @return void
   * @author 蔡浩
   * @date 2020/2/15 23:22
   * @since 1.0.0
   */
  @Override
  public void sendSimpleMail(MailBean mailBean) {
    SimpleMailMessage mailMessage = new SimpleMailMessage();
    // 设置发送人
    mailMessage.setFrom(MAIL_SENDER);
    // 设置接收人
    mailMessage.setTo(mailBean.getRecipient());
    // 设置主题
    mailMessage.setSubject(mailBean.getSubject());
    // 设置内容
    mailMessage.setText(mailBean.getContent());
    try {
      javaMailSender.send(mailMessage);
    } catch (MailException e) {
      e.printStackTrace();
    }
  }

  @Override
  public boolean sendAttachmentFile(String to, String subject, String content, MultipartFile file) {
    MimeMessage message = mailSender.createMimeMessage();
    try {
      MimeMessageHelper helper = new MimeMessageHelper(message, true);
      helper.setFrom(MAIL_SENDER);
      helper.setTo(to);
      helper.setSubject(subject);
      helper.setText(content, true);

//      FileSystemResource file = new FileSystemResource(new File(filePath));
      helper.addAttachment(file.getOriginalFilename(), file);
      mailSender.send(message);
      //日志信息
      log.info("邮件已经发送。");
      return true;
    } catch (MessagingException e) {
      log.error("发送邮件时发生异常！", e);
      return false;
    }

  }

  @Override
  public boolean sendAttachmentFiles(String to, String subject, String content,
      List<MultipartFile> files) {
    MimeMessage message = mailSender.createMimeMessage();
    try {
      MimeMessageHelper helper = new MimeMessageHelper(message, true);
      helper.setFrom(MAIL_SENDER);
      helper.setTo(to);
      helper.setSubject(subject);
      helper.setText(content, true);

//      FileSystemResource file = new FileSystemResource(new File(filePath));
      for (MultipartFile file : files) {
        helper.addAttachment(file.getOriginalFilename(), file);
      }
      mailSender.send(message);
      //日志信息
      log.info("邮件已经发送。");
      return true;
    } catch (MessagingException e) {
      log.error("发送邮件时发生异常！", e);
      return false;
    }
  }
}
