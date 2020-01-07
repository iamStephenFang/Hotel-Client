package cn.edu.zjut.service;

import cn.edu.zjut.dao.OrderMapper;
import cn.edu.zjut.dao.RoomMapper;
import cn.edu.zjut.dao.RoomTypeMapper;
import cn.edu.zjut.po.Order;
import cn.edu.zjut.po.OrderExtendsRegister;
import cn.edu.zjut.po.RoomType;
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
    private RoomTypeMapper roomTypeMapper =null;

    @Autowired
    public void setRoomTypeMapper(RoomTypeMapper roomTypeMapper) { this.roomTypeMapper = roomTypeMapper; }
    public RoomTypeMapper getRoomTypeMapper() { return roomTypeMapper; }

    @Autowired
    public void setRoomMapper(RoomMapper roomMapper) { this.roomMapper = roomMapper; }
    public RoomMapper getRoomMapper() { return roomMapper; }

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

    @Override
    public boolean checkOrder(String type,Date checkInTime,Date leaveTime,int leftRoom){
        System.out.println("正在执行checkOrder方法");
        ActionContext context = ActionContext.getContext();
        request = (Map<String, List>) context.get("request");
        try {
            RoomType instance = roomTypeMapper.findByRoomType(type);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String beginDate = sdf.format(checkInTime);
            String endDate = sdf.format(leaveTime);
            int days = (int)(leaveTime.getTime()-checkInTime.getTime())/(24*3600*1000);
            request.put("days",days);
            request.put("leftRoom", leftRoom);
            request.put("roomType", instance);
            request.put("checkInTime", beginDate);
            request.put("leaveTime", endDate);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public int restRoomNum(String type, Date checkInTime ,Date leaveTime) {
        System.out.println("正在执行restRoomNum方法...");
        ActionContext context = ActionContext.getContext();
        request = (Map<String, List>) context.get("request");
        RoomType instance = roomTypeMapper.findByRoomType(type);
        List<Order> orders = new ArrayList<Order>();
        try {
            orders = orderMapper.findNonemptyRoom(type, checkInTime, leaveTime);
            System.out.println("找到" + type + "非空房间" + orders.size() + "间");
            int roomTypeNum = roomMapper.findRoomNumByType(type);
            System.out.println(type + "共有" + roomTypeNum + "间");

            int max=0;
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(checkInTime);
            while (!calendar.getTime().after(leaveTime)){
                int count = 0;
                for (Order order:orders){
                    Date orderCheckInTime = order.getCheckInTime();
                    Date orderLeaveTime = order.getLeaveTime();
                    if (!calendar.getTime().after(orderLeaveTime) && !calendar.getTime().before(orderCheckInTime)){
                        count=count+order.getRoomNum();
                    }
                }
                if (count > max) {
                    max = count;
                }
                calendar.add(Calendar.DATE,1);
            }
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            request.put("leftRoom",roomTypeNum - max);
            request.put("roomType",instance);
            request.put("checkInTime",sdf.format(checkInTime));
            request.put("leaveTime",sdf.format(leaveTime));
            return roomTypeNum - max;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public boolean insertOrder(Order order){
        System.out.println("正在执行insertOrder方法...");
        order.setOrderTime(new Date());
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
                System.out.println("找到订单...");
                for (Order order: orders){
                    System.out.println(order);
                }
                request.put("orders",orders);
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
