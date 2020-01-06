package cn.edu.zjut.authcode;

public interface IAuthCodeService {
    boolean sendMsg(String phone);
    boolean verifyCode(String mobile, String code);
}
