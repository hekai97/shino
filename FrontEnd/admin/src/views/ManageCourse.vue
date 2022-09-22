<template>
  <div style="margin-top: -60px">
  <el-container style="border: 1px solid red;height: 1050px">
    <el-menu
        active-color="#ffd04b"
        background-color="#545c64"
        class="el-menu-vertical"
        default-active="1-2-2"
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
        <el-menu-item index="1-2-2" style="margin-left: 15px">管理课程</el-menu-item>
        <el-menu-item index="1-2-3" style="margin-left: 15px" @click="ConfigureCourses">配置课程</el-menu-item>
      </el-sub-menu>
      <el-menu-item index="1-3" v-if="pList.get(104)===true" @click="Teacher">
        <el-icon>
          <User/>
        </el-icon>
        <span style="margin-left: 3px">讲师管理</span>
      </el-menu-item>
      <el-menu-item index="1-4" v-if="pList.get(105)===true"  @click="ManageStudent">
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
          <div style="height: 50px;">
            <div style="width: 100px;float: left;margin-left: 20px;margin-top: 20px;">课程管理</div>
            <div style="display: inline-block;float:left;margin-top: 14px;margin-left: 20px">
              <span>时间筛选</span>
              <el-date-picker
                  v-model="value4"
                  type="dates"
                  placeholder="开始时间"
                  style="margin-left: 10px;width: 130px"
              />
              <el-date-picker
                  v-model="value5"
                  type="dates"
                  placeholder="结束时间"
                  style="margin-left: 5px;width: 130px"
              />
            </div>
            <div style="float:left;width: 100px;margin-top: 18px;margin-left: 0px">选择店铺</div>
            <div style="margin-top: 14px;float: left">
              <el-select v-model="value1" placeholder="请选择店铺" style="width: 150px">
                <el-option
                    v-for="item in dpList"
                    :key="item.id"
                    :label="item.label"
                    :value="item.storeName"
                />
              </el-select>
            </div>
            <div style="float:left;width: 100px;margin-top: 18px;margin-left: 0px">选择分类</div>
            <div style="margin-top: 14px;float: left">
              <el-select v-model="value1" placeholder="请选择分类" style="width: 150px">
                <el-option
                    v-for="item in CourseCate"
                    :key="item.id"
                    :label="item.label"
                    :value="item.categoryName"
                />
              </el-select>
            </div>
            <div style="float:left;width: 100px;margin-top: 18px;margin-left: 0px">选择等级</div>
            <div style="margin-top: 14px;float: left">
              <el-select v-model="value1" placeholder="请选择等级" style="width: 150px">
              <el-option
                  v-for="item in Grade"
                  :key="item.id"
                  :label="item.grade"
                  :value="item.grade"
              />
              </el-select>
            </div>
            <div style="float:left;width: 100px;margin-top: 18px;margin-left: 121px">内容搜索</div>
            <div style="margin-top: 14px;float: left"><el-input v-model="input"  placeholder="输入店铺名称进行搜索" style="width: 200px;" /></div>
            <div style="margin-top: 14px;float:left;margin-left: 10px"><el-button  style="width: 60px;float: left;background-color: #79bbff;">
              <el-icon>
                <Search/>
              </el-icon>
            </el-button></div>
          </div>
          <div style="margin-left: 30px;height: 35px;margin-top: 70px;">
            <el-button type="primary" style="float: left;" @click="CreatNewCourse" >创建新课程</el-button>
          </div>

          <div style="margin-top: 20px;">
            <el-table
                ref="multipleTableRef"
                style="width: 100%"
                border
                :data="CourseData"
            >
              <el-table-column type="selection" width="55" align="center" ></el-table-column>
              <el-table-column label="id" property="Courseid" sortable min-width="70px" align="center" v-if="false"/>
              <el-table-column label="课程编号" property="CourseNumber" sortable min-width="80px" align="center"/>
              <el-table-column label="课程名称" property="CourseName" min-width="80px" align="center"/>
              <el-table-column label="课程分类编号" property="CourseCateId" min-width="55px" align="center" v-if="false"/>
              <el-table-column label="课程分类" property="CourseCate" min-width="80px" align="center"/>
              <el-table-column label="等级" property="CourseGrade" min-width="80px" align="center"/>
              <el-table-column label="创建人" property="CourseCreater" min-width="80px" align="center"/>
              <el-table-column label="课程简介" property="CourseIntroduce" min-width="100px" align="center" v-if="false"/>
              <el-table-column label="详情图片" property="CoursePic" min-width="100px" align="center">
                <template #default="scope">
                  <div class="demo-image__preview">
                    <el-image
                        style="width: 60px;
                          height: 40px"
                        :src="scope.row.CoursePic"
                        :preview-src-list="srcList"
                        :preview-teleported="true"
                        fit="cover"
                        :initial-index="scope.row.Courseid"/>
                  </div>
                </template>
              </el-table-column>
              <el-table-column label="发布状态" property="CourseState" min-width="100px" align="center">
                <template #default="scope">
                  <el-switch
                      v-model="scope.row.CourseState"
                      inline-prompt
                      active-text="已发布"
                      inactive-text="未发布"
                      width="60px"
                      @change="ChangeCourseState(scope.row.CourseState,scope.row.Courseid,scope.row.CourseNumber,scope.row.CourseName,scope.row.CourseCateId)"
                  />
                </template>
              </el-table-column>
              <el-table-column label="操作" property="Operation" min-width="120px" align="center">
                <template #default="scope">
                  <el-button type="primary" @click="UpdataCourse(scope.row.Courseid,
                                                                 scope.row.CourseNumber,
                                                                 scope.row.CourseName,
                                                                 scope.row.CourseCateId,
                                                                 scope.row.CourseCate,
                                                                 scope.row.CourseGrade,
                                                                 scope.row.CourseIntroduce,
                                                                 )"><el-icon><EditPen /></el-icon>编辑</el-button>
                  <el-button type="danger" @click="DeleteCourse(scope.row.CourseNumber,scope.row.CourseName)"><el-icon><Delete /></el-icon>删除</el-button>
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
              :total="Coursetotal"
              style="margin-top: 30px">
          </el-pagination>

