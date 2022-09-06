<template>
  <div style="margin-top: -60px">
      <el-container style="border: 1px solid red">
        <el-aside style="border: 1px solid white;background-color: #545c64;color: white" width="270px" class="lef">
          <h3>臻焙课工场</h3>
          <el-menu
              active-color="#ffd04b"
              background-color="#545c64"
              class="el-menu-vertical"
              default-active="2"
              text-color="#fff"
              @open="handleOpen"
              @close="handleClose"
          >
            <el-menu-item index="0-1">
              <el-icon><icon-menu /></el-icon>
              <span>统计分析</span>
            </el-menu-item>
            <el-menu-item style="border-bottom: 1px solid white" index="0-2">
              <el-icon><icon-menu /></el-icon>
              <span>深度分析</span>
            </el-menu-item>
            <el-menu-item index="1-1">
              <el-icon><icon-menu /></el-icon>
              <span>门店管理</span>
            </el-menu-item>
            <el-sub-menu index="1-2" >
              <template #title>
                <el-icon><location /></el-icon>
                <span style="color: white;">课程管理</span>
              </template>
                <el-menu-item index="1-2-1" style="margin-left: 30px">查看课程</el-menu-item>
                <el-menu-item index="1-2-2" style="margin-left: 30px">创建新课程</el-menu-item>
                <el-menu-item index="1-2-3" style="margin-left: 30px">修改课程信息</el-menu-item>
                <el-menu-item index="1-2-4" style="margin-left: 30px">删除课程</el-menu-item>
                <el-menu-item index="1-2-5" style="margin-left: 30px">配置课程</el-menu-item>
                <el-menu-item index="1-2-6" style="margin-left: 30px">课程追踪</el-menu-item>
            </el-sub-menu>
            <el-menu-item index="1-3">
              <el-icon><icon-menu /></el-icon>
              <span>讲师管理</span>
            </el-menu-item>
            <el-menu-item index="1-4">
              <el-icon><icon-menu /></el-icon>
              <span>学员管理</span>
            </el-menu-item>
            <el-menu-item index="1-5" style="border-bottom: 1px solid white">
              <el-icon><icon-menu /></el-icon>
              <span>订单管理</span>
            </el-menu-item>
            <el-sub-menu index="1-6" >
              <template #title>
                <el-icon><location /></el-icon>
                <span style="color: white;">权限管理</span>
              </template>
              <el-menu-item index="1-6-1" style="margin-left: 30px">查看角色</el-menu-item>
              <el-menu-item index="1-6-2" style="margin-left: 30px">角色管理</el-menu-item>
              <el-menu-item index="1-6-3" style="margin-left: 30px">创建员工账号</el-menu-item>
              <el-menu-item index="1-6-4" style="margin-left: 30px">查看权限</el-menu-item>
            </el-sub-menu>
          </el-menu>
        </el-aside>
        <el-container>
          <el-header style="border: 1px solid black" class="head">Header</el-header>
          <el-main style="border: 1px solid black" class="main">Main</el-main>
        </el-container>
      </el-container>
  </div>
</template>

<script>
// const handleOpen = (key: string, keyPath: string[]) => {
//   console.log(key, keyPath)
// }
// const handleClose = (key: string, keyPath: string[]) => {
//   console.log(key, keyPath)
// }
import {
  // Document,
  Menu as IconMenu,
  Location,
  // Setting,
} from '@element-plus/icons-vue'
export default {
  name: "myHome",
  components:{
    // Document,
    // eslint-disable-next-line vue/no-unused-components
    IconMenu,
    Location,
    // Setting
  }
}
</script>

<style scoped>
.lef{
    height: 800px;
}
.el-menu-vertical {
  border-top: 1px solid white;
}
::-webkit-scrollbar {
  width: 0;
  height: 0;
}

</style>