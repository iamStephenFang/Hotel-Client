package cn.edu.zjut.service;

import cn.edu.zjut.dao.RegisterMapper;
import cn.edu.zjut.po.Register;
import com.opensymphony.xwork2.ActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class RegisterService implements IRegisterService {
    private Map session;
    private Map request;
    private RegisterMapper registerMapper = null;

    public RegisterMapper getRegisterMapper() {
        return registerMapper;
    }

    @Autowired
    public void setRegisterMapper(RegisterMapper registerMapper) {
        this.registerMapper = registerMapper;
    }


    /**
     * @author 方宣淼
     * @return boolean
     * 通过手机号码查询订单
     */
    @Override
    public Register findByPhone(Register register){
        System.out.println("正在执行RegisterService的login方法...");
        ActionContext context = ActionContext.getContext();
        session = context.getSession();
        request = (Map<String, String>) context.get("request");
        try {
            Register instance = registerMapper.findByPhone(register.getPhone());
            if (instance == null){
                request.put("tip","用户不存在");
                System.out.println("查无此人...");
                return null;
            }
            if (instance.getPassword().equals(register.getPassword())) {
                session.put("register",instance);
                System.out.println("查找注册用户信息成功...");
                return instance;
            }
            else {
                request.put("tip","密码错误");
                System.out.println("密码错误...");
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * @author 方宣淼
     * @return boolean
     * 更新Register账户信息
     */
    @Override
    public boolean updateRegister(Register register){
        System.out.println("正在执行updateRegister方法...");
        try {
            int updatedColumns = registerMapper.updateRegister(register);
            if (updatedColumns == 0){
                System.out.println("更新失败...");
                return false;
            }
            else {
                System.out.println("更新成功...");
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @author 方宣淼
     * @return boolean
     * 根据账户名或手机号查询所有用户
     */
    @Override
    public boolean findByMultiConditions(String account,String phone) {
        System.out.println("正在执行findByMultiConditions方法...");
        ActionContext context = ActionContext.getContext();
        request = (Map<String, List>)context.get("request");
        List<Register> registers = new ArrayList<Register>();
        try {
            registers = registerMapper.findByMultiConditions(account,phone);
            if(registers == null){
                System.out.println("查询失败...");
                return false;
            }
            else {
                request.put("registers",registers);
                for (Register register: registers){
                    System.out.println(register);
                }
                System.out.println("查询成功...");
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }



    /**
     * @author 朱炫帆
     * @return boolean
     * 注册用户
     */

    @Override
    public boolean insertRegister(Register register){
        System.out.println("正在执行insertRegister方法...");
        try {
            int insertedColumns = registerMapper.insertRegister(register);
            if (insertedColumns == 0){
                System.out.println("注册失败...");
                return false;
            }
            else {
                System.out.println("注册成功...");
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
