package cn.edu.zjut.action;

import cn.edu.zjut.po.Register;
import cn.edu.zjut.service.IOrderService;
import cn.edu.zjut.service.IRegisterService;
import com.opensymphony.xwork2.ActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("prototype")
public class RegisterAction {
    private Register register;
    private IRegisterService registerService;

    public void setRegister(){
        this.register=register;
    }
    public Register getRegister(){
        return register;
    }

    @Autowired
    public void setRegisterService(IRegisterService registerService) {
        this.registerService = registerService;
    }
    public IRegisterService getRegisterService() {
        return registerService;
    }

    /**
     * @author 朱炫帆
     * @return String
     * 用户注册
     */
    public String insertRegister() {
        if (registerService.insertRegister(register))
            return "insertRegisterSuccess";
        else
            return "insertRegisterFail";
    }

    /**
     * @author 朱炫帆
     * @return String
     * 更改用户信息
     */
    public String updateRegister(){
        if(registerService.updateRegister(register))
            return "updateRegisterSuccess";
        else
            return "updateRegisterFail";
    }
}
