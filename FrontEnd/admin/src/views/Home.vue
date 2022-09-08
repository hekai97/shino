<template>
  <div style="margin-top: -60px">
      <el-container style="border: 1px solid red;height: 800px">
        <el-menu
            active-color="#ffd04b"
            background-color="#545c64"
            class="el-menu-vertical"
            default-active="0-1"
            text-color="#fff"
            :collapse="isCollapse"
        >

          <el-menu-item index="0-0" disabled>
            <span style="color:white;font-size:17px"><h3>臻焙课工场</h3></span>
          </el-menu-item>
            <el-menu-item index="0-1">
              <el-icon><PieChart /></el-icon>
              <span style="margin-left: 3px">统计分析</span>
            </el-menu-item>
            <el-menu-item style="border-bottom: 1px solid white" index="0-2">
              <el-icon><Coin /></el-icon>
              <span style="margin-left: 3px">深度分析</span>
            </el-menu-item>
            <el-menu-item index="1-1">
              <el-icon><House /></el-icon>
              <span style="margin-left: 3px">门店管理</span>
            </el-menu-item>
            <el-sub-menu index="1-2" >
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
            <el-menu-item index="1-3">
              <el-icon><User /></el-icon>
              <span style="margin-left: 3px">讲师管理</span>
            </el-menu-item>
            <el-menu-item index="1-4">
              <el-icon><Edit /></el-icon>
              <span style="margin-left: 3px">学员管理</span>
            </el-menu-item>
            <el-menu-item index="1-5" style="border-bottom: 1px solid white">
              <el-icon><Files /></el-icon>
              <span style="margin-left: 3px">订单管理</span>
            </el-menu-item>
            <el-sub-menu index="1-6" >
              <template #title>
                <el-icon><Operation /></el-icon>
                <span style="margin-left: 3px">权限管理</span>
              </template>
              <el-menu-item index="1-6-1" style="margin-left: 15px">查看角色</el-menu-item>
              <el-menu-item index="1-6-2" style="margin-left: 15px">角色管理</el-menu-item>
              <el-menu-item index="1-6-3" style="margin-left: 15px">创建员工账号</el-menu-item>
              <el-menu-item index="1-6-4" style="margin-left: 15px">查看权限</el-menu-item>
            </el-sub-menu>
            <el-menu-item index="1-7" >
              <el-icon><Setting /></el-icon>
              <span style="margin-left: 3px">系统配置</span>
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
              <div style="float:right; margin-left: 20px" >姓名</div>
            </div>
                <div style="background-color: #42b983;width: 100px;">
                  <div class="toggle-btn" @click="exchange">
                    <el-icon size="large" v-if="result"><DArrowLeft/></el-icon>
                    <el-icon size="large" v-else><DArrowRight/></el-icon>
                  </div>
                  <div style="border-top: 2px solid  #73767a;float: right;width: 60px;background-color: #f4f4f5">
                    <el-icon size="large" style="margin-top: 4px"><TrendCharts /></el-icon>
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
                        :key="item.value"
                        :label="item.label"
                        :value="item.value"
                    />
                  </el-select>
                </div>
                <el-button style="width: 60px;float: left;background-color: #79bbff;margin-left: 10px;margin-top: 7px">
                  <el-icon><Search/></el-icon>
                </el-button>
              </div>
            </div>
            <div style="margin-top: 20px;border: 1px solid black;">
                <div style="width: 300px;background-color: white;border-radius: 5px;height: 120px;display: inline-block;float: left;">
                  <div style="width: 100px;font-size: 13px;height: 30px;line-height: 30px">销售金额</div>
                  <div style="font-size: 30px;width: 130px;font-weight:bold;margin-top: 15px">2636.4</div>
                  <div style="margin-top: 15px">
                    <div style="width: 50px;display: inline-block;float: left;font-size: 13px;margin-left: 10px">金额</div>
                    <div style="width: 100px;display: inline-block;margin-left: 140px;font-size: 13px">单位：元<el-icon style="font-size:15px;margin-left: 10px"><Money /></el-icon></div></div>
                </div>

              <div style="width: 300px;background-color: white;border-radius: 5px;height: 120px;display: inline-block;margin-left: 15px">
                <div style="width: 100px;font-size: 13px;height: 30px;line-height: 30px">销售金额</div>
                <div style="font-size: 30px;width: 130px;font-weight:bold;margin-top: 15px">2636.4</div>
                <div style="margin-top: 15px">
                  <div style="width: 50px;display: inline-block;float: left;font-size: 13px;margin-left: 10px">金额</div>
                  <div style="width: 100px;display: inline-block;margin-left: 140px;font-size: 13px">单位：元<el-icon style="font-size:15px;margin-left: 10px"><Money /></el-icon></div></div>
              </div>

              <div style="width: 300px;background-color: white;border-radius: 5px;height: 120px;display: inline-block;margin-left: 17px">
                <div style="width: 100px;font-size: 13px;height: 30px;line-height: 30px">销售金额</div>
                <div style="font-size: 30px;width: 130px;font-weight:bold;margin-top: 15px">2636.4</div>
                <div style="margin-top: 15px">
                  <div style="width: 50px;display: inline-block;float: left;font-size: 13px;margin-left: 10px">金额</div>
                  <div style="width: 100px;display: inline-block;margin-left: 140px;font-size: 13px">单位：元<el-icon style="font-size:15px;margin-left: 10px"><Money /></el-icon></div></div>
              </div>

              <div style="width: 300px;background-color: white;border-radius: 5px;height: 120px;display: inline-block;margin-left: 17px">
                <div style="width: 100px;font-size: 13px;height: 30px;line-height: 30px">销售金额</div>
                <div style="font-size: 30px;width: 130px;font-weight:bold;margin-top: 15px">2636.4</div>
                <div style="margin-top: 15px">
                  <div style="width: 50px;display: inline-block;float: left;font-size: 13px;margin-left: 10px">金额</div>
                  <div style="width: 100px;display: inline-block;margin-left: 140px;font-size: 13px">单位：元<el-icon style="font-size:15px;margin-left: 10px"><Money /></el-icon></div></div>
              </div>

            </div>
