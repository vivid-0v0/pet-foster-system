<template>
  <div id="app">
    <!-- 顶部轮播图 - 预留图片位置 -->
    <el-carousel 
      height="400px" 
      autoplay 
      interval="5000" 
      indicator-position="bottom"
      class="carousel-box"
      trigger="click"
    >
      <el-carousel-item name="1">
        <div class="carousel-item page1">
          <!-- 替换：src/assets/images/Page1.png -->
          <div class="carousel-placeholder">
            <i class="el-icon-picture-outline"></i>
            
            
          </div>
          <div class="carousel-text">
            <h1>🐾 欢迎来到宠物寄养系统</h1>
            <p>专业呵护 · 安心托付</p>
          </div>
        </div>
      </el-carousel-item>
      <el-carousel-item name="2">
        <div class="carousel-item page2">
          <!-- 替换：src/assets/images/Page2.png -->
          <div class="carousel-placeholder">
            <i class="el-icon-picture-outline"></i>
            
            
          </div>
          <div class="carousel-text">
            <h1>🐶 给毛孩子一个温暖的家</h1>
            <p>24小时看护 · 科学喂养</p>
          </div>
        </div>
      </el-carousel-item>
      <el-carousel-item name="3">
        <div class="carousel-item page3">
          <!-- 替换：src/assets/images/Page3.png -->
          <div class="carousel-placeholder">
            <i class="el-icon-picture-outline"></i>
            
            
          </div>
          <div class="carousel-text">
            <h1>🐱 专业寄养 · 安心陪伴</h1>
            <p>实时监控 · 每日反馈</p>
          </div>
        </div>
      </el-carousel-item>
    </el-carousel>

    <!-- 导航栏 -->
    <el-menu 
      :default-active="activeIndex" 
      mode="horizontal" 
      background-color="#fff" 
      text-color="#333" 
      active-text-color="#8b78e6"
      class="nav-menu"
    >
      <el-menu-item index="1">
        <i class="el-icon-user"></i>
        <router-link to="/login">登录</router-link>
      </el-menu-item>
      <el-menu-item index="2">
        <i class="el-icon-edit"></i>
        <router-link to="/order/create">创建订单</router-link>
      </el-menu-item>
      <el-menu-item index="3">
        <i class="el-icon-menu"></i>
        <router-link to="/order/list">我的订单</router-link>
      </el-menu-item>
      <el-menu-item index="4">
        <i class="el-icon-setting"></i>
        <router-link to="/personal">个人中心</router-link>
      </el-menu-item>
      <el-menu-item index="5">
        <i class="el-icon-info"></i>
        <router-link to="/about">关于我们</router-link>
      </el-menu-item>
    </el-menu>
    
    <!-- 首页特色模块（仅首页显示） -->
    <div v-if="$route.path === '/' || $route.path === '/login'" class="home-features">
      <div class="feature-card">
        <i class="el-icon-house"></i>
        <h3>舒适环境</h3>
        <p>独立空间，恒温恒湿，每日清洁消毒</p>
      </div>
      <div class="feature-card">
        <i class="el-icon-user-solid"></i>
        <h3>专业看护</h3>
        <p>持证宠物护理师，24小时贴心陪伴</p>
      </div>
      <div class="feature-card">
        <i class="el-icon-video-camera"></i>
        <h3>实时监控</h3>
        <p>专属摄像头，随时查看宠物状态</p>
      </div>
      <div class="feature-card">
        <i class="el-icon-medical-record"></i>
        <h3>健康保障</h3>
        <p>每日健康记录，就近合作宠物医院</p>
      </div>
    </div>

    <!-- 路由出口 -->
    <router-view />

    <!-- 底部版权 -->
    <footer class="app-footer">
      <p>🐾 宠物寄养系统 © 2025 版权所有</p>
      <div class="footer-links">
        <a href="javascript:;">隐私政策</a>
        <a href="javascript:;">用户协议</a>
        <a href="javascript:;">联系我们</a>
      </div>
    </footer>
  </div>
</template>

<script setup>
import { ref, watch } from 'vue'
import { useRoute } from 'vue-router'

