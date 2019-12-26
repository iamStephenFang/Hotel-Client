package cn.edu.zjut.dao;

import cn.edu.zjut.po.Register;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegisterMapper {
    /**
     * @author 方宣淼
     * @return List
     * 查询所有会员信息
     */
    List<Register> findAllRegisters();

    /**
     * @author 方宣淼
     * @param register  会员
     * @return Register
     * 通过多种信息查找会员信息
     */
    List<Register> findByMultiConditions(Register register);

    /**
     * @author 方宣淼
     * @param register 会员
     * @return int
     * 更新会员信息
     */
    int updateRegister(Register register);

    /**
     * @author 方宣淼
     * @param register 会员
     * @return int
     * 注册会员
     */
    int insertRegister(Register register);

    /**
     * @author 方宣淼
     * @param orderId 订单号
     * @return int
     * 通过订单号寻找会员信息
     */
    Register findByOrderID(int orderId);
}
