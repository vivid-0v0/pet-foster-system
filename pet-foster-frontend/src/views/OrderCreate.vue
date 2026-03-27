<template>
  <div class="create-page">
    <div class="card">
      <h1>📋 创建寄养订单</h1>
      <el-form :model="form" label-width="100px">
        <el-form-item label="宠物名称">
          <el-input v-model="form.petName" />
        </el-form-item>
        <el-form-item label="类型">
          <el-select v-model="form.type">
            <el-option label="狗狗" value="dog" />
            <el-option label="猫咪" value="cat" />
          </el-select>
        </el-form-item>
        <el-form-item label="开始时间">
          <el-date-picker v-model="form.start" type="date" />
        </el-form-item>
        <el-form-item label="结束时间">
          <el-date-picker v-model="form.end" type="date" />
        </el-form-item>
        <el-form-item>
          <el-button type="primary">提交</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue'
const form = ref({
  petName: '',
  type: '',
  start: '',
  end: ''
})
</script>

<style scoped>
.create-page {
  display: flex;
  justify-content: center;
  padding: 20px;
}
.card {
  background: white;
  padding: 40px;
  border-radius: 20px;
  box-shadow: 0 4px 12px rgba(0,0,0,0.1);
  width: 600px;
}
.card h1 {
  text-align: center;
  margin-bottom: 25px;
  color: #8b78e6;
}
</style>