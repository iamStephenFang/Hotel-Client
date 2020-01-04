package cn.edu.zjut.service;

import cn.edu.zjut.po.Order;

import java.util.Date;

public interface IOrderService {
    boolean findAllOrders();
    boolean findOrderById(int orderId);
    boolean findByMultiConditions(Integer id, String phone);
    boolean findOrderByPhone(String phone);
    boolean updateOrder(Order order);
    int restRoomNum(String type, Date checkInTime, Date leaveTime);
    boolean insertOrder(Order order);
    boolean deleteOrder(int orderId);
}
