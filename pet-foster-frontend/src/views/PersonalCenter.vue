<template>
  <div class="personal-container">
    <div class="personal-card">
      <h2>👤 个人中心</h2>
      <el-descriptions title="用户信息" column={1}>
        <el-descriptions-item label="用户昵称">铲屎官</el-descriptions-item>
        <el-descriptions-item label="联系电话">13800138000</el-descriptions-item>
        <el-descriptions-item label="注册时间">2025-01-01</el-descriptions-item>
      </el-descriptions>

      <div style="margin-top:30px">
        <el-button type="primary">修改资料</el-button>
        <el-button style="margin-left:10px">退出登录</el-button>
      </div>
    </div>
  </div>
</template>

<script setup>
</script>

<style scoped>
.personal-container {
  max-width: 700px;
  margin: 0 auto;
  padding: 20px 0;
  min-height: 70vh;
  background-color: #fffaf0; /* 统一温馨淡黄色背景 */
}
.personal-card {
  padding: 30px;
  background: white;
  border-radius: 20px;
  box-shadow: 0 4px 20px rgba(0,0,0,0.1);
}
.personal-card h2 {
  text-align: center;
  margin-bottom: 30px;
  color: #8b78e6;
}
</style>