<template>
  <div class="create-container">
    <div class="create-card">
      <h2>📝 创建寄养订单</h2>
      <el-form label-width="100px">
        <el-form-item label="宠物名称">
          <el-input placeholder="请输入宠物名称" />
        </el-form-item>
        <el-form-item label="宠物类型">
          <el-select placeholder="请选择类型">
            <el-option label="狗狗" value="dog" />
            <el-option label="猫咪" value="cat" />
          </el-select>
        </el-form-item>
        <el-form-item label="寄养开始">
          <el-date-picker type="date" placeholder="选择日期" />
        </el-form-item>
        <el-form-item label="寄养结束">
          <el-date-picker type="date" placeholder="选择日期" />
        </el-form-item>
        <el-form-item label="特殊要求">
          <el-input type="textarea" rows="3" placeholder="请填写喂养/健康要求" />
        </el-form-item>
        <el-form-item>
          <el-button type="primary" block>提交订单</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script setup>
</script>

<style scoped>
.create-container {
  max-width: 700px;
  margin: 0 auto;
  padding: 20px 0;
  /* 统一温馨淡黄色背景 */
  background-color: #fffaf0;
  min-height: 80vh;
}
.create-card {
  padding: 30px;
  background: white;
  border-radius: 20px;
  box-shadow: 0 4px 20px rgba(0,0,0,0.1);
}
.create-card h2 {
  text-align: center;
  margin-bottom: 30px;
  color: #8b78e6;
}
</style>