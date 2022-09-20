<template>
  <div style="margin-top: -60px">
    <el-container style="border: 1px solid red;height: 1050px">
      <el-menu
          active-color="#ffd04b"
          background-color="#545c64"
          class="el-menu-vertical"
          default-active="1-2-1"
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
          <el-menu-item index="1-2-1" style="margin-left: 15px">课程分类</el-menu-item>
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
                  <HomeFilled />
                </el-icon>
              </div>
            </div>
          </div>
        </el-header>
        <el-main style="background-color: #F0F2F5;">
          <div style="margin-top: 10px;background-color: white;height: 650px">
            <div style="height: 50px;">
              <div style="width: 100px;float: left;margin-left: 20px;margin-top: 20px;">课程分类</div>
              <div style="display: inline-block;float:left;margin-top: 14px;margin-left: 200px">
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
              <div style="float:left;width: 100px;margin-top: 18px;margin-left: 0px">内容搜索</div>
              <div style="margin-top: 14px;float: left"><el-input v-model="input"  placeholder="输入店铺名称进行搜索" style="width: 200px;" /></div>
              <div style="margin-top: 14px;float:left;margin-left: 10px"><el-button  style="width: 60px;float: left;background-color: #79bbff;">
                <el-icon>
                  <Search/>
                </el-icon>
              </el-button></div>
            </div>
            <div style="margin-left: 30px;height: 35px;margin-top: 20px">
              <el-button type="primary" style="float: left;" @click="CreatNewCourseCate" >创建新分类</el-button>
            </div>
            <div style="margin-top: 20px;">
              <el-table
                  ref="multipleTableRef"
                  style="width: 100%"
                  border
                  :data="CourseCateData"
              >
                <el-table-column type="selection" width="55" align="center" ></el-table-column>
                <el-table-column label="编号" property="CourseCateid" sortable min-width="70px" align="center"/>
                <el-table-column label="课程分类名称" property="CourseCateName" min-width="100px" align="center"/>
                <el-table-column label="课程数量" property="CourseInCate" sortable min-width="70px" align="center"/>
                <el-table-column label="创建人ID" property="CourseCreaterid" min-width="70px" align="center" v-if="false" />
                <el-table-column label="创建人" property="CourseCreater" min-width="100px" align="center"/>
                <el-table-column label="创建时间" property="CourseCreatTime" sortable min-width="120px" align="center" />
                <el-table-column label="发布状态" property="isPublished" min-width="100px" align="center">
                  <template #default="scope">
                  <el-switch
                      v-model="scope.row.isPublished"
                      inline-prompt
                      active-text="已发布"
                      inactive-text="未发布"
                      width="60px"
                      @change="ChangeRowState(scope.row.isPublished,scope.row.CourseCateid,scope.row.CourseCateName,scope.row.CourseCreaterid,scope.row.CourseCreatTime)"
                  />
                  </template>
                </el-table-column>
                <el-table-column label="操作" property="Operation" min-width="120px" align="center">
                  <template #default="scope">
                  <el-button type="primary" @click="UpdataCorseCate(scope.row.isPublished,scope.row.CourseCateid,scope.row.CourseCateName,scope.row.CourseCreaterid,scope.row.CourseCreatTime,scope.row.CourseCreater,scope.row.CourseInCate)"><el-icon><EditPen /></el-icon>编辑</el-button>
                  <el-button type="danger" @click="DeleteCrouseCate(scope.row.CourseCateid,scope.row.CourseCateName)"><el-icon><Delete /></el-icon>删除</el-button>
                  </template>
                </el-table-column>
              </el-table>
            </div>
