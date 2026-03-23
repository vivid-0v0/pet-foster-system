<template>
  <div id="app">
    <!-- 导航栏 -->
    <el-menu :default-active="activeIndex" mode="horizontal" background-color="#fff" text-color="#333" active-text-color="#409eff">
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
    
    <!-- 路由出口（页面内容显示区域） -->
    <router-view />
  </div>
</template>

<script setup>
import { ref } from 'vue'
const activeIndex = ref('1')  // 默认选中登录页
</script>

<style scoped>
#app {
  max-width: 1200px;
  margin: 0 auto;
  padding: 20px;
}
</style>