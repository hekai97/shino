<template>
  <div style="margin-top: -60px">
    <el-container style="border: 1px solid red;height: 1050px">
      <el-menu
          active-color="#ffd04b"
          background-color="#545c64"
          class="el-menu-vertical"
          default-active="0-1"
          text-color="#fff"
          :collapse="isCollapse"
      >

        <el-menu-item index="0-0" disabled>
          <span style="color:white;font-size:17px;"><h3>臻焙课工场</h3></span>
        </el-menu-item>
        <el-menu-item index="0-1" v-if="pList.get(101)===true">
          <el-icon>
            <PieChart/>
          </el-icon>
          <span style="margin-left: 3px">统计分析</span>
        </el-menu-item>
        <el-menu-item style="border-bottom: 1px solid white" index="0-2" v-if="pList.get(102)===true" @click="deep">
          <el-icon>
            <Coin/>
          </el-icon>
          <span style="margin-left: 3px">深度分析</span>
        </el-menu-item>
        <el-menu-item index="1-1" v-if="pList.get(106)===true" @click="store">
          <el-icon>
            <House/>
          </el-icon>
          <span style="margin-left: 3px">门店管理</span>
        </el-menu-item>
        <el-sub-menu index="1-2" v-if="pList.get(103)===true">
          <template #title>
            <el-icon>
              <Calendar/>
            </el-icon>
            <span style="margin-left: 3px">课程管理</span>
          </template>
          <el-menu-item index="1-2-1" style="margin-left: 15px" @click="CourseCategories">课程分类</el-menu-item>
          <el-menu-item index="1-2-2" style="margin-left: 15px" @click="ManageCourse">管理课程</el-menu-item>
          <el-menu-item index="1-2-3" style="margin-left: 15px" @click="ConfigureCourses">配置课程</el-menu-item>
        </el-sub-menu>
        <el-menu-item index="1-3" v-if="pList.get(104)===true" @click="Teacher">
          <el-icon>
            <User/>
          </el-icon>
          <span style="margin-left: 3px">讲师管理</span>
        </el-menu-item>
        <el-menu-item index="1-4" v-if="pList.get(105)===true" @click="ManageStudent">
          <el-icon>
            <Edit/>
          </el-icon>
          <span style="margin-left: 3px">学员管理</span>
        </el-menu-item>
        <el-menu-item index="1-5" style="border-bottom: 1px solid white" v-if="pList.get(107)===true" @click="OrMange">
          <el-icon>
            <Files/>
          </el-icon>
          <span style="margin-left: 3px">订单管理</span>
        </el-menu-item>
        <el-sub-menu index="1-6" v-if="pList.get(109)===true">
          <template #title>
            <el-icon>
              <Operation/>
            </el-icon>
            <span style="margin-left: 3px">权限管理</span>
          </template>
          <el-menu-item index="1-6-1" style="margin-left: 15px" @click="ManageUser">用户管理</el-menu-item>
          <el-menu-item index="1-6-2" style="margin-left: 15px" @click="ManageRole">角色管理</el-menu-item>
        </el-sub-menu>
        <el-menu-item index="1-7" v-if="pList.get(110)===true">
          <el-icon>
            <Setting/>
          </el-icon>
          <span style="margin-left: 3px">系统配置</span>
        </el-menu-item>
        <el-menu-item index="1-8" v-if="pList.get(108)===true">
          <el-icon>
            <Van/>
          </el-icon>
          <span style="margin-left: 3px">售后管理</span>
        </el-menu-item>
      </el-menu>
      <el-container>
        <el-header class="head">
          <div style="display: table-cell;width: 100%">
            <div style="vertical-align: middle;margin-top: 10px;width: 100%">
              <el-popover
                  placement="bottom-start"
                  trigger="hover"
                  content="Under Development"
              >
                <template #reference>
                  <el-icon size="large">
                    <Fold/>
                  </el-icon>
                </template>
              </el-popover>
              <el-popover
                  placement="bottom-start"
                  trigger="hover"
                  content="Under Development"
              >
                <template #reference>
                  <el-icon size="large" style="margin-left: 20px">
                    <ChromeFilled/>
                  </el-icon>
                </template>
              </el-popover>
              <el-popover
                  placement="bottom-start"
                  trigger="hover"
                  content="Under Development"
              >
                <template #reference>
                  <el-icon size="large" style="margin-left: 20px">
                    <Refresh/>
                  </el-icon>
                </template>
              </el-popover>
              <el-input
                  v-model="inputSearch"
                  placeholder="Search Something"
                  style="width: 15%;margin-left: 20px;"
                  size="small"
              />
              <el-popover
                  placement="bottom-start"
                  trigger="hover"
                  content="Under Development"
              >
                <template #reference>
                  <el-icon size="large" style="margin-left: 550px">
                    <Bell/>
                  </el-icon>
                </template>
              </el-popover>
              <el-popover
                  placement="bottom-start"
                  trigger="hover"
                  content="Under Development"
              >
                <template #reference>
                  <el-icon size="large" style="margin-left: 20px">
                    <Help/>
                  </el-icon>
                </template>
              </el-popover>
              <el-popover
                  placement="bottom-start"
                  trigger="hover"
                  content="Under Development"
              >
                <template #reference>
                  <el-icon size="large" style="margin-left: 20px">
                    <Discount/>
                  </el-icon>
                </template>
              </el-popover>
              <el-popover
                  placement="bottom-start"
                  trigger="hover"
                  content="Under Development"
              >
                <template #reference>
                  <el-icon size="large" style="margin-left: 20px">
                    <Sort/>
                  </el-icon>
                </template>
              </el-popover>
              <el-dropdown style="margin-left:30px;color: #79bbff;float: right;font-weight: bold">
                  <span class="el-dropdown-link" id="aname">
                    {{ adminname }}
                    <el-icon class="el-icon--right">
                      <ArrowDown/>
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
                <el-icon size="large" v-if="result">
                  <DArrowLeft/>
                </el-icon>
                <el-icon size="large" v-else>
                  <DArrowRight/>
                </el-icon>
              </div>
              <div style="border-top: 2px solid  #73767a;float: right;width: 60px;background-color: #f4f4f5">
                <el-icon size="large" style="margin-top: 4px">
                  <TrendCharts/>
                </el-icon>
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
                <el-icon>
                  <Search/>
                </el-icon>
              </el-button>
            </div>
          </div>
          <div style="margin-top: 20px;height:120px">
            <div style="width: 24%;background-color: white;border-radius: 5px;height: 120px;display: inline-block;float: left;">
              <div style="width: 100px;font-size: 13px;height: 30px;line-height: 30px">销售金额</div>
              <div style="font-size: 30px;width: 130px;font-weight:bold;margin-top: 15px">{{this.tbedfit}}</div>
              <div style="margin-top: 15px">
                <div style="width: 50px;display: inline-block;float: left;font-size: 13px;margin-left: 10px">金额</div>
                <div style="width: 100px;display: inline-block;margin-left: 140px;font-size: 13px">单位：元
                  <el-icon style="font-size:15px;margin-left: 10px">
                    <Money/>
                  </el-icon>
                </div>
              </div>
            </div>

            <div style="width: 24%;background-color: white;border-radius: 5px;height: 120px;display: inline-block;float: left;margin-left: 1.3%">
              <div style="width: 100px;font-size: 13px;height: 30px;line-height: 30px">实际订单量</div>
              <div style="font-size: 30px;width:130px;font-weight:bold;margin-top: 15px;text-align: left;margin-left: 17px">
                {{this.torder}}
              </div>
              <div style="margin-top: 15px">
                <div style="width: 50px;display: inline-block;float: left;font-size: 13px;margin-left: 10px">订单</div>
                <div style="width: 100px;display: inline-block;margin-left: 140px;font-size: 13px">单位：条
                  <el-icon style="font-size:15px;margin-left: 10px">
                    <ShoppingCart/>
                  </el-icon>
                </div>
              </div>
            </div>

            <div
                style="width: 24%;background-color: white;border-radius: 5px;height: 120px;display: inline-block;float: left;margin-left: 1.3%">
              <div style="width: 100px;font-size: 13px;height: 30px;line-height: 30px">次均消费</div>
              <div style="font-size: 30px;width: 150px;font-weight:bold;margin-top: 15px">{{(tbedfit/torderuser).toFixed(2)}}</div>
              <div style="margin-top: 15px">
                <div style="width: 50px;display: inline-block;float: left;font-size: 13px;margin-left: 10px">消费</div>
                <div style="width: 100px;display: inline-block;margin-left: 140px;font-size: 13px">单位：元
                  <el-icon style="font-size:15px;margin-left: 10px">
                    <Money/>
                  </el-icon>
                </div>
              </div>
            </div>

            <div
                style="width: 24%;background-color: white;border-radius: 5px;height: 120px;display: inline-block;float: right">
              <div style="width: 100px;font-size: 13px;height: 30px;line-height: 30px">平均销售额</div>
              <div style="font-size: 30px;width: 150px;font-weight:bold;margin-top: 15px">{{(tbedfit/tstoresum).toFixed(2)}}</div>
              <div style="margin-top: 15px">
                <div style="width: 50px;display: inline-block;float: left;font-size: 13px;margin-left: 10px">平均</div>
                <div style="width: 100px;display: inline-block;margin-left: 140px;font-size: 13px">单位：元
                  <el-icon style="font-size:15px;margin-left: 10px">
                    <Money/>
                  </el-icon>
                </div>
              </div>
            </div>
          </div>
          <div style="background-color: white; margin-top:20px;border-radius: 5px">
            <div style="margin-left:25px;display: inline-block;float: left;" id="FunChart"></div>
            <div style="display: inline-block;" id="BarChart"></div>
          </div>

          <div style="background-color: white; margin-top:20px;border-radius: 5px">
            <div style="margin-left:25px;display: inline-block;float: left;" id="FunChartTwo"></div>
            <div style="display: inline-block;" id="BarChartTwo"></div>
          </div>

        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>
