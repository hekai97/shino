import { createRouter, createWebHashHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import firsthome from '../views/Home.vue'
import Login from '../views/Login'
import Deep from '../views/Deepanalysis'
import Store from '../views/Store'
import teacher from "@/views/teacher";
const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/about',
    name: 'about',
    component: () => import(/* webpackChunkName: "about" */ '../views/Navigaation')
  },
  {
    path:'/firsthome',
    name:'firsthome',
    component:firsthome
  },
  {
    path: '/Login',
    name:'Login',
    component: Login
  },
  {
    path:'/Deep',
    name:'Deep',
    component: Deep
  },
  {
    path:'/Store',
    name: 'Store',
    component: Store
  },
  {
    path: '/teacher',
    name: 'teacher',
    component: teacher
  }
]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router
