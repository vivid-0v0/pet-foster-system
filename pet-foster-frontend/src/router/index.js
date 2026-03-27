import { createRouter, createWebHistory } from 'vue-router'

// 导入页面组件
import Login from '../views/LoginForm.vue'
import OrderCreate from '../views/OrderCreate.vue'
import OrderList from '../views/OrderList.vue'
import PersonalCenter from '../views/PersonalCenter.vue'
import AboutView from '../views/AboutView.vue' // 新增

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      redirect: '/login'
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
    },
    { // 新增About路由
      path: '/about',
      name: 'about',
      component: AboutView
    }
  ]
})

export default router