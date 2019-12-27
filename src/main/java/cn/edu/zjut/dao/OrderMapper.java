package cn.edu.zjut.dao;

import cn.edu.zjut.po.Order;
import cn.edu.zjut.po.OrderExtendsRegister;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface OrderMapper {
    /**
     * @author 王凌云
     * @return List
     * 查询所有订单
     */
    List<OrderExtendsRegister> findAllOrders();

    /**
     * @author 王凌云
     * @param orderId 订单号
     * @return Order
     * 通过订单号单条件搜索订单
     */
    Order findOrderById(int orderId);

    /**
     * @author 王凌云
     * @param orderId 订单号
     * @param phone 手机号
     * @return List
     * 通过订单号或手机号查询订单
     */
    List<OrderExtendsRegister> findByMultiConditions(@Param("orderId") Integer orderId, @Param("phone") String phone);

    /**
     * @author 王凌云
     * @param order 订单
     * @return int
     * 更新订单
     */
    int updateOrder(Order order);

//    以下为朱炫帆写的正确率极高的bug

    /**
     * @author 朱炫帆
     * @param order 订单
     * @return int
     * 新增订单
     */
    int insertOrder(Order order);

    /**
     * @author 朱炫帆
     * @param roomId 订单号
     * @return int
     * 删除订单
     */
    int deleteOrder (@Param("roomId")String roomId);

    /**
     * @author 朱炫帆
     * @param roomType     房间类型（查询
     * @param checkInTime  入住时间（查询
     * @param leaveTime    离开时间（查询
     * @return List
     * 查（非）（空）房
     */
    List<Order> findNonemptyRoom(@Param("roomType") String roomType, @Param("checkInTime")Date checkInTime, @Param("leaveTime")Date leaveTime);
}
