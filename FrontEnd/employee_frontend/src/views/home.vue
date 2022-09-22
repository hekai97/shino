<template>
  <div>
    <el-container style="border: 1px solid red">
      <el-aside style="border: 1px solid white;background-color: #7ab8cc;color: white" width="isCollapse ? '30px' : '150px'" class="lef">

        <el-menu
          active-color="#ffd04b"
          background-color="#7ab8cc"
          class="el-menu-vertical"
          default-active="0-1"
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

          <el-sub-menu index="0-2">
            <template #title>
              <el-icon><Notebook /></el-icon>
              <span style="margin-left: 3px">排课</span>
            </template>
            <el-menu-item index="0-2-1" style="margin-left: 10px;width: 5px" @click="book">预约</el-menu-item>
            <el-menu-item index="0-2-2" style="margin-left: 10px;width: 5px" @click="schedule">排课</el-menu-item>
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
              <div>
                <span style="position: absolute;left: 2px;font-size: xx-large;top: 40px">999,999</span><br/>
                <span style="position: absolute;font-size: xx-small">总计访问量:88万<el-icon><Flag /></el-icon></span>
              </div>
            </el-card>
          </el-space>
          <el-space wrap>
            <el-card  class="box-card" style="width: 240px;height: 100px;position: absolute;left: 490px">
              <template #header>
                <div class="card-header" style="height: 1px;">
                  <p style="font-size: x-small;position: absolute;left: 1px;top: 1px" >下载</p>
                </div>
              </template>
              <div>
                <span style="position: absolute;left: 2px;font-size: xx-large;top: 40px">33,555</span><br/>
                <span style="position: absolute;font-size: xx-small">新下载:10%<el-icon><Avatar /></el-icon></span>
              </div>
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
            <el-card  class="box-card" style="width: 600px;height: 300px;position: absolute;left: 240px;top: 210px ">
              <template #header>
                <div class="card-header" style="height: 1px;">
                  <p style="font-size: x-small;position: absolute;left: 1px;top: 1px" >访问量</p>
                </div>
              </template>
              <div id="myChart"></div>
            </el-card>
          </el-space>
          <el-space wrap>
            <el-card  class="box-card" style="width: 380px;height: 300px;position: absolute;right: 20px;top: 210px ">
              <template #header>
                <div class="card-header" style="height: 1px;">
                  <p style="font-size: x-small;position: absolute;left: 1px;top: 1px" >访问量</p>
                </div>
              </template>
              <div class="demo-progress">
                <p style="position: absolute;top: 30px;left: 20px">月访问数</p><br/>
                <p style="position: absolute;left: 22px;top: 60px;font-size: xx-small">同上期增长</p>
                <el-progress style="position: absolute;top: 90px"
                  :text-inside="true"
                  :stroke-width="20"
                  :percentage="30"
                  status="success"
                />
                <p style="position: absolute;top: 100px;left: 20px">月下载数</p><br/>
                <p style="position: absolute;left: 22px;top: 130px;font-size: xx-small">同上期增长</p>
                <el-progress style="position: absolute;top: 160px;"
                  :text-inside="true"
                  :stroke-width="22"
                  :percentage="20"
                  status="success"
                />
                <p style="position: absolute;top: 170px;left: 20px">月收入</p><br/>
                <p style="position: absolute;left: 22px;top: 200px;font-size: xx-small">同上期增长</p>
                <el-progress style="position: absolute;top: 230px"
                  :text-inside="true"
                  :stroke-width="20"
                  :percentage="25"
                  status="success"
                />
              </div>
            </el-card>
          </el-space>
          <el-space wrap>
            <el-card  class="box-card" style="width: 320px;height: 250px;position: absolute;left: 240px;top: 540px ">
              <template #header>
                <div class="card-header" style="height: 1px;">
                  <p style="font-size: x-small;position: absolute;left: 1px;top: 1px" >用户留言</p>
                </div>
              </template>
              <el-table :data="suggestionData" height="250" style="width: 100%;font-size: xx-small">
                <el-table-column prop="phone" label="用户手机号"/>
                <el-table-column prop="question" label="问题"/>
                <el-table-column prop="description" label="描述" show-overflow-tooltip="true"/>
                <el-table-column prop="createTime" label="创建时间"/>
              </el-table>
            </el-card>
          </el-space>
          <el-space wrap>
            <el-card  class="box-card" style="width: 320px;height: 250px;position: absolute;left: 580px;top: 540px ">
              <template #header>
                <div class="card-header" style="height: 1px;">
                  <p style="font-size: x-small;position: absolute;left: 1px;top: 1px" >本周活跃用户列表</p>
                </div>
              </template>
              <el-table :data="tableData" height="250" style="width: 100%;font-size: xx-small">
                <el-table-column prop="user" label="用户名" width="80"  />
                <el-table-column prop="latest" label="最后登录时间" width="100" align="center"/>
                <el-table-column prop="status" label="状态" width="50"/>
                <el-table-column prop="zan" label="获得赞" width="60" align="center"/>
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
                :data="tableDatas"
                style="width: 100%;font-size: xx-small"
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
  PriceTag,
  Discount,
  Sort,
  Flag,
  Avatar
} from '@element-plus/icons'
import router from "@/router";
import *as echarts from 'echarts'	// 引入echarts
import axios from 'axios'
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
    PriceTag,
    Discount,
    Sort,
    Flag,
    Avatar
  },
  data () {
    return {
      isCollapse: false,
      tableData:[
      {
        user:"胡歌",
        latest:"11:20",
        status:"在线",
        zan:"22"
      },
        {
          user:"彭于晏",
          latest:"3:09",
          status:"离线",
          zan:"50"
        },
        {
          user:"吴磊",
          latest: "5:20",
          status: "在线",
          zan:"200"
        },
        {
          user:"赵露思",
          latest: "5:20",
          status: "在线",
          zan:"368"
        },
    ],
      tableDatas:[
        {
          date:"开会",
          name:"一小时",
          address:"已完成"
        },
        {
          date:"项目开发",
          name:"两小时",
          address:"进行中"
        },
        {
          date: "吃饭",
          name: "一小时",
          address: "未完成"
        },
        {
          date: "修改bug",
          name: "一小时",
          address: "未完成"
        }
      ],


      echartsOption: {	// echarts选项，所有绘图数据和样式都在这里设置
        legend: {	//图表上方的图例
          data: ['访问量', '下载量', '平均访问量',]
        },
        xAxis: {
          type: 'category',
          data: ['1月', '2月', '3月', '4月', '5月', '6月', '7月','8月', '9月', '10月', '11月', '12月'],   // x轴数据
          name: '日期',   // x轴名称
          nameTextStyle: {	// x轴名称样式
            fontWeight: 600,
            fontSize: 13
          }
        },
        yAxis: {
          type: 'value',
          name: '访问量',   // y轴名称
          nameTextStyle: {	// y轴名称样式
            fontWeight: 600,
            fontSize: 13
          }
        },
        tooltip: {   //鼠标放到图上的数据展示样式
          trigger: 'axis'
        },
        series: [	//每条折线的数据系列
          {
            name: '访问量',
            data: [820, 932, 901, 934, 900,950,980,1000,800,1030,1200,1100],
            type: 'line'
          },
          {
            name: '下载量',
            data: [620, 711, 823, 934,1178,1100,1200,1250,1204,1000,1200,1270],
            type: 'line'
          },
          {
            name: '平均访问量',
            data: [612, 700,720,800,780,850,890,950,990,1040,1100,1180],
            type: 'line'
          }

        ],
      },
      suggestionData:[
        {
          phone:"18888888888",
          question:"222",
          description:"111111111111111111111111111111111111111111111111111111111111",
          createTime:"2021-01-01 12:00:00"
        },
        {
          phone:"18888888888",
          question:"222",
          description:"111",
          createTime:"2021-01-01 12:00:00"
        },
        {
          phone:"18888888888",
          question:"222",
          description:"111",
          createTime:"2021-01-01 12:00:00"
        },
        {
          phone:"18888888888",
          question:"222",
          description:"111",
          createTime:"2021-01-01 12:00:00"
        },
      ]
    }
  },
  methods:{
    book(){
      router.push({
        name:"book"
      })
    },
    schedule(){
      router.push({
        name:"schedule"
      })
    },
    sign(){
      router.push({
        name:"sign"
      })
    },
    getSuggestions() {
      axios({
        method: 'get',
        url: "suggest/getAllSuggest",
      }).then((res) => {
        console.log(res.data)
        if(res.data.status==0){
          this.suggestionData=res.data.data;
        }else{
          this.$message.error(res.data.message);
        }
      })
    }
  },
  mounted() {
    let myChart = echarts.init(document.getElementById('myChart'), 'light')	// 初始化echarts, theme为light
    myChart.setOption(this.echartsOption)	// echarts设置选项
    this.getSuggestions();
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
  height: 280px;

}
.demo-progress .el-progress--line {
  margin-bottom: 15px;
  width: 350px;
}
</style>
