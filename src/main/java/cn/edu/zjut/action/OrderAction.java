package cn.edu.zjut.action;

import cn.edu.zjut.po.Order;
import cn.edu.zjut.po.Register;
import cn.edu.zjut.service.IOrderService;
import com.opensymphony.xwork2.ActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

@Controller
@Scope("prototype")
public class OrderAction {
    private Order order;
    private String type;
    private Integer orderId;
    private String phone;
    private String checkInTime;
    private String leaveTime;
    private int leftRoom;
    private IOrderService orderService;
    private Map session;

    public void setOrder(Order order) {
        this.order = order;
    }
    public Order getOrder() {
        return order;
    }

    public void setType(String type) {
        this.type=type;
    }
    public String getType() {
        return type;
    }

    public void setPhone(String phone) { this.phone = phone; }
    public String getPhone() { return phone; }

    public void setOrderId(Integer orderId) { this.orderId = orderId; }
    public Integer getOrderId() { return orderId; }

    public void setCheckInTime(String checkInTime) {
        this.checkInTime = checkInTime;
    }
    public String getCheckInTime() {
        return checkInTime;
    }

    public void setLeaveTime(String leaveTime) {
        this.leaveTime = leaveTime;
    }
    public String getLeaveTime() {
        return leaveTime;
    }

    public void setLeftRoom(int leftRoom) { this.leftRoom = leftRoom; }
    public int getLeftRoom() { return leftRoom; }

    @Autowired
    public void setOrderService(IOrderService orderService) {
        this.orderService = orderService;
    }
    public IOrderService getOrderService() {
        return orderService;
    }


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

    /**
     * @author 朱炫帆
     * @return String
     * 查找 剩余 空房
     */
    public String getRestRoomNum(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            if (orderService.restRoomNum(type,simpleDateFormat.parse(checkInTime),simpleDateFormat.parse(leaveTime))>=0){
                return "getRestRoomNumSuccess";
            }
            else {
                return "getRestRoomNumFail";
            }
        }catch (Exception e){
            e.printStackTrace();
            return "getRestRoomNumFail";
        }
    }

    /**
     * @author 朱炫帆
     * @return String
     * 删除订单信息
     */
    public String deleteOrder() {
        if (orderService.deleteOrder(orderId)) {
            return "deleteOrderSuccess";
        } else {
            return "deleteOrderFail";
        }
    }

    /**
     * @author 方宣淼
     * @return String
     * 确认信息订单
     */
    public String checkOrder() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            if(orderService.checkOrder(type,simpleDateFormat.parse(checkInTime),simpleDateFormat.parse(leaveTime),leftRoom)){
                return "checkOrderSuccess";
            }
            else {
                return "checkOrderFail";
            }
        }catch (Exception e){
            e.printStackTrace();
            return "checkOrderFail";
        }
    }

    /**
     * @author 朱炫帆
     * @return String
     * 新增订单信息
     */
    public String insertOrder() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            order.setCheckInTime(sdf.parse(checkInTime));
            order.setLeaveTime(sdf.parse(leaveTime));
        } catch (ParseException e) {
            e.printStackTrace();
            return "insertOrderFail";
        }
        if (orderService.insertOrder(order)) {
            return "insertOrderSuccess";
        } else {
            return "insertOrderFail";
        }
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
        if (orderService.findOrderByPhone(register.getPhone())) {
            return "findOrderByPhoneSuccess";
        } else {
            return "findOrderByPhoneFail";
        }
    }
}
