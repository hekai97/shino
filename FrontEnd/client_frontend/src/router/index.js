import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path:'/index',
      name:'index',
      component:function (){
        return import('../components/index.vue')
      },
      redirect: '/front',//页面默认加载的路由
      children:[
        {
          path:'/front',
          name:'front',
          component:function (){
            return import('../components/front.vue')
          }
        },
        {
          path:'/course',
          name:'/course',
          component:function (){
            return import('../components/course.vue')
          }
        }
      ]
    },
  ]
})
