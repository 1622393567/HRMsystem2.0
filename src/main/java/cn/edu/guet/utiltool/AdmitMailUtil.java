package cn.edu.guet.utiltool;


import org.springframework.scheduling.annotation.Async;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class AdmitMailUtil {
         @Async
        public  void sendEmail(String email,String post,String name) throws AddressException, MessagingException {
            Properties properties = new Properties();
            properties.put("mail.transport.protocol", "smtp");// 连接协议
            properties.put("mail.smtp.host", "smtp.qq.com");// 主机名
            properties.put("mail.smtp.port", 465);// 端口号
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.ssl.enable", "true");// 设置是否使用ssl安全连接 ---一般都使用
            properties.put("mail.debug", "true");// 设置是否显示debug信息 true 会在控制台显示相关信息
            // 得到回话对象
            Session session = Session.getInstance(properties);
            // 获取邮件对象
            Message message = new MimeMessage(session);
            // 设置发件人邮箱地址
            message.setFrom(new InternetAddress("2444806715@qq.com"));
            // 设置收件人邮箱地址
            message.setRecipients(Message.RecipientType.TO, new InternetAddress[]{new InternetAddress(email)});
            //message.setRecipient(Message.RecipientType.TO, new InternetAddress("xxx@qq.com"));//一个收件人
            // 设置邮件标题
            message.setSubject("通过面试邮件:");
            // 设置邮件内容

            message.setContent("<h1>面试通过</h1><p><b>"+name+"</b></p><p>&nbsp;&nbsp;&nbsp;&nbsp;您好，你通过了我们公司的面试，我们认为你很适合我们公司" +
                            "<b>"+post+
                            "</b>的职位，您的学识、经历给我们留下了良好的印象。\n" +
                            " 成为我们大家庭的一员，工作地在是xxxxxx" +
                            "</p>\n" +
                            "<p>咨询电话:______________。</p>\n" +
                            "<p>______人力资源部</p>",

                    "text/html;charset=UTF-8");
            // 得到邮差对象
            Transport transport = session.getTransport();
            // 连接自己的邮箱账户
            transport.connect("2444806715@qq.com", "crdfyityocyvebhe");// 密码为QQ邮箱开通的stmp服务后得到的客户端授权码,输入自己的即可
            // 发送邮件
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
            System.out.println("发送成功");
        }

    }


