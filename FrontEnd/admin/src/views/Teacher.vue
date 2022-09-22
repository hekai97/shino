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
        <el-menu-item index="1-4" v-if="pList.get(105)===true" @click="ManageStudent">
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
                  <TrendCharts/>
                </el-icon>
              </div>
            </div>
          </div>
        </el-header>
        <el-main style="background-color: #F0F2F5" class="main">
         <div>
           <div style="margin-top: 10px;background-color: white;">
             <div style="height: 50px;">
               <div style="display: inline-block;float:left;margin-top: 14px;margin-left: 20px">
                 <span>入职时间</span>
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
               <div style="float:left;width: 100px;margin-top: 18px;margin-left: 0px">擅长类别</div>
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


               <div style="float:left;width: 100px;margin-top: 18px;">内容搜索</div>
               <div style="margin-top: 14px;float: left"><el-input v-model="input"  placeholder="输入店铺名称进行搜索" style="width: 200px;" /></div>
               <div style="margin-top: 14px;float:left;margin-left: 10px"><el-button  style="width: 60px;float: left;background-color: #79bbff;">
                 <el-icon>
                   <Search/>
                 </el-icon>
               </el-button></div>
             </div>
             <div style="margin-top: 20px;;height: 35px;margin-left: 30px">
               <el-button type="primary" style="float:left;" @click="OpenAddNewTeacher">创建新讲师</el-button>
             </div>
           </div>

          <div style="margin-top: 20px">
            <el-card style="top: 200px;width: 100%">
              <el-table
                  ref="multipleTableRef"
                  style="width: 100%;margin-top: 50px"
                  border
                  :data="TeacherData"
              >
                <el-table-column type="selection" align="center" min-width="55" />
                <el-table-column label="Id" property="id" min-width="50px" align="center" v-if="false" />
                <el-table-column label="编号" property="number" sortable min-width="60px" align="center"></el-table-column>
                <el-table-column property="name" label="讲师姓名" min-width="80px" align="center" />
                <el-table-column property="phone" label="讲师手机号" min-width="100" align="center" />
                <el-table-column property="email" label="讲师邮箱" min-width="100" align="center" v-if="false"/>
                <el-table-column property="address" label="家庭住址" min-width="120" align="center" v-if="false" />
                <el-table-column property="storeId" label="门店id" min-width="70" align="center" v-if="false"/>
                <el-table-column property="storenum" label="门店编号" min-width="70" align="center" v-if="false"/>
                <el-table-column property="storeName" label="门店" min-width="80" align="center" />
                <el-table-column property="sex" label="性别" min-width="60" align="center"  v-if="false" />
                <el-table-column property="birthday" label="出生日期" min-width="90" align="center" v-if="false" />
                <el-table-column property="employmentDate" label="从业日期" min-width="100" align="center" v-if="false"/>
                <el-table-column property="entryDate" label="入职日期" sortable min-width="90" align="center" />
                <el-table-column property="leaveDate" label="离职日期" sortable min-width="90" align="center" />
                <el-table-column property="goodCategory" label="擅长分类" min-width="120px" align="center" v-if="false" />
                <el-table-column property="description" label="讲师简介" min-width="100px" align="center" v-if="false" />
                <el-table-column property="pictureUrl" label="详情图片" min-width="90" align="center" >
                  <template #default="scope">
                    <div class="demo-image__preview">
                      <el-image
                          style="width: 60px;
                          height: 40px"
                          :src="scope.row.pictureUrl"
                          :preview-src-list="srcList"
                          :preview-teleported="true"
                          fit="cover"
                          :initial-index="scope.row.id"/>
                    </div>
                  </template>
                </el-table-column>
                <el-table-column property="status" label="发布状态" min-width="90" align="center" >
                  <template #default="scope">
                    <el-switch
                        v-model="scope.row.status"
                        inline-prompt
                        active-text="在职"
                        inactive-text="离职"
                        width="60px"
                        @change="Teacherresign(scope.row.status,scope.row.id)"
                    />
                  </template>
                </el-table-column>
                <el-table-column property="operation" label="操作" min-width="120" align="center">
                  <template #default="scope">
                    <el-button type="primary" size="small" @click="UpdataTeacher(scope.row,scope.row.id)"><el-icon><EditPen /></el-icon>编辑</el-button>
                    <el-button type="danger" size="small" @click="DeleteTeacher(scope.row.number,scope.row.name)"><el-icon><Delete /></el-icon>删除</el-button>
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
                  :total="Teachertotal"
                  style="margin-top: 30px">
              </el-pagination>
            </el-card>
          </div>

