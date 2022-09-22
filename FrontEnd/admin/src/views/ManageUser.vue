<template>
  <div style="margin-top: -60px">
    <el-container style="border: 1px solid red;height: 1050px">
      <el-menu
          active-color="#ffd04b"
          background-color="#545c64"
          class="el-menu-vertical"
          default-active="1-6-1"
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
          <el-menu-item index="1-6-1" style="margin-left: 15px">用户管理</el-menu-item>
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
                  <HomeFilled />
                </el-icon>
              </div>
            </div>
          </div>
        </el-header>
        <el-main style="background-color: #F0F2F5;">
          <div style="margin-top: 10px;background-color: white;height: 650px">
            <div style="height: 50px;">
              <div style="width: 100px;float: left;margin-left: 20px;margin-top: 20px;">用户管理</div>
              <div style="display: inline-block;margin-top: 14px;margin-left: 200px">
                <p style="position: absolute;top: 95px;left: 560px">选择店铺</p>
                <el-form-itemv style="position: absolute;top: 80px;left: 600px;width: 10%">
                  <el-select v-model="value" style="width: 100%;top: 25px;left: 40px" clearable placeholder="请选择标签">
                    <el-option
                        v-for="item in StoreList"
                        :key="item.id"
                        :label="item.storeName"
                        :value="item.id"
                    />
                  </el-select>
                </el-form-itemv>
              </div>
              <div style="float:left;width: 100px;margin-top: 18px;margin-left: 600px">内容搜索</div>
              <div style="margin-top: 14px;float: left;"><el-input v-model="input"  placeholder="输入店铺名称进行搜索" style="width: 200px;" /></div>
              <div style="margin-top: -5px;float: left;margin-left: 20px"><el-button  style="width: 60px;float: left;background-color: #79bbff;">
                <el-icon>
                  <Search/>
                </el-icon>
              </el-button></div>
            </div>
            <div style="margin-left: 30px;height: 35px;margin-top: 20px">
              <el-button type="primary" style="float: left;margin-top:18px" @click="CreatNewUser" >创建用户</el-button>
            </div>
            <div style="margin-top: 30px;">
              <el-table
                  ref="multipleTableRef"
                  style="width: 100%"
                  border
                  :data="UserData"
              >
                <el-table-column type="selection" width="55" align="center" ></el-table-column>
                <el-table-column label="id" property="id" min-width="50px" align="center" v-if="false"/>
                <el-table-column label="编号" property="number" sortable min-width="70px" align="center"/>
                <el-table-column label="姓名" property="name" min-width="80px" align="center"/>
                <el-table-column label="密码" property="password" min-width="100px" align="center" v-if="false"/>
                <el-table-column label="角色ID" property="roleId" min-width="50px" align="center" v-if="false"/>
                <el-table-column label="角色" property="role" sortable min-width="70px" align="center"/>
                <el-table-column label="创建人" property="creator" min-width="80px" align="center"/>
                <el-table-column label="创建时间" property="createdTime" sortable min-width="120px" align="center" />
                <el-table-column label="门店ID" property="storeId" min-width="50px" align="center" v-if="false"/>
                <el-table-column label="所属门店" property="store" sortable min-width="90px" align="center"/>
                <el-table-column label="最后登录时间" property="lastLoginTime" sortable min-width="120px" align="center"/>
                <el-table-column label="更新人员" property="updater" min-width="80px" align="center"/>
                <el-table-column label="更新时间" property="updatedTime" min-width="90px" sortable align="center"/>
                <el-table-column label="启用状态" property="enabled" min-width="90px" align="center">
                  <template #default="scope">
                    <el-switch
                        v-model="scope.row.enabled"
                        inline-prompt
                        active-text="已启用"
                        inactive-text="未启用"
                        width="60px"
                        @change="getNewenabled(scope.row.enabled,scope.row.id,scope.row.number,scope.row.name,scope.row.roleId)"
                    />
                  </template>
                </el-table-column>
                <el-table-column label="操作" property="Operation" min-width="140px" align="center">
                  <template #default="scope">
                    <el-button type="primary" size="small" @click="UpdataUser(scope.row)" ><el-icon><EditPen /></el-icon>编辑</el-button>
                    <el-button type="danger" size="small" @click="DeleteUser(scope.row.id,scope.row.number,scope.row.name)"><el-icon><Delete /></el-icon>删除</el-button>
                  </template>
                </el-table-column>
              </el-table>

              <el-pagination
                  @size-change="handleSizeChange"
                  @current-change="handleCurrentChange"
                  :current-page="queryInfo.page"
                  :page-sizes="[3, 5, 10, 15]"
                  :page-size="queryInfo.size"
                  layout="total, sizes, prev, pager, next, jumper"
                  :total="Usertotal">
              </el-pagination>

            </div>


            <!--        添加新的用户-->
            <el-dialog
                title="添加新用户"
                v-model="OpenNewUser"
                width="40%"
                draggable>
              <el-form :model="form" label-width="120px" style="margin-left: 60px">
                <el-form-item label="用户编号" >
                  <el-input v-model="form.number" style="width: 70%" placeholder="(注：编号不能和已存在的编号重复)"/>
                </el-form-item>
                <el-form-item label="用户名">
                  <el-input v-model="form.name" style="width: 70%"/>
                </el-form-item>
                <el-form-item label="密码">
                  <el-input  type="password" show-password v-model="form.password" style="width: 70%"/>
                </el-form-item>
                <el-form-item label="角色">
                  <el-select v-model="form.role" placeholder="请选择标签" @change="getNewRoleId">
                    <el-option
                        v-for="item in RoleList"
                        :key="item.id"
                        :label="item.RoleName"
                        :value="item.id"
                    />
                  </el-select>
                </el-form-item>
              </el-form>
              <div style="margin-top: 30px"><el-button @click="AddNewUser" type="primary">确定</el-button></div>
            </el-dialog>

