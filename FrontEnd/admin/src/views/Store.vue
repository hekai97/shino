<template>
  <div style="margin-top: -60px">
    <el-container style="border: 1px solid red;height: 1050px">
      <el-menu
          active-color="#ffd04b"
          background-color="#545c64"
          class="el-menu-vertical"
          default-active="1-1"
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
        <el-menu-item index="1-1" v-if="pList.get(106)===true">
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
          <el-menu-item index="1-2-3" style="margin-left: 15px">配置课程</el-menu-item>
          <el-menu-item index="1-2-4" style="margin-left: 15px">课程追踪</el-menu-item>
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
              <div style="width: 100px;float: left;margin-left: 20px;margin-top: 10px;">门店管理</div>
              <div style="width: 100px;float: left;margin-top: 10px;margin-left: 700px">内容搜索</div>
              <div style="float: left;margin-top: 6px;"><el-input v-model="input"  placeholder="输入店铺名称进行搜索" style="width: 200px;" /></div>
              <div style="float: left;margin-top: 6px;margin-left: 10px"><el-button  style="width: 60px;float: left;background-color: #79bbff;">
                <el-icon>
                  <Search/>
                </el-icon>
              </el-button></div>
            </div>
            <div style="margin-left: 10px;height: 35px;margin-top: 20px">
              <el-button type="primary" style="float: left;" @click="ChangedialogTableVisible">创建门店</el-button>
              <el-dialog v-model="dialogTableVisible" title="添加新门店" draggable>
                <div>
                  <div style="width: 89%">
                    <div style="display: inline-block;">门店编号：</div>
                    <div style="display: inline-block;margin-left: 13px">
                      <el-input v-model="CreateStoreNumber" placeholder="设置门店编号"></el-input>
                    </div>
                    <div style="display: inline-block;margin-left: 5px;font-weight: lighter;color: red">（注：门店编号不能和已存在的门店编号重复）</div>
                  </div>
                  <div  style="width: 60%;margin-top: 10px">
                    <div style="display: inline-block;">门店名称：</div>
                    <div style="display: inline-block;">
                      <el-input v-model="CreateStoreName" placeholder="请输入门店名称" style="width:300px;margin-left: 5%"/>
                    </div>
                  </div>
                  <div style="width: 51%;margin-top: 10px">
                    <div style="display: inline-block;">选择店长：</div>
                    <div style="display: inline-block;margin-left: 3.5%">
                      <el-select v-model="value" placeholder="选择店长" @change="getNewManager">
                        <el-option
                            v-for="item in StoreManger"
                            :key="item.id"
                            :label="item.number+item.name"
                            :value="item.id">
                          <span style="float: left">{{ item.number }}</span>
                          <span style="float: left;margin-left: 10%">{{ item.name }}</span>
                        </el-option>
                      </el-select>
                    </div>
                  </div>

                  <div style="margin-top: 10px">
                        <div style="height: 148px;margin-left:35px;line-height: 150px;float: left;">门店照片:</div>
                    <div style="display: inline-block;width: 80%">
                      <el-upload action="http://124.221.159.221:8080/admin/store/uploadStoreImage" style="float:left"
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

                  <div style="margin-top: 20px">
                    <div style="display: inline-block;float: left;margin-left: 35px;margin-top: 10px">门店地址:</div>
                    <el-cascader style="display: inline-block;margin-left: 0%" size='large' :options='options' v-model="selectedOptions" @change="addressChange"></el-cascader>
                    <div style="display: inline-block;margin-left: 2%;width: 47%">
                      <el-input v-model="stroedetailaddress" size="large" placeholder="请输入详细地址"></el-input>
                    </div>
                  </div>

                  <div style="margin-top: 10px">
                    <div style="display: inline-block;float: left;margin-left: 35px;margin-top: 15px">门店简介：</div>
                    <div style="display: inline-block;width: 81%;margin-left: 0%">
                      <el-input
                          v-model="storeIntroduction"
                          :rows="2"
                          type="textarea"
                          placeholder="请输入简介内容"
                      />
                    </div>
                  </div>

                  <div style="margin-top: 20px">
                    <el-button type="primary" @click="AddStore">确定</el-button>
                  </div>

                </div>
              </el-dialog>
            </div>

            <div style="margin-top: 20px;">
              <el-table
                  ref="multipleTableRef"
                  style="width: 100%"
                  border
                  :data="tableData"
                  @cell-click="LookEmployeesAndCourse"
              >

                <el-table-column type="selection" width="55" align="center" ></el-table-column>
                <el-table-column label="ID" property="storeid" min-width="70" align="center" v-if="false"/>
                <el-table-column label="编号" property="storenumber" sortable min-width="80" align="center"></el-table-column>
                <el-table-column property="storename" label="门店名称"  min-width="150px" align="center" />
                <el-table-column property="address" label="地址" show-overflow-tooltip min-width="250px" align="center" />
                <el-table-column property="manageid" label="店长id" min-width="250px" align="center" v-if="false" />
                <el-table-column property="stroeown" label="店长"  min-width="150px" align="center"/>
                <el-table-column property="employeesname" label="店员"  min-width="170px" align="center" />
                <el-table-column property="storesummy" label="店铺简介" v-if="false" align="center"/>
                <el-table-column property="picture" label="图片"  min-width="120px" align="center">
                  <template #default="scope">
                    <div class="demo-image__preview">
                      <el-image
                          style="width: 60px;
                          height: 40px"
                          :src="scope.row.pictureUrl"
                          :preview-src-list="srcList"
                          :preview-teleported="true"
                          fit="cover"/>
                    </div>
                  </template>
                </el-table-column>
                    <el-table-column property="operation" label="操作"  min-width="200px" align="center">
                      <template #default="scope">
                          <el-button size="small" type="primary" @click="OpenCourseDetail(scope.row.storeid,scope.row.storename)"><el-icon><Reading /></el-icon>课程</el-button>
                          <el-button size="small" type="success" @click="OpenUpdataView(scope.row.storeid,scope.row.storenumber,scope.row.storename,scope.row.address,scope.row.managerid,scope.row.stroeown,scope.row.picture,scope.row.storesummy)"><el-icon><EditPen /></el-icon>编辑</el-button>
                      </template>
                    </el-table-column>
              </el-table>

