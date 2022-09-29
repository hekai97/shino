<template>
  <div>
    <el-container>
      <el-aside style="border: 1px solid white;background-color: #7ab8cc;color: white" width="isCollapse ? '30px' : '270px'" class="lef">
        <el-menu
            active-color="#ffd04b"
            background-color="#7ab8cc"
            class="el-menu-vertical"
            default-active="0-2-1"
            text-color="#fff"
            :collapse="isCollapse"
        >
          <el-menu-item index="0-0" disabled>
            <span style="color: white;font-size: 17px"><h3>员工操作平台</h3></span>
          </el-menu-item>
          <el-menu-item index="0-1" @click="home">
            <el-icon><IceCream /></el-icon>
            <span style="margin-left: 3px">店铺经营状况</span>
          </el-menu-item>

          <el-sub-menu index="0-2" >
            <template #title>
              <el-icon><Notebook /></el-icon>
              <span style="margin-left: 3px">排课</span>
            </template>
            <el-menu-item index="0-2-1" style="margin-left: 30px">预约</el-menu-item>
            <el-menu-item index="0-2-2" style="margin-left: 30px" @click="schedule">排课</el-menu-item>
          </el-sub-menu>

          <el-menu-item index="1-1" @click="sign">
            <el-icon><AlarmClock /></el-icon>
            <span style="margin-left: 3px">上课签到</span>
          </el-menu-item>

          <el-sub-menu index="1-2" >
            <template #title>
              <el-icon><Mouse /></el-icon>
              <span style="margin-left: 3px">信息录入</span>
            </template>
            <el-menu-item index="1-2-1" style="margin-left: 30px">查看课程</el-menu-item>
          </el-sub-menu>

          <el-menu-item index="1-3">
            <el-icon><User /></el-icon>
            <span style="margin-left: 3px">档案</span>
          </el-menu-item>

          <el-menu-item index="1-4">
            <el-icon><Tools /></el-icon>
            <span style="margin-left: 3px">设置</span>
          </el-menu-item>

          <el-menu-item index="1-5" >
            <el-icon><InfoFilled /></el-icon>
            <span style="margin-left: 3px">关于</span>
          </el-menu-item>

        </el-menu>
        <el-radio-group v-model="isCollapse" style="margin-left: 0px;width: 30px" size="mini" >

          <el-radio-button :label="true"><el-icon><DArrowLeft /></el-icon></el-radio-button>
          <el-radio-button :label="false"><el-icon><DArrowRight /></el-icon></el-radio-button>
        </el-radio-group>
      </el-aside>
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
              <div style="float:right; margin-left: 20px" >{{adminname}}</div>
            </div>
            <div style="background-color: #42b983;width: 100px;">
              <div style="border-top: 2px solid  #73767a;float: right;width: 60px;background-color: #f4f4f5">
              </div>
            </div>
          </div>
        </el-header>
        <el-main class="main">
          <el-timeline>
            <el-timeline-item timestamp="2022/9/13" placement="top">
              <div  v-for="item in courseReservationPageable.content" :key="item.id">
                <div v-if="item.arrangementDate==null  ">
              <el-card style="height: 220px;margin-top: 30px">
                <el-divider />
                <div style="width: 17%;margin-top: -1%;display: inline-block;float: left">
                  <p style="left: 50px;width: 100%;text-align: left">课程名称</p>
                  <div style="margin-top: 10px;width: 100%;text-align: left">{{item.courseName}}</div>
                </div>
                <div style="width: 17%;margin-top: -1%;display: inline-block;float: left;margin-left: 24%">
                  <p style="left: 0px;top: 60px;width: 100%;text-align: left">预约时间</p>
                  <div style="margin-top: 10px;width: 100%;text-align: left">{{item.date}}456</div>
                </div>
                <div style="width: 17%;margin-top: -1%;display: inline-block;float: left;margin-left: 24%">
                  <p style="left: 0px;top: 60px;width: 100%;text-align: left">预约地点</p>
                  <div style="margin-top:10px;width: 100%;text-align: left">{{item.storeName}}</div>
                </div>
                  <el-divider style="top: 60px"/>
                <div style="width: 17%;margin-top: 1%;display: inline-block;float: left">
                  <p style="top: 60px;left: 0px;width: 100%;text-align: left">联系人：</p>
                  <div style="margin-top: 10px;width: 100%;text-align: left">{{item.name}}  </div>
                </div>
                <div style="width: 17%;margin-top: 1%;display: inline-block;float: left;margin-left: 24%">
                  <p style="top: 60px;left: 0px;width: 100%;text-align: left">手机号：</p>
                  <div style="margin-top: 10px;width: 100%;text-align: left">{{item.phoneNumber}}147</div>
                </div>
                <div style="width: 17%;display: inline-block;margin-left: 15%;margin-top: 2.5%">
                  <el-popover
                    placement="top-start"
                    :width="20"
                    trigger="hover"
                    content="排课">
                    <template #reference>
                  <el-button @click="Arranging(item.name,item.courseName,item.storeId,item.storeName,item.date,item.courseId,item.id,item.orderId)"
                             style="">
                    <el-icon><Reading /></el-icon>
                  </el-button>
                    </template>
                  </el-popover>
                  <el-popconfirm title="是否要删除?">
                    <template #reference>
                  <el-button style="" @click="DeleteSchedule(item.id)">
                    <el-icon><DeleteFilled /></el-icon>
                  </el-button>
                    </template>
                  </el-popconfirm>
                </div>
              </el-card>
                </div>
              </div>
            </el-timeline-item>
          </el-timeline>