<!--     创建新讲师-->
           <el-dialog v-model="OpenNewTeacher" title="添加新讲师" draggable>
             <div>
               <div style="margin-top: 10px">
                 <div style="height: 148px;margin-left:35px;line-height: 150px;float: left;">课程照片:</div>
                 <div style="display: inline-block;width: 80%">
                   <el-upload action="http://124.221.159.221:8080/admin/teacher/uploadTeacherImage" style="float:left"
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

               <div style="width: 89%;margin-top: 10px">
                 <el-form :model="form" ref="form" label-width="120px">
                   <el-form-item label="编号">
                     <el-input v-model="form.number" placeholder="请输入讲师编号（注：不能与以存在的编号重复）" />
                   </el-form-item>
                   <el-form-item label="姓名">
                     <el-input v-model="form.name" placeholder="请输入讲师姓名" />
                   </el-form-item>
                   <el-form-item label="性别" >
                     <el-radio-group v-model="form.resource"  >
                       <el-radio label="男" />
                       <el-radio label="女" />
                     </el-radio-group>
                   </el-form-item>
                   <el-form-item label="手机">
                     <el-input v-model="form.phone" placeholder="请输入正确的手机号"/>
                   </el-form-item>
                   <el-form-item label="邮箱">
                     <el-input v-model="form.email" placeholder="请输入正确的邮箱" />
                   </el-form-item>
                   <el-form-item label="所在门店">
                     <el-select v-model="value1" placeholder="请选择店铺" style="width: 150px" @change="getNewStore">
                       <el-option
                           v-for="item in dpList"
                           :key="item.id"
                           :label="item.storeName"
                           :value="item.id"
                       />
                     </el-select>
                   </el-form-item>
                   <el-form-item label="擅长类别">
                     <el-select v-model="TeacherCourseCate" placeholder="请选择分类"  @change="getNewCourseCate">
                       <el-option
                           v-for="item in CourseCate"
                           :key="item.id"
                           :label="item.categoryName"
                           :value="item.categoryName"
                       />
                     </el-select>
                   </el-form-item>
                   <el-form-item label="出生日期">
                     <el-col :span="11">
                       <el-date-picker
                           v-model="form.birthdate"
                           type="date"
                           placeholder="出生日期"
                           style="width: 100%"
                       />
                     </el-col>
                   </el-form-item>
                   <el-form-item label="从业时间">
                     <el-col :span="12">
                       <el-date-picker
                           v-model="form.workdate"
                           type="date"
                           placeholder="从业时间"
                           style="width: 100%"
                       />
                     </el-col>
                   </el-form-item>
                   <el-form-item label="入职日期">
                     <el-col :span="13">
                       <el-date-picker
                           v-model="form.entrywork"
                           type="date"
                           placeholder="入职日期"
                           style="width: 100%"
                       />
                     </el-col>
                   </el-form-item>
                   <div style="margin-top: 20px">
                     <div style="display: inline-block;float: left;margin-left: 50px;margin-top: 10px">家庭地址:&nbsp;&nbsp;</div>
                     <div style="float: left;">
                     <el-cascader
                         style="display: inline-block;"
                         size='large'
                         :options='options'
                         v-model="selectedOptions"
                         @change="addressChange">
                     </el-cascader>
                     </div>
                     <div style="display: inline-block;margin-left: 2%;width: 42%">
                       <el-input v-model="UpdataTeacherAddressDetail" size="large" placeholder="请输入详细地址"></el-input>
                     </div>
                   </div>
                   <div style="margin-top: 10px">
                     <div style="display: inline-block;float: left;margin-left: 50px;margin-top: 15px">讲师简介：</div>
                     <div style="display: inline-block;width: 81%;margin-left: 0%">
                       <el-input
                           v-model="UpdataIntroduce"
                           :rows="2"
                           type="textarea"
                           placeholder="请输入简介内容"
                       />
                     </div>
                   </div>

                 </el-form>
               </div>
               <div style="margin-top: 30px">
                 <el-button type="primary" @click="CreateNewTeacher()">确定</el-button>
               </div>
             </div>
           </el-dialog>
           <el-dialog v-model="OpenNewTeacher" title="添加新讲师" draggable>
             <div>
               <div style="margin-top: 10px">
                 <div style="height: 148px;margin-left:35px;line-height: 150px;float: left;">课程照片:</div>
                 <div style="display: inline-block;width: 80%">
                   <el-upload action="http://124.221.159.221:8080/admin/teacher/uploadTeacherImage" style="float:left"
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

               <div style="width: 89%;margin-top: 10px">
                 <el-form :model="form" ref="form" label-width="120px">
                   <el-form-item label="编号">
                     <el-input v-model="form.number" placeholder="请输入讲师编号（注：不能与以存在的编号重复）" />
                   </el-form-item>
                   <el-form-item label="姓名">
                     <el-input v-model="form.name" placeholder="请输入讲师姓名" />
                   </el-form-item>
                   <el-form-item label="性别" >
                     <el-radio-group v-model="form.resource"  >
                       <el-radio label="男" />
                       <el-radio label="女" />
                     </el-radio-group>
                   </el-form-item>
                   <el-form-item label="手机">
                     <el-input v-model="form.phone" placeholder="请输入正确的手机号"/>
                   </el-form-item>
                   <el-form-item label="邮箱">
                     <el-input v-model="form.email" placeholder="请输入正确的邮箱" />
                   </el-form-item>
                   <el-form-item label="所在门店">
                     <el-select v-model="value1" placeholder="请选择店铺" style="width: 150px" @change="getNewStore">
                       <el-option
                           v-for="item in dpList"
                           :key="item.id"
                           :label="item.storeName"
                           :value="item.id"
                       />
                     </el-select>
                   </el-form-item>
                   <el-form-item label="擅长类别">
                     <el-select v-model="TeacherCourseCate" placeholder="请选择分类"  @change="getNewCourseCate">
                       <el-option
                           v-for="item in CourseCate"
                           :key="item.id"
                           :label="item.categoryName"
                           :value="item.categoryName"
                       />
                     </el-select>
                   </el-form-item>
                   <el-form-item label="出生日期">
                     <el-col :span="11">
                       <el-date-picker
                           v-model="form.birthdate"
                           type="date"
                           placeholder="出生日期"
                           style="width: 100%"
                       />
                     </el-col>
                   </el-form-item>
                   <el-form-item label="从业时间">
                     <el-col :span="12">
                       <el-date-picker
                           v-model="form.workdate"
                           type="date"
                           placeholder="从业时间"
                           style="width: 100%"
                       />
                     </el-col>
                   </el-form-item>
                   <el-form-item label="入职日期">
                     <el-col :span="13">
                       <el-date-picker
                           v-model="form.entrywork"
                           type="date"
                           placeholder="入职日期"
                           style="width: 100%"
                       />
                     </el-col>
                   </el-form-item>
                   <div style="margin-top: 20px">
                     <div style="display: inline-block;float: left;margin-left: 50px;margin-top: 10px">家庭地址:&nbsp;&nbsp;</div>
                     <div style="float: left;">
                       <el-cascader
                           style="display: inline-block;"
                           size='large'
                           :options='options'
                           v-model="selectedOptions"
                           @change="addressChange">
                       </el-cascader>
                     </div>
                     <div style="display: inline-block;margin-left: 2%;width: 42%">
                       <el-input v-model="UpdataTeacherAddressDetail" size="large" placeholder="请输入详细地址"></el-input>
                     </div>
                   </div>
                   <div style="margin-top: 10px">
                     <div style="display: inline-block;float: left;margin-left: 50px;margin-top: 15px">讲师简介：</div>
                     <div style="display: inline-block;width: 81%;margin-left: 0%">
                       <el-input
                           v-model="UpdataIntroduce"
                           :rows="2"
                           type="textarea"
                           placeholder="请输入简介内容"
                       />
                     </div>
                   </div>

                 </el-form>
               </div>
               <div style="margin-top: 30px">
                 <el-button type="primary" @click="UpdataNewTeacher()">确定</el-button>
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
  Menu as IconMenu,
  PieChart, Coin, House, Calendar, User, Edit, Setting, Files, Operation, DArrowRight, DArrowLeft, Fold, ChromeFilled,
  Refresh, Bell, Help, Discount, Sort, TrendCharts, Search, ArrowDown, Van,Delete,EditPen,ZoomIn,Plus
} from '@element-plus/icons-vue'
import axios from "axios";
import {ElLoading, ElMessage, ElMessageBox} from "element-plus";
import router from "@/router";
import {useRoute} from "vue-router/dist/vue-router";
import {CodeToText, regionData} from "element-china-area-data";
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
    IconMenu, PieChart, Coin, House, Calendar, User, Edit, Setting, Files, Operation, DArrowLeft, DArrowRight, Fold, ChromeFilled,
    Refresh, Bell, Help, Discount, Sort, TrendCharts, Search, ArrowDown, Van, Delete, EditPen,ZoomIn,Plus
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
      CourseCate:[],
      pList: new Map(),
      Teachertotal:0,
      queryInfo: {
        page: 1,
        size: 10
      },
      TeacherData:[{
        id:'',
        number:'',
        name:'',
        phone:'',
        email:'',
        address:'',
        storeId:'',
        storenum:'',
        storeName:'',
        sex:'',
        birthday:'',
        entryDate:'',
        leaveDate:'',
        pictureUrl:'',
        status:false,
        description:'',
        goodCategory:'',
        employmentDate:'',
      }],
      srcList:[],
      BaseUrl:axios.defaults.baseURL,
      OpenNewTeacher:false,
      form:{
        number:'',
        name:'',
        resource:'',
        store:'',
        phone:'',
        email:'',
        updates:'',
        region:'',
        birthdate:'',
        workdate:'',
        entrywork:'',
        leavedate:'',
      },
      options:regionData,
      selectedOptions:['370000','370600','370613'],
      UpdataTeacherAddressDetail:'',
      UpdataIntroduce:'',
      AddAddressProvinces:'',
      AddAddressCity:'',
      AddAddressCounty:'',
      dialogImageUrl:'',
      enlargePic:false,
      CreateCoursePictureUrl:'',
      TeacherCourseCate:'',
      CreateCourseCateid:'',
      CreateNewStoreId:'',
      id:'',
    }
  },
  mounted() {
    this.getAllPermission()
    this.getStoreList()
    this.getCouseCateList()
    this.getTeacherList()
    this.getNewCourseCate()
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
    async getCouseCateList(){
      await axios({
        method:'get',
        url:'/admin/course/getCourseCategoryList'
      }).then(res=>{
        this.CourseCate=res.data.data;
      })
    },
    async getTeacherList(){
        axios({
          method:'post',
          url:'/admin/teacher/getTeacherListPageable',
          params:{
            page:this.queryInfo.page-1,
            size:this.queryInfo.size,
          }
        }).then(res=>{
          console.log(res.data.data.content)
          this.Teachertotal=res.data.data.totalElements;
          for(let i=0;i<res.data.data.content.length;i++){
              let obj=new Object();
              obj.id=res.data.data.content[i].id;
              obj.number=res.data.data.content[i].number;
              obj.storeId=res.data.data.content[i].storeId;
              obj.name=res.data.data.content[i].name;
              obj.phone=res.data.data.content[i].phone;
              obj.email=res.data.data.content[i].email;
              obj.address=res.data.data.content[i].address;
              obj.storenum=res.data.data.content[i].storenum;
              obj.storeName=res.data.data.content[i].storeName;
              obj.sex=res.data.data.content[i].sex;
              obj.birthday=res.data.data.content[i].birthday;
              obj.entryDate=res.data.data.content[i].entryDate;
              obj.leaveDate=res.data.data.content[i].leaveDate;
              obj.pictureUrl=this.BaseUrl+res.data.data.content[i].pictureUrl;
              obj.goodCategory=res.data.data.content[i].goodCategory;
              obj.employmentDate=res.data.data.content[i].employmentDate;
                // status:'',
              if(res.data.data.content[i].status===0){
                obj.status=false;
              }else{
                obj.status=true;
              }
              obj.description=res.data.data.content[i].description;
             this.TeacherData[i]=obj;
            this.srcList[res.data.data.content[i].id]=this.BaseUrl+res.data.data.content[i].pictureUrl;
          }
        })
    },
    async getNewCourseCate(val) {
      this.CreateCourseCateid = val;
    },
    async getNewStore(val){
      this.CreateNewStoreId=val;
    },
    handleSizeChange(newSize){
      this.queryInfo.size = newSize
      this.TeacherData=[];
      this.getTeacherList()
    },
    handleCurrentChange(newPage){
      this.queryInfo.page = newPage
      this.TeacherData=[];
      this.getTeacherList()
    },
    OpenAddNewTeacher(){

      this.OpenNewTeacher=!this.OpenNewTeacher
    },
    addressChange(arr){
      console.log(this.selectedOptions)
      console.log(arr)
      console.log(CodeToText[arr[0]],CodeToText[arr[1]],CodeToText[arr[2]])
      this.AddAddressProvinces=CodeToText[arr[0]]
      this.AddAddressCity=CodeToText[arr[1]]
      this.AddAddressCounty=CodeToText[arr[2]]
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
    CreateNewTeacher(){
      let NewTeacher=new FormData;
      NewTeacher={
        storeId:this.CreateNewStoreId,
        number:this.form.number,
        name:this.form.name,
        address:this.AddAddressProvinces+this.AddAddressCity+this.AddAddressCounty+this.UpdataTeacherAddressDetail,
        email:this.form.email,
        phone:this.form.phone,
        birthday:this.form.birthdate,
        sex:this.form.resource,
        pictureUrl:this.CreateCoursePictureUrl,
        employmentDate:this.form.workdate,
        goodCategory:this.CreateCourseCateid,
        entryDate:this.form.entrywork,
        leaveDate:this.form.leavedate,
        description:this.UpdataIntroduce,
      };
      console.log(NewTeacher);
      axios({
        method:'post',
        url:'/admin/teacher/addTeacher',
        data:NewTeacher
      }).then(res=>{
        if(res.data.status===0){
          ElMessage("添加讲师成功")
          router.go(0)
        }else{
          ElMessage(res.data.message)
        }
      })
    },
    DeleteTeacher(TeacherNumber,TeacherName){
      ElMessageBox.confirm(
          '是否确定删除' + TeacherName + '讲师',
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
              url:'/admin/teacher/deleteTeacherByNumber',
              params:{
                number:TeacherNumber
              }
            }).then(res=>{
              if(res.data.status===0){
                ElMessage("删除成功");
                router.go(0)
              }
              else{
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
    Teacherresign(status,id){
      if(status===true){
        status=1;
        let UpdataT=new FormData();
        UpdataT={
          id:id,
          status:status
        }
        console.log(UpdataT)
        axios({
          method:'post',
          url:'/admin/teacher/updateTeacher',
          data:UpdataT
        }).then(res=>{
          if(res.data.status===0){
            ElMessage("成功就职");
          }
          else{
            ElMessage(res.data.message)
          }
        })
      }else{
        status=0;
        let UpdataT=new FormData();
        let date = new Date();
        let seperator1 = "-";
        let year = date.getFullYear();
        let month = date.getMonth() + 1;
        let strDate = date.getDate();
        if (month >= 1 && month <= 9) {
          month = "0" + month;
        }
        if (strDate >= 0 && strDate <= 9) {
          strDate = "0" + strDate;
        }
        let currentdate = year + seperator1 + month + seperator1 + strDate;
        console.log(currentdate)
        UpdataT={
          id:id,
          leaveDate:currentdate,
          status:status
        }
        console.log(UpdataT)
        axios({
          method:'post',
          url:'/admin/teacher/updateTeacher',
          data:UpdataT
        }).then(res=>{
          if(res.data.status===0){
            ElMessage("成功离职");
            router.go(0)
          }
          else{
            ElMessage(res.data.message)
          }
        })
        status=0;
      }

    },
    UpdataTeacher(Val,id){
      this.id=id;
      this.form.number=Val.number;
      this.form.name=Val.name;
      this.form.resource=Val.sex;
      this.form.phone=Val.phone;
      this.form.email=Val.email;
      this.value1=Val.storeName;
      this.TeacherCourseCate=Val.goodCategory;
      this.form.birthdate=Val.birthday;
      this.form.workdate=Val.employmentDate;
      this.form.entrywork=Val.entryDate;
      this.UpdataTeacherAddressDetail=Val.address;
      this.UpdataIntroduce=Val.description;
      this.OpenNewTeacher=!this.OpenNewTeacher
      },
    UpdataNewTeacher(){
      let NewTeacher=new FormData;
      NewTeacher={
        id:this.id,
        storeId:this.CreateNewStoreId,
        number:this.form.number,
        name:this.form.name,
        address:this.AddAddressProvinces+this.AddAddressCity+this.AddAddressCounty+this.UpdataTeacherAddressDetail,
        email:this.form.email,
        phone:this.form.phone,
        birthday:this.form.birthdate,
        sex:this.form.resource,
        pictureUrl:this.CreateCoursePictureUrl,
        employmentDate:this.form.workdate,
        goodCategory:this.CreateCourseCateid,
        entryDate:this.form.entrywork,
        leaveDate:this.form.leavedate,
        description:this.UpdataIntroduce,
      };
      axios({
        method:'post',
        url:'/admin/teacher/updateTeacher',
        data:NewTeacher
      }).then(res=>{
        if(res.data.status===0){
          ElMessage("更新完成")
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