<!--              进入编辑界面-->
              <el-dialog
                  v-model="OpenUpdata"
                  draggable
                  style="background-color:#F0F2F5">
                <div>
                  <div style="width: 89%">
                    <div style="display: inline-block;">门店编号：</div>
                    <div style="display: inline-block;margin-left: 13px">
                      <el-input v-model="UpdataStoreNumber" placeholder="设置门店编号"></el-input>
                    </div>
                    <div style="display: inline-block;margin-left: 5px;font-weight: lighter;color: red">（注：门店编号不能和已存在的门店编号重复）</div>
                  </div>
                  <div  style="width: 60%;margin-top: 10px">
                    <div style="display: inline-block;">门店名称：</div>
                    <div style="display: inline-block;">
                      <el-input v-model="UpdataStoreName" placeholder="请输入门店名称" style="width:300px;margin-left: 5%"/>
                    </div>
                  </div>
                  <div style="width: 51%;margin-top: 10px">
                    <div style="display: inline-block;">选择店长：</div>
                    <div style="display: inline-block;margin-left: 3.5%">
                      <el-select v-model="UpdataManager" placeholder="选择店长" @change="UpdataNewManager">
                        <el-option
                            v-for="item in StoreManger"
                            :key="item.number"
                            :label="item.number+item.name"
                            :value="item.number">
                          <span style="float: left">{{ item.number }}</span>
                          <span style="float: left;margin-left: 10%">{{ item.name }}</span>
                        </el-option>
                      </el-select>
                    </div>
                  </div>

                  <div style="margin-top: 10px">
                    <div style="height: 148px;margin-left:35px;line-height: 150px;float: left;">门店照片:</div>
                    <div style="display: inline-block;width: 80%">
                      <el-upload action="http://124.221.159.221:8080/admin/store/uploadStoreImage" style="float:left"
                                 list-type="picture-card"
                                 :auto-upload="true" limit="1"
                                 :on-success="UpdataUploadPic" name="image"
                                  v-model="UpdataPicUrl">
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

                  <div style="margin-top: 20px">
                    <div style="display: inline-block;float: left;margin-left: 35px;margin-top: 10px">门店地址:</div>
                    <el-cascader style="display: inline-block;margin-left: 0%" size='large' :options='options' v-model="selectedOptions" @change="addressChange"></el-cascader>
                    <div style="display: inline-block;margin-left: 2%;width: 47%">
                      <el-input v-model="UpdataAddressDetail" size="large" placeholder="请输入详细地址"></el-input>
                    </div>
                  </div>

                  <div style="margin-top: 10px">
                    <div style="display: inline-block;float: left;margin-left: 35px;margin-top: 15px">门店简介：</div>
                    <div style="display: inline-block;width: 81%;margin-left: 0%">
                      <el-input
                          v-model="UpdataIntroduce"
                          :rows="2"
                          type="textarea"
                          placeholder="请输入简介内容"
                      />
                    </div>
                  </div>

                  <div style="margin-top: 20px">
                    <el-button type="primary" @click="UpdataStore">确定</el-button>
                  </div>

                </div>
              </el-dialog>
