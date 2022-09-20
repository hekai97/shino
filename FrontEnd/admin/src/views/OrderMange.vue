<template>
  <div style="margin-top: -60px">
    <el-container style="border: 1px solid red;height: 1050px">
      <el-menu
          active-color="#ffd04b"
          background-color="#545c64"
          class="el-menu-vertical"
          default-active="1-5"
          text-color="#fff"
          :collapse="isCollapse"
      >

        <el-menu-item index="0-0" disabled>
          <span style="color:white;font-size:17px;"><h3>臻焙课工场</h3></span>
        </el-menu-item>
        <el-menu-item index="0-1" v-if="pList.get(101)===true" @click="home">
          <el-icon>
            <PieChart/>
          </el-icon>
          <span style="margin-left: 3px">统计分析</span>
        </el-menu-item>
        <el-menu-item style="border-bottom: 1px solid white" index="0-2" v-if="pList.get(102)===true" @click="Deep">
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
        <el-menu-item index="1-4" v-if="pList.get(105)===true">
          <el-icon>
            <Edit/>
          </el-icon>
          <span style="margin-left: 3px">学员管理</span>
        </el-menu-item>
        <el-menu-item index="1-5" style="border-bottom: 1px solid white" v-if="pList.get(107)===true">
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
          <el-menu-item index="1-6-1" style="margin-left: 15px">查看角色</el-menu-item>
          <el-menu-item index="1-6-2" style="margin-left: 15px">角色管理</el-menu-item>
          <el-menu-item index="1-6-3" style="margin-left: 15px">创建员工账号</el-menu-item>
          <el-menu-item index="1-6-4" style="margin-left: 15px">查看权限</el-menu-item>
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
          <div style="display: table-cell;">
            <div style="display: inline-block;vertical-align: middle;margin-top: 10px">
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

        <div>
          <div>
            <el-input
               placeholder="请输入搜索内容"
               v-model="inputSearch"
               size="large"
               style="width: 25%;float: left;margin-bottom: 20px"
            >
            </el-input>
          </div>
          <div><el-button type="primary" style="float: left;margin-left: 2%" size="large">搜索</el-button></div>
        </div>
         <el-table :data="orderList"
                   border
                   stripe
                   >
           <el-table-column type="selection" width="55" align="center" ></el-table-column>
           <el-table-column label="订单编号" prop="order_number" align="center"></el-table-column>
           <el-table-column label="用户姓名" prop="user_name" align="center"></el-table-column>
           <el-table-column label="订单价格" prop="order_price" align="center"></el-table-column>
           <el-table-column align="center" label="下单时间"  prop="creationTime" />
           <el-table-column label="支付方式" prop="is_send" align="center"></el-table-column>
           <el-table-column label="支付时间" prop="paytime" align="center">
           </el-table-column>
             <!--表格行操作按钮 -->
             <el-table-column property="operation" label="操作" min-width="60px" align="center">
               <template #default="scope">
                    <el-button size="small" type="primary" @click="Lookdetails(scope.row.order_number,scope.row.user_name,scope.row.creationTime,scope.row.is_send,scope.row.paytime)"><el-icon><Reading/></el-icon>查看详情</el-button>
               </template>
             </el-table-column>
         </el-table>

          <el-dialog v-model="dialogTableVisible" title="详情展示">
            <div>
                <div>
                  <div style="display: inline-block;font-size: 20px">订单编号：</div>
                  <div style="display: inline-block;font-size: 18px">{{this.OrderNumber}}</div>
                </div>
                <div>
                  <div style="display: inline-block;font-size: 20px">下单课程：</div>
                  <div style="display: inline-block;font-size: 18px">{{this.courseName}}</div>
                </div>
                <div>
                  <div style="display: inline-block;font-size: 20px">课程类别：</div>
                  <div style="display: inline-block;font-size: 18px">{{this.courseType}}</div>
                </div>
                <div>
                  <div style="display: inline-block;font-size: 20px">课程分类：</div>
                  <div style="display: inline-block;font-size: 18px">{{this.categoryName}}</div>
                </div>
                <div>
                  <div style="display: inline-block;font-size: 20px">订单价格：</div>
                  <div style="display: inline-block;font-size: 18px">{{this.price}}</div>
                </div>
              <div>
                <div style="display: inline-block;font-size: 20px">用户姓名：</div>
                <div style="display: inline-block;font-size: 18px">{{this.username}}</div>
              </div>
              <div>
                <div style="display: inline-block;font-size: 20px">支付方式：</div>
                <div style="display: inline-block;font-size: 18px">{{this.payway}}</div>
              </div>
              <div>
                <div style="display: inline-block;font-size: 20px">下单时间：</div>
                <div style="display: inline-block;font-size: 18px">{{this.createdtime}}</div>
              </div>
              <div>
                <div style="display: inline-block;font-size: 20px">支付时间：</div>
                <div style="display: inline-block;font-size: 18px">{{this.paytime}}</div>
              </div>
            </div>
          </el-dialog>


         <!-- 分页 -->
         <el-pagination
             @size-change="handleSizeChange"
             @current-change="handleCurrentChange"
             :current-page="queryInfo.page"
             :page-sizes="[3, 5, 10, 15]"
             :page-size="queryInfo.size"
             layout="total, sizes, prev, pager, next, jumper"
             :total="total">
         </el-pagination>

        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>
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
  ArrowDown,
  Van,
  Reading,
} from '@element-plus/icons-vue'
import router from "@/router";
import axios from "axios";
import {ElMessage} from "element-plus";
let aname;
let aid;
export default {
  name: "OrderMange",
  setup() {
    let route = useRoute();
    aname = route.query.adminname;
    return {
      adminname: aname,
      adminid:aid
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
    ArrowDown,
    Van,
    Reading,
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
      dpList: [],
      pList: new Map(),
      OrderNumber:'',
      courseName:'',
      courseType:'',
      categoryName:'',
      price:'',
      username:'',
      createdtime:'',
      payway:'',
      paytime:'',
      dialogTableVisible:false,
      OrderDetail:[{
        courseName:'',
        courseTypeId:''
      }],
      //查询条件
      queryInfo: {
        page: 1,
        size: 10
      },
      //订单列表数据
      orderList: [{
        order_number:'',
        user_name:'',
        order_price:'',
        creationTime:'',
        is_send:'',
        paytime:''
      }],
      //数据总条数
      total:0,
    }
  },
  mounted() {
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
  },
  created(){
    this.getOrderList()
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
    home() {
      router.push({
        name: 'firsthome',
        query: {
          adminname: aname,
          adminid:aid
        }
      })
    },
    store() {
      router.push({
        name: 'Store',
        query: {
          adminname: aname,
          adminid:aid
        }
      })
    },
    Deep() {
      router.push({
        name: 'Deep',
        query: {
          adminname: aname,
          adminid:aid
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
    async getOrderList() {
      axios({
        method:'post',
        url:'/admin/order/getOrderListPageable',
        params:{
          page:this.queryInfo.page-1,
          size:this.queryInfo.size
        }
      }).then(res=>{
        this.total=res.data.data.totalElements
        for(let i=0;i<res.data.data.content.length;i++){
          const obj = new Object();
          obj.order_number=res.data.data.content[i].orderNumber;
          obj.user_name=res.data.data.content[i].username
          obj.order_price=res.data.data.content[i].totalAmount
          obj.creationTime=res.data.data.content[i].createdTime
          obj.is_send=res.data.data.content[i].paymentWay
          obj.paytime=res.data.data.content[i].payTime
          this.orderList[i]=obj;
        }
      })
    },
    handleSizeChange(newSize){
        this.queryInfo.size = newSize
        this.orderList=[];
        this.getOrderList()
      },
    handleCurrentChange(newPage){
        this.queryInfo.page = newPage
        this.orderList=[];
        this.getOrderList()
      },
    Lookdetails(order_number,username,createdtime,payway,paytime){
        // ElMessage(order_number)
      this.OrderNumber=order_number;
      this.username=username;
      this.createdtime=createdtime;
      this.payway=payway;
      this.paytime=paytime;
      // const obj=new new URLSearchParams();
      axios({
        method:'post',
        url:'/admin/order/getOrderDetailByOrderNumber',
        params:{
          orderNumber:order_number
        }
      }).then(res=>{
        for(let i=0;i<res.data.data.length;i++) {
          this.courseName = res.data.data[i].courseName;
          this.courseType = res.data.data[i].courseType;
          this.categoryName = res.data.data[i].categoryName;
          this.price = res.data.data[i].price;
        }
      })
      this.dialogTableVisible=!this.dialogTableVisible;
    }
  }
}
</script>

<style scoped>
.toggle-btn {
  /*border: 1px solid black;*/
  width: 40px;
  height: 20px;
  margin-top: 5px;
  margin-left: -20px;
  float: left;
}
.el-menu-vertical {
  border-top: 1px solid white;
}

.el-menu-vertical:not(.el-menu--collapse) {
  width: 200px;
  min-height: 800px;
}
</style>