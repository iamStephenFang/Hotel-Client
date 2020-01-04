package cn.edu.zjut.dao;

import cn.edu.zjut.po.RoomType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomTypeMapper {
    /**
     * @author 方宣淼
     * @return List
     * 查询所有房间类型
     */
    List<RoomType> findAllRoomTypes();

    /**
     * @author 方宣淼
     * @param type
     * @return RoomType
     * 通过roomType查找房间类型信息
     */
    RoomType findByRoomType(String type);

}
