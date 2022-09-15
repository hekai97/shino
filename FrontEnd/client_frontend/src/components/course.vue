<template>
  <div>
    <el-container>
      <el-header>
        <div class="head"></div>
      </el-header>
      <el-main>
        <div class="content">
          <div class="tab" >
            <el-tabs  type="border-card" @tab-click="getCourse">
              <el-tab-pane v-for="(item,index) in CategoryList" :key="index" :label="item.categoryName">
                <div v-for="(item,index) in courseList" :key="index" class="img" @click="showDialog(item)">
                  <img :src="baseUrl + item.pictureUrl" width="200px" height="200px">
                </div>
              </el-tab-pane>
            </el-tabs>
          </div>
          <div class="other">

          </div>
        </div>
        <div class="footer">
          <el-pagination
            @size-change="handleSizeChange"
            @current-change="handleCurrentChange"
            :current-page="currentPage4"
            :page-sizes="[100, 200, 300, 400]"
            :page-size="100"
            layout="total, sizes, prev, pager, next, jumper"
            :total="400">
          </el-pagination>
        </div>
        <div class="call">
          <h1 class="title">五百多家连锁店遍布全国，快来联系我们学习吧！</h1>
        </div>
      </el-main>
    </el-container>
    <el-dialog
      :visible.sync="dialogVisible"
      width="60%"
      :before-close="handleClose"
    >
      <ActivityWindow :detal="detail"></ActivityWindow>
    </el-dialog>
  </div>
</template>
<script>
import ActivityWindow from "./ActivityWindow";
import axios from "axios";
  export default {
    components:{
      ActivityWindow
    },
    data(){
      return{
        activeIndex:'/course',
        CategoryList:[],
        courseList:[],
        dialogVisible: false,
        baseUrl:axios.defaults.baseURL,
        currentPage4: 4,
        detail:{
          courseTypeName:'',
          courseCategoryName:'',
          coursePrice:'',
          courseContent:'',
          courseLevel:'',
          coursePoints:'',
          createdTime:''
        }
      }
    },
    mounted() {
      this.getCategory()
      this.getCourse()
    },
    methods:{
      showDialog(item){
        this.dialogVisible = true
        this.detail.courseTypeName = item.courseTypeName
        this.detail.courseCategoryName = item.courseCategoryName
        this.detail.coursePrice = item.coursePrice
        this.detail.courseContent = item.courseContent
        this.detail.courseLevel = item.courseLevel
        this.detail.coursePoints = item.coursePoints
        this.detail.createdTime = item.createdTime
        console.log('bbbb',this.detail)
      },
      async getCategory(){
        this.$axios({
          method:'get',
          url:'/course/getAllCourseCategory'
        }).then((res)=>{
          this.CategoryList = res.data.data
          console.log(this.CategoryList)
        })
      },
      getCourse(item) {
        var index = 1
        if(item == null){
          index = 1
          console.log(index)
        }else {
          index = this.CategoryList[item.index].id
          console.log(index)
        }
        this.$axios({
          method:'get',
          url:'/course/getCoursesPageableByCategoryId',
          params:{
            id: index
          }
        }).then((res)=>{
          this.courseList = res.data.data.content
          console.log('哈哈哈哈哈哈哈哈哈',this.courseList)
        })
      },
      handleSizeChange(val) {
        console.log(`每页 ${val} 条`);
      },
      handleCurrentChange(val) {
        console.log(`当前页: ${val}`);
      },
      handleClose(done) {
        this.$confirm('确认关闭？')
          .then(_ => {
            done();
          })
          .catch(_ => {});
      }
    },
  }
</script>
<style scoped>
  .head{
    width: 100%;
    height: 100px;
    background-color: cadetblue;
  }
  .img{
    display: inline-block;
    float: left;
  }
  .content{
    width: 100%;
  }
  .tab{
    width: 75%;
    overflow: auto;
    float: left;
    background-color: lightseagreen;
  }
  .other{
    width: 25%;
    float: right;
    height: 533px;
    background-color: rosybrown;
  }
  .rowone .colone{
    width: 25%;
    height: 150px;
    display: inline-block;
    background-color: bisque;
  }
  .rowone .coltwo{
    width: 25%;
    height: 150px;
    display: inline-block;
    background-color: lightblue;
  }
  .rowone .colthree{
    width: 25%;
    height: 150px;
    display: inline-block;
    background-color: thistle;
  }
  .rowtwo .colone{
    width: 25%;
    height: 150px;
    display: inline-block;
    background-color: thistle;
  }
  .rowtwo .coltwo{
    width: 25%;
    height: 150px;
    display: inline-block;
    background-color: darkgray;
  }
  .rowtwo .colthree{
    width: 25%;
    height: 150px;
    display: inline-block;
    background-color: cornflowerblue;
  }
  .rowthree .colone{
    width: 25%;
    height: 150px;
    display: inline-block;
    background-color: darkseagreen;
  }
  .rowthree .coltwo{
    width: 25%;
    height: 150px;
    display: inline-block;
    background-color: thistle;
  }
  .rowthree .colthree{
    width: 25%;
    height: 150px;
    display: inline-block;
    background-color: peachpuff;
  }
  .footer{
    width: 100%;
    height: 50px;
    display: flex;
  }
  .el-pagination{
    margin: auto;
    align-self: center;
  }
  .call{
    width: 100%;
    height: 150px;
    display: flex;
    background-color: rgba(0,0,0,0.4);
  }
  .title{
    align-self: center;
    margin:auto;
    color: white;
  }
</style>
