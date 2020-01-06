package cn.edu.zjut.action;

import cn.edu.zjut.authcode.IAuthCodeService;
import cn.edu.zjut.email.IEmailService;
import cn.edu.zjut.po.Register;
import cn.edu.zjut.service.IRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("prototype")
public class RegisterAction {
    private Register register;
    private String authCode;
    private IRegisterService registerService;
    private IAuthCodeService authCodeService;
    private IEmailService emailService;

    public void setRegister(Register register) {
        this.register = register;
    }
    public Register getRegister(){
        return register;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }
    public String getAuthCode() {
        return authCode;
    }

    @Autowired
    public void setRegisterService(IRegisterService registerService) {
        this.registerService = registerService;
    }
    public IRegisterService getRegisterService() {
        return registerService;
    }

    @Autowired
    public void setAuthCodeService(IAuthCodeService authCodeService) {
        this.authCodeService = authCodeService;
    }
    public IAuthCodeService getAuthCodeService() {
        return authCodeService;
    }

    @Autowired
    public void setEmailService(IEmailService emailService) {
        this.emailService = emailService;
    }
    public IEmailService getEmailService() {
        return emailService;
    }

    /**
     * @author 朱炫帆 王凌云
     * @return String
     * 用户注册
     */
    public String insertRegister() {
        System.out.println("手机号：" + register.getPhone() + "; 验证码：" + authCode);

        if (!authCodeService.verifyCode(register.getPhone(),authCode)){
            return "insertRegisterFail";
        }

        String emailContent = "注册成功！哈啤酒店欢迎您！";
        String emailTile = "JAVA EE 课程设计";
        emailService.sendMail(register.getEmail(),emailContent,emailTile);

        if (registerService.insertRegister(register)) {
            return "insertRegisterSuccess";
        } else {
            return "insertRegisterFail";
        }
    }

    /**
     * @author 朱炫帆
     * @return String
     * 更改用户信息
     */
    public String updateRegister(){
        if(registerService.updateRegister(register)) {
            return "updateRegisterSuccess";
        } else {
            return "updateRegisterFail";
        }
    }
}
