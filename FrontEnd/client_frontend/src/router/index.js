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
      path:'/ActivityWindow',
      name:'ActivityWindow',
      component:function (){
        return import('../components/ActivityWindow.vue')
      }
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
          name:'course',
          component:function (){
            return import('../components/course.vue')
          }
        },
        {
          path:'/store',
          name:'store',
          component:function (){
            return import('../components/store.vue')
          }
        },
        {
          path:'/detail',
          name:'detail',
          component:function (){
            return import('../components/detail.vue')
          }
        },
        {
          path:'/news',
          name:'news',
          component:function (){
            return import('../components/news.vue')
          }
        },
        {
          path:'/person',
          name:'person',
          component:function (){
            return import('../components/person.vue')
          },
          children:[
            {
              path:'/info',
              name:'info',
              component:function (){
                return import('../components/info.vue')
              }
            },
            {
              path:'/car',
              name:'car',
              component:function (){
                return import('../components/car.vue')
              }
            }
          ]
        }
      ]
    },
  ]
})
