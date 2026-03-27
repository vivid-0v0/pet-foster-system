<template>
<<<<<<< HEAD
  <div class="list-page">
    <div class="card">
      <h1>📋 我的寄养订单</h1>
      <el-table :data="list" border>
        <el-table-column prop="orderNo" label="订单号" />
        <el-table-column prop="petName" label="宠物名" />
        <el-table-column prop="status" label="状态" />
      </el-table>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue'
const list = ref([
  { orderNo: '1001', petName: '旺财', status: '进行中' },
  { orderNo: '1002', petName: '咪咪', status: '已完成' }
])
</script>

<style scoped>
.list-page {
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
=======
    <div class="order-list">
      <h1>我的寄养订单</h1>
      <!-- 后续添加订单列表 -->
    </div>
  </template>
  
  <script setup>
  // 订单列表逻辑后续补充
  </script>
  
  <style scoped>
  .order-list {
    padding: 20px;
  }
  </style>
>>>>>>> eca9c944a480341c8d84a8e6ab9e97d337a8f62a