<!--                查看课程列表-->
              <el-dialog
               v-model="CourseDeatil"
               width="30%"
               draggable
               style="background-color:#F0F2F5"
               >
                <template #title>
                  <div>{{this.CourseDetailStoreName}}</div>
                </template>
                  <div>
                    <div>
                      <div style="display: inline-block">选择课程</div>
                      <div style="display: inline-block;margin-left: 10px">
                        <el-select v-model="value" placeholder="选择课程" @change="getNewCourse">
                          <el-option
                              v-for="item in FreeCourse"
                              :key="item.courseNumber"
                              :label="item.courseName"
                              :value="item.courseNumber">
                            <span style="float: left">{{ item.courseNumber }}</span>
                            <span style="float: left;margin-left: 10%">{{ item.courseName }}</span>
                          </el-option>
                          ` </el-select>
                      </div>
                      <div style="display: inline-block;margin-left: 10px"><el-button @click="AddCourseToStore" type="primary"><el-icon><Plus /></el-icon>添加</el-button></div>
                    </div>

                      <div style="margin-top: 50px"
                         v-for="item in LookAllCourseInstore"
                         :key="item.courseNumber">
                        <div>
                          <div style="display: inline-block">{{item.courseName}}</div>
                          <div style="display: inline-block;margin-left: 5%">编号：</div>
                          <div style="display: inline-block">{{item.courseNumber}}</div>
                        </div>
                        <div style="margin-top: 10px">
                          <el-image style="width: 75%;border: 1px solid black" :src="BaseUrl+item.pictureUrl"></el-image>
                        </div>
                        <div style="margin-top: 15px">
                          <el-button type="danger" @click="DeleteCourseFromStore(item.courseNumber)"><el-icon><Delete /></el-icon>删除</el-button>
                        </div>
                      </div>
                    </div>
              </el-dialog>
<!--              查看员工列表-->
              <el-dialog
                  v-model="LookEmployeedig"
                  width="30%"
                  draggable
                  style="background-color:#F0F2F5"
                  @close="ClearData"
              >
                <template #title>
                     <div>{{this.lookemploeeStoreName}}</div>
                </template>
                <div>
                  <div>
                    <div style="display: inline-block">选择员工</div>
                    <div style="display: inline-block;margin-left: 10px">
                      <el-select v-model="value" placeholder="选择店员" @change="getNewEmployee">
                          <el-option
                              v-for="item in FreeEmployee"
                              :key="item.number"
                              :label="item.name"
                              :value="item.number">
                            <span style="float: left"><el-icon><UserFilled /></el-icon></span>
                            <span style="float: left">{{ item.number }}</span>
                            <span style="float: left;margin-left: 10%">{{ item.name }}</span>
                          </el-option>
                    ` </el-select>
                    </div>
                    <div style="display: inline-block;margin-left: 10px"><el-button @click="AddEmployeeToStore" type="primary"><el-icon><Plus /></el-icon>添加</el-button></div>
                  </div>
                   <div style="margin-left:20px;margin-top: 20px;width:89%;background-color: white;font-size:15px;height: 40px;"
                        v-for="item in LookAllEmployeeInStore"
                        :key="item.id"
                        >
                        <div style="display: inline-block;margin-left: 2%"><el-icon><UserFilled /></el-icon></div>
                        <div style="display: inline-block;margin-left: 5%;line-height: 40px">编号：</div>
                        <div style="display: inline-block;width: 10%;text-align: left">{{item.number}}</div>
                        <div style="display: inline-block;margin-left: 5%;">姓名：</div>
                        <div style="display: inline-block;width: 20%;text-align: left">{{item.name}}</div>
                        <div style="display: inline-block;margin-left: 0%">
                          <el-button type="danger" size="small" @click="DeleteEmployeeFromStore(item.number)"><el-icon><Delete /></el-icon>删除</el-button>
                        </div>
                   </div>

                </div>
                <div style="height: 300px"></div>
              </el-dialog>
            </div>
          </div>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>
