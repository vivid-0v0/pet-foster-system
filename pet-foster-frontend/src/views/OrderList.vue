<template>
  <div class="list-page">
    <div class="card">
      <div class="card-header">
        <h1>📋 我的寄养订单</h1>
        <el-input 
          v-model="searchText" 
          placeholder="搜索宠物名/订单号" 
          prefix-icon="el-icon-search"
          class="search-input"
        />
      </div>
      
      <!-- 订单筛选 -->
      <div class="filter-bar">
        <el-select v-model="statusFilter" placeholder="全部状态" class="filter-select">
          <el-option label="全部状态" value="" />
          <el-option label="进行中" value="进行中" />
          <el-option label="已完成" value="已完成" />
          <el-option label="已取消" value="已取消" />
        </el-select>
        <el-button type="primary" icon="el-icon-refresh" @click="refreshList">刷新</el-button>
      </div>
      
      <!-- 订单列表 -->
      <el-table 
        :data="filteredList" 
        border 
        stripe
        style="width: 100%"
        empty-text="暂无订单数据，快去创建吧～"
        :header-cell-style="{background: '#f8f9fa'}"
      >
        <el-table-column prop="orderNo" label="订单号" width="120" />
        <el-table-column prop="petName" label="宠物名" width="100" />
        <el-table-column prop="type" label="宠物类型" width="100">
          <template #default="scope">
            <el-tag :type="scope.row.type === 'dog' ? 'primary' : 'success'">
              {{ scope.row.type === 'dog' ? '狗狗' : '猫咪' }}
            </el-tag>
          </template>
        </el-table-column>
        <el-table-column prop="start" label="开始时间" width="180" />
        <el-table-column prop="end" label="结束时间" width="180" />
        <el-table-column prop="status" label="状态" width="100">
          <template #default="scope">
            <el-tag 
              :type="scope.row.status === '进行中' ? 'warning' : scope.row.status === '已完成' ? 'success' : 'danger'"
            >
              {{ scope.row.status }}
            </el-tag>
          </template>
        </el-table-column>
        <el-table-column label="操作" width="180">
          <template #default="scope">
            <el-button type="text" icon="el-icon-view" @click="viewDetail(scope.row)">查看</el-button>
            <el-button 
              type="text" 
              icon="el-icon-delete" 
              @click="cancelOrder(scope.row)"
              v-if="scope.row.status === '进行中'"
              style="color: #f56c6c"
            >
              取消
            </el-button>
          </template>
        </el-table-column>
      </el-table>
      
      <!-- 分页 -->
      <el-pagination
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :current-page="currentPage"
        :page-sizes="[5, 10, 20]"
        :page-size="pageSize"
        layout="total, sizes, prev, pager, next, jumper"
        :total="filteredList.length"
        class="pagination"
      >
      </el-pagination>
    </div>
  </div>
</template>

<script setup>
import { ref, computed } from 'vue'
import { ElMessage } from 'element-plus'

// 模拟订单数据
const list = ref([
  { orderNo: '1001', petName: '旺财', type: 'dog', start: '2025-01-10', end: '2025-01-20', status: '进行中' },
  { orderNo: '1002', petName: '咪咪', type: 'cat', start: '2025-01-01', end: '2025-01-05', status: '已完成' },
  { orderNo: '1003', petName: '小白', type: 'dog', start: '2025-01-15', end: '2025-01-25', status: '进行中' },
  { orderNo: '1004', petName: '橘猫', type: 'cat', start: '2024-12-20', end: '2024-12-30', status: '已完成' },
  { orderNo: '1005', petName: '小黑', type: 'dog', start: '2025-01-08', end: '2025-01-18', status: '已取消' },
])

// 搜索和筛选
const searchText = ref('')
const statusFilter = ref('')
const filteredList = computed(() => {
  return list.value.filter(item => {
    const matchSearch = item.petName.includes(searchText.value) || item.orderNo.includes(searchText.value)
    const matchStatus = statusFilter.value ? item.status === statusFilter.value : true
    return matchSearch && matchStatus
  })
})

// 分页
const currentPage = ref(1)
const pageSize = ref(5)
const handleSizeChange = (val) => {
  pageSize.value = val
}
const handleCurrentChange = (val) => {
  currentPage.value = val
}

// 操作方法
const refreshList = () => {
  ElMessage.success('订单列表已刷新')
}
const viewDetail = (row) => {
  ElMessage.info(`查看订单 ${row.orderNo} 详情`)
}
const cancelOrder = (row) => {
  ElMessage.confirm('确定取消该订单吗？', '提示', {
    confirmButtonText: '确定',
    cancelButtonText: '取消',
    type: 'warning'
  }).then(() => {
    row.status = '已取消'
    ElMessage.success('订单已取消')
  }).catch(() => {
    ElMessage.info('已取消操作')
  })
}
</script>

<style scoped>
.list-page {
  padding: 20px;
  min-height: 80vh;
  background-color: #fffaf0; /* 统一温馨淡黄色背景 */
}
.card {
  background: white;
  padding: 30px;
  border-radius: 20px;
  box-shadow: 0 4px 12px rgba(0,0,0,0.1);
}
.card-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 20px;
}
.card-header h1 {
  text-align: center;
  margin: 0;
  color: #8b78e6;
  font-size: 24px;
}
.search-input {
  width: 300px;
}
.filter-bar {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 20px;
}
.filter-select {
  width: 200px;
}
.pagination {
  margin-top: 20px;
  text-align: right;
}
</style>