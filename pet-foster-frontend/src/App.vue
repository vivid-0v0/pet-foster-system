<template>
  <div id="app">
<<<<<<< HEAD
    <!-- 顶部轮播图 -->
    <el-carousel 
      height="300px" 
      autoplay 
      interval="3000" 
      indicator-position="bottom"
      class="carousel-box"
    >
      <el-carousel-item>
        <div class="carousel-item bg1">
          <h1>🐾 欢迎来到宠物寄养系统</h1>
        </div>
      </el-carousel-item>
      <el-carousel-item>
        <div class="carousel-item bg2">
          <h1>🐶 给毛孩子一个温暖的家</h1>
        </div>
      </el-carousel-item>
      <el-carousel-item>
        <div class="carousel-item bg3">
          <h1>🐱 专业寄养 · 安心陪伴</h1>
        </div>
      </el-carousel-item>
    </el-carousel>

    <!-- 导航 -->
    <el-menu mode="horizontal" class="nav-menu">
=======
    <!-- 导航栏 -->
    <el-menu :default-active="activeIndex" mode="horizontal" background-color="#fff" text-color="#333" active-text-color="#409eff">
>>>>>>> eca9c944a480341c8d84a8e6ab9e97d337a8f62a
      <el-menu-item index="1">
        <router-link to="/login">登录</router-link>
      </el-menu-item>
      <el-menu-item index="2">
        <router-link to="/order/create">创建订单</router-link>
      </el-menu-item>
      <el-menu-item index="3">
        <router-link to="/order/list">我的订单</router-link>
      </el-menu-item>
      <el-menu-item index="4">
        <router-link to="/personal">个人中心</router-link>
      </el-menu-item>
    </el-menu>
    
<<<<<<< HEAD
=======
    <!-- 路由出口（页面内容显示区域） -->
>>>>>>> eca9c944a480341c8d84a8e6ab9e97d337a8f62a
    <router-view />
  </div>
</template>

<script setup>
<<<<<<< HEAD
</script>

<style>
*{
  margin:0;
  padding:0;
  box-sizing:border-box;
}
#app {
  max-width: 1000px;
  margin: 0 auto;
  padding: 20px;
  font-family: "Microsoft YaHei", sans-serif;
}
.carousel-box {
  border-radius: 20px;
  overflow: hidden;
  margin-bottom: 20px;
  box-shadow: 0 4px 10px rgba(0,0,0,0.1);
}
.carousel-item {
  width: 100%;
  height: 300px;
  display: flex;
  align-items: center;
  justify-content: center;
  color: white;
  font-size: 22px;
  font-weight: bold;
}
.bg1 {
  background: #f698c9;
}
.bg2 {
  background: #98d8f6;
}
.bg3 {
  background: #8b78e6;
}
.nav-menu {
  border-radius: 16px;
  margin-bottom: 20px;
=======
import { ref } from 'vue'
const activeIndex = ref('1')  // 默认选中登录页
</script>

<style scoped>
#app {
  max-width: 1200px;
  margin: 0 auto;
  padding: 20px;
>>>>>>> eca9c944a480341c8d84a8e6ab9e97d337a8f62a
}
</style>