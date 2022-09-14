<template>
  <div style="margin-top: -60px">
    <el-container style="border: 1px solid red;height: 800px">
      <el-menu
          active-color="#ffd04b"
          background-color="#545c64"
          class="el-menu-vertical"
          default-active="0-2"
          text-color="#fff"
          :collapse="isCollapse"
      >

        <el-menu-item index="0-0" disabled>
          <span style="color:white;font-size:17px;"><h3>臻焙课工场</h3></span>
        </el-menu-item>
        <el-menu-item index="0-1" v-if="pList.get(101)===true" @click="home">
          <el-icon><PieChart /></el-icon>
          <span style="margin-left: 3px">统计分析</span>
        </el-menu-item>
        <el-menu-item style="border-bottom: 1px solid white" index="0-2" v-if="pList.get(102)===true" >
          <el-icon><Coin /></el-icon>
          <span style="margin-left: 3px">深度分析</span>
        </el-menu-item>
        <el-menu-item index="1-1" v-if="pList.get(106)===true" @click="store">
          <el-icon><House /></el-icon>
          <span style="margin-left: 3px">门店管理</span>
        </el-menu-item>
        <el-sub-menu index="1-2"  v-if="pList.get(103)===true">
          <template #title>
            <el-icon><Calendar /></el-icon>
            <span style="margin-left: 3px">课程管理</span>
          </template>
          <el-menu-item index="1-2-1" style="margin-left: 15px">查看课程</el-menu-item>
          <el-menu-item index="1-2-2" style="margin-left: 15px">创建新课程</el-menu-item>
          <el-menu-item index="1-2-3" style="margin-left: 15px">修改课程信息</el-menu-item>
          <el-menu-item index="1-2-4" style="margin-left: 15px">删除课程</el-menu-item>
          <el-menu-item index="1-2-5" style="margin-left: 15px">配置课程</el-menu-item>
          <el-menu-item index="1-2-6" style="margin-left: 15px">课程追踪</el-menu-item>
        </el-sub-menu>
        <el-menu-item index="1-3" v-if="pList.get(104)===true">
          <el-icon><User /></el-icon>
          <span style="margin-left: 3px">讲师管理</span>
        </el-menu-item>
        <el-menu-item index="1-4" v-if="pList.get(105)===true">
          <el-icon><Edit /></el-icon>
          <span style="margin-left: 3px">学员管理</span>
        </el-menu-item>
        <el-menu-item index="1-5" style="border-bottom: 1px solid white" v-if="pList.get(107)===true">
          <el-icon><Files /></el-icon>
          <span style="margin-left: 3px">订单管理</span>
        </el-menu-item>
        <el-sub-menu index="1-6" v-if="pList.get(109)===true">
          <template #title>
            <el-icon><Operation /></el-icon>
            <span style="margin-left: 3px">权限管理</span>
          </template>
          <el-menu-item index="1-6-1" style="margin-left: 15px">查看角色</el-menu-item>
          <el-menu-item index="1-6-2" style="margin-left: 15px">角色管理</el-menu-item>
          <el-menu-item index="1-6-3" style="margin-left: 15px">创建员工账号</el-menu-item>
          <el-menu-item index="1-6-4" style="margin-left: 15px">查看权限</el-menu-item>
        </el-sub-menu>
        <el-menu-item index="1-7" v-if="pList.get(110)===true" >
          <el-icon><Setting /></el-icon>
          <span style="margin-left: 3px">系统配置</span>
        </el-menu-item>
        <el-menu-item index="1-8" v-if="pList.get(108)===true" >
          <el-icon><Van /></el-icon>
          <span style="margin-left: 3px">售后管理</span>
        </el-menu-item>
      </el-menu>
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
                  <el-icon size="large" style="margin-left: 550px"><Bell /></el-icon>
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
              <el-dropdown style="margin-left:30px;color: #79bbff;float: right;font-weight: bold">
                  <span class="el-dropdown-link">
                    {{adminname}}
                    <el-icon class="el-icon--right">
                      <ArrowDown />
                    </el-icon>
                  </span>
                <template #dropdown>
                  <el-dropdown-menu>
                    <el-dropdown-item @click="loginout">退出登录</el-dropdown-item>
                  </el-dropdown-menu>
                </template>
              </el-dropdown>
            </div>
            <div style="background-color: #42b983;width: 100px;">
              <div class="toggle-btn" @click="exchange">
                <el-icon size="large" v-if="result"><DArrowLeft/></el-icon>
                <el-icon size="large" v-else><DArrowRight/></el-icon>
              </div>
              <div style="border-top: 2px solid  #73767a;float: right;width: 60px;background-color: #f4f4f5">
                <el-icon size="large" style="margin-top: 4px"><Histogram /></el-icon>
              </div>
            </div>
          </div>
        </el-header>
        <el-main style="background-color: #F0F2F5" class="main">
          <div style="height: 50px;background-color: white">
            <div style="width: 100px;display: inline-block;float: left;margin-top: 13px">店铺筛选</div>
            <div style="width: 600px;display: inline-block;margin-top: 9px;margin-left: 10px">
              <span>时间筛选</span>
              <el-date-picker
                  v-model="value4"
                  type="dates"
                  placeholder="开始时间"
                  style="margin-left: 10px"
              />
              <el-date-picker
                  v-model="value5"
                  type="dates"
                  placeholder="结束时间"
                  style="margin-left: 5px"
              />
            </div>
            <div style="height: 40px;width: 500px;float:right;">
              <span style="width: 100px;display: inline-block;float: left;margin-top: 13px">选择店铺</span>
              <div style="width: 200px;display: inline-block;float: left;margin-top: 8px;margin-left: 10px">
                <el-select v-model="value1" placeholder="请选择标签">
                  <el-option
                      v-for="item in dpList"
                      :key="item.id"
                      :label="item.label"
                      :value="item.storeName"
                  />
                </el-select>
              </div>
              <el-button style="width: 60px;float: left;background-color: #79bbff;margin-left: 10px;margin-top: 7px">
                <el-icon><Search/></el-icon>
              </el-button>
            </div>
          </div>
          <div style="margin-top: 20px;height:80px;">
            <div style="width: 15%;background-color: white;border-radius: 5px;height: 80px;display: inline-block;float: left;">
                <div style="width:90px;line-height: 30px;font-size: 13px;height: 30px">注册用户</div>
                <div style="width: 90px;font-size: 25px;margin-top: 5px">{{ResgistTotal}}人</div>
            </div>

            <div style="width: 15%;background-color: white;border-radius: 5px;height: 80px;display: inline-block;float: left;margin-left: 2%">
              <div style="width:90px;line-height: 30px;font-size: 13px;height: 30px">下单用户</div>
              <div style="width: 90px;font-size: 25px;margin-top: 5px">{{BuyuserTotal}}人</div>
            </div>

            <div style="width: 15%;background-color: white;border-radius: 5px;height: 80px;display: inline-block;float: left;margin-left: 2%">
              <div style="width:120px;line-height: 30px;font-size: 13px;height: 30px">用户下单转化率</div>
              <div style="width: 110px;font-size: 25px;margin-top: 5px;">{{((BuyuserTotal/ResgistTotal)*100).toFixed(2)}}%</div>
            </div>

            <div style="width: 15%;background-color: white;border-radius: 5px;height: 80px;display: inline-block;float: left;margin-left: 2%">
              <div style="width:90px;line-height: 30px;font-size: 13px;height: 30px">购买用户数</div>
              <div style="width: 90px;font-size: 25px;margin-top: 5px">{{BuyuserTotal}}人</div>
            </div>

            <div style="width: 15%;background-color: white;border-radius: 5px;height: 80px;display: inline-block;float: left;margin-left: 2%">
              <div style="width:90px;line-height: 30px;font-size: 13px;height: 30px">APPU值</div>
              <div style="width: 110px;font-size: 25px;margin-top: 5px">376.63</div>
            </div>

            <div style="width: 15%;background-color: white;border-radius: 5px;height: 80px;display: inline-block;float: right;">
              <div style="width:90px;line-height: 30px;font-size: 13px;height: 30px">男女比例</div>
              <div style="width: 90px;font-size: 25px;margin-top: 5px">1:6</div>
            </div>

          </div>
          <div id="LineChart" style="margin-top: 20px;background-color: white">
          </div>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>
