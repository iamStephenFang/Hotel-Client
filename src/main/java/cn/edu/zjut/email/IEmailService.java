package cn.edu.zjut.email;

public interface IEmailService {
    boolean sendMail(String to, String content, String title);
}
