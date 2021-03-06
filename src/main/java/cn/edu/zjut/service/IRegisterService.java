package cn.edu.zjut.service;

import cn.edu.zjut.po.Register;

public interface IRegisterService {
    boolean updateRegister(Register register);
    boolean findByMultiConditions(String account, String phone);
    boolean insertRegister(Register register);
    Register findByPhone(Register register);
}
