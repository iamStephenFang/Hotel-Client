package cn.edu.zjut.action;

import cn.edu.zjut.po.RoomType;
import cn.edu.zjut.service.IOrderService;
import cn.edu.zjut.service.IRoomTypeService;
import com.opensymphony.xwork2.ActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.Date;
import java.util.Map;

@Controller
@Scope("prototype")
public class RoomAction {
    private RoomType roomType;
    private String type;
    private Date checkInTime;
    private Date leaveTime;
    private IRoomTypeService roomTypeService;
    private IOrderService orderService;

    public void setRoomType(RoomType roomType) { this.roomType = roomType; }
    public RoomType getRoomType() { return roomType; }

    public void setType(String type) { this.type = type; }
    public String getType() { return type; }

    public void setCheckInTime(Date checkInTime) { this.checkInTime = checkInTime; }
    public Date getCheckInTime() { return checkInTime; }

    public void setLeaveTime(Date leaveTime) { this.leaveTime = leaveTime; }
    public Date getLeaveTime() { return leaveTime; }

    @Autowired
    public void setRoomTypeService(IRoomTypeService roomTypeService) { this.roomTypeService = roomTypeService;}
    public IRoomTypeService getRoomTypeService() { return roomTypeService; }

    @Autowired
    public void setOrderService(IOrderService orderService) { this.orderService = orderService; }
    public IOrderService getOrderService() { return orderService; }

    /**
     * @author 方宣淼
     * @return String
     * 检索RoomType信息
     */
    public String findByRoomType() {
        if (roomTypeService.findByRoomType(type))
            return "findByRoomTypeSuccess";
        else
            return "findByRoomTypeFail";
    }

    /**
     * @author 朱炫帆
     * @return String
     * 查找 剩余 空房
     */
    public String getRestRoomNum(){
        if (orderService.restRoomNum(type,checkInTime,leaveTime)>=0){
            return "getRestRoomNumSuccess";
        }
        else {
            return "getRestRoomNumFail";
        }
    }
}