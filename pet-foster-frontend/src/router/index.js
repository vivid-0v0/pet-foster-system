import { createRouter, createWebHistory } from 'vue-router'

// 导入页面组件（先创建空组件，后续补代码）
import Login from '../views/LoginForm.vue'
import OrderCreate from '../views/OrderCreate.vue'
import OrderList from '../views/OrderList.vue'
import PersonalCenter from '../views/PersonalCenter.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      redirect: '/login'  // 默认跳转到登录页
    },
    {
      path: '/login',
      name: 'login',
      component: Login
    },
    {
      path: '/order/create',
      name: 'orderCreate',
      component: OrderCreate
    },
    {
      path: '/order/list',
      name: 'orderList',
      component: OrderList
    },
    {
      path: '/personal',
      name: 'personalCenter',
      component: PersonalCenter
    }
  ]
})

export default router