<!--      添加新课程-->
          <el-dialog v-model="OpenAddNewCourse" title="添加新课程" draggable>
            <div>
              <div>
                <div style="width: 51%">
                  <div style="display: inline-block;">选择分类：</div>
                  <div style="display: inline-block;margin-left: 3.5%">
                    <el-select v-model="AddNewCourseCate" placeholder="请选择分类"  @change="getNewCourseCate">
                      <el-option
                          v-for="item in CourseCate"
                          :key="item.id"
                          :label="item.categoryName"
                          :value="item.id"
                      />
                    </el-select>
                  </div>
                </div>
              </div>

              <div style="width: 89%;margin-top: 10px">
                <div style="display: inline-block;">课程编号：</div>
                <div style="display: inline-block;margin-left: 13px">
                  <el-input v-model="CreateCourseNumber" placeholder="设置课程编号"></el-input>
                </div>
                <div style="display: inline-block;margin-left: 5px;font-weight: lighter;color: red">（注：课程编号不能和已存在的课程编号重复）</div>
              </div>

              <div style="width: 75.2%;margin-top: 10px">
                <div style="display: inline-block">课程价格：</div>
                <div style="display: inline-block"><el-input v-model="CreateCoursePrice" placeholder="请输入课程价格" style="width:150px;margin-left: 8.5%"></el-input></div>
                <div style="margin-left: 7%;display: inline-block">课程点数：</div>
                <div style="display: inline-block"><el-input v-model="CreateCoursePoints" placeholder="请输入课程点数" style="width:150px;margin-left: 5%" /></div>
              </div>

              <div  style="width: 60%;margin-top: 10px">
                <div style="display: inline-block;">课程名称：</div>
                <div style="display: inline-block;">
                  <el-input v-model="CreateNewCourseName" placeholder="请输入课程名称" style="width:300px;margin-left: 5%"/>
                </div>
              </div>

              <div style="margin-top: 10px">
                <div style="height: 148px;margin-left:35px;line-height: 150px;float: left;">课程照片:</div>
                <div style="display: inline-block;width: 80%">
                  <el-upload action="http://124.221.159.221:8080/admin/course/uploadCourseImage" style="float:left"
                             list-type="picture-card"
                             :auto-upload="true" limit="1"
                             :on-success="handleAvatarSuccess" name="image">
                    <el-icon><Plus /></el-icon>
                    <template #file="{ file }">
                      <div>
                        <img class="el-upload-list__item-thumbnail" :src="file.url" alt="" />
                        <span class="el-upload-list__item-actions">
                              <span
                                  class="el-upload-list__item-preview"
                                  @click="handlePictureCardPreview(file)"
                              >
                                <el-icon><zoom-in /></el-icon>
                              </span>
                            </span>
                      </div>
                    </template>

                  </el-upload>
                  <el-dialog v-model="enlargePic">
                    <img :src="dialogImageUrl" alt="Preview Image" style="width: 50%;"/>
                  </el-dialog>
                </div>
              </div>

              <div style="margin-top: 20px;width: 55%;">
                <div style="display: inline-block;">课程等级：</div>
                <div style="display: inline-block;width: 65%">
                  <el-radio-group v-model="ChooseGrade" style="margin-left: 5%;">
                    <el-radio :label="1">初级</el-radio>
                    <el-radio :label="2">中级</el-radio>
                    <el-radio :label="3">高级</el-radio>
                  </el-radio-group>
                </div>
              </div>

              <div style="margin-top: 20px;width: 30%;">
                <div style="display: inline-block;">发布状态：</div>
                <div style="display: inline-block;margin-left: 15px;width: 30%;">
                  <el-switch
                      v-model="NewCourseState"
                      inline-prompt
                      active-text="已发布"
                      inactive-text="未发布"
                      width="60px"
                      @change="getNewCourseState(this.NewCourseState)"
                  />
                </div>
              </div>

              <div style="margin-top: 10px">
                <div style="display: inline-block;float: left;margin-left: 35px;margin-top: 15px">课程内容：</div>
                <div style="display: inline-block;width: 81%;margin-left: 0%">
                  <el-input
                      v-model="CourseIntroduction"
                      :rows="2"
                      type="textarea"
                      placeholder="请输入课程内容"
                  />
                </div>
              </div>

              <div style="margin-top: 20px">
                <el-button type="primary" @click="AddCourse">确定</el-button>
              </div>

            </div>
          </el-dialog>