<!--            <div id="myChart"></div>-->
          </el-main>
        </el-container>
      </el-container>
  </div>
</template>

<script>
// import * as echarts from 'echarts'
import {
  Menu as IconMenu,PieChart, Coin, House, Calendar, User, Edit, Setting, Files, Operation,DArrowRight,DArrowLeft,Fold,ChromeFilled,Refresh,Bell,
  Help,Discount,Sort,TrendCharts,Search,Money} from '@element-plus/icons-vue'
export default {
  name: "myHome",
  components:{
    // eslint-disable-next-line vue/no-unused-components
    IconMenu, PieChart, Coin, House, Calendar, User, Edit, Setting, Files, Operation, DArrowLeft, DArrowRight, Fold,ChromeFilled,Refresh,Bell,
    Help,Discount,Sort,TrendCharts,Money,Search,
  },
  data(){
    return{
      isCollapse:false,
      result:'true',
      inputSearch:'',
      value4:'',
      value5:'',
      value1:'',
      dpList:[
        {
          value: '1111',
          label: 'Option1',
        },
        {
          value: 'Option2',
          label: 'Option2',
        },
        {
          value: 'Option3',
          label: 'Option3',
        },
        {
          value: 'Option4',
          label: 'Option4',
        },
        {
          value: 'Option5',
          label: 'Option5',
        },
      ],
  //     echartsOption: {	// echarts选项，所有绘图数据和样式都在这里设置
  //       legend: {	//图表上方的图例
  //         data: ['腾讯', '阿里巴巴', '华为', '字节跳动']
  //       },
  //       tooltip: {   //鼠标放到图上的数据展示样式
  //         trigger: 'axis'
  //       },
  //       series: [{
  //         name: '公司市值占比',
  //         type: 'pie',
  //         barWidth: '60%',
  //         data: [	// 扇形图数据格式： {value, name}
  //           {value: 0.35, name: '腾讯'},		// value不一定是比例，echarts会自动转换
  //           {value: 0.2, name: '阿里巴巴'},
  //           {value: 0.25, name: '华为'},
  //           {value: 0.2, name: '字节跳动'},
  //         ],
  //       }],
  //     }
    }
  },
  // mounted(){
  //   let myChart = echarts.init(document.getElementById('myChart'), 'light')	// 初始化echarts, theme为light
  //   myChart.setOption(this.echartsOption)	// echarts设置选项
  // },
  methods:{
    exchange(){
      this.isCollapse=!this.isCollapse;
      this.result=!this.result;
    }
  }
}
</script>

<style scoped>
.lef{
    height: 800px;
}
.head{

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
.toggle-btn{
  /*border: 1px solid black;*/
  width: 40px;
  height: 20px;
  margin-top: 5px;
  margin-left: -20px;
  float: left;
}
#myChart{
  border: 1px solid black;
  width: 100%;
  height: 300px;
  background-color: white;
  border-radius: 30px;
}

</style>