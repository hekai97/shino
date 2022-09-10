<template>
  <div>
    <el-container style="border: 1px solid red">
      <el-aside style="border: 1px solid white;background-color: #7ab8cc;color: white" width="isCollapse ? '30px' : '270px'" class="lef">

        <el-menu
            active-color="#ffd04b"
            background-color="#7ab8cc"
            class="el-menu-vertical"
            default-active="2"
            text-color="#fff"
            :collapse="isCollapse"
        >
          <el-menu-item index="0-0" disabled>
            <span style="color: white;font-size: 17px"><h3>员工操作平台</h3></span>
          </el-menu-item>
          <el-menu-item index="0-1">
            <el-icon><IceCream /></el-icon>
            <span style="margin-left: 3px">店铺经营状况</span>
          </el-menu-item>

          <el-sub-menu index="0-2" >
            <template #title>
              <el-icon><Notebook /></el-icon>
              <span style="margin-left: 3px">排课</span>
            </template>
            <el-menu-item index="0-2-1" style="margin-left: 30px">预约</el-menu-item>
            <el-menu-item index="0-2-2" style="margin-left: 30px">排课</el-menu-item>
          </el-sub-menu>

          <el-menu-item index="1-1">
            <el-icon><AlarmClock /></el-icon>
            <span style="margin-left: 3px">上课签到</span>
          </el-menu-item>

          <el-sub-menu index="1-2" >
            <template #title>
              <el-icon><Mouse /></el-icon>
              <span style="margin-left: 3px">信息录入</span>
            </template>
            <el-menu-item index="1-2-1" style="margin-left: 30px">查看课程</el-menu-item>
          </el-sub-menu>

          <el-menu-item index="1-3">
            <el-icon><User /></el-icon>
            <span style="margin-left: 3px">档案</span>
          </el-menu-item>

          <el-menu-item index="1-4">
            <el-icon><Tools /></el-icon>
            <span style="margin-left: 3px">设置</span>
          </el-menu-item>

          <el-menu-item index="1-5" >
            <el-icon><InfoFilled /></el-icon>
            <span style="margin-left: 3px">关于</span>
          </el-menu-item>

        </el-menu>
        <el-radio-group v-model="isCollapse" style="margin-left: 0px;width: 30px" size="mini" >

          <el-radio-button :label="true"><el-icon><DArrowLeft /></el-icon></el-radio-button>
          <el-radio-button :label="false"><el-icon><DArrowRight /></el-icon></el-radio-button>
        </el-radio-group>
      </el-aside>
      <el-container>
        <el-header style="border: 1px solid black" class="head">
        </el-header>
        <el-main style="border: 1px solid black" class="main">
          <el-timeline>
            <el-timeline-item center timestamp="2022/9/7" placement="top">
              <el-card>
                <h4 style="margin-left: 0px">订单号：</h4>
                <el-divider />
                <p style="left: auto">课程名称</p>
                <el-divider />
              </el-card>
            </el-timeline-item>
          </el-timeline>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>
import {
  Menu as IconMenu,
  IceCream,
  Notebook,
  AlarmClock,
  Mouse,
  User,
  Tools,
  DArrowLeft,
  DArrowRight,
  InfoFilled
} from '@element-plus/icons'
export default {
  // eslint-disable-next-line vue/multi-word-component-names
  name: 'mybook',
  components: {
    // eslint-disable-next-line vue/no-unused-components
    IconMenu,
    IceCream,
    Notebook,
    AlarmClock,
    Mouse,
    User,
    Tools,
    DArrowLeft,
    DArrowRight,
    InfoFilled
  },
  data () {
    return {
      isCollapse: true
    }
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
