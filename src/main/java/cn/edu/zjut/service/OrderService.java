package cn.edu.zjut.service;

import cn.edu.zjut.dao.OrderMapper;
import cn.edu.zjut.dao.RegisterMapper;
import cn.edu.zjut.dao.RoomMapper;
import cn.edu.zjut.po.Order;
import cn.edu.zjut.po.OrderExtendsRegister;
import cn.edu.zjut.po.Register;
import com.opensymphony.xwork2.ActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class OrderService implements IOrderService {
    private Map request;
    private OrderMapper orderMapper = null;
    private RoomMapper roomMapper =null;

    @Autowired
    public void setOrderMapper(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }
    public OrderMapper getOrderMapper() {
        return orderMapper;
    }

    /**
     * @author 王凌云
     * @return boolean
     * 查询所有订单
     */
    @Override
    public boolean findAllOrders() {
        System.out.println("正在执行findAllOrders方法...");
        ActionContext context = ActionContext.getContext();
        request = (Map<String, List>)context.get("request");
        List<OrderExtendsRegister> orders = new ArrayList<OrderExtendsRegister>();
        try {
            orders = orderMapper.findAllOrders();
            if (orders == null){
                System.out.println("查询失败...");
                return false;
            }
            else {
                request.put("orders",orders);
                for (Order order: orders){
                    System.out.println(order);
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
     * @author 王凌云
     * @param orderId 订单
     * @return boolean
     * 通过订单号单条件搜索订单
     */
    @Override
    public boolean findOrderById(int orderId){
        System.out.println("正在执行findOrderById方法...");
        ActionContext context = ActionContext.getContext();
        request = (Map<String, List>)context.get("request");
        try {
            Order order = orderMapper.findOrderById(orderId);
            if (order == null){
                System.out.println("未找到订单...");
                return false;
            }
            else {
                System.out.println(order);
                System.out.println("找到订单...");
                request.put("order",order);
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @author 王凌云
     * @return boolean
     * 根据订单号或手机号查询所有订单
     */
    @Override
    public boolean findByMultiConditions(Integer id,String phone) {
        System.out.println("正在执行findByMultiConditions方法...");
        ActionContext context = ActionContext.getContext();
        request = (Map<String, List>)context.get("request");
        List<OrderExtendsRegister> orders = new ArrayList<OrderExtendsRegister>();
        try {
            orders = orderMapper.findByMultiConditions(id,phone);
            if (orders == null){
                System.out.println("未查找到订单...");
            }
            else {
                for (Order order: orders){
                    System.out.println(order);
                }
            }
            request.put("orders",orders);
            System.out.println("查询成功...");
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @author 王凌云
     * @param order 订单
     * @return boolean
     * 更新订单信息
     */
    @Override
    public boolean updateOrder(Order order) {
        System.out.println("正在执行updateOrder方法...");
        int colNum = orderMapper.updateOrder(order);
        try {
            if (colNum == 0){
                System.out.println("更新订单信息失败...");
                return false;
            }
            else {
                System.out.println("更新订单信息成功...");
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    @Override
    public int restRoomNum(String roomType, Date checkInTime ,Date leaveTime) {
        System.out.println("正在findNonemptyRoom方法...");

        ActionContext context = ActionContext.getContext();
        request = (Map<String, List>) context.get("request");
        List<Order> orders = new ArrayList<Order>();

        try {
            orders = orderMapper.findNonemptyRoom(roomType, checkInTime, leaveTime);
            int roomTypeNum = roomMapper.findRoomNumByType(roomType);
            int max=0;
            Date beginDate = new SimpleDateFormat("yyyy-MM-dd").parse(String.valueOf(checkInTime));
            Date endDate = new SimpleDateFormat("yyyy-MM-dd").parse(String.valueOf(leaveTime));
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(beginDate);
            while (!calendar.getTime().after(endDate)){
                int count = 0;
                for (Order order:orders){
                    Date orderCheckInTime = new SimpleDateFormat("yyyy-MM-dd").parse(String.valueOf(order.getCheckInTime()));
                    Date orderLeaveTime = new SimpleDateFormat("yyyy-MM-dd").parse(String.valueOf(order.getLeaveTime()));
                    if (!calendar.getTime().after(orderLeaveTime) && !calendar.getTime().before(orderCheckInTime)){
                        count=count+order.getRoomNum();
                    }
                }
                if (count > max)
                    max = count;
                calendar.add(Calendar.DATE,1);
            }
            return roomTypeNum - max;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public boolean insertOrder(Order order){
        System.out.println("正在执行insertOrder方法...");
        int colNum = orderMapper.insertOrder(order);

        try {
            if (colNum == 0){
                System.out.println("新增订单信息失败...");
                return false;
            }
            else {
                System.out.println("新增订单信息成功...");
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @author 朱炫帆
     * @param orderId 订单号
     * @return boolean
     * 通过订单号单条件搜索订单
     */
    @Override
    public boolean deleteOrder(int orderId){
        System.out.println("正在执行deleteOrder方法...");
        int colNum = orderMapper.deleteOrder(orderId);
        try {
            if (colNum == 0){
                System.out.println("删除订单信息失败...");
                return false;
            }
            else {
                System.out.println("删除订单信息成功...");
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @author 朱炫帆
     * @param phone 手机号
     * @return boolean
     * 通过订单号单条件搜索订单
     */

    @Override
    public boolean findOrderByPhone(String phone){
        System.out.println("正在执行findOrderByPhone方法...");
        ActionContext context = ActionContext.getContext();
        request = (Map<String, List>)context.get("request");
        List<Order> orders = new ArrayList<Order>();
        try {
            orders = orderMapper.findOrderByPhone(phone);
            if (orders == null){
                System.out.println("未找到订单...");
                return false;
            }
            else {
                System.out.println(orders);
                System.out.println("找到订单...");
                request.put("orders",orders);
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
