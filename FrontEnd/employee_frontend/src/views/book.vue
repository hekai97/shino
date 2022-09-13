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
        <el-header  class="head">
          <div style="display: table-cell;">
            <div style="display: inline-block;float: left;vertical-align: middle;margin-top: 10px">
              <el-popover
                placement="bottom-start"
                trigger="hover"
                content="Under Development"
              >
                <template #reference>
                  <el-icon size="large"><Fold /></el-icon>
                </template>
              </el-popover>
              <el-popover
                placement="bottom-start"
                trigger="hover"
                content="Under Development"
              >
                <template #reference>
                  <el-icon size="large" style="margin-left: 20px"><ChromeFilled /></el-icon>
                </template>
              </el-popover>
              <el-popover
                placement="bottom-start"
                trigger="hover"
                content="Under Development"
              >
                <template #reference>
                  <el-icon size="large" style="margin-left: 20px"><Refresh /></el-icon>
                </template>
              </el-popover>
              <el-input
                v-model="inputSearch"
                placeholder="Search Something"
                style="width: 350px;margin-left: 20px;"
                size="small"
              />
              <el-popover
                placement="bottom-start"
                trigger="hover"
                content="Under Development"
              >
                <template #reference>
                  <el-icon size="large" style="margin-left: 600px"><Bell /></el-icon>
                </template>
              </el-popover>
              <el-popover
                placement="bottom-start"
                trigger="hover"
                content="Under Development"
              >
                <template #reference>
                  <el-icon size="large" style="margin-left: 20px"><Help /></el-icon>
                </template>
              </el-popover>
              <el-popover
                placement="bottom-start"
                trigger="hover"
                content="Under Development"
              >
                <template #reference>
                  <el-icon size="large" style="margin-left: 20px"><Discount /></el-icon>
                </template>
              </el-popover>
              <el-popover
                placement="bottom-start"
                trigger="hover"
                content="Under Development"
              >
                <template #reference>
                  <el-icon size="large" style="margin-left: 20px"><Sort /></el-icon>
                </template>
              </el-popover>
              <div style="float:right; margin-left: 20px" >{{adminname}}</div>
            </div>
            <div style="background-color: #42b983;width: 100px;">
              <div style="border-top: 2px solid  #73767a;float: right;width: 60px;background-color: #f4f4f5">
              </div>
            </div>
          </div>
        </el-header>
        <el-main style="border: 1px solid black" class="main">
          <el-timeline>
            <el-timeline-item timestamp="2022/9/13" placement="top">
              <el-card style="height: 200px">
                <h4 style="position: absolute;left: 50px;top: 20px">订单号：</h4>
                <el-divider />
                <p style="position: absolute;left: 50px;top: 60px">课程名称</p>
                <p style="position: absolute;left: 400px;top: 60px">预约时间</p>
                <p style="position: absolute;left: 700px;top: 60px;">预约地点</p>
                <el-divider style="top: 60px"/>
                <p style="position: absolute;top: 160px;left: 50px">联系人：</p>
                <p style="position: absolute;left: 400px;top: 160px">手机号：</p>
                <el-popover
                  placement="top-start"
                  :width="20"
                  trigger="hover"
                  content="排课">
                  <template #reference>
                <el-button style="position: absolute;left: 675px;top: 160px;">
                  <el-icon><Reading /></el-icon>
                </el-button>
                  </template>
                </el-popover>
                <el-popconfirm title="是否要删除?">
                  <template #reference>
                <el-button style="position: absolute;left: 710px;top: 160px;">
                  <el-icon><DeleteFilled /></el-icon>
                </el-button>
                  </template>
                </el-popconfirm>
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
  InfoFilled,
  Fold,
  ChromeFilled,
  Refresh,
  Bell,
  Help,
  Discount,
  Sort,
  Delete,
  DeleteFilled,
  Reading
} from '@element-plus/icons'

const {ref} = require("vue");
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
    InfoFilled,
    Fold,
    ChromeFilled,
    Refresh,
    Bell,
    Help,
    Discount,
    Sort,
    Delete,
    DeleteFilled,
    Reading
  },
  data () {
    return {
      isCollapse: true
    }
  }
}
let centerDialogVisible = ref(false)
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
.dialog-footer button:first-child {
  margin-right: 10px;
}
</style>
