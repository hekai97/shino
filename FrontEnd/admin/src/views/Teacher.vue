<template>
  <div style="margin-top: -60px">
    <el-container style="border: 1px solid red;height: 1050px">
      <el-menu
          active-color="#ffd04b"
          background-color="#545c64"
          class="el-menu-vertical"
          default-active="1-3"
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
        <el-menu-item index="1-1" v-if="pList.get(106)===true" @click="Store">
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
            <div style="display: inline-block;float: left;vertical-align: middle;margin-top: 10px">
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
              <p style="position: absolute;left: 230px;top: 95px;font-size: small">入职时间</p>
              <el-input v-model="input" placeholder="开始时间" style="width: 10%;position: absolute;top:100px;left: 290px"/>
              <el-input v-model="input1" placeholder="结束时间" style="position: absolute;width: 10%;top: 100px;left: 420px"/>
              <p style="position: absolute;top: 95px;left: 560px;font-size: small;">选择店铺</p>
              <el-form-itemv style="position: absolute;top: 80px;left: 600px;width: 10%">
                <el-select v-model="value" style="width: 100%;top: 20px;left: 20px" clearable placeholder="请选择标签">
                  <el-option
                      v-for="item in options"
                      :key="item.value"
                      :label="item.label"
                      :value="item.value"
                  />
                </el-select>
              </el-form-itemv>
              <p style="position: absolute;top: 95px;left: 780px;font-size: small;">擅长类别</p>
              <el-form-itemv style="position: absolute;top: 80px;left: 820px;width: 10%">
                <el-select v-model="value1" style="width: 100%;top: 20px;left: 20px" clearable placeholder="请选择标签">
                  <el-option
                      v-for="item in options"
                      :key="item.value"
                      :label="item.label"
                      :value="item.value"
                  />
                </el-select>
              </el-form-itemv>
              <p style="position: absolute;top: 95px;right: 220px;font-size: small;">内容搜索</p>
              <el-input v-model="input2" placeholder="表内任意内容" style="width: 10%;position: absolute;top:100px;right: 80px"/>
              <el-button style=" position: absolute;right: 20px;top: 100px"><el-icon><Search /></el-icon></el-button>
              </div>
          <div style="margin-top: 60px;margin-right: 900px">
          <el-button  type="primary">添加新讲师</el-button>
          </div>
          <div style="margin-top: 20px">
            <el-card style="top: 200px;width: 100%">
              <el-table
                  ref="multipleTableRef"
                  :data="tableDatas"
                  style="width: 100%;font-size: xx-small"
                  @selection-change="handleSelectionChange"
              >
                <el-table-column type="selection" width="30" />
                <el-table-column label="编号" width="80">
                  <template #default="scope">{{ scope.row.date }}</template>
                </el-table-column>
                <el-table-column property="name" label="讲师姓名" width="80" />
                <el-table-column property="phonenumber" label="讲师手机号" width="90" />
                <el-table-column property="address" label="家庭住址" width="80" />
                <el-table-column property="Store" label="门店" width="80" />
                <el-table-column property="storenum" label="门店编号" width="80" />
                <el-table-column property="sex" label="性别" width="80" />
                <el-table-column property="birthday" label="出生日期" width="80" />
                <el-table-column property="Induction" label="入职日期" width="80" />
                <el-table-column property="quit" label="离职日期" width="80" />
                <el-table-column property="picture" label="详情图片" width="80" />
                <el-table-column property="status" label="发布状态" width="80" />
                <el-table-column property="operation" label="操作" width="80" />
              </el-table>
              <div style="margin-top: 5px">
                <el-pagination background layout="prev, pager, next" :total="1000" />
              </div>
            </el-card>
          </div>

        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>
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
  ArrowDown,
  Van,
} from '@element-plus/icons-vue'
import axios from "axios";
import {ElLoading, ElMessage} from "element-plus";
import router from "@/router";
import {useRoute} from "vue-router/dist/vue-router";
let aname;
let aid;
export default {
  name: "Teacher",
  setup () {
    let route = useRoute();
    aname = route.query.adminname;
    return {
      adminname: aname,
      adminaid:aid
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
    Search,
    ArrowDown,
    Van,
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
      value:'',
      input:'',
      input1:'',
      input2:'',
      dpList: [],
      pList: new Map(),
      tableDatas:[
        {

        }
      ]
    }
  },
  mounted() {
    this.getAllPermission()
  },
  methods: {
    exchange() {
      this.isCollapse = !this.isCollapse;
      this.result = !this.result;
    },
    loginout() {
      axios({
        method: 'post',
        url: 'http://10.20.44.236/admin/user/logout',
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
          }
        })
      }, 500)
    },
    Store(){
      router.push({
        name: 'Store',
        query: {
          adminname: aname,
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

    async getAllPermission() {
      await axios({
        methods: 'get',
        url: '/admin/permission/getAllPermissionList',
      }).then(response => {
        if (response.data.status === 0) {
          for (let i = 0; i < response.data.data.length; i++) {
            this.pList.set(response.data.data[i].permissionCode, true)
          }
        }
      })
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
</style>
