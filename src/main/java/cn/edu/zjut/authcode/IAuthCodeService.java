package cn.edu.zjut.authcode;

public interface IAuthCodeService {
    boolean sedMsg(String phone);
    boolean verifyCode(String mobile, String code);
}