<!--        添加新的课程分类-->
            <el-dialog
                title="添加新课程分类"
              v-model="OpenNewCouseCate"
              draggable
              style="background-color:#F0F2F5">
              <div>
                <div>
                  <div style="display: inline-block;">分类名称：</div>
                  <div style="display: inline-block;margin-left: 15px;width: 30%">
                    <el-input  placeholder="输入分类名称" v-model="NewCourseCateName"></el-input>
                  </div>
                </div>
                <div style="margin-top: 20px;width: 78%">
                  <div style="display: inline-block;">发布状态：</div>
                  <div style="display: inline-block;margin-left: 15px;width: 10%;">
                    <el-switch
                        v-model="NewCourseCateState"
                        inline-prompt
                        active-text="已发布"
                        inactive-text="未发布"
                        width="60px"
                        @change="getNewCourseCateState(this.NewCourseCateState)"
                    />
                  </div>
                </div>
                <div style="margin-top: 20px">
                  <el-button type="primary" @click="CreateNewCrouseCate">确定</el-button>
                </div>
              </div>
            </el-dialog>
<!--        更新课程分类信息-->
            <el-dialog
                title=this.UpdataCourseCateName
                v-model="OpenUpdataCourseCate"
                draggable
                style="background-color:#F0F2F5">
              <template #title>
                <div>{{this.UpdataTitle}}</div>
              </template>
              <div>
                <div style="width: 90%;">
                  <div style="display: inline-block;">课程编号：</div>
                  <div style="display: inline-block;margin-left: 13px">
                    <el-input v-model="UpdataCourseCateid" disabled></el-input>
                  </div>
                </div>
                <div  style="width: 90%;margin-top: 10px;">
                  <div style="display: inline-block;">分类名称：</div>
                  <div style="display: inline-block;margin-left: 13px">
                    <el-input v-model="UpdataCourseCateName"/>
                  </div>
                </div>
                <div style="width: 90%;margin-top: 10px;">
                  <div style="display: inline-block;">课程数量：</div>
                  <div style="display: inline-block;margin-left:13px;">
                    <el-input v-model="UpdataCourseInCate" disabled></el-input>
                  </div>
                </div>

                <div style="margin-top: 10px;width: 93%;">
                  <div style="display: inline-block;">创建人:</div>
                  <div style="display: inline-block;margin-left: 13px;">
                    <el-input v-model="UpdataCourseCateCreater" disabled></el-input>
                  </div>
                </div>

                <div style="margin-top: 10px;width: 100%;">
                  <div style="display: inline-block;">创建时间：</div>
                  <div style="display: inline-block;margin-left: 13px;width:37.5%;">
                    <el-input v-model="UpdataCourseCateTime"  disabled></el-input>
                  </div>
                </div>

                <div style="margin-top: 20px">
                  <el-button type="primary" @click="UpdataCourseDetail">确定</el-button>
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
      CourseCateData:[{
        CourseCateid:'',
        CourseCateName:'',
        CourseInCate:'',
        CourseCreaterid:'',
        CourseCreater:'',
        CourseCreatTime:'',
        isPublished:false,
      }],
      SumCourse:'',
      OpenNewCouseCate:false,
      NewCourseCateName:'',
      NewCourseCateState:false,
      OpenUpdataCourseCate:false,
      UpdataCourseCateid:'',
      UpdataCourseCateName:'',
      UpdataCourseCateCreater:'',
      UpdataCourseCateCreaterid:'',
      UpdataCourseCateTime:'',
      UpdataCourseInCate:'',
      UpdataTitle:'',
      UpdataCourseCateState:'',
    }
  },
  mounted() {
    this.getAllPermission()
    this.getAllCourseCate()
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
    async getAllCourseCate(){
      await axios({
        method:'get',
        url:'/admin/course/getCourseCategoryList',
      }).then(res=>{
        for(let i=0;i<res.data.data.length;i++){
          let obj=new Object();
          obj.CourseCateid=res.data.data[i].id;
          obj.CourseCateName=res.data.data[i].categoryName;
          obj.CourseCreatTime=res.data.data[i].createTime;
          obj.CourseCreaterid=res.data.data[i].createdId;
          if(res.data.data[i].isPublished===1){
            obj.isPublished=true
          }
          else{
            obj.isPublished=false
          }
          axios({
            method:'get',
            url:'/admin/user/getEmployeeUserByEmployeeId',
            params:{
              employeeId:res.data.data[i].createdId
            }
          }).then(respone=>{
              this.CourseCateData[i].CourseCreater=respone.data.data.name
          })
          axios({
            method:'get',
            url:'/admin/course/getCoursesPageableByCategoryId',
            params:{
              page:0,
              size:50,
              categoryId:res.data.data[i].id
            }
          }).then(respone=>{
            this.CourseCateData[i].CourseInCate=respone.data.data.totalElements
          })
          this.CourseCateData[i]=obj
        }
      })
    },
    CreatNewCourseCate(){
      this.OpenNewCouseCate=!this.OpenNewCouseCate
    },
    getNewCourseCateState(val){
      console.log(val)
    },
    ChangeRowState(state,CourseCateid,CourseCateName,CourseCreaterid,CourseCreatTime){
      let UpdataState;
      if(state===true){
        UpdataState=1;
      }
      else{
        UpdataState=0;
      }
      let UpdataCourse={
        id: CourseCateid,
        categoryName:CourseCateName,
        isPublished: UpdataState,
        createdId: CourseCreaterid,
        createTime: CourseCreatTime
      }
      // console.log(UpdataCourse)
      axios({
        method:'post',
        url:'/admin/course/updateCourseCategory',
        data:UpdataCourse
      }).then(res=>{
        console.log(res.data.message)
      })
    },
    CreateNewCrouseCate(){
      let CreatData=new FormData;
      let isPublic;
      if(this.NewCourseCateState===true){
        isPublic=1;
      }else {
        isPublic=0;
      }
      CreatData={
        categoryName:this.NewCourseCateName,
        isPublished:isPublic
      }
      axios({
        method:'post',
        url:'/admin/course/addCourseCategory',
        data:CreatData
      }).then(res=>{
        if(res.data.status===0){
          ElMessage("添加课程分类成功");
          router.go(0)
        }else{
          ElMessage(res.data.message);
        }
      })
    },
    DeleteCrouseCate(CourseCateid,CourseCateName){
      ElMessageBox.confirm(
          '是否确定删除'+CourseCateName+'课程分类',
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
              url:'/admin/course/deleteCourseCategory',
              params:{
                categoryId:CourseCateid
              }
            }).then(res=>{
              if(res.data.status===0){
                ElMessage("删除成功");
                router.go(0)
              }else {
                ElMessage(res.data.message);
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
    UpdataCorseCate(isPublished,CourseCateid,CourseCateName,CourseCreaterid,CourseCreatTime,CourseCreater,CourseInCate){
      this.UpdataCourseCateid=CourseCateid;
      this.UpdataCourseCateName=CourseCateName;
      this.UpdataCourseCateCreater=CourseCreater;
      this.UpdataCourseCateTime=CourseCreatTime;
      this.UpdataCourseCateCreaterid=CourseCreaterid;
      this.UpdataCourseInCate=CourseInCate;
      this.UpdataTitle=CourseCateName;
      if(isPublished===true){
        this.UpdataCourseCateState=1;
      }else{
        this.UpdataCourseCateState=0;
      }
      this.OpenUpdataCourseCate=!this.OpenUpdataCourseCate;
    },
    UpdataCourseDetail(){
      let UpdataCourse={
        id: this.UpdataCourseCateid,
        categoryName:this.UpdataCourseCateName,
        isPublished:this.UpdataCourseCateState,
        createdId: this.UpdataCourseCateCreaterid,
        createTime: this.UpdataCourseCateTime
      }
      axios({
        method:'post',
        url:'/admin/course/updateCourseCategory',
        data:UpdataCourse
      }).then(res=>{
       if(res.data.status===0){
         ElMessage("课程属性更新成功");
         router.go(0)
       }else{
         ElMessage(res.data.message)
       }
      })
    },
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