package com.example.petfoster.mapper;

import com.example.petfoster.entity.PetStatus;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface PetStatusMapper {
    // 按订单ID查最新宠物状态
    @Select("SELECT * FROM pet_status WHERE order_id = #{orderId} ORDER BY update_time DESC LIMIT 1")
    PetStatus selectLatestByOrderId(Long orderId);

    // 新增/更新宠物状态（简化：每次新增一条）
    @Insert("INSERT INTO pet_status(order_id, status_desc) VALUES(#{orderId}, #{statusDesc})")
    int insertPetStatus(PetStatus petStatus);
}