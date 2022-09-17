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
          <el-menu-item index="/front">网站首页</el-menu-item>
          <el-menu-item index="/course">课程展示</el-menu-item>
          <el-menu-item index="/store">店铺展示</el-menu-item>
          <el-menu-item index="/news">新闻资讯</el-menu-item>
          <el-menu-item index="/person">个人中心</el-menu-item>
        </el-menu>
      </div>
    </el-header>
    <el-main>
      <router-view></router-view>
    </el-main>
  </el-container>
</template>
<script>
export default {
  data() {
    return {
      activeIndex: "/front",
    };
  },
  methods: {
    handleSelect(key, keyPath) {
      console.log(key, keyPath);
    },
  },
};
</script>
<style scoped>
.menu {
  text-align: center;
}
.el-menu {
  display: inline-block;
}
</style>
