package com.example.petfoster.mapper;

import com.example.petfoster.entity.ShopInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;

/**
 * 店铺信息Mapper接口（MyBatis注解版）
 */
@Mapper // 标记为MyBatis映射接口，Spring会自动扫描并创建实现类
public interface ShopInfoMapper {
    // 查询所有营业中的店铺（status=1）
    @Select("SELECT * FROM shop_info WHERE status = 1")
    List<ShopInfo> selectAllOpenShops();

    // 按ID查询店铺详情
    @Select("SELECT * FROM shop_info WHERE id = #{id}")
    ShopInfo selectById(Long id);
}