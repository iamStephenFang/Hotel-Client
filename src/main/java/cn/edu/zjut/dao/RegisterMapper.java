package cn.edu.zjut.dao;

import cn.edu.zjut.po.Register;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegisterMapper {
    /**
     * @author 方宣淼
     * @return List
     * 查询所有注册用户信息
     */
    List<Register> findAllRegisters();

    /**
     * @author 方宣淼
     * @param phone
     * @return Register
     * 通过电话号码查找注册用户信息
     */
    Register findByPhone(String phone);

    /**
     * @author 方宣淼
     * @param register 入住房客
     * @return int
     * 更新会员信息
     */
    int updateRegister(Register register);

    /**
     * @author 方宣淼
     * @param account 账户名
     * @param phone 手机号
     * @return List
     * 通过账户名/手机号查询用户
     */
    List<Register> findByMultiConditions(@Param("account") String account, @Param("phone") String phone);


    //以下为朱炫帆所写的正确率极高的bug

    /**
     * @author 朱炫帆
     * @param register 会员
     * @return int
     * 注册会员
     */
    int insertRegister(Register register);

    /**
     * @author 朱炫帆
     * @param account
     * @param phone
     * @param level
     * @return int
     * 三个要素察觉（
     * P.S. 没用了，可以爬
     */
    List<Register> findByMultiConditions_Another(@Param("account") String account, @Param("phone") String phone,@Param("level") String level);

    /**
     * @author 朱炫帆
     * @param orderId 订单号
     * @return Register
     * 通过订单号寻找会员信息
     * P.S. 没用了，可以爬
     */
    Register findByOrderID(int orderId);
}