import {
  PieChart, Coin, House, Calendar, User, Edit, Setting, Files, Operation, DArrowRight, DArrowLeft, Fold,
  ChromeFilled, Refresh,Bell, Help, Discount, Sort,ArrowDown,Van,HomeFilled,Search,Reading,EditPen,Plus,ZoomIn,UserFilled,Delete
} from '@element-plus/icons-vue'
import axios from "axios";
import {ElLoading, ElMessage} from "element-plus";
import router from "@/router";
import {useRoute} from "vue-router/dist/vue-router";
import { regionData, CodeToText } from 'element-china-area-data'
let aname;
let aid;
export default {
  name: "myStore",
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
    ChromeFilled, Refresh, Bell,Help, Discount, Sort, ArrowDown, Van,HomeFilled,Search,Reading,EditPen,Plus,ZoomIn,UserFilled,Delete
  },

  data() {
    return {
      // adminname:route.params.adminname,
      isCollapse: false,
      result: 'true',
      inputSearch: '',
      value:'',
      value4: '',
      value5: '',
      value1: '',
      input:'',
      dpList: [],
      tabled:[],
      dialogTableVisible:false,
      PicVisible:false,
      BaseUrl:axios.defaults.baseURL,
      srcList:[],
      tableData: [{
        storenumber: '',
        storename: '',
        address: '',
        stroeown:'',
        employees:[],
        pictureUrl:'',
        employeesname:'',
        storeid:'',
        storesummy:'',
        managerid:"",
      }],
      pList: new Map(),
      options:regionData,
      selectedOptions:['370000','370600','370613'],
      stroedetailaddress:'',
      storeIntroduction:'',
      enlargePic:false,
      dialogImageUrl:'',
      lookemploeeStoreName:'',
      LookEmployeedig:false,
      LookEmployeeStoreId:'',
      CreateStoreName:'',
      CreateStoreNumber:'',
      CreateStorePictureUrl:'',
      CreateStoreManagerId:'',
      CreateStoreManagerNumber:'',
      CreateStoreManagerName:'',
      StoreManger:[],
      AddAddressProvinces:'',
      AddAddressCity:'',
      AddAddressCounty:'',
      FreeEmployee:[{
        id:'',
        number:'',
        name:''
      }],
      LookAllEmployeeInStore:[{
        id: '',
        number:'',
        name:'',
      }],
      AddNewEmployeeNumber:'',
      CourseDetailStoreName:'',
      CourseDeatil:false,
      opencoursestoreid:'',
      FreeCourse:[],
      LookAllCourseInstore:[],
      AddNewCoureseToStore:'',
      OpenUpdata:false,
      UpdataStoreId:'',
      UpdataStoreNumber:'',
      UpdataStoreName:'',
      UpdataManagerId:'',
      UpdataManagerNumber:'',
      UpdataManager:'',
      UpdataPicUrl:'',
      UpdataAddressDetail:'',
      UpdataIntroduce:''
    }
  },
  mounted() {
    this.getAllproData()
    this.getAllPermission()
    this.getAllFreeStoreManage()
    this.getAllFreeEmployee()
  },
  methods:{
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
    home(){
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
    Order(){
      router.push({
        name: 'Order',
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
    async getAllproData(){
      const res=await axios.get("/admin/store/getStoreList");
        this.tabled=res.data.data;
        console.log(this.tabled)
        for (let i=0;i<res.data.data.length;i++)
        {
          const obj = new Object();
          obj.storeid=res.data.data[i].id;
          obj.storenumber=res.data.data[i].storeNumber;
          obj.storename=res.data.data[i].storeName
          obj.address=res.data.data[i].address
          obj.stroeown=res.data.data[i].storeManagerName
          obj.storesummy=res.data.data[i].summary
          obj.managerid=res.data.data[i].storeManagerId
          obj.pictureUrl=this.BaseUrl+res.data.data[i].pictureUrl
          await axios({
            method:'post',
            url:'/admin/user/getOnlyEmployeeUserPageableByStoreId',
            params:{
              page:0,
              size:20,
              storeId:res.data.data[i].id
            }
          }).then(respone=>{
            for(let j=0;j<respone.data.data.content.length;j++){
              obj.employeesname=respone.data.data.content[j].name
            }
          })
          this.tableData[i]=obj;
          // this.tableData[i].employeesname=objj;
          this.srcList[i]=this.BaseUrl+res.data.data[i].pictureUrl;
        }
        // console.log(this.srcList)
    },
    ChangedialogTableVisible(){
      this.dialogTableVisible=!this.dialogTableVisible
    },
    getAllFreeStoreManage(){
      axios({
          method:'get',
          url:'/admin/user/getAllFreeStoreManager'
      }).then(res=>{
        this.StoreManger=res.data.data;
      })
    },
    getAllFreeEmployee(){
      axios({
        method:'get',
        url:'/admin/user/getAllFreeEmployee',
      }).then(res=>{
        for(let i=0;i<res.data.data.length;i++)
        {
          const obj=new Object();
          obj.id=res.data.data[i].id;
          obj.number=res.data.data[i].number;
          obj.name=res.data.data[i].name;
          this.FreeEmployee[i]=obj;
        }
        // console.log(res.data.data)
      })
    },
    async getAllFreeCourse(){
     await axios({
        method:'get',
        url:'/admin/course/getCoursesNotInStore',
        params:{
          storeId:this.opencoursestoreid
        }
      }).then(res=>{
        this.FreeCourse=res.data.data
      })
    },
    AddStore(){
      let AddStore=new FormData();
      AddStore={
        storeNumber:this.CreateStoreNumber,
        storeName:this.CreateStoreName,
        // type:"小吃",
        storeManagerId:this.CreateStoreManagerId,
        address:this.AddAddressProvinces+this.AddAddressCity+this.AddAddressCounty+this.stroedetailaddress,
        pictureUrl:this.CreateStorePictureUrl,
        summary:this.storeIntroduction
      }
      // console.log(AddStore);
      axios({
        method:'post',
        url:'/admin/store/createStore',
        data:AddStore
      }).then(res=>{
        if(res.data.status===0)
        {
          ElMessage("添加门店成功")
          router.go(0)
        }else{
          ElMessage(res.data.message)
        }
      })
    },
    getNewManager(val){
      this.CreateStoreManagerId=val
    },
    getNewEmployee(val){
      this.AddNewEmployeeNumber=val
    },
    getNewCourse(val){
      this.AddNewCoureseToStore=val;
    },
    addressChange(arr){
      console.log(this.selectedOptions)
      console.log(arr)
      console.log(CodeToText[arr[0]],CodeToText[arr[1]],CodeToText[arr[2]])
      this.AddAddressProvinces=CodeToText[arr[0]]
      this.AddAddressCity=CodeToText[arr[1]]
      this.AddAddressCounty=CodeToText[arr[2]]
    },
    handlePictureCardPreview(file){
      // console.log(file)
      this.dialogImageUrl= file.url
      this.enlargePic = true
    },
    handleAvatarSuccess(res){
      this.CreateStorePictureUrl=res.data;
      // ElMessage(this.CreateStorePictureUrl)
    },
    LookEmployeesAndCourse(row, column){
      if(column.label==="店员")
      {
        this.lookemploeeStoreName=row.storename
        this.LookEmployeeStoreId=row.storeid;
        axios({
          method:'post',
          url:'/admin/user/getEmployeeUserPageableByStoreId',
          params:{
            page:0,
            size:20,
            storeId:row.storeid
          }
        }).then(res=>{
          // console.log(res.data.data.content)
            let j=0;
            for (let i = 0; i < res.data.data.content.length; i++) {
              if (res.data.data.content[i].roleId === 3 || res.data.data.content[i].roleId === 4) {
                console.log(res.data.data.content[i].name)
                const obj = new Object();
                obj.id = res.data.data.content[i].id;
                obj.number = res.data.data.content[i].number;
                obj.name = res.data.data.content[i].name;
                this.LookAllEmployeeInStore[j] = obj;
                j++;
              }
            }
          console.log(this.LookAllEmployeeInStore)
        })
        this.LookEmployeedig=!this.LookEmployeedig;
      }
    },
    ClearData(){
      this.LookAllEmployeeInStore=[];
    },
    DeleteEmployeeFromStore(EmployeeNumber){
      axios({
        method:'post',
        url:'/admin/user/deleteEmployeeToStoreByEmployeeNumber',
        params:{
          storeId:this.LookEmployeeStoreId,
          employeeUserNumber:EmployeeNumber
        }
      }).then(res=>{
        if(res.data.status===0){
          ElMessage("成功解雇该员工")
          router.go(0)
        }else{
          ElMessage(res.data.message)
        }
      })
    },
    DeleteCourseFromStore(coursenumber){
        axios({
          method:'post',
          url:'/admin/course/deleteCourseFromStore',
          params:{
            storeId:this.opencoursestoreid,
            courseNumber:coursenumber
          }
        }).then(res=>{
          if(res.data.status===0){
            ElMessage("成功移除该课程")
            router.go(0)
          }else{
            ElMessage(res.data.message)
          }
        })
    },
    AddEmployeeToStore(){
      axios({
        method:'post',
        url:'/admin/user/setEmployeeToStoreByEmployeeNumber',
        params:{
          storeId:this.LookEmployeeStoreId,
          employeeUserNumber:this.AddNewEmployeeNumber
        }
      }).then(res=>{
        if(res.data.status===0){
          ElMessage("店员添加成功")
          router.go(0)
        }else{
          ElMessage(res.data.message)
        }
      })
    },
    AddCourseToStore(){
      axios({
        method:'post',
        url:'/admin/course/setCourseToStoreByCourseNumber',
        params:{
          courseNumber:this.AddNewCoureseToStore,
          storeId:this.opencoursestoreid
        }
      }).then(res=>{
        if(res.data.status===0){
          ElMessage("课程添加成功")
          router.go(0)
        }else{
          ElMessage(res.data.message)
        }
      })
    },
    async OpenCourseDetail(storeid,storename){
      this.opencoursestoreid=storeid;
      this.CourseDetailStoreName=storename;
      this.getAllFreeCourse();
      await axios({
        method:'get',
        url:'/admin/course/getCoursesPageableByStoreId',
        params:{
          page:0,
          size:30,
          storeId:storeid
        }
      }).then(res=>{
        this.LookAllCourseInstore=res.data.data.content
      })
      this.CourseDeatil=!this.CourseDeatil
    },
    OpenUpdataView(storeid,storenumber,storename,address,manageid,stroeown,picture,storesummy){
      this.UpdataStoreId=storeid
      this.UpdataStoreNumber=storenumber;
      this.UpdataStoreName=storename;
      this.UpdataAddressDetail=address;
      this.UpdataManagerId=manageid;
      axios({
        method:'get',
        url:'/admin/user/getAllStoreManager',
      }).then(res=>{
        // console.log(manageid)
        // console.log(res.data.data)
        for(let i=0;i<res.data.data.length;i++){
          if(res.data.data[i].id===manageid){
            this.UpdataManagerNumber=res.data.data[i].number
            break;
          }
        }
        // console.log(this.UpdataManagerNumber)
      })
      this.UpdataManager=stroeown;
      // this.UpdataPicUrl=picture;
      console.log(picture)
      this.UpdataIntroduce=storesummy;
      this.OpenUpdata=!this.OpenUpdata
    },
    UpdataNewManager(val){
      axios({
        method:'post',
        url:'/admin/user/deleteEmployeeToStoreByEmployeeNumber',
        params:{
          employeeUserNumber:this.UpdataManagerNumber,
          storeId:this.UpdataStoreId
        }
      }).then(res=>{
        console.log(res.data.message)
      })
      this.UpdataManagerNumber=val;
    },
    UpdataUploadPic(res){
      this.UpdataPicUrl=res.data
    },
    async UpdataStore(){
      await axios({
        method:'get',
        url:'/admin/user/getAllStoreManager'
      }).then(res=>{
        for(let i=0;i<res.data.data.length;i++){
          if(res.data.data[i].number===this.UpdataManagerNumber){
            this.UpdataManagerId=res.data.data[i].id
          }
        }
      })
      let UpdataStore=new FormData();
      UpdataStore={
        id:this.UpdataStoreId,
        storeNumber:this.UpdataStoreNumber,
        storeName:this.UpdataStoreName,
        // type:"小吃",
        storeManagerId:this.UpdataManagerId,
        address:this.AddAddressProvinces+this.AddAddressCity+this.AddAddressCounty+this.UpdataAddressDetail,
        pictureUrl:this.UpdataPicUrl,
        summary:this.UpdataIntroduce
      }
      await axios({
        method:'post',
        url:'/admin/user/setEmployeeToStoreByEmployeeNumber',
        params:{
          storeId:this.UpdataStoreId,
          employeeUserNumber:this.UpdataManagerNumber
        }
      }).then(res=>{
        console.log(res.data.message)
      })
      await axios({
        method:'post',
        url:'/admin/store/updateStoreInfo',
        data:UpdataStore
      }).then(res=>{
        if(res.data.status===0)
        {
          ElMessage("门店信息更新成功")
          router.go(0)
        }else{
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
.toggle-btn{
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