<!--      更新课程信息-->
          <el-dialog v-model="OpenUpdataCourse" title="添加新课程" draggable>
            <div>
              <div>
                <div style="width: 51%">
                  <div style="display: inline-block;">选择分类：</div>
                  <div style="display: inline-block;margin-left: 3.5%">
                    <el-select v-model="UpdataCourseCate" placeholder="请选择分类"  @change="getNewCourseCate">
                      <el-option
                          v-for="item in CourseCate"
                          :key="item.id"
                          :label="item.categoryName"
                          :value="item.id"
                      />
                    </el-select>
                  </div>
                </div>
              </div>

              <div style="width: 89%;margin-top: 10px">
                <div style="display: inline-block;">课程编号：</div>
                <div style="display: inline-block;margin-left: 13px">
                  <el-input v-model="UpdataCourseNumber" placeholder="设置课程编号"></el-input>
                </div>
                <div style="display: inline-block;margin-left: 5px;font-weight: lighter;color: red">（注：课程编号不能和已存在的课程编号重复）</div>
              </div>

              <div  style="width: 60%;margin-top: 10px">
                <div style="display: inline-block;">课程名称：</div>
                <div style="display: inline-block;">
                  <el-input v-model="UpdataCourseName" placeholder="请输入课程名称" style="width:300px;margin-left: 5%"/>
                </div>
              </div>

              <div style="margin-top: 10px">
                <div style="height: 148px;margin-left:35px;line-height: 150px;float: left;">课程照片:</div>
                <div style="display: inline-block;width: 80%">
                  <el-upload action="http://124.221.159.221:8080/admin/course/uploadCourseImage" style="float:left"
                             list-type="picture-card"
                             :auto-upload="true" limit="1"
                             :on-success="handleAvatarSuccess" name="image">
                    <el-icon><Plus /></el-icon>
                    <template #file="{ file }">
                      <div>
                        <img class="el-upload-list__item-thumbnail" :src="file.url" alt="" />
                        <span class="el-upload-list__item-actions">
                              <span
                                  class="el-upload-list__item-preview"
                                  @click="handlePictureCardPreview(file)"
                              >
                                <el-icon><zoom-in /></el-icon>
                              </span>
                            </span>
                      </div>
                    </template>

                  </el-upload>
                  <el-dialog v-model="enlargePic">
                    <img :src="dialogImageUrl" alt="Preview Image" style="width: 50%;"/>
                  </el-dialog>
                </div>
              </div>

              <div style="margin-top: 20px;width: 55%;">
                <div style="display: inline-block;">课程等级：</div>
                <div style="display: inline-block;width: 65%">
                  <el-radio-group v-model="UpdataGrade" style="margin-left: 5%;" @change="ChangeUpdataGrade">
                    <el-radio :label="1">初级</el-radio>
                    <el-radio :label="2">中级</el-radio>
                    <el-radio :label="3">高级</el-radio>
                  </el-radio-group>
                </div>
              </div>

              <div style="margin-top: 10px">
                <div style="display: inline-block;float: left;margin-left: 35px;margin-top: 15px">课程内容：</div>
                <div style="display: inline-block;width: 81%;margin-left: 0%">
                  <el-input
                      v-model="UpdataIntroduction"
                      :rows="2"
                      type="textarea"
                      placeholder="请输入课程内容"
                  />
                </div>
              </div>

              <div style="margin-top: 20px">
                <el-button type="primary" @click="UpdataCourseSure">确定</el-button>
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
  ChromeFilled, Refresh,Bell, Help, Discount, Sort,ArrowDown,Van,Search,Folder,EditPen,Delete,Plus,ZoomIn
} from '@element-plus/icons-vue'
import axios from "axios";
import {ElLoading, ElMessage, ElMessageBox} from "element-plus";
import router from "@/router";
import {useRoute} from "vue-router/dist/vue-router";
let aname;
let aid;
export default {
  name: "ManageCourse",
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
    ChromeFilled, Refresh, Bell,Help, Discount, Sort, ArrowDown, Van,Search,Folder,EditPen,Delete,Plus,ZoomIn
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
      CourseCate:[],
      tabled: [],
      pList: new Map(),
      Grade:[
        {
          id:1,
          grade:'初级'
        },
        {
          id:2,
          grade:'中级'
        },
        {
          id:3,
          grade:'高级'
        },
      ],
      queryInfo: {
        page: 1,
        size: 10
      },
      Coursetotal:0,
      CourseData:[{
        Courseid:'',
        CourseNumber:'',
        CourseName:'',
        CourseCateId:'',
        CourseCate:'',
        CourseGrade:'',
        CourseCreater:'',
        CoursePic:'',
        CourseState:false,
        CourseIntroduce:'',
      }],
      BaseUrl:axios.defaults.baseURL,
      srcList:[],
      OpenAddNewCourse:false,
      ChooseGrade:1,
      AddNewCourseCate:'',
      CreateCourseCateid:'',
      CreateNewCourseName:'',
      dialogImageUrl:'',
      enlargePic:false,
      CourseIntroduction:'',
      CreateCoursePictureUrl:'',
      CreateCourseNumber:'',
      CreateCoursePrice:'',
      CreateCoursePoints:'',
      NewCourseState:false,
      OpenUpdataCourse:false,
      UpdataCourseid:'',
      UpdataCourseCate:'',
      UpdataCourseNumber:'',
      UpdataCourseName:'',
      UpdataGrade:'',
      UpdataIntroduction:'',
      UpdataNewGrade:'',
    }
  },
  mounted(){
    this.getAllPermission()
    this.getStoreList()
    this.getCouseCateList()
    this.getCourseList()
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
    Teacher(){
      router.push({
        name:'Teacher',
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
    ManageRole(){
      router.push({
        name:'ManageRole',
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
    async getStoreList() {
      await axios({
        url: "/admin/store/getStoreList",
        method: "get",
      }).then((res) => {
        this.dpList = res.data.data;
      })
    },
    async getCouseCateList() {
      await axios({
        method: 'get',
        url: '/admin/course/getCourseCategoryList'
      }).then(res => {
        this.CourseCate = res.data.data;
      })
    },
    async getCourseList() {
      axios({
        method: 'get',
        url: '/admin/course/getAllCoursePageable',
        params: {
          page: this.queryInfo.page - 1,
          size: this.queryInfo.size,
        }
      }).then(res => {
        this.Coursetotal = res.data.data.totalElements;
        console.log(res.data.data.content)
        for (let i = 0; res.data.data.content.length; i++) {
          let obj = new Object();
          obj.Courseid = res.data.data.content[i].id;
          obj.CourseNumber = res.data.data.content[i].courseNumber;
          obj.CourseName = res.data.data.content[i].courseName;
          obj.CourseCateId = res.data.data.content[i].courseCategoryId;
          obj.CourseCate = res.data.data.content[i].courseCategoryName;
          if (res.data.data.content[i].courseLevel === "1") {
            obj.CourseGrade = "初级";
          } else {
            if (res.data.data.content[i].courseLevel === "2") {
              obj.CourseGrade = "中级"
            } else {
              obj.CourseGrade = "高级"
            }
          }
          obj.CourseCreater = res.data.data.content[i].creator;
          obj.CoursePic = this.BaseUrl + res.data.data.content[i].pictureUrl;
          if (res.data.data.content[i].isPublic === 1) {
            obj.CourseState = true
          } else {
            obj.CourseState = false
          }
          obj.CourseIntroduce = res.data.data.content[i].description;
          this.CourseData[i] = obj;
          this.srcList[res.data.data.content[i].id] = this.BaseUrl + res.data.data.content[i].pictureUrl;
        }
      })
    },
    handleSizeChange(newSize) {
      this.queryInfo.size = newSize
      this.CourseData = [];
      this.getCourseList()
    },
    handleCurrentChange(newPage) {
      this.queryInfo.page = newPage
      this.CourseData = [];
      this.getCourseList()
    },
    CreatNewCourse() {
      this.OpenAddNewCourse = !this.OpenAddNewCourse
    },
    handlePictureCardPreview(file) {
      // console.log(file)
      this.dialogImageUrl = file.url
      this.enlargePic = true
    },
    handleAvatarSuccess(res) {
      this.CreateCoursePictureUrl = res.data;
      console.log(this.CreateCoursePictureUrl)
    },
    getNewCourseState(val) {
      console.log(val)
    },
    getNewCourseCate(val) {
      this.CreateCourseCateid = val;
    },
    AddCourse() {
      let CreateCourseisPublic;
      if (this.NewCourseState === true) {
        CreateCourseisPublic = 1;
      } else {
        CreateCourseisPublic = 0;
      }
      let AddCourse = new FormData;
      AddCourse = {
        courseCategoryId: this.CreateCourseCateid,
        courseName: this.CreateNewCourseName,
        courseNumber: this.CreateCourseNumber,
        coursePrice: this.CreateCoursePrice,
        coursePoints: this.CreateCoursePoints,
        pictureUrl: this.CreateCoursePictureUrl,
        courseLevel: this.ChooseGrade,
        isPublic: CreateCourseisPublic,
      };
      console.log(AddCourse)
      axios({
        method: 'post',
        url: '/admin/course/createCourse',
        data: AddCourse
      }).then(res => {
        if (res.data.status === 0) {
          ElMessage("新课程添加成功");
          router.go(0)
        } else {
          ElMessage(res.data.message)
        }
      })
    },
    DeleteCourse(CourseNumber, CourseName) {
      ElMessageBox.confirm(
          '是否确定删除' + CourseName + '课程',
          '提醒',
          {
            confirmButtonText: '确定',
            cancelButtonText: '取消',
            type: 'warning',
          }
      )
          .then(() => {
            axios({
              method: 'post',
              url: '/admin/course/deleteCourseByNumber',
              params: {
                courseNumber: CourseNumber
              }
            }).then(res => {
              if (res.data.status === 0) {
                ElMessage("成功删除该课程")
                router.go(0)
              } else {
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
    ChangeCourseState(CourseState, Courseid, CourseNumber, CourseName, CourseCateId,) {
      let UpdataState;
      if (CourseState === true) {
        UpdataState = 1;
      } else {
        UpdataState = 0;
      }
      let UpdateCourse = new FormData;
      UpdateCourse = {
        id: Courseid,
        courseCategoryId: CourseCateId,
        courseName: CourseName,
        CourseNumber: CourseNumber,
        isPublic: UpdataState
      }
      axios({
        method: 'post',
        url: '/admin/course/updateCourseInfo',
        data: UpdateCourse
      }).then(res => {
        console.log(res.data.message)
      })
    },
    ChangeUpdataGrade(val) {
      console.log(val);
      this.UpdataNewGrade = val;
    },
    UpdataCourse(Courseid, CourseNumber, CourseName, CourseCateId, CourseCate, CourseGrade, CourseIntroduce) {
      this.UpdataCourseid = Courseid;
      this.UpdataCourseCate = CourseCate;
      this.UpdataCourseNumber = CourseNumber;
      this.UpdataCourseName = CourseName;
      if (CourseGrade === "初级") {
        this.UpdataGrade = 1;
      } else {
        if (CourseGrade === "中级") {
          this.UpdataGrade = 2;
        } else {
          this.UpdataGrade = 3;
        }
      }
      // console.log(CourseGrade)
      console.log(CourseCateId)
      this.UpdataIntroduction = CourseIntroduce;
      this.OpenUpdataCourse = !this.OpenUpdataCourse;
     },
    UpdataCourseSure(){
      let UpdataDate=new FormData;
      UpdataDate={
        id:this.UpdataCourseid,
        courseCategoryId:this.CreateCourseCateid,
        courseName:this.UpdataCourseName,
        courseNumber:this.UpdataCourseNumber,
        description:this.UpdataIntroduction,
        pictureUrl:this.CreateCoursePictureUrl,
        courseLevel:this.UpdataNewGrade
      }
      console.log(UpdataDate)
        axios({
          method:'post',
          url:'/admin/course/updateCourseInfo',
          data:UpdataDate
        }).then(res=>{
          if(res.data.status===0){
            ElMessage("信息更改成功")
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