<!--        更新新用户-->
            <el-dialog
                title="更新用户"
                v-model="OpenUpdataUser"
                destroy-on-close
                width="40%"
                draggable>
              <el-form :model="form" label-width="120px" style="margin-left: 60px">
                <el-form-item label="用户编号" >
                  <el-input v-model="form.number" style="width: 70%" placeholder="(注：编号不能和已存在的编号重复)"/>
                </el-form-item>
                <el-form-item label="用户名">
                  <el-input v-model="form.name" style="width: 70%"/>
                </el-form-item>
                <el-form-item label="密码">
                  <el-input disabled type="password" show-password v-model="form.password" style="width: 70%"/>
                </el-form-item>
                <el-form-item label="角色">
                  <el-select v-model="form.role" placeholder="请选择标签" @change="getNewRoleId">
                    <el-option
                        v-for="item in RoleList"
                        :key="item.id"
                        :label="item.RoleName"
                        :value="item.id"
                    />
                  </el-select>
                </el-form-item>
              </el-form>
              <div style="margin-top: 30px"><el-button @click="UpdataNewUser" type="primary">确定</el-button></div>
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
  ChromeFilled, Refresh,Bell, Help, Discount, Sort,ArrowDown,Van,HomeFilled,Search,Delete,EditPen
} from '@element-plus/icons-vue'
import axios from "axios";
import {ElLoading, ElMessage, ElMessageBox} from "element-plus";
import router from "@/router";
import {useRoute} from "vue-router/dist/vue-router";
let aname;
let aid;
export default {
  name: "CourseCategories",
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
    ChromeFilled, Refresh, Bell,Help, Discount, Sort, ArrowDown, Van,HomeFilled,Search,EditPen,Delete
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
      tabled: [],
      pList: new Map(),
      UserData:[{
        id:'',
        number:'',
        name:'',
        password:'',
        roleId:'',
        role:'',
        creator:'',
        createdTime:'',
        storeId:'',
        store:'',
        lastLoginTime:'',
        updater:'',
        updatedTime:'',
        enabled:false
      }],
      queryInfo: {
        page: 1,
        size: 10
      },
      Usertotal:0,
      StoreList:[],
      OpenNewUser:false,
      form:{
        number:'',
        name:'',
        password:'',
        role:'',
      },
      RoleList:[
      {
        id:1,
        RoleName:'超级管理员'
      },
      {
        id:2,
        RoleName: '店长'
      },
      {
        id:3,
        RoleName: '店员'
      }
      ],
      NewRoleId:'',
      OpenUpdataUser:false,
      UpdataUserid:'',
    }
  },
  mounted() {
    this.getAllPermission()
    this.getAllUser()
    this.getAllStore()
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
    ManageRole(){
      router.push({
        name:'ManageRole',
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
    async getAllStore(){
      axios({
        method:'get',
        url:'/admin/store/getStoreList',
      }).then(res=>{
        this.StoreList=res.data.data;
      })
    },
    async getAllUser(){
      axios({
        method:'get',
        url:'/admin/user/getAllEmployeeUserPageable',
        params:{
          page: this.queryInfo.page - 1,
          size: this.queryInfo.size,
        }
      }).then(res=>{
        console.log(res.data.data.content)
        this.Usertotal=res.data.data.totalElements;
        this.UserData=res.data.data.content;
        for (let i=0;i<res.data.data.content.length;i++){
          if(res.data.data.content[i].enabled===1){
            this.UserData[i].enabled=true;
          }else{
            this.UserData[i].enabled=false;
          }
          if(res.data.data.content[i].roleId===1){
            this.UserData[i].role="超级管理员"
          }else{
            if(res.data.data.content[i].roleId===2){
              this.UserData[i].role="店长"
            }else{
              if(res.data.data.content[i].roleId===3){
                this.UserData[i].role="店员"
              }
            }
          }

          axios({
            method:'get',
            url:'/admin/store/getStoreList',
          }).then(respone=>{
            for(let j=0;j<respone.data.data.length;j++){
              if(res.data.data.content[i].storeId===respone.data.data[j].id){
                this.UserData[i].store=respone.data.data[j].storeName;
                break;
              }
            }
          })

        }
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
    CreatNewUser(){
      this.OpenNewUser=!this.OpenNewUser;
    },
    getNewRoleId(Val){
      this.NewRoleId=Val;
    },
    AddNewUser(){
      let NewUserData=new FormData();
      NewUserData={
        number:this.form.number,
        name:this.form.name,
        password:this.form.password,
        roleId:this.NewRoleId
      }
      axios({
        method:'post',
        url:'/admin/user/createEmployeeAccount',
        data:NewUserData
      }).then(res=>{
        if(res.data.status===0){
          ElMessage("添加成功")
          router.go(0)
        }else{
          ElMessage(res.data.message)
        }
      })
    },
    getNewenabled(enabled,id,number,name,roleid){
      if(enabled===true){
        enabled=1
      }else{
        enabled=0;
      }
      let changeenabled=new FormData();
      changeenabled={
        id:id,
        enabled:enabled,
        number:number,
        name:name,
        roleId:roleid
      }
      axios({
        method:'post',
        url:'/admin/user/updateEmployeeAccount',
        data:changeenabled
      }).then(res=>{
        if(res.data.status===0){
          ElMessage("修改成功")
        }
      })
    },
    DeleteUser(id,number,name){
      let deleter=new FormData;
      deleter={
        id:id,
        number:number,
        name:name
      }
      axios({
        method:'post',
        url:'/admin/user/deleteEmployeeAccount',
        data:deleter
      }).then(res=>{
        if(res.data.status===0){
          ElMessage("删除成功")
          router.go(0)
        }else{
          ElMessage(res.data.message)
        }
      })
    },
    UpdataUser(Val){
      this.UpdataUserid=Val.id;
      this.form.number=Val.number;
      this.form.name=Val.name;
      this.form.role=Val.role;
      this.OpenUpdataUser=!this.OpenUpdataUser
    },
    UpdataNewUser(){
      let UpdataUser=new FormData();
      UpdataUser={
        id:this.UpdataUserid,
        number:this.form.number,
        name:this.form.name,
        roleId:this.NewRoleId
      }
      axios({
        method:'post',
        url:'/admin/user/updateEmployeeAccount',
        data:UpdataUser
      }).then(res=>{
        if(res.data.status===0){
          ElMessage("更新成功")
          router.go(0)
        }
        else{
          ElMessage(res.data.message)
        }
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