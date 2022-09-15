import { createApp } from 'vue'
import router from './router'
import store from './store'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import App from './App.vue'
import * as ElementPlusIconsVue from '@element-plus/icons-vue'
import VDistpicker from 'v-distpicker'
createApp(App).component('v-distpicker', VDistpicker)

import axios from "axios"
//其他vue组件中就可以this.$axios调用使用
createApp(App).config.globalProperties.$axios = axios;
axios.defaults.baseURL='/api'
for(let iconName in ElementPlusIconsVue){
    createApp(App).component(iconName,ElementPlusIconsVue[iconName])
}
createApp(App).use(store).use(router).use(ElementPlus).mount('#app')



