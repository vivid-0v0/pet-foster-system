// 1. 声明包路径：必须和文件夹路径完全一致
package com.example.petfoster.controller;

// 2. 导入依赖类（缺少会报红，需确保这些类已创建）
import com.example.petfoster.common.Result; // 统一返回结果类
import com.example.petfoster.entity.PetType; // 宠物类型实体类
import com.example.petfoster.entity.ShopInfo; // 店铺信息实体类
import com.example.petfoster.mapper.PetTypeMapper; // 宠物类型Mapper
import com.example.petfoster.mapper.ShopInfoMapper; // 店铺信息Mapper
import lombok.RequiredArgsConstructor; // Lombok注解：构造方法注入
import org.springframework.web.bind.annotation.GetMapping; // GET请求注解
import org.springframework.web.bind.annotation.RequestMapping; // 接口前缀注解
import org.springframework.web.bind.annotation.RestController; // REST接口注解
import java.util.List; // 集合类

/**
 * 基础数据接口控制器：提供店铺、宠物类型的查询接口
 * 核心功能：给前端返回下单所需的基础选择数据
 */
@RestController // 标记为REST控制器，返回JSON格式数据（而非页面）
@RequestMapping("/api/basic") // 所有接口的统一前缀：http://localhost:8080/api/basic
@RequiredArgsConstructor // Lombok注解：自动生成含final字段的构造方法，实现依赖注入
public class BasicDataController {
    // 3. 注入Mapper（final修饰：配合@RequiredArgsConstructor实现注入）
    private final ShopInfoMapper shopInfoMapper;
    private final PetTypeMapper petTypeMapper;

    // 4. 接口1：查询所有营业中的店铺
    // 接口路径：/api/basic/shops（GET请求）
    @GetMapping("/shops")
    public Result<List<ShopInfo>> getAllOpenShops() {
        // 调用Mapper方法查询数据库
        List<ShopInfo> shops = shopInfoMapper.selectAllOpenShops();
        // 封装统一返回结果（code=200，msg=操作成功，data=店铺列表）
        return Result.success(shops);
    }

    // 5. 接口2：查询所有宠物类型（六大类）
    // 接口路径：/api/basic/pet-types（GET请求）
    @GetMapping("/pet-types")
    public Result<List<PetType>> getAllPetTypes() {
        // 调用Mapper方法查询数据库
        List<PetType> petTypes = petTypeMapper.selectAll();
        // 封装统一返回结果
        return Result.success(petTypes);
    }
}