import * as echarts from 'echarts'
import {
  Menu as IconMenu,PieChart, Coin, House, Calendar, User, Edit, Setting, Files, Operation,DArrowRight,DArrowLeft,Fold,ChromeFilled,Refresh,Bell,
  Help,Discount,Sort,ArrowDown,Histogram,Search,Van} from '@element-plus/icons-vue'
import axios from "axios";
import {ElLoading, ElMessage} from "element-plus";
import router from "@/router";
import {useRoute} from "vue-router/dist/vue-router";
let aname
export default {
  name: "myDeepanalysis",
  components:{
    // eslint-disable-next-line vue/no-unused-components
    IconMenu, PieChart, Coin, House, Calendar, User, Edit, Setting, Files, Operation, DArrowLeft, DArrowRight, Fold,ChromeFilled,Refresh,Bell,
    Help,Discount,Sort,ArrowDown,Histogram,Search,Van
  },
  setup(){
    let route=useRoute();
    aname=route.query.adminname;
    return{
      adminname: aname,
    }
  },
  data() {
    return {
      // adminname:route.params.adminname,
      isCollapse: false,
      result: 'true',
      inputSearch: '',
      value4: '',
      value5: '',
      value1: '',
      dpList:[],
      ResgistTotal:'',
      BuyuserTotal:'',
      LineChart:'',
      pList:new Map(),
    }
  },
  mounted () {
    this.LineChartsinitData();
    this.drawLineCharts();
    // let LineChart = echarts.init(document.getElementById('LineChart'), 'light')	// 初始化echarts, theme为light
    // LineChart.setOption(this.LinechartsOption)	// echarts设置选项
    this.getAllresgitSum();
    this.getAllorderSum();
    axios({
      method: 'get',
      url: '/admin/store/getStoreList',
    }).then(response=>{
      // alert(response.data.status)
      if(response.data.status===0){
        // alert(response.data.data.storeName)
        this.dpList=response.data.data;
        // console.log(this.dpList)
      }
    })
    axios({
      methods: 'get',
      url:'/admin/permission/getAllPermissionList',
    }).then(response=>{
      if(response.data.status===0){
        for(let i=0;i<response.data.data.length;i++)
        {
          this.pList.set(response.data.data[i].permissionCode,true)
        }
      }
    })
  },
  methods: {
    exchange() {
      this.isCollapse = !this.isCollapse;
      this.result = !this.result;
    },
    loginout() {
      axios({
        method: 'post',
        url: '/admin/user/logout',
      }).then(response => {
        // alert(response.data.message)
        if (response.data.status === 0) {
          ElMessage('退出成功');
          router.push({
            name: 'Login',
          })
        }
      })
    },
    home(){
        const loading = ElLoading.service({
          lock: true,
          text: 'Loading',
          background: 'rgba(0, 0, 0, 0.7)',
        })
        setTimeout(() => {
          loading.close()
          router.push({
            name:'firsthome',
            query:{
              adminname:aname,
            }
          })
        }, 500)

    },
    store(){
      router.push({
        name:'Store',
        query:{
          adminname:aname,
        }
      })
    },
    getAllresgitSum(){
      axios({
        method:'post',
        url:'/admin/user/getAllUserPageable',
        params:{
          page:0,
          size:1
        }
      }).then(res=>{
          this.ResgistTotal=res.data.data.totalElements
      })
    },
    getAllorderSum(){
      axios({
        method:'get',
        url:'/admin/order/getAllPaidUserNumber'
      }).then(res=>{
        this.BuyuserTotal=res.data.data
      })
    },
    async drawLineCharts(){
      this.LineChart=echarts.init(document.getElementById("LineChart"))
      this.LineChart.setOption({
        legend: {	//图表上方的图例
              data: ['下单用户', '注册用户', '购买用户']
            },
            xAxis: {
              type: 'category',
              data: [],   // x轴数据
              name: '日期',   // x轴名称
              nameTextStyle: {	// x轴名称样式
                fontWeight: 600,
                fontSize: 18
              }
            },
            yAxis: {
              type: 'value',
              name: '时间序列图',   // y轴名称
              nameTextStyle: {	// y轴名称样式
                fontWeight: 600,
                fontSize: 18
              }
            },
            tooltip: {   //鼠标放到图上的数据展示样式
              trigger: 'axis'
            },
            series: [	//每条折线的数据系列
              {
                name: '下单用户',
                data: [],
                type: 'line'
              },
              {
                name: '注册用户',
                data: [],
                type: 'line'
              },
              {
                name: '购买用户',
                data: [],
                type: 'line'
              },
            ],
      })
    },
    async LineChartsinitData(){
      const getTimedata=[];
      const getorderCountdata=[];
      const getregistCountdata=[];
      await axios({
        method:'get',
        url:'/admin/user/getRegisterUserByDate',
        params:{
          days:7
        }
      }).then(res=>{
        console.log(res.data.data);
        for(let i=0;i<res.data.data.length;i++)
        {
          getTimedata[i]=res.data.data[res.data.data.length-1-i].time
          getregistCountdata[i]=res.data.data[res.data.data.length-1-i].count
        }
      })

      await axios({
        method:'get',
        url:'/admin/order/getOrderItemsByDate',
        params:{
          days:7
        }
      }).then(respone=>{
        for(let i=0;i<respone.data.data.length;i++) {
          getorderCountdata[i] = respone.data.data[respone.data.data.length-1-i].count
        }
      })
      console.log(getregistCountdata);
      this.LineChart.setOption({
        xAxis: {
          data:getTimedata
        },
        series: [	//每条折线的数据系列
          {
            name: '下单用户',
            data: getorderCountdata,
            type: 'line'
          },
          {
            name: '注册用户',
            data: getregistCountdata,
            type: 'line'
          },
          {
            name: '购买用户',
            data: getorderCountdata,
            type: 'line'
          },
        ]
      })
    }
  }
}
</script>

<style scoped>
.el-menu-vertical {
  border-top: 1px solid white;
}
.el-menu-vertical:not(.el-menu--collapse) {
  width: 200px;
  min-height: 800px;
}

::-webkit-scrollbar {
  width: 0;
  height: 0;
}
.toggle-btn{
  /*border: 1px solid black;*/
  width: 40px;
  height: 20px;
  margin-top: 5px;
  margin-left: -20px;
  float: left;
}
#LineChart{
  width: 100%;
  height: 480px;
}
</style>