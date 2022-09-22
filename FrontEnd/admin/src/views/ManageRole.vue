<template>
  <div style="margin-top: -60px">
    <el-container style="border: 1px solid red;height: 1050px">
      <el-menu
          active-color="#ffd04b"
          background-color="#545c64"
          class="el-menu-vertical"
          default-active="1-6-2"
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
        <el-menu-item index="1-4" v-if="pList.get(105)===true" @click="ManageStudent">
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
          <el-menu-item index="1-6-2" style="margin-left: 15px">角色管理</el-menu-item>
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
                  <HomeFilled />
                </el-icon>
              </div>
            </div>
          </div>
        </el-header>
        <el-main style="background-color: #F0F2F5;">
          <div style="margin-top: 10px;background-color: white;height: 650px">
            <div style="height: 50px;">
              <div style="width: 100px;float: left;margin-left: 20px;margin-top: 20px;">角色管理</div>
              <div style="float:left;width: 100px;margin-top: 22px;margin-left: 100px">内容搜索</div>
              <div style="margin-top: 18px;float: left"><el-input v-model="input"  placeholder="输入店铺名称进行搜索" style="width: 200px;" /></div>
              <div style="margin-top: 18px;float:left;margin-left: 10px"><el-button  style="width: 60px;float: left;background-color: #79bbff;">
                <el-icon>
                  <Search/>
                </el-icon>
              </el-button></div>
            </div>
            <div style="margin-left: 30px;height: 35px;margin-top: 20px">
              <el-button type="primary" style="float: left;" @click="CreatNewRole" >创建角色</el-button>
            </div>
            <div style="margin-top: 20px;">
              <el-table
                  ref="multipleTableRef"
                  style="width: 100%"
                  border
                  :data="RoleData"
              >
                <el-table-column type="selection" width="55" align="center" ></el-table-column>
                <el-table-column label="角色ID" property="id" sortable min-width="70px" align="center"/>
                <el-table-column label="角色名称" property="name" min-width="100px" align="center"/>
                <el-table-column label="创建者" property="creator" min-width="100px" align="center"/>
                <el-table-column label="操作" property="Operation" min-width="120px" align="center">
                  <template #default="scope">
                    <el-button type="primary" @click="UpdataRole(scope.row)"><el-icon><EditPen /></el-icon>编辑</el-button>
                    <el-button type="danger" @click="DeleteRole(scope.row)"><el-icon><Delete /></el-icon>删除</el-button>
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
                :total="Roletotal"
                style="margin-top: 50px;margin-left: 30px">
            </el-pagination>


            <!--        添加新的课程分类-->
            <el-dialog
                title="添加新角色"
                v-model="OpenNewRole"
                draggable
                style="background-color:#F0F2F5">
              <div>
                <div style="display: inline-block">角色名称</div>
                <div style="display: inline-block;margin-left: 20px">
                  <el-input v-model="NewRoleName"></el-input>
                </div>
              </div>
              <div style="margin-top: 20px">
                <el-button type="primary" @click="AddRole">确定</el-button>
              </div>
            </el-dialog>


            <!--        更新角色信息-->

            <el-dialog
                v-model="OpenUpdataRole"
                draggable
                style="background-color:#F0F2F5">
              <template #title>
                <div>{{this.UpdataRoleName}}</div>
              </template>
                <div>

                  <div>
                    <div style="display: inline-block">选择权限</div>
                    <div style="display: inline-block;margin-left: 10px">
                      <el-select v-model="RolePermissionSelect" placeholder="请选择权限" @change="getNewPermission">
                        <el-option
                            v-for="item in RolePermission"
                            :key="item.id"
                            :label="item.permissionName"
                            :value="item.id">
                          <span style="float: left"><el-icon><UserFilled /></el-icon></span>
                          <span style="float: left">{{ item.permissionCode }}</span>
                          <span style="float: left;margin-left: 10%">{{ item.permissionName}}</span>
                        </el-option>
                        ` </el-select>
                    </div>
                    <div style="display: inline-block;margin-left: 10px"><el-button @click="AddPermissionToRole" type="primary"><el-icon><Plus /></el-icon>添加</el-button></div>
                  </div>
                  <div style="margin-left:20px;margin-top: 20px;width:89%;background-color: white;font-size:15px;height: 40px;"
                       v-for="item in LookAllPermissionInRole"
                       :key="item.id"
                  >
                    <div style="display: inline-block;margin-left: 2%"><el-icon><UserFilled /></el-icon></div>
                    <div style="display: inline-block;margin-left: 2%;line-height: 40px">编号：</div>
                    <div style="display: inline-block;width: 10%;text-align: left">{{item.permissionCode}}</div>
                    <div style="display: inline-block;margin-left: 5%;">姓名：</div>
                    <div style="display: inline-block;width: 20%;text-align: left">{{item.permissionName}}</div>
                    <div style="display: inline-block;margin-left: 0%">
                      <el-button type="danger" size="small" @click="DeleteUserPermission(item.id)"><el-icon><Delete /></el-icon>删除</el-button>
                    </div>
                  </div>


                </div>


            </el-dialog>


          </div>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>
import {
  PieChart, Coin, House, Calendar, User, Edit, Setting, Files, Operation, DArrowRight, DArrowLeft, Fold,
  ChromeFilled, Refresh,Bell, Help, Discount, Sort,ArrowDown,Van,HomeFilled,Search,Delete,EditPen,UserFilled
} from '@element-plus/icons-vue'
import axios from "axios";
import {ElLoading, ElMessage, ElMessageBox} from "element-plus";
import router from "@/router";
import {useRoute} from "vue-router/dist/vue-router";
let aname;
let aid;
export default {
  name: "Role",
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
    ChromeFilled, Refresh, Bell,Help, Discount, Sort, ArrowDown, Van,HomeFilled,Search,EditPen,Delete,UserFilled
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
      role:'',
      dpList: [],
      tabled: [],
      pList: new Map(),
      RoleData:[],
      queryInfo: {
        page: 1,
        size: 10
      },
      Roletotal:0,
      OpenNewRole:false,
      NewRoleName:'',
      OpenUpdataRole:false,
      UpdataRoleName:'',
      RolePermissionSelect:'',
      RolePermission:{
        id:'',
        permissionCode:'',
        permissionName:''
      },
      UpdateNewPermission:'',
      Updataid:'',
      LookAllPermissionInRole:{
        id:'',
        permissionCode:'',
        permissionName:'',
      },
    }
  },
  mounted() {
    this.getAllPermission()
    this.getAllRole()
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
    Order() {
      router.push({
        name: 'Order',
        query: {
          adminname: aname,
          adminid:aid
        }
      })
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
    CourseCategories(){
      router.push({
        name:'CourseCategories',
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
    ManageUser(){
      router.push({
        name:'ManageUser',
        query:{
          adminname:aname,
          adminid:aid
        }
      })
    },
    async getAllPermission(){
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
    async getAllRole(){
      axios({
        method:'get',
        url:'/admin/permission/getRoleListPageable',
        params:{
          page: this.queryInfo.page - 1,
          size: this.queryInfo.size,
        }
      }).then(res=>{
        this.Roletotal=res.data.data.totalElements;
        this.RoleData=res.data.data.content;
      })
    },
    getNewPermission(Val){
      this.UpdateNewPermission=Val;
    },
    handleSizeChange(newSize) {
      this.queryInfo.size = newSize
      this.RoleData = [];
      this.getAllRole()
    },
    handleCurrentChange(newPage) {
      this.queryInfo.page = newPage
      this.RoleData = [];
      this.getAllRole()
    },
    CreatNewRole(){
      this.OpenNewRole=!this.OpenNewRole
    },
    AddRole(){
      let NewRole=new FormData();
      NewRole={
        name:this.NewRoleName
      }
      axios({
        method:'post',
        url:'/admin/permission/addRole',
        data:NewRole
      }).then(res=>{
        if(res.data.status===0){
          ElMessage("角色创建成功")
          router.go(0)
        }else{
          ElMessage(res.data.message)
        }
      })
    },
    DeleteRole(Val){
      ElMessageBox.confirm(
          '是否确定删除' + Val.name + '角色',
          '提醒',
          {
            confirmButtonText: '确定',
            cancelButtonText: '取消',
            type: 'warning',
          }
      )
          .then(() => {
            axios({
              method:'post',
              url:'/admin/permission/deleteRole',
              data:Val
            }).then(res=>{
              if(res.data.status===0){
                ElMessage("删除成功")
                router.go(0)
              }else{
                ElMessage(res.data.message)
              }
            })
          })
          .catch(() => {
            ElMessage({
              type: 'info',
              message: '取消删除',
            })
          })
    },
    async UpdataRole(Val){
      this.Updataid=Val.id;
      this.UpdataRoleName=Val.name;
      await axios({
        method:'get',
        url:'/admin/permission/getPermissionNotInRole',
        params:{
          roleId:Val.id
        }
      }).then(res=>{
        this.RolePermission=res.data.data;
      })

      await axios({
        method:'get',
        url:'/admin/permission/getPermissionOfRole',
        params:{
          roleId:Val.id
        }
      }).then(res=>{
        this.LookAllPermissionInRole=res.data.data
      })

      this.OpenUpdataRole=!this.OpenUpdataRole
     },
    AddPermissionToRole(){
      let NewPermission=new FormData();
      NewPermission={
        roleId:this.Updataid,
        permissionId:this.UpdateNewPermission
      }
        axios({
          method:'post',
          url:'/admin/permission/addPermissionToRole',
          data:NewPermission
        }).then(res=>{
          if(res.data.status===0){
            ElMessage("权限添加成功")
            router.go(0)
          }else{
            ElMessage(res.data.message)
          }
        })
    },
    DeleteUserPermission(permissionid){
      let deletepermission=new FormData();
      deletepermission={
        roleId:this.Updataid,
        permissionId:permissionid
      }

      ElMessageBox.confirm(
          '确定删除该角色此权限吗',
          '提醒',
          {
            confirmButtonText: '确定',
            cancelButtonText: '取消',
            type: 'warning',
          }
      )
          .then(() => {
            axios({
              method:'post',
              url:'/admin/permission/deletePermissionToRole',
              data:deletepermission
            }).then(res=>{
              if(res.data.status===0){
                ElMessage("删除成功");
                router.go(0)
              }else {
                ElMessage(res.data.message)
              }
            })
          })
          .catch(() => {
            ElMessage({
              type: 'info',
              message: '取消删除',
            })
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
.toggle-btn {
  /*border: 1px solid black;*/
  width: 40px;
  height: 20px;
  margin-top: 5px;
  margin-left: -20px;
  float: left;
}
</style>
