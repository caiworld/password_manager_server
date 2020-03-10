package com.caihao.password_manager.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * 发送邮件的Bean
 *
 * @author caihao
 * @date 2020/2/15 22:10
 */
@Data
public class MailBean implements Serializable {

  private static final long serialVersionUID = -2116367492649751914L;

  /**
   * 邮件接收人
   */
  private String recipient;

  /**
   * 邮件主题
   */
  private String subject;

  /**
   * 邮件内容
   */
  private String content;

}
