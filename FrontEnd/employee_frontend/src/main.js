import Vue, { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import axios from "axios"
createApp(App).config.globalProperties.$axios=axios
axios.defaults.baseURL='/api'
createApp(App).use(store).use(ElementPlus).use(router).mount('#app')
/* 对axios进行全局配置，因为表单验证完要发起网络请求了 */
//配置请求的根路径
// axios.defaults.baseURL='/api'
/*把axios这个包挂载到vue的原型对象上，这样的话vue的每一个组件都可通过this直接访问到http，从而去发起ajax请求 */
// Vue.prototype.$http = axiosVue.config.productionTip = false
