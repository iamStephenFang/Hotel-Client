package cn.edu.zjut.action;

import cn.edu.zjut.po.Register;
import cn.edu.zjut.service.IRegisterService;
import com.opensymphony.xwork2.ActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.Map;

@Controller
@Scope("prototype")
public class LoginAction {
    private String phone;
    private String password;
    IRegisterService registerService;

    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getPhone() {
        return phone;
    }

    @Autowired
    public void setRegisterService(IRegisterService registerService) {
        this.registerService = registerService;
    }

    public IRegisterService getRegisterService() {
        return registerService;
    }

    /**
     * @author 方宣淼
     * @return String
     * 注册用户登录
     */
    public String login(){
        ActionContext context = ActionContext.getContext();
        Register register = new Register();
        register.setPhone(phone);
        register.setPassword(password);
        if(registerService.findByPhone(register)!= null)
            return "loginSuccess";
        else
            return  "loginFail";
    }
}
