import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import axios from "axios"
createApp(App).config.globalProperties.$axios=axios
axios.defaults.baseURL='/api'
createApp(App).use(store).use(ElementPlus).use(router).mount('#app')
