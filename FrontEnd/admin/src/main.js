import { createApp } from 'vue'
import router from './router'
import store from './store'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import App from './App.vue'
import * as ElementPlusIconsVue from '@element-plus/icons-vue'
import axios from "axios"
//其他vue组件中就可以this.$axios调用使用
createApp(App).config.globalProperties.$axios = axios;
for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
    createApp(App).component(key, component)
}
createApp(App).use(store).use(router).use(ElementPlus).mount('#app')




