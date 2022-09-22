<template>
  <div style="margin-top: -60px">
    <el-container style="border: 1px solid red;height: 1050px">
      <el-menu
          active-color="#ffd04b"
          background-color="#545c64"
          class="el-menu-vertical"
          default-active="1-4"
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
        <el-menu-item index="1-5" style="border-bottom: 1px solid white" v-if="pList.get(107)===true" @click="Order">
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
                  <Folder />
                </el-icon>
              </div>
            </div>
          </div>
        </el-header>
        <el-main style="background-color: #F0F2F5;">
          <div style="margin-top: 10px;background-color: white;height: 650px">
              <div style="margin-top: 20px;">
                <el-table
                    ref="multipleTableRef"
                    style="width: 100%"
                    border
                    :data="UserData">
                  <el-table-column type="selection" width="55" align="center" ></el-table-column>
                  <el-table-column label="id" property="id" sortable min-width="70px" align="center" v-if="false"/>
                  <el-table-column label="用户名" property="username" min-width="90px" align="center" />
                  <el-table-column label="姓名" property="name" min-width="90px" align="center"/>
                  <el-table-column label="手机号" property="phoneNumber" min-width="110px" align="center"/>
                  <el-table-column label="地址" property="address" min-width="120px" align="center"/>
                  <el-table-column label="性别" property="sex" min-width="60px" align="center"/>
                  <el-table-column label="出生日期" property="birthday" min-width="110px" align="center"/>
                  <el-table-column label="电子邮箱" property="email" min-width="110px" align="center"/>
                  <el-table-column label="注册时间" property="registerTime" min-width="100px" align="center"/>
                  <el-table-column label="最后登录时间" property="lastLoginTime" min-width="120px" align="center"/>
                  <el-table-column label="操作" property="Operation" min-width="100px" align="center">
                    <template #default="scope">
                      <el-button type="primary" size="small" @click="UserDetail(scope.row)"><el-icon><Reading /></el-icon>查看详情</el-button>
                    </template>
                  </el-table-column>
                </el-table>
              </div>
            <el-pagination
                @size-change="handleSizeChange"
                @current-change="handleCurrentChange"
                :current-page="queryInfo.page"
                :page-sizes="[3, 5, 10, 15]"
                :page-size="queryInfo.size"
                layout="total, sizes, prev, pager, next, jumper"
                :total="Usertotal"
                style="margin-top: 30px">
            </el-pagination>
          </div>

          <el-dialog
              v-model="Detail"
              draggable>
            <template #title>
              <div>{{this.DetailTitle}}</div>
            </template>
            <el-form :model="form" label-width="120px">
              <el-form-item label="用户名">
                <el-input v-model="form.username" disabled/>
              </el-form-item>
              <el-form-item label="姓名">
                <el-input v-model="form.name" disabled />
              </el-form-item>
              <el-form-item label="手机号">
                <el-input v-model="form.phoneNumber" disabled/>
              </el-form-item>
              <el-form-item label="地址">
                <el-input v-model="form.address" disabled />
              </el-form-item>
              <el-form-item label="性别">
                <el-input v-model="form.sex" disabled />
              </el-form-item>
              <el-form-item label="出生日期">
                <el-input v-model="form.birthday" disabled />
              </el-form-item>
              <el-form-item label="电子邮箱">
                <el-input v-model="form.email" disabled />
              </el-form-item>
              <el-form-item label="注册时间">
                <el-input v-model="form.registerTime" disabled />
              </el-form-item>
              <el-form-item label="最后登录时间">
                <el-input v-model="form.lastLoginTime" disabled />
              </el-form-item>
            </el-form>

          </el-dialog>


        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>
