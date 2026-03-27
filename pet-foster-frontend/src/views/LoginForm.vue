<template>
<<<<<<< HEAD
  <div class="login-page">
    <div class="login-card">
      <h1>🐾 宠物寄养系统登录</h1>
      <el-form :model="loginForm" label-width="80px">
        <el-form-item label="用户名">
          <el-input v-model="loginForm.username" placeholder="请输入" />
        </el-form-item>
        <el-form-item label="密码">
          <el-input v-model="loginForm.password" type="password" placeholder="请输入" />
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="handleLogin">登录</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue'
const loginForm = ref({
  username: '',
  password: ''
})
const handleLogin = () => {
  console.log('登录')
}
</script>

<style scoped>
.login-page {
  display: flex;
  justify-content: center;
  padding: 40px 0;
}
.login-card {
  background: white;
  padding: 40px;
  border-radius: 20px;
  box-shadow: 0 4px 12px rgba(0,0,0,0.1);
  width: 400px;
}
.login-card h1 {
  text-align: center;
  margin-bottom: 30px;
  color: #8b78e6;
}
</style>
=======
    <div class="login-page">
      <h1>宠物寄养-登录页</h1>
      <!-- 后续添加登录表单 -->
    </div>
  </template>
  
  <script setup>
  // 登录逻辑后续补充
  </script>
  
  <style scoped>
  .login-page {
    padding: 20px;
    text-align: center;
  }
  </style>
>>>>>>> eca9c944a480341c8d84a8e6ab9e97d337a8f62a
