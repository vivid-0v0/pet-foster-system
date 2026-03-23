import { createApp } from 'vue'
import { createPinia } from 'pinia'
import ElementPlus from 'element-plus'  // 引入Element Plus
import 'element-plus/dist/index.css'     // 引入Element Plus样式
import axios from 'axios'                // 引入Axios

import App from './App.vue'
import router from './router'

const app = createApp(App)

// 全局挂载Pinia、Router、Element Plus
app.use(createPinia())
app.use(router)
app.use(ElementPlus)

// 全局挂载Axios（方便所有组件使用）
app.config.globalProperties.$axios = axios
// 配置Axios默认请求地址（后端接口地址）
axios.defaults.baseURL = 'http://localhost:8080'

app.mount('#app')