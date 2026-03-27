<template>
  <div class="login-container">
    <div class="login-card">
      <h2>🐾 宠物寄养系统登录</h2>
      <el-form label-width="80px">
        <el-form-item label="账号">
          <el-input placeholder="请输入账号" />
        </el-form-item>
        <el-form-item label="密码">
          <el-input placeholder="请输入密码" show-password />
        </el-form-item>
        <el-form-item>
          <el-button type="primary" block>登录</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script setup>
</script>

<style scoped>
/* 登录页整体：温馨淡黄色背景 */
.login-container {
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 60vh;
  background-color: #fffaf0; /* 统一淡黄色背景 */
}
.login-card {
  width: 400px;
  padding: 30px;
  background: white;
  border-radius: 20px;
  box-shadow: 0 4px 20px rgba(0,0,0,0.1);
}
.login-card h2 {
  text-align: center;
  margin-bottom: 30px;
  color: #8b78e6;
}
</style>