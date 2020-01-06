package cn.edu.zjut.service;

import cn.edu.zjut.dao.RoomTypeMapper;
import cn.edu.zjut.po.RoomType;
import com.opensymphony.xwork2.ActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class RoomTypeService implements IRoomTypeService{
    private Map request;
    private RoomTypeMapper roomTypeMapper = null;
    public RoomTypeMapper getRoomTypeMapper() {
        return roomTypeMapper;
    }

    @Autowired
    public void setRoomTypeMapper(RoomTypeMapper roomTypeMapper) {
        this.roomTypeMapper = roomTypeMapper;
    }

    /**
     * @author 方宣淼
     * @return boolean
     * 查询所有房型
     */
    @Override
    public boolean findAllRoomTypes() {
        System.out.println("正在执行findAllRoomTypes方法...");
        ActionContext context = ActionContext.getContext();
        request = (Map<String, List>)context.get("request");
        List<RoomType> roomTypes = new ArrayList<RoomType>();
        try {
            roomTypes = roomTypeMapper.findAllRoomTypes();
            if(roomTypes == null){
                request.put("error","房型查询失败");
                System.out.println("查询失败...");
                return false;
            }
            else {
                request.put("roomTypes",roomTypes);
                for (RoomType roomType: roomTypes){
                    System.out.println(roomType);
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
     * @author 方宣淼
     * @return boolean
     * 通过roomType查询房间信息
     */
    @Override
    public boolean findByRoomType(String roomType) {
        System.out.println("正在执行findByRoomType方法...");
        ActionContext context = ActionContext.getContext();
        List<RoomType> roomTypes = new ArrayList<RoomType>();
        request = (Map<String, String>) context.get("request");
        try {
            RoomType instance = roomTypeMapper.findByRoomType(roomType);
            if (instance == null){
                request.put("error","未找到该房型");
                System.out.println("未找到该房型...");
                return false;
            }
            else {
                System.out.println(roomType);
                System.out.println("找到该房型...");
                request.put("roomType",instance);
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
