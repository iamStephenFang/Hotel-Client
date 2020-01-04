package cn.edu.zjut.action;

import cn.edu.zjut.po.CheckCustomer;
import cn.edu.zjut.po.Order;
import cn.edu.zjut.po.Register;
import cn.edu.zjut.service.IOrderService;
import com.opensymphony.xwork2.ActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.Date;
import java.util.Map;

@Controller
@Scope("prototype")
public class OrderAction {
    private Order order;
    private String roomType;
    private int orderId;
    private String phone;
    private Date checkInTime;
    private Date leaveTime;
    private IOrderService orderService;
    private Map session;

    public void setOrder(Order order) {
        this.order = order;
    }
    public Order getOrder() {
        return order;
    }

    public void setRoomType(String roomType) {
        this.roomType=roomType;
    }
    public String getRoomType() {
        return roomType;
    }

    public void setPhone(String phone) { this.phone = phone; }
    public String getPhone() { return phone; }

    public void setOrderId(int orderId) { this.orderId = orderId; }
    public int getOrderId() { return orderId; }

    public void setCheckInTime(Date checkInTime) {
        this.checkInTime = checkInTime;
    }
    public Date getCheckInTime() {
        return checkInTime;
    }

    public void setLeaveTime(Date leaveTime) {
        this.leaveTime = leaveTime;
    }
    public Date getLeaveTime() {
        return leaveTime;
    }

    @Autowired
    public void setOrderService(IOrderService orderService) {
        this.orderService = orderService;
    }
    public IOrderService getOrderService() {
        return orderService;
    }

//    /**
//     * @author 王凌云
//     * @return String
//     * 返回所有订单信息
//     */
//    public String listAll(){
//        if (orderService.findAllOrders()){
//            return "findAllSuccess";
//        }
//        else {
//            return "findAllFail";
//        }
//    }
//
//    /**
//     * @author 王凌云
//     * @return String
//     * 通过订单号单条件搜索订单
//     */
//    public String findOrderById() {
//        if (orderService.findOrderById(order.getOrderId()))
//            return "findOrderByIdSuccess";
//        else
//            return "findOrderByIdFail";
//    }
//
    /**
     * @author 王凌云
     * @return String
     * 返回指定订单号或手机号的订单信息
     */
    public String findByMultiConditions(){
        if (orderService.findByMultiConditions(order.getOrderId(),order.getRegister().getPhone())){
            return "findByMultiConditionsSuccess";
        }
        else {
            return "findByMultiConditionsFail";
        }
    }
//
//    /**
//     * @author 王凌云
//     * @return String
//     * 更新订单信息
//     */
//    public String updateOrder() {
//        if (orderService.updateOrder(order))
//            return "updateOrderSuccess";
//        else
//            return "updateOrderFail";
//    }
//
//
    /**
     * @author 朱炫帆
     * @return String
     * 查找 剩余 空房
     */
    public String getRestRoomNum(){
        if (orderService.restRoomNum(roomType,checkInTime,leaveTime)>=0){
            return "getRestRoomNumSuccess";
        }
        else {
            return "getRestRoomNumFail";
        }
    }

    /**
     * @author 朱炫帆
     * @return String
     * 删除订单信息
     */
    public String deleteOrder() {
        if (orderService.deleteOrder(orderId))
            return "deleteOrderSuccess";
        else
            return "deleteOrderFail";
    }

    /**
     * @author 朱炫帆
     * @return String
     * 新增订单信息
     */
    public String insertOrder() {
        if (orderService.insertOrder(order))
            return "updateOrderSuccess";
        else
            return "updateOrderFail";
    }

    /**
     * @author 朱炫帆
     * @return String
     * 按手机号查询订单
     */
    public String findOrderByPhone() {
        ActionContext ctx = ActionContext.getContext();
        session = ctx.getSession();
        Register register = (Register) session.get("register");
        if (orderService.findOrderByPhone(register.getPhone()))
            return "findOrderByPhoneSuccess";
        else
            return "findOrderByPhoneFail";
    }
}