import {
  PieChart, Coin, House, Calendar, User, Edit, Setting, Files, Operation, DArrowRight, DArrowLeft, Fold,
  ChromeFilled, Refresh,Bell, Help, Discount, Sort,ArrowDown,Van,Search,Folder,EditPen,Reading
} from '@element-plus/icons-vue'
import axios from "axios";
import {ElLoading, ElMessage} from "element-plus";
import router from "@/router";
import {useRoute} from "vue-router/dist/vue-router";
let aname;
let aid;
export default {
  name: "ManageStudent",
  setup () {
    let route = useRoute();
    aname = route.query.adminname;
    return {
      adminname: aname,
      adminid:aid
    }
  },
  components: {
    PieChart, Coin, House, Calendar, User, Edit, Setting, Files, Operation, DArrowLeft, DArrowRight, Fold,
    ChromeFilled, Refresh, Bell,Help, Discount, Sort, ArrowDown, Van,Search,Folder,EditPen,Reading
  },
  data() {
    return {
      // adminname:route.params.adminname,
      isCollapse: false,
      result: 'true',
      inputSearch: '',
      value: '',
      value4: '',
      value5: '',
      value1: '',
      input: '',
      dpList: [],
      CourseCate: [],
      tabled: [],
      pList: new Map(),
      queryInfo: {
        page: 1,
        size: 10
      },
      Usertotal: 0,
      UserData:[],
      Detail:false,
      DetailTitle:'',
      form:{
        username:'',
        name:'',
        phoneNumber:'',
        address:'',
        sex:'',
        birthday:'',
        email:'',
        registerTime:'',
        lastLoginTime:''
      },

    }
  },
  mounted(){
    this.getAllPermission()
    this.getAllUser()
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
          adminid: aid
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
            adminid: aid
          }
        })
      }, 500)
    },
    Order() {
      router.push({
        name: 'Order',
        query: {
          adminname: aname,
          adminid: aid
        }
      })
    },
    store() {
      router.push({
        name: 'Store',
        query: {
          adminname: aname,
          adminid: aid
        }
      })
    },
    CourseCategories() {
      router.push({
        name: 'CourseCategories',
        query: {
          adminname: aname,
          adminid: aid
        }
      })
    },
    ConfigureCourses() {
      router.push({
        name: 'ConfigureCourses',
        query: {
          adminname: aname,
          adminid: aid
        }
      })
    },
    ManageCourse() {
      router.push({
        name: 'ManageCourse',
        query: {
          adminname: aname,
          adminid: aid
        }
      })
    },
    Teacher() {
      router.push({
        name: 'Teacher',
        query: {
          adminname: aname,
          adminid: aid
        }
      })
    },
    ManageUser() {
      router.push({
        name: 'ManageUser',
        query: {
          adminname: aname,
          adminid: aid
        }
      })
    },
    ManageRole() {
      router.push({
        name: 'ManageRole',
        query: {
          adminname: aname,
          adminid: aid
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
    async getAllUser(){
        axios({
          method:'post',
          url:'/admin/user/getAllUserPageable',
          params:{
            page: this.queryInfo.page - 1,
            size: this.queryInfo.size,
          }
        }).then(res=>{
          this.Usertotal=res.data.data.totalElements;
          this.UserData=res.data.data.content;
        })
    },
    handleSizeChange(newSize) {
      this.queryInfo.size = newSize
      this.UserData = [];
      this.getAllUser()
    },
    handleCurrentChange(newPage) {
      this.queryInfo.page = newPage
      this.UserData = [];
      this.getAllUser()
    },
    UserDetail(Val){
        this.form.username=Val.username;
        this.form.name=Val.name;
        this.form.phoneNumber=Val.phoneNumber;
        this.form.address=Val.address;
        this.form.sex=Val.sex;
        this.form.birthday=Val.birthday;
        this.form.email=Val.email;
        this.form.registerTime=Val.registerTime;
        this.form.lastLoginTime=Val.lastLoginTime;
        this.DetailTitle=Val.username
        this.Detail=!this.Detail
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
.toggle-btn {
  /*border: 1px solid black;*/
  width: 40px;
  height: 20px;
  margin-top: 5px;
  margin-left: -20px;
  float: left;
}
.demo-image__error .image-slot {
  font-size: 30px;
}
.demo-image__error .image-slot .el-icon {
  font-size: 30px;
}
.demo-image__error .el-image {
  width: 100%;
  height: 200px;
}
</style>