<!--        排课-->
          <el-dialog
          v-model="OpenArranging"
          title="排课"
          width="40%"
          draggable>
            <div>
              <el-form :model="form" ref="form" label-width="120px">
                <el-form-item label="学员姓名">
                  <el-input v-model="form.name" style="width: 70%" disabled/>
                </el-form-item>
                <el-form-item label="上课地点">
                  <el-input v-model="form.address" style="width: 70%" disabled />
                </el-form-item>
                <el-form-item label="预约课程">
                  <el-input v-model="form.class" style="width: 70%" disabled />
                </el-form-item>
                <el-form-item label="排课日期">
                  <el-col :span="11">
                    <el-date-picker
                      v-model="form.date1"
                      type="date"
                      style="width: 100%"
                      format="YYYY/MM/DD"
                      value-format="YYYY-MM-DD"
                      @change="getDate"
                    />
                  </el-col>
                </el-form-item>
                <el-form-item label="排课时间">
                  <el-radio-group v-model="form.time" @change="getNewTime">
                    <el-radio label="09:00-11:00" />
                    <el-radio label="13:30-15:30" />
                    <el-radio label="16:00-18:00" />
                    <el-radio label="19:30-21:30"/>
                  </el-radio-group>
                </el-form-item>
                <el-form-item label="预约讲师">
                  <el-select v-model="form.region"  placeholder="请选择" @change="getNewTeacher">
                    <el-option
                      v-for="item in TeacherData"
                      :key="item.id"
                      :label="item.name"
                      :value="item.id"

                    />
                  </el-select>
                </el-form-item>
                <el-form-item align="center">
                  <el-button type="primary" @click="SendSchedule">发送排课通知</el-button>
                </el-form-item>
              </el-form>
            </div>
          </el-dialog>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>
