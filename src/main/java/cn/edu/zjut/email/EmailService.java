package cn.edu.zjut.email;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

public class EmailService implements IEmailService {
    // 发件人邮箱地址
    private static final String FROM = "m13646686983@163.com";
    // 发件人称号，同邮箱地址
    private static final String USER = "m13646686983@163.com";
    // 发件人邮箱客户端授权码
    private static final String PASSWORD = "163authorization";

    /**
     * @author 王凌云
     * @param to 发送至某邮箱
     * @param content 邮件内容
     * @param title 邮件标题
     * @return boolean
     * “注册成功”信息的邮件发送
     */
    public boolean sendMail(String to, String content, String title) {
        Properties props = new Properties();
        // 设置 SMTP 协议
        props.put("mail.transport.protocol", "smtp");
        // 设置邮件服务器
        props.put("mail.smtp.host", "smtp.163.com");
        // 设置授权，即用户名和密码的校验
        props.put("mail.smtp.auth", "true");
        // 由 props 对象创建 session
        Session session = Session.getDefaultInstance(props);
        // 控制台显示发送邮件的过程
        session.setDebug(true);
        // 由 session 创建消息对象
        MimeMessage message = new MimeMessage(session);
        try {
            // 加载发件人地址
            message.setFrom(new InternetAddress(FROM));
            // 加载收件人地址
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            // 加载标题
            message.setSubject(title);
            // 向 multipart 对象中添加邮件的文本内容或附件
            Multipart multipart = new MimeMultipart();
            // 设置邮件的文本内容
            BodyPart contentPart = new MimeBodyPart();
            contentPart.setContent(content, "text/html;charset=utf-8");
            multipart.addBodyPart(contentPart);
            message.setContent(multipart);
            // 保存变化
            message.saveChanges();
            // 设置 SMTP 协议，连接163服务器邮箱
            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.163.com", USER, PASSWORD);
            // 发送邮件
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
