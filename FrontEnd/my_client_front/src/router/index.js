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
      redirect: "/front", //页面默认加载的路由
      children: [
        {
          path: "/front",
          name: "front",
          component: () => import("@/views/FrontView.vue"),
        },
        {
          path: "/course",
          name: "course",
          component: () => import("@/views/CourseView.vue"),
        },
        {
          path: "/store",
          name: "store",
          component: () => import("@/views/StoreView.vue"),
        },
        {
          path: "/person",
          name: "person",
          component: () => import("@/views/PersonView.vue"),
          children: [
            {
              path: "/info",
              name: "info",
              component: () => import("@/views/PersonInfo.vue"),
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
