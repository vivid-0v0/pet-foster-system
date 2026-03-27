<template>
  <div class="personal-page">
    <div class="card">
      <h1>👤 个人中心</h1>
      <el-descriptions title="我的信息">
        <el-descriptions-item label="用户名">test</el-descriptions-item>
        <el-descriptions-item label="状态">已登录</el-descriptions-item>
      </el-descriptions>
    </div>
  </div>
</template>

<script setup>
</script>

<style scoped>
.personal-page {
  padding: 20px;
}
.card {
  background: white;
  padding: 30px;
  border-radius: 20px;
  box-shadow: 0 4px 12px rgba(0,0,0,0.1);
}
.card h1 {
  text-align: center;
  margin-bottom: 20px;
  color: #8b78e6;
}
</style>