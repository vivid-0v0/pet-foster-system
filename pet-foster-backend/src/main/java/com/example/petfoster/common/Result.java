package com.example.petfoster.common;

import lombok.Data;

/**
 * 全局统一返回结果
 */
@Data
public class Result<T> {
    private Integer code;       // 200成功/400参数错/401未登录/500系统错
    private String msg;         // 响应提示
    private T data;             // 响应数据

    // 手动添加构造方法（Lombok的@Data会生成，但显式声明更清晰）
    public Result(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    // 快捷构造方法（全部显式指定泛型类型）
    public static <T> Result<T> success() {
        return new Result<T>(200, "操作成功", null); // 修正：Result<T> 而非 Result<>
    }
    
    public static <T> Result<T> success(T data) {
        return new Result<T>(200, "操作成功", data); // 修正：Result<T> 而非 Result<>
    }
    
    public static <T> Result<T> error(String msg) {
        return new Result<T>(500, msg, null); // 修正：Result<T> 而非 Result<>
    }
    
    public static <T> Result<T> error(Integer code, String msg) {
        return new Result<T>(code, msg, null); // 修正：Result<T> 而非 Result<>
    }
}