const activeIndex = ref('1')
const route = useRoute()

// 路由变化时更新导航选中状态
watch(() => route.path, (path) => {
  switch(path) {
    case '/login': activeIndex.value = '1'; break
    case '/order/create': activeIndex.value = '2'; break
    case '/order/list': activeIndex.value = '3'; break
    case '/personal': activeIndex.value = '4'; break
    case '/about': activeIndex.value = '5'; break
    default: activeIndex.value = '1'
  }
}, { immediate: true })
</script>

<style scoped>
/* 全局页面背景：温馨淡黄色 */
:root {
  background-color: #fffaf0;
}
#app {
  max-width: 1200px;
  margin: 0 auto;
  padding: 20px;
  font-family: "Microsoft YaHei", sans-serif;
  /* 给容器也加一点同色系背景，更柔和 */
  background-color: #fffaf0;
}

/* 轮播图样式 */
.carousel-box {
  border-radius: 20px;
  overflow: hidden;
  margin-bottom: 20px;
  box-shadow: 0 8px 24px rgba(0,0,0,0.15);
}
.carousel-item {
  width: 100%;
  height: 400px;
  display: flex;
  align-items: center;
  justify-content: center;
  color: white;
  position: relative;
  background-size: cover;
  background-position: center;
  border-radius: 20px;
}
/* 轮播图占位样式 */
.carousel-placeholder {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background: rgba(0,0,0,0.1);
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  color: #666;
  z-index: 1;
}
.carousel-placeholder i {
  font-size: 48px;
  margin-bottom: 10px;
}
.carousel-placeholder p {
  font-size: 20px;
  font-weight: bold;
}
.carousel-placeholder small {
  color: #999;
  margin-top: 8px;
}
/* 轮播图文字 */
.carousel-text {
  position: relative;
  z-index: 2;
  text-align: center;
  text-shadow: 0 2px 8px rgba(0,0,0,0.3);
  background: rgba(0,0,0,0.2);
  padding: 20px 40px;
  border-radius: 12px;
}
.carousel-text h1 {
  font-size: 36px;
  margin-bottom: 16px;
}
.carousel-text p {
  font-size: 18px;
  opacity: 0.9;
}
/* 轮播图背景色（临时） */
.page1 { 
  background-image: url('@/assets/images/Page1.png'); 
}
.page2 { 
  background-image: url('@/assets/images/Page2.png'); 
}
.page3 { 
  background-image: url('@/assets/images/Page3.png'); 
}

/* 导航样式 */
.nav-menu {
  border-radius: 16px;
  margin-bottom: 30px;
  padding: 0 20px;
  box-shadow: 0 4px 12px rgba(0,0,0,0.08);
}
.nav-menu :deep(.el-menu-item) {
  border-radius: 10px;
  margin: 0 5px;
  padding: 0 20px;
}
.nav-menu :deep(.el-menu-item i) {
  margin-right: 8px;
}

/* 首页特色模块 */
.home-features {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
  gap: 20px;
  margin-bottom: 30px;
}
.feature-card {
  background: white;
  padding: 30px 20px;
  border-radius: 16px;
  box-shadow: 0 4px 16px rgba(0,0,0,0.08);
  text-align: center;
  transition: transform 0.3s ease;
}
.feature-card:hover {
  transform: translateY(-5px);
}
.feature-card i {
  font-size: 40px;
  color: #8b78e6;
  margin-bottom: 15px;
}
.feature-card h3 {
  font-size: 18px;
  font-weight: 600;
  margin-bottom: 10px;
  color: #333;
}
.feature-card p {
  color: #666;
  font-size: 14px;
  line-height: 1.5;
}

/* 底部样式 */
.app-footer {
  margin-top: 40px;
  padding: 20px;
  text-align: center;
  border-top: 1px solid #eee;
  color: #999;
}
.footer-links {
  margin-top: 10px;
}
.footer-links a {
  color: #8b78e6;
  margin: 0 10px;
  text-decoration: none;
  font-size: 14px;
}
.footer-links a:hover {
  text-decoration: underline;
}
</style>