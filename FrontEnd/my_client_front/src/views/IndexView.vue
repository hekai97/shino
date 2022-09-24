<template>
  <el-container>
    <el-header>
      <div class="menu">
        <el-menu
          :default-active="activeIndex"
          :router="true"
          class="el-menu-demo"
          mode="horizontal"
          @select="handleSelect"
          :ellipsis="false"
        >
          <el-menu-item index="/index/front">网站首页</el-menu-item>
          <el-menu-item index="/index/course">课程展示</el-menu-item>
          <el-menu-item index="/index/store">店铺展示</el-menu-item>
          <!-- <el-menu-item index="/index/news">新闻资讯</el-menu-item> -->
          <el-menu-item index="/index/person" @click="checkLoginStatus"
            >个人中心</el-menu-item
          >
          <el-menu-item v-if="!isLogin" index="/">登录</el-menu-item>
          <el-menu-item v-else index="" @click="logout">退出登录</el-menu-item>
        </el-menu>
      </div>
    </el-header>
    <el-main>
      <router-view></router-view>
    </el-main>
  </el-container>
</template>
<script>
import axios from "axios";

export default {
  data() {
    return {
      isLogin: false,
      activeIndex: "/front",
    };
  },
  mounted() {
    this.checkUserLoginInfo();
  },
  methods: {
    handleSelect(key, keyPath) {
      console.log(key, keyPath);
    },
    checkUserLoginInfo() {
      axios({
        method: "post",
        url: "/student/getUserInfo",
      }).then((res) => {
        if (res.data.status == 0) {
          this.isLogin = true;
        } else {
          this.isLogin = false;
        }
      });
    },
    checkLoginStatus() {
      if (!this.isLogin) {
        this.$router.push("/");
      }
    },
    logout() {
      axios({
        method: "post",
        url: "/student/logout",
      }).then((res) => {
        if (res.data.status == 0) {
          this.isLogin = false;
          this.$router.push("/");
        }
      });
    },
  },
};
</script>
<style scoped>
.menu {
  text-align: center;
}
.el-menu {
  display: inline-flex;
}
</style>
