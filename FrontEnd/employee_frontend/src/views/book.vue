<template>
  <div>
    <el-container style="border: 1px solid red">
      <el-aside style="border: 1px solid white;background-color: #7ab8cc;color: white" width="isCollapse ? '30px' : '270px'" class="lef">

        <el-menu
            active-color="#ffd04b"
            background-color="#7ab8cc"
            class="el-menu-vertical"
            default-active="0-2-1"
            text-color="#fff"
            :collapse="isCollapse"
        >
          <el-menu-item index="0-0" disabled>
            <span style="color: white;font-size: 17px"><h3>员工操作平台</h3></span>
          </el-menu-item>
          <el-menu-item index="0-1" @click="home">
            <el-icon><IceCream /></el-icon>
            <span style="margin-left: 3px">店铺经营状况</span>
          </el-menu-item>

          <el-sub-menu index="0-2" >
            <template #title>
              <el-icon><Notebook /></el-icon>
              <span style="margin-left: 3px">排课</span>
            </template>
            <el-menu-item index="0-2-1" style="margin-left: 30px">预约</el-menu-item>
            <el-menu-item index="0-2-2" style="margin-left: 30px" @click="schedule">排课</el-menu-item>
          </el-sub-menu>

          <el-menu-item index="1-1" @click="sign">
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
                <el-button @click="Arranging" style="position: absolute;left: 675px;top: 160px;">
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

<!--        排课-->
          <el-dialog
          v-model="OpenArranging"
          title="排课"
          width="60%"
          draggable>
            <div>
              <el-form :model="form" ref="form" label-width="120px">
                <el-form-item label="学员姓名">
                  <el-input v-model="form.name" />
                </el-form-item>
                <el-form-item label="上课地点">
                  <el-input v-model="form.address" />
                </el-form-item>
                <el-form-item label="预约课程">
                  <el-input v-model="form.class" />
                </el-form-item>
                <el-form-item label="预约讲师">
                  <el-select v-model="form.region" placeholder="请选择">
                    <el-option label="Zone one" value="shanghai" />
                    <el-option label="Zone two" value="beijing" />
                  </el-select>
                </el-form-item>
                <el-form-item label="预约方式">
                  <el-radio-group v-model="form.resource">
                    <el-radio label="应用预约" />
                    <el-radio label="电话预约" />
                    <el-radio label="应用电话预约" />
                  </el-radio-group>
                </el-form-item>
                <el-form-item label="排课日期">
                  <el-col :span="11">
                    <el-date-picker
                      v-model="form.date1"
                      type="date"
                      style="width: 100%"
                    />
                  </el-col>
                </el-form-item>
                <el-form-item label="排课时间">
                  <el-radio-group v-model="form.time">
                    <el-radio label="09:00-11:00" />
                    <el-radio label="13:30-15:30" />
                    <el-radio label="16:00-18:00" />
                    <el-radio label="19:30-21:30"/>
                  </el-radio-group>
                </el-form-item>
                <el-form-item align="center">
                  <el-button type="primary" @click="onSubmit">发送排课通知</el-button>
                </el-form-item>
              </el-form>
            </div>
          </el-dialog>
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
  Refresh,
  Bell,
  Help,
  Discount,
  Sort,
  Delete,
  DeleteFilled,
  Reading
} from '@element-plus/icons'
import router from "@/router";
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
    Refresh,
    Bell,
    Help,
    Discount,
    Sort,
    Delete,
    DeleteFilled,
    Reading,

  },
  data () {
    return {
      isCollapse: false,
      OpenArranging:false,
      form:{
        name:'',//学员姓名
        region:'',//预约讲师
        address:'',//上课地点
        class:'',//预约课程
        date1:'',//排课日期
        resource:'',//预约方式
        time:'',//排课时间
      }
    }
  },
  methods: {
    home() {
      router.push({
        name: "home"
      })
    },
    schedule() {
      router.push({
        name: "schedule"
      })
    },
    sign(){
      router.push({
        name:"sign"
      })
    },
    Arranging(){
      this.OpenArranging=!this.OpenArranging
    },
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
.dialog-footer button:first-child {
  margin-right: 10px;
}
</style>
