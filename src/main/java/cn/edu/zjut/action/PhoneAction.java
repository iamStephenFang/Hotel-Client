package cn.edu.zjut.action;

import cn.edu.zjut.authcode.IAuthCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("prototype")
public class PhoneAction {
    private String phone;
    private IAuthCodeService authCodeService;

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getPhone() {
        return phone;
    }

    @Autowired
    public void setAuthCodeService(IAuthCodeService authCodeService) {
        this.authCodeService = authCodeService;
    }
    public IAuthCodeService getAuthCodeService() {
        return authCodeService;
    }

    /**
     * @author 王凌云
     * @return String
     * 发送短信验证码
     */
    public String sendMsg() {
        if (authCodeService.sendMsg(phone)){
            return "sendMsgSuccess";
        }
        else {
            return "sendMsgFail";
        }
    }
}