import {
  Menu as IconMenu,
  IceCream,
  Notebook,
  AlarmClock,
  Mouse,
  User,
  Tools,
  DArrowLeft,
  DArrowRight,
  InfoFilled,
  Fold,
  Refresh,
  Bell,
  Help,
  Discount,
  Sort,
  Delete,
  DeleteFilled,
  Reading
} from '@element-plus/icons'
import router from "@/router";
import axios from 'axios';
import {ElMessage} from "element-plus";
export default {
  // eslint-disable-next-line vue/multi-word-component-names
  name: 'mybook',
  components: {
    // eslint-disable-next-line vue/no-unused-components
    IconMenu,
    IceCream,
    Notebook,
    AlarmClock,
    Mouse,
    User,
    Tools,
    DArrowLeft,
    DArrowRight,
    InfoFilled,
    Fold,
    Refresh,
    Bell,
    Help,
    Discount,
    Sort,
    Delete,
    DeleteFilled,
    Reading,

  },
  data () {
    return {
      isCollapse: false,
      OpenArranging:false,
      form:{
        name:'',//学员姓名
        region:'',//预约讲师
        address:'',//上课地点
        class:'',//预约课程
        date1:'',//排课日期
        resource:'',//预约方式
        time:'',//排课时间
        // TeacherData:[],
      },
      TeacherData:[],
      //传入的实体类型
      pageable: {
        page: 0,
        size: 10000,
      },
      //分页排课表实体
      courseReservationPageable: {
        //总共有多少条数据
        totalElements: 0,
        //总共有多少页
        totalPages: 0,
        //传入的size
        size: 0,
        content: [
          {
            id: 0,
            courseId: 0,
            courseName: "string",
            storeId: 0,
            storeName: "string",
            //这是用户预约的日期
            date: "string",
            //这是用户预约的时间段
            beginTime: "string",
            endTime: "string",
            //这是员工端将要给他排的日期
            arrangementDate: "2022-09-22T03:24:25.076Z",
            //这是员工端将要给他排的时间段
            orderBeginTime: "2022-09-22T03:24:25.076Z",
            orderEndTime: "2022-09-22T03:24:25.076Z",

            orderId: 0,
            operateTime: "string",
            display: 0,
            startTime: "2022-09-22T03:24:25.076Z",
            //状态，0是未排课，1是已上课
            state: 0,

            //新增的属性,代表是哪个用户预约的，这些是用户信息
            username:"",
            name:"",
            phoneNumber:"",
            email:"",
          },
        ],
        number: 0,
        //sort属性暂时没用
        sort: {
          empty: true,
          sorted: true,
          unsorted: true,
        },
        pageable: {
          offset: 0,
          sort: {
            empty: true,
            sorted: true,
            unsorted: true,
          },
          pageNumber: 0,
          pageSize: 0,
          unpaged: true,
          paged: true,
        },
        first: true,
        last: true,
        //这个数据代表当前这一页有多少条数据
        numberOfElements: 0,

        empty: true,
        StoreId:'',
        courseId:'',
        NewDate:'',

        tableid:'',
        userid:'',
        teacherid:'',
        NewTime:'',
      },
    }
  },
  mounted() {
    //填完之后把这个解开
    this.getAllCourseReservation();

  },
  methods: {
    home() {
      router.push({
        name: "home"
      })
    },
    schedule() {
      router.push({
        name: "schedule"
      })
    },
    sign(){
      router.push({
        name:"sign"
      })
    },
    Arranging(name,courseName,storeid,storeName,date,courseId,id,orderId){
      this.StoreId=storeid;
      this.courseId=courseId;
      this.form.name=name;
      this.form.class=courseName;
      this.form.address=storeName;
      this.tableid=id;
      axios({
        method:'get',
        url:'/employee/reservation/getUserInformationByOrderId',
        params:{
          orderId:orderId
        }
      }).then(res=>{
        if(res.data.status===0){
          this.userid=res.data.data.id;
          // console.log("用户"+this.userid)
        }
      })
      this.OpenArranging=!this.OpenArranging
    },

    //获取所有的预约信息
    getAllCourseReservation() {
      axios({
        method: 'get',
        url: '/employee/reservation/getCourseReservationNoStartPageable',
        params: {
          size: this.pageable.size,
          page: this.pageable.page,
        },
      }).then((response) => {
        if(response.data.status==0){
          this.courseReservationPageable = response.data.data
          for(let i=0;i<this.courseReservationPageable.content.length;++i){
            this.getUserInformationByOrderId(i,this.courseReservationPageable.content[i].orderId);
          }
        }else{
          this.$message.error(response.data.message)
        }
      })
    },
    getUserInformationByOrderId(index,orderId) {
      axios({
        method: 'get',
        url: '/employee/reservation/getUserInformationByOrderId',
        params: {
          orderId: orderId,
        },
      }).then(res=>{
        if(res.data.status==0){
          this.courseReservationPageable.content[index].username=res.data.data.username
          this.courseReservationPageable.content[index].name=res.data.data.name
          this.courseReservationPageable.content[index].phoneNumber=res.data.data.phoneNumber
          this.courseReservationPageable.content[index].email=res.data.data.email
        }else{
          this.$message.error(res.data.message)
        }
      })
    },
    getDate(Val){
      this.NewDate=Val;
      console.log(this.NewDate)
    },
    getNewTime(Val){
      // let date=this.form.date1.slice(0,10);
      let date=this.form.date1;
      // console.log(this.StoreId)
      // console.log(date)
      // console.log(Val)
      let timeId;
      this.NewTime=Val;
      if(Val==="09:00-11:00"){
          timeId=1;
      }else{
        if(Val==="13:30-15:30"){
          timeId=2;
        }else{
          if(Val==="16:00-18:00"){
            timeId=3
          }else{
            if(Val==="19:30-21:30"){
              timeId=4;
            }
          }
        }
      }
      axios({
        method:'get',
        url:'/employee/Scheduling/getFreeTeacherByTime',
        params:{
          date:date,
          timeId:timeId,
          courseId:this.courseId
        }
      }).then(res=>{
        console.log(res.data.data)
        this.TeacherData=res.data.data;
      })
    },
    getNewTeacher(Val){
      this.teacherid=Val;
      console.log(Val)
    },
    SendSchedule(){
        // let ScheduleData=new FormData();
      console.log(this.NewDate)
      console.log(this.NewTime)
      let beginTime,endTime;
      if(this.NewTime==="09:00-11:00"){
          beginTime="09:00:00"
        endTime="11:00:00"
      }else{
        if(this.NewTime==="13:30-15:30"){
          beginTime="13:30:00";
          endTime="15:30:00";
        }else{
          if(this.NewTime==="16:00-18:00"){
            beginTime="16:00:00";
            endTime="18:00:00"
          }else{
            if(this.NewTime==="19:30-21:30"){
              beginTime="19:30:00";
              endTime="21:30:30;"
            }
          }
        }
      }


        // let ScheduleData={
        //   courseReservationId:this.tableid,
        // }
        let myCourseTable= {
          storeId: this.StoreId,
          courseId: this.courseId,
          teacherId: this.teacherid,
          userId: this.userid,
          courseReservationId:this.tableid,
          date:this.NewDate,
          beginTime:beginTime,
          endTime:endTime
        }
        // console.log(ScheduleData)
      console.log(myCourseTable)
        axios({
          method:'post',
          url:'/employee/Scheduling/createScheduling',
          data:myCourseTable
        }).then(res=>{
          if(res.data.status===0){
            ElMessage("成功预约课程")
            router.go(0)
          }
        })
    },
    DeleteSchedule(id){
     console.log(id)
    },
  }
}
</script>

<style scoped>
.lef{
  height: 800px;
}
.el-menu-vertical {
  border-top: 1px solid white;
}
::-webkit-scrollbar {
  width: 0;
  height: 0;
}
.dialog-footer button:first-child {
  margin-right: 10px;
}
</style>
