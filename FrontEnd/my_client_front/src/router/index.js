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
      ],
    },
  ],
});

export default router;