import * as echarts from 'echarts'
import {useRoute} from "vue-router";
import {
  Menu as IconMenu,
  PieChart,
  Coin,
  House,
  Calendar,
  User,
  Edit,
  Setting,
  Files,
  Operation,
  DArrowRight,
  DArrowLeft,
  Fold,
  ChromeFilled,
  Refresh,
  Bell,
  Help,
  Discount,
  Sort,
  TrendCharts,
  Search,
  Money,
  ShoppingCart,
  ArrowDown,
  Van
} from '@element-plus/icons-vue'
import axios from "axios";
import {ElLoading, ElMessage} from "element-plus";
import router from "@/router";

let aname;
let aid;
export default {
  name: "myHome",
  setup() {
    let route = useRoute();
    aname = route.query.adminname;
    return {
      adminname: aname,
      adminid: aid,
    }
  },
  components: {
    // eslint-disable-next-line vue/no-unused-components
    IconMenu,
    PieChart,
    Coin,
    House,
    Calendar,
    User,
    Edit,
    Setting,
    Files,
    Operation,
    DArrowLeft,
    DArrowRight,
    Fold,
    ChromeFilled,
    Refresh,
    Bell,
    Help,
    Discount,
    Sort,
    TrendCharts,
    Money,
    Search,
    ShoppingCart,
    ArrowDown,
    Van
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
      tbedfit: 0,
      torder:0,
      torderuser:0,
      tstoresum:0,
      dpList: [],
      FunChart:'',
      BarChart:'',
      FunChartTwo:'',
      BarChartTwo:'',
      storeAndIncome:new Map(),
      pList: new Map(),
    }
  },

  mounted() {
    this.initData();
    this.BarinitData();
    this.FunTwoinitData();
    this.BarTwoinitData();
    this.drawCharts();
    this.getStoreList()
    axios({
      methods: 'get',
      url: '/admin/permission/getAllPermissionList',
    }).then(response => {
      if (response.data.status === 0) {
        for (let i = 0; i < response.data.data.length; i++) {
          this.pList.set(response.data.data[i].permissionCode, true)
        }
      }
    })
    axios({
      method:'get',
      url:'/admin/order/getAllPaidUserNumber'
    }).then(res=>{
      if(res.data.status===0){
        this.torderuser=res.data.data;
      }
    })
  },
  methods: {
    getStoreList() {
      axios({
        url: "/admin/store/getStoreList",
        method: "get",
      }).then((res) => {
        this.dpList = res.data.data;
        this.tstoresum = this.dpList.length
        for (let i = 0; i < this.dpList.length; i++) {
          axios({
            url: "admin/order/getBenefitByStoreId",
            method: "post",
            params: {
              storeId: this.dpList[i].id,
            },
          }).then((res) => {
            this.tbedfit = this.tbedfit + res.data.data
            // console.log(res.data.data)
            this.storeAndIncome.set(this.dpList[i].id, res.data.data)
          });
        }
        for (let i = 0; i < this.dpList.length; i++) {
          axios({
            url: "/admin/order/getOrderItemsByStoreIdPageable",
            method: "post",
            params: {
              page: 0,
              size: 1,
              storeId: this.dpList[i].id
            },
          }).then(res => {
            // console.log(res);
            this.torder = this.torder + res.data.data.totalElements;
          })
        }
      });
    },
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
    deep() {
      const loading = ElLoading.service({
        lock: true,
        text: 'Loading',
        background: 'rgba(0, 0, 0, 0.7)',
      })
      setTimeout(() => {
        loading.close()
        router.push({
          name: 'Deep',
          query: {
            adminname: aname,
            adminid:aid
          }
        })
      }, 500)
    },
    store(){
      router.push({
        name: 'Store',
        query: {
          adminname: aname,
          adminid:aid
        }
      })
    },
    OrMange(){
      router.push({
        name:'Order',
        query: {
          adminname: aname,
          adminid:aid,
        }
      })
    },
    CourseCategories(){
      router.push({
        name:'CourseCategories',
        query:{
          adminname:aname,
          adminid:aid
        }
      })
    },
    ManageCourse(){
      router.push({
        name:'ManageCourse',
        query:{
          adminname:aname,
          adminid:aid
        }
      })
    },
    ConfigureCourses(){
      router.push({
        name:'ConfigureCourses',
        query:{
          adminname:aname,
          adminid:aid
        }
      })
    },
    Teacher(){
      router.push({
        name:'Teacher',
        query:{
          adminname:aname,
          adminid:aid
        }
      })
    },
    ManageUser(){
      router.push({
        name:'ManageUser',
        query:{
          adminname:aname,
          adminid:aid
        }
      })
    },
    ManageStudent(){
      router.push({
        name:'ManageStudent',
        query:{
          adminname:aname,
          adminid:aid
        }
      })
    },
    ManageRole(){
      router.push({
        name:'ManageRole',
        query:{
          adminname:aname,
          adminid:aid
        }
      })
    },
    drawBarChart(){          //获取课程分类下的课程数--柱形图
      this.BarChart=echarts.init(document.getElementById("BarChart"))
      this.BarChart.setOption({
        legend: {show: true, data: [{name: '课程数',}], top: 10},
        xAxis: {
          type: 'value',
          name: '',   // x轴名称
          nameTextStyle: {	// x轴名称样式
            fontWeight: 600,
            fontSize: 18
          }
        },
        yAxis: {
          type: 'category',
          name: '全部课程分类',   // y轴名称
          data: [],
          nameTextStyle: {	// y轴名称样式
            fontWeight: 600,
            fontSize: 18
          }
        },
        tooltip: {   //鼠标放到图上的数据展示样式
          trigger: 'axis'
        },
        series: [{  //series中加入每个bar的数据
          name: "课程数",
          type: 'bar',
          barWidth: '60%',
          data: [],
        }],
      })
    },
    async BarinitData(){        //获取课程分类下柱形图的填充数据
      const res=await axios.get("/admin/course/getCourseCategoryList");
      const getData=[];
      const getcouName=[];
      for(let i=0;i<res.data.data.length;i++)
      {
        getcouName[i]=res.data.data[i].categoryName
        await axios({
          method:'get',
          url:'/admin/course/getCoursesPageableByCategoryId',
          params:{
            page:0,
            size:1,
            categoryId:res.data.data[i].id
          }
        }).then(respone=>{
          getData[i]=respone.data.data.totalElements;
        })
      }
      this.BarChart.setOption({
        yAxis: {
          data: getcouName
        },
        series: [{
          data:getData
        }]
      })
    },
    drawFunChart() {      //不同店铺收益的扇形图
      this.FunChart = echarts.init(document.getElementById("FunChart"));
      this.FunChart.setOption({
        legend: {	//图表上方的图例
          orient: 'vertical',
          left: 0,
          y: 'center',
          data: []
        },
        tooltip: {   //鼠标放到图上的数据展示样式
          trigger: 'item',
          formatter: "{b}({d}%)"
        },
        title: {
          text: '全部店铺收益',
          x: 'left',
          y: 10
        },
        series: [{
          name: '店铺收益占比',
          type: 'pie',
          barWidth: '60%',
          data: [],
        }],
      })
    },
    async initData() {      //不同店铺收益扇形图填充数据
      const res = await axios.get("/admin/store/getStoreList");
      const getData = [];
      for (let i = 0; i < res.data.data.length; i++) {
        const obj = new Object();
        obj.name = res.data.data[i].storeName;
        await axios({
          method:'post',
          url:'/admin/order/getBenefitByStoreId',
          params:{
            storeId:res.data.data[i].id
          }
        }).then(respone=>{
          obj.value=respone.data.data
        })
        getData[i]=obj;
        // console.log(getData[i])
      }
      this.FunChart.setOption({
        legend: {
          data: res.data.data.storeName
        },
        series: [{
          data: getData,
        }]
      });
    },
    drawFunChartTwo(){
      this.FunChartTwo = echarts.init(document.getElementById("FunChartTwo"));
      this.FunChartTwo.setOption({
        legend: {	//图表上方的图例
              orient: 'vertical',
              left: 0,
              y: 'center',
              data: []
            },
            tooltip: {   //鼠标放到图上的数据展示样式
              trigger: 'item',
              formatter: "{b}({d}%)"
            },
            title: {
              text: '课程分类收益',
              x: 'left',
              y: 10
            },
            series: [{
              name: '课程分类收益',
              type: 'pie',
              barWidth: '60%',
              data: [	// 扇形图数据格式： {value, name}
                {value: 0.3, name: '饼干'},		// value不一定是比例，echarts会自动转换
                {value: 0.25, name: '蛋糕'},
                {value: 0.2, name: '饮品'},
                {value: 0.25, name: '套餐'},
              ],
            }],
      })
    },
    async FunTwoinitData(){
      const res=await axios.get("/admin/course/getCourseCategoryList");
      const getData=[];
      for(let i=0;i<res.data.data.length;i++){
        const obj=new Object();
        obj.name=res.data.data[i].categoryName
        await axios({
          method:'post',
          url:'/admin/course/getCourseCategoryIncomeByCategoryId',
          params:{
            categoryId:res.data.data[i].id
          }
        }).then(respone=>{
          obj.value=respone.data.data
        })
        getData[i]=obj;
      }
       this.FunChartTwo.setOption({
         legend: {
           data: res.data.data.categoryName
         },
         series: [{
           data: getData,
         }]
       });
     },
    drawBarChartTwo(){
      this.BarChartTwo=echarts.init(document.getElementById("BarChartTwo"))
      this.BarChartTwo.setOption({
        legend: {show: true, data: [{name: '开课数',}], top: 10},
          xAxis: {
            type: 'value',
            name: '',   // x轴名称
            nameTextStyle: {	// x轴名称样式
              fontWeight: 600,
              fontSize: 18
            }
          },
          yAxis: {
            type: 'category',
            name: '开课次数',   // y轴名称
            data: [],
            nameTextStyle: {	// y轴名称样式
              fontWeight: 600,
              fontSize: 18
            }
          },
          tooltip: {   //鼠标放到图上的数据展示样式
            trigger: 'axis'
          },
          series: [{  //series中加入每个bar的数据
            name: "开课数",
            type: 'bar',
            barWidth: '60%',
            data: [],
          }],
      })
    },
    async BarTwoinitData(){
      const res=await axios.get("/admin/course/getCourseRanking");
      const getcName=[];
      const getData=[];
      for(let i=0;i<5;i++)
      {
        getcName[i]=res.data.data[i].courseName
        getData[i]=res.data.data[i].count
      }
      this.BarChartTwo.setOption({
        yAxis: {
          data: getcName
        },
        series: [{
          data:getData
        }]
      })
    },

    drawCharts() {
      this.drawFunChart();
      this.drawBarChart();
      this.drawFunChartTwo();
      this.drawBarChartTwo()
    },
  }
}
</script>

<style scoped>
.lef {
  height: 800px;
}

.head {

}

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

.toggle-btn {
  /*border: 1px solid black;*/
  width: 40px;
  height: 20px;
  margin-top: 5px;
  margin-left: -20px;
  float: left;
}

#FunChart {
  width: 47%;
  height: 300px;
  background-color: white;
}

#BarChart {
  width: 47%;
  height: 300px;
  background-color: white;
}

#FunChartTwo {
  width: 47%;
  height: 300px;
  background-color: white;
}

#BarChartTwo {
  width: 47%;
  height: 300px;
  background-color: white;
}

</style>