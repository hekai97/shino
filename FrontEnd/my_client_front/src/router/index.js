import { createRouter, createWebHistory } from "vue-router";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: "/",
      name: "login",
      component: () => import("@/views/LoginView.vue"),
    },
    {
      path: "/index",
      name: "index",
      component: () => import("@/views/IndexView.vue"),
      redirect: "/index/front", //页面默认加载的路由
      children: [
        {
          path: "front",
          name: "首页",
          component: () => import("@/views/FrontView.vue"),
        },
        {
          path: "course",
          name: "课程界面",
          component: () => import("@/views/CourseView.vue"),
        },
        {
          path: "store",
          name: "商店页面",
          component: () => import("@/views/StoreView.vue"),
        },
        {
          path: "person",
          name: "个人页面",
          component: () => import("@/views/PersonView.vue"),
          children: [
            {
              path: "info",
              name: "信息",
              component: () => import("@/views/PersonInfo.vue"),
            },
            {
              path: "shoppingcart",
              name: "购物车",
              component: () => import("@/views/ShoppingCart.vue"),
            },
            {
              path: "noReservation",
              name: "未预约",
              component: () => import("@/views/NoReservationView.vue"),
            },
            {
              path: "alreadyReservation",
              name: "已预约",
              component: () => import("@/views/AlreadyReservation.vue"),
            },
            {
              path: "alreadyDone",
              name: "上完课",
              component: () => import("@/views/AlreadyDone.vue"),
            },
          ],
        },
      ],
    },
    {
      path: "/storeDetail",
      name: "storeDetail",
      component: () => import("@/views/StoreDetail.vue"),
    },
  ],
});

export default router;
