<template>
  <div style="margin-top: -60px">
    <el-container style="border: 1px solid red;height: 800px">
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
          <el-menu-item index="1-2-1" style="margin-left: 15px">查看课程</el-menu-item>
          <el-menu-item index="1-2-2" style="margin-left: 15px">创建新课程</el-menu-item>
          <el-menu-item index="1-2-3" style="margin-left: 15px">修改课程信息</el-menu-item>
          <el-menu-item index="1-2-4" style="margin-left: 15px">删除课程</el-menu-item>
          <el-menu-item index="1-2-5" style="margin-left: 15px">配置课程</el-menu-item>
          <el-menu-item index="1-2-6" style="margin-left: 15px">课程追踪</el-menu-item>
        </el-sub-menu>
        <el-menu-item index="1-3" v-if="pList.get(104)===true">
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


       <el_card>
         <!-- 搜索栏 -->
         <el-row :gutter="20">
           <el-col :span="8">
             <el-button @click="search">搜索</el-button>
             <el-input
                 placeholder="请输入搜索内容"
                 v-model="inputSearch"
             >
             </el-input>
           </el-col>
         </el-row>

         <el-table :data="orderList"
                   border
                   stripe
                   >
           <el-table-column type="selection" width="55" align="center" ></el-table-column>
<!--           <el-table-column type="index"></el-table-column>-->
           <el-table-column label="订单编号" prop="order_number" align="center"></el-table-column>
           <el-table-column label="用户姓名" prop="user_name" align="center"></el-table-column>
           <el-table-column label="订单价格" prop="order_price" align="center"></el-table-column>
<!--           <el-table-column label="是否付款" prop="pay_status">
             <template v-slot="scope">
               <el-tag type="success" v-if="scope.row.pay_status === '1'">已付款</el-tag>
               <el-tag type="danger" v-else>未付款</el-tag>
             </template>
           </el-table-column>-->

           <el-table-column align="center" label="下单时间"  prop="creationTime" />
           <el-table-column label="支付方式" prop="is_send" align="center"></el-table-column>
           <el-table-column label="支付时间" prop="paytime" align="center">
           </el-table-column>
             <!--表格行操作按钮 -->
             <el-table-column property="operation" label="操作" min-width="150px" align="center">
               <el-button size="small" type="primary"><el-icon><Reading/></el-icon>课程</el-button>
               <el-button size="small" type="primary"><el-icon><EditPen/></el-icon>编辑</el-button>
               <el-button size="small" type="primary"><el-icon><Delete/></el-icon>删除</el-button>
             </el-table-column>
         </el-table>

         <!-- 分页 -->
         <el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page="queryInfo.page" :page-sizes="[3, 5, 10, 15]" :page-size="queryInfo.size" layout="total, sizes, prev, pager, next, jumper" :total="total">
         </el-pagination>
       </el_card>

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
  EditPen,
  Delete
} from '@element-plus/icons-vue'
import router from "@/router";
import axios from "axios";
import {ElMessage} from "element-plus";
let aname;
export default {
  name: "OrderMange",
  setup() {
    let route = useRoute();
    aname = route.query.adminname;
    return {
      adminname: aname,
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
    EditPen,
    Delete
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
      //查询条件
      queryInfo: {
        page: 0,
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
        }
      })
    },
    store() {
      router.push({
        name: 'Store',
        query: {
          adminname: aname,
        }
      })
    },
    Deep() {
      router.push({
        name: 'Deep',
        query: {
          adminname: aname,
        }
      })
    },
    async getOrderList() {
      //   const { data: res } = await this.$http.get('orders', {params: this.queryInfo})
      //   if (res.meta.status !== 200) {
      //     return this.$message.error('获取订单列表数据失败!')
      //   }
      //   this.total = res.data.total
      //   this.orderList = res.data.goods
      // },
      // handleSizeChange(newSize){
      //   this.queryInfo.pagesize = newSize
      //   this.getOrderList()
      // },
      // handleCurrentChange(newPage){
      //   this.queryInfo.pagenum = newPage
      //   this.getOrderList()
      // }
      axios({
        method:'post',
        url:'/admin/order/getOrderListPageable',
        params:this.queryInfo
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
        this.queryInfo.pagesize = newSize
        this.getOrderList()
      },
      handleCurrentChange(newPage){
        this.queryInfo.pagenum = newPage
        this.getOrderList()
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
</style>