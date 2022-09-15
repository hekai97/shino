<template>
  <div class="content">
    <div class="left">
      <el-menu
        default-active="2"
        :router="true"
        class="el-menu-vertical-demo"
        @open="handleOpen"
        @close="handleClose">
        <el-submenu>
          <template slot="title">
            <i class="el-icon-menu"></i>
            <span>个人中心</span>
          </template>
          <el-menu-item index="/info">个人信息</el-menu-item>
        </el-submenu>
        <el-submenu index="2">
          <template slot="title">
            <i class="el-icon-document"></i>
            <span>课程中心</span>
          </template>
          <el-menu-item index="/car">购物车</el-menu-item>
          <el-menu-item>未预约</el-menu-item>
          <el-menu-item>已预约</el-menu-item>
          <el-menu-item>已上课</el-menu-item>
        </el-submenu>
      </el-menu>
    </div>
    <div class="right">
      <router-view></router-view>
    </div>
  </div>
</template>
<script>
export default {
  methods: {
    handleOpen(key, keyPath) {
      console.log(key, keyPath);
    },
    handleClose(key, keyPath) {
      console.log(key, keyPath);
    }
  }
}
</script>
<style scoped>
  .left{
    width: 20%;
    float: left;
  }
  .right{
    width: 80%;
    float: right;
  }
</style>
