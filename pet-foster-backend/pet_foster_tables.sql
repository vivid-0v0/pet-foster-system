-- 先指定要使用的数据库（提前创建好）
USE pet_foster_db;

-- 1. 用户表（user_info）
CREATE TABLE user_info (
    id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '用户ID',
    username VARCHAR(50) NOT NULL COMMENT '用户名',
    email VARCHAR(100) UNIQUE COMMENT '邮箱',
    password VARCHAR(100) NOT NULL COMMENT '加密密码',
    avatar VARCHAR(255) COMMENT '头像URL',
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
) COMMENT '用户基本信息表';

-- 2. 宠物类型表（pet_type）
CREATE TABLE pet_type (
    id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '类型ID',
    type_name VARCHAR(50) NOT NULL COMMENT '宠物类型名称（猫/狗/仓鼠/兔子/鸟类/爬宠）',
    type_desc VARCHAR(255) COMMENT '类型描述',
    price_per_day DECIMAL(10,2) NOT NULL COMMENT '单日寄养价格'
) COMMENT '六大类宠物类型表';

-- 3. 店铺表（shop_info）
CREATE TABLE shop_info (
    id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '店铺ID',
    shop_name VARCHAR(100) NOT NULL COMMENT '店铺名称',
    address VARCHAR(255) COMMENT '店铺地址',
    phone VARCHAR(20) COMMENT '联系电话',
    status TINYINT DEFAULT 1 COMMENT '营业状态（1-营业中，0-休息）'
) COMMENT '寄养店铺表';

-- 4. 订单表（order_info）- 核心表
CREATE TABLE order_info (
    id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '订单ID',
    user_id BIGINT NOT NULL COMMENT '用户ID',
    shop_id BIGINT NOT NULL COMMENT '店铺ID',
    pet_type_id BIGINT NOT NULL COMMENT '宠物类型ID',
    pet_info VARCHAR(255) COMMENT '宠物具体信息（如品种、年龄、备注）',
    foster_days INT NOT NULL COMMENT '寄养天数',
    total_amount DECIMAL(10,2) NOT NULL COMMENT '订单总金额',
    order_status VARCHAR(20) DEFAULT 'UNFINISHED' COMMENT '订单状态（UNFINISHED-未完成，FINISHED-已完成）',
    comment VARCHAR(500) COMMENT '订单评论',
    score TINYINT COMMENT '评分（1-5）',
    foster_start_time DATETIME COMMENT '寄养开始时间',
    foster_end_time DATETIME COMMENT '寄养结束时间',
    create_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    FOREIGN KEY (user_id) REFERENCES user_info(id),
    FOREIGN KEY (shop_id) REFERENCES shop_info(id),
    FOREIGN KEY (pet_type_id) REFERENCES pet_type(id)
) COMMENT '寄养订单表';

-- 5. 宠物状态表（pet_status）
CREATE TABLE pet_status (
    id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '状态ID',
    order_id BIGINT NOT NULL COMMENT '关联订单ID',
    status_desc VARCHAR(255) COMMENT '宠物活跃状态描述（如“进食正常/玩耍中/休息中”）',
    update_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '状态更新时间',
    FOREIGN KEY (order_id) REFERENCES order_info(id)
) COMMENT '宠物实时状态表';

-- 可选：插入测试数据（方便后续调试）
INSERT INTO pet_type (type_name, type_desc, price_per_day) VALUES
('猫', '各类家养猫（英短/布偶等）', 50.00),
('狗', '各类家养狗（泰迪/金毛等）', 60.00),
('仓鼠', '金丝熊/布丁等仓鼠', 10.00),
('兔子', '垂耳兔/侏儒兔等', 15.00),
('鸟类', '鹦鹉/文鸟等', 20.00),
('爬宠', '蜥蜴/守宫等', 30.00);

INSERT INTO shop_info (shop_name, address, phone) VALUES
('萌宠之家寄养店', '北京市朝阳区建国路88号', '13800138000'),
('宠安寄养中心', '上海市浦东新区张江路100号', '13900139000');