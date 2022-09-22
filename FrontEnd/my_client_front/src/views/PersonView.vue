<template>
  <div class="content">
    <div class="left">
      <el-menu
        default-active="2"
        :router="true"
        class="el-menu-vertical-demo"
        @open="handleOpen"
        @close="handleClose"
      >
        <el-submenu>
          <template v-slot:title>
            <i class="el-icon-menu"></i>
            <span>个人中心</span>
          </template>
          <el-menu-item index="/index/person/info">个人信息</el-menu-item>
        </el-submenu>
        <el-menu-item index="/index/person/changePassword"
          >修改密码</el-menu-item
        >
        <el-submenu index="2">
          <template v-slot:title>
            <i class="el-icon-document"></i>
            <span>课程中心</span>
          </template>
          <el-menu-item index="/index/person/shoppingcart">购物车</el-menu-item>
          <el-menu-item index="/index/person/noReservation">
            未预约
          </el-menu-item>
          <el-menu-item index="/index/person/alreadyReservation">
            已预约
          </el-menu-item>
          <el-menu-item index="/index/person/alreadyDone">已上课</el-menu-item>
          <el-menu-item index="/index/person/suggestion">意见反馈</el-menu-item>
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
    },
  },
};
</script>
<style scoped>
.left {
  width: 20%;
  float: left;
}
.right {
  width: 80%;
  float: right;
}
</style>
