<template>
  <div style="margin-top: -60px">
    <el-container style="border: 1px solid red;height: 800px">
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
                  style="width: 350px;margin-left: 20px;"
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
        <el-main style="background-color: #F0F2F5;border: 1px solid black">
          <div style="margin-top: 10px;border: 1px solid red;background-color: white;height: 650px">
            <div style="height: 50px;border: 1px solid black">
              <div style="width: 100px;float: left;margin-left: 20px;margin-top: 10px;">门店管理</div>
              <div style="width: 100px;float: left;margin-top: 10px;margin-left: 700px">内容搜索</div>
              <div style="float: left;margin-top: 6px;"><el-input v-model="input"  placeholder="输入店铺名称进行搜索" style="width: 200px;" /></div>
              <div style="float: left;margin-top: 6px;margin-left: 10px"><el-button  style="width: 60px;float: left;background-color: #79bbff;">
                <el-icon>
                  <Search/>
                </el-icon>
              </el-button></div>
            </div>
            <div style="border: 1px solid black;margin-left: 10px;height: 35px;margin-top: 20px">
              <el-button type="primary" style="float: left;" @click="ChangedialogTableVisible">创建门店</el-button>
              <el-dialog v-model="dialogTableVisible" title="添加新门店">
                <div>
                  <div  style="border: 1px solid black ">
                    <div>门店名称</div>
                    <div><el-input v-model="input" placeholder="请输入门店名称" style="width:20%"/></div>
                  </div>
                  <div>选择店长</div>
                  <el-select v-model="value" placeholder="请选择" @change="handleChange" >
                    <el-option v-for="item in socialData" :key="item._id" :label="item.name" :value="item._id"> </el-option>
                  </el-select>

                  <el-form-item label="图片" >
                    <el-upload class="upload-demo" action="/api/marketing/picture"
                               :on-preview="handlePreview" :on-remove="handleRemove" :before-remove="beforeRemove" multiple :limit="3"
                               :on-exceed="handleExceed" :file-list="fileList">
                      <el-button size="small" type="primary">点击上传</el-button>
<!--                      <div slot="tip" class="el-upload__tip">只能上传jpg/png文件，且不超过500kb</div>-->
                    </el-upload>
                  </el-form-item>
                  <div>111</div>
                  <div style="height: 100px;">
                    111
                    <v-distpicker province="山东省" city="烟台市" area="莱山区"></v-distpicker>
                    <div>
<!--                      你当前选的的地址:{{fullAddress}}-->222
                    </div>
                  </div>

                </div>
              </el-dialog>
            </div>

            <div style="border: 1px solid blue;margin-top: 20px;">
              <el-table
                  ref="multipleTableRef"
                  style="width: 100%"
                  border
                  :data="tableData"
              >
                <el-table-column type="selection" width="55" align="center" ></el-table-column>
                <el-table-column label="编号" property="storenumber" sortable min-width="100" align="center" />
                <el-table-column property="storename" label="门店名称"  min-width="170px" align="center" />
                <el-table-column property="address" label="地址" show-overflow-tooltip min-width="250px" align="center" />
                <el-table-column property="stroeown" label="店长"  min-width="150px" align="center"/>
                <el-table-column property="employeesname" label="店员"  min-width="170px" align="center"/>
                <el-table-column property="picture" label="图片"  min-width="120px" align="center">
                  <template #default="scope">
                    <div class="demo-image__preview" style="display: flex; align-items: center">
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
                <el-table-column property="operation" label="操作"  min-width="250px" align="center">
                  <el-button size="small" type="primary"><el-icon><Reading /></el-icon>课程</el-button>
                  <el-button size="small" type="primary"><el-icon><EditPen /></el-icon>编辑</el-button>
                  <el-button size="small" type="primary"><el-icon><Delete /></el-icon>删除</el-button>
                </el-table-column>
              </el-table>
            </div>
          </div>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>
import {
  Menu as IconMenu, PieChart, Coin, House, Calendar, User, Edit, Setting, Files, Operation, DArrowRight, DArrowLeft, Fold,
  ChromeFilled, Refresh,Bell, Help, Discount, Sort,ArrowDown,Van,HomeFilled,Search,Reading,EditPen,Delete
} from '@element-plus/icons-vue'
import axios from "axios";
import {ElLoading, ElMessage} from "element-plus";
import router from "@/router";
import {useRoute} from "vue-router/dist/vue-router";
// import VDistpicker from 'v-distpicker'

let aname;
export default {
  name: "myStore",
  emits:['myself'],
  setup () {
    let route = useRoute();
    aname = route.query.adminname;
    return {
      adminname: aname,
    }
  },

  components: {
    // eslint-disable-next-line vue/no-unused-components
    IconMenu, PieChart, Coin, House, Calendar, User, Edit, Setting, Files, Operation, DArrowLeft, DArrowRight, Fold,
    ChromeFilled, Refresh, Bell,Help, Discount, Sort, ArrowDown, Van,HomeFilled,Search,Reading,EditPen,Delete,
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
        /*socialData:[],
        value:''*/
        selected:{
          province:"山东省",
          city:"烟台市",
          area:"莱山区"
        }
      }],
      pList: new Map(),
    }
  },
  mounted() {
    this.getAllproData()
    this.getAllPermission()
  },
  computed:{
    fullAddress:function(){
      return this.selected.province +"-"+ this.selected.city +"-"+ this.selected.area
    }
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
        for (let i=0;i<res.data.data.length;i++)
        {
          const obj = new Object();
          obj.storenumber=res.data.data[i].storeNumber;
          obj.storename=res.data.data[i].storeName
          obj.address=res.data.data[i].address
          obj.stroeown=res.data.data[i].storeManagerName
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

            // obj.employees=respone.data.data.content[i].name
            // obj.employees=respone.data.data.content.name
            //   this.tableData.employees=respone.data.data.content;
            //   obj.employees=respone.data.data.content[j].name
            // console.log(respone.data.data.content.length)
            for(let j=0;j<respone.data.data.content.length;j++){
              // const objj = new Object();
              obj.employeesname=respone.data.data.content[j].name
              // console.log(obj.employeesname)
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
    onSelected(data){
      const {province,city,area} = data;
      if(!province.code && !city.code && !city.code) return;
      this.selected.province = province.value;
      this.selected.city = city.value;
      this.selected.area = area.value;
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