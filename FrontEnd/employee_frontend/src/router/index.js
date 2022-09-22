import { createRouter, createWebHashHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import login from '../views/demo.vue'
import home from '../views/home.vue'
// import book from '../views/book'
import schedule from '../views/schedule'
// import sign from '../views/sign'
const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  },
  {
    path:'/login',
    name:'login',
    component: login
  },
  {
    path:'/home',
    name:'home',
    component: home
  },
  {
    path:'/book',
    name:'book',
    // component:book
    component: () => import(/* webpackChunkName: "about" */ '../views/book.vue')
  },
  {
    path:'/schedule',
    name:'schedule',
    component: schedule
  },
  // {
  //   path: '/sign',
  //   name: 'sign',
  //   component: sign
  // }
]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router
