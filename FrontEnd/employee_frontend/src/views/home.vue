<template>
  <div>
    <el-container style="border: 1px solid red">
      <el-aside style="border: 1px solid white;background-color: #7ab8cc;color: white" width="isCollapse ? '30px' : '150px'" class="lef">

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
            <el-menu-item index="0-2-1" style="margin-left: 10px;width: 5px">预约</el-menu-item>
            <el-menu-item index="0-2-2" style="margin-left: 10px;width: 5px">排课</el-menu-item>
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
            <el-menu-item index="1-2-1" style="margin-left: 10px;width: 10px">查看课程</el-menu-item>
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
        <el-radio-group v-model="isCollapse" style="position: absolute; left: 15px;width: 30px" size="mini" >

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
          <el-space wrap>
            <el-card  class="box-card" style="width: 240px;height: 100px;position: absolute;left: 240px">
              <template #header>
                <div class="card-header" style="height: 1px;">
                  <p style="font-size: x-small;position: absolute;left: 1px;top: 1px" >访问量</p>
                </div>
              </template>
            </el-card>
          </el-space>
          <el-space wrap>
            <el-card  class="box-card" style="width: 240px;height: 100px;position: absolute;left: 490px">
              <template #header>
                <div class="card-header" style="height: 1px;">
                  <p style="font-size: x-small;position: absolute;left: 1px;top: 1px" >下载</p>

                </div>
              </template>
            </el-card>
          </el-space>
          <el-space wrap>
            <el-card  class="box-card" style="width: 240px;height: 100px;position: absolute;right: 270px">
              <template #header>
                <div class="card-header" style="height: 1px;">
                  <p style="font-size: x-small;position: absolute;left: 1px;top: 1px" >收入</p>

                </div>
              </template>
            </el-card>
          </el-space>
          <el-space wrap>
            <el-card  class="box-card" style="width: 240px;height: 100px;position: absolute;right: 20px">
              <template #header>
                <div class="card-header" style="height: 1px;">
                  <p style="font-size: x-small;position: absolute;left: 1px;top: 1px" >活跃用户</p>

                </div>
              </template>
            </el-card>
          </el-space>
          <el-space wrap>
            <el-card  class="box-card" style="width: 1000px;height: 300px;position: absolute;left: 240px;top: 210px ">
              <template #header>
                <div class="card-header" style="height: 1px;">
                  <p style="font-size: x-small;position: absolute;left: 1px;top: 1px" >访问量</p>
                </div>
              </template>
              <div id="myChart"></div>
            </el-card>
          </el-space>
          <el-space wrap>
            <el-card  class="box-card" style="width: 320px;height: 250px;position: absolute;left: 240px;top: 540px ">
              <template #header>
                <div class="card-header" style="height: 1px;">
                  <p style="font-size: x-small;position: absolute;left: 1px;top: 1px" >用户留言</p>
                </div>
              </template>
            </el-card>
          </el-space>
          <el-space wrap>
            <el-card  class="box-card" style="width: 320px;height: 250px;position: absolute;left: 580px;top: 540px ">
              <template #header>
                <div class="card-header" style="height: 1px;">
                  <p style="font-size: x-small;position: absolute;left: 1px;top: 1px" >本周活跃用户列表</p>
                </div>
              </template>
              <el-table :data="tableData" style="width: 100%;font-size: xx-small">
                <el-table-column prop="user" label="用户名" width="80"  />
                <el-table-column prop="latest" label="最后登录时间" width="100" />
                <el-table-column prop="status" label="状态" width="50"/>
                <el-table-column prop="zan" label="获得赞" width="60"/>
              </el-table>
            </el-card>
          </el-space>
          <el-space wrap>
            <el-card  class="box-card" style="width: 320px;height: 250px;position: absolute;right: 20px;top: 540px ">
              <template #header>
                <div class="card-header" style="height: 1px;">
                  <p style="font-size: x-small;position: absolute;left: 1px;top: 1px" >项目进展</p>
                </div>
              </template>
              <el-table
                ref="multipleTableRef"
                :data="tableData"
                style="width: 100%"
                @selection-change="handleSelectionChange"
              >
                <el-table-column type="selection" width="30" />
                <el-table-column label="任务" width="80">
                  <template #default="scope">{{ scope.row.date }}</template>
                </el-table-column>
                <el-table-column property="name" label="所需时间" width="80" />
                <el-table-column property="address" label="完成情况" show-overflow-tooltip />
              </el-table>
            </el-card>
          </el-space>
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
  DArrowRight,
  DArrowLeft,
  InfoFilled,
  Fold,
  Help,
  RefreshRight,
  Bell,
  PriceTag
} from '@element-plus/icons'
export default {
  name: 'myHome',
  components: {
    // eslint-disable-next-line vue/no-unused-components
    IconMenu,
    IceCream,
    Notebook,
    AlarmClock,
    Mouse,
    User,
    Tools,
    DArrowRight,
    DArrowLeft,
    InfoFilled,
    Fold,
    Help,
    RefreshRight,
    Bell,
    PriceTag
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
  height: 1000px;
}
.el-menu-vertical {
  border-top: 1px solid white;
}
::-webkit-scrollbar {
  width: 0;
  height: 0;
}
#myChart{
  width: 100%;
  height: 500px;
  margin: 0 auto;
  margin-top: 5%;
}

</style>
