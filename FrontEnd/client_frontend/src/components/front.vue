<template>
  <div>
    <div>
      <el-carousel trigger="click" height="450px">
        <el-carousel-item v-for="item in imgList" :key="item.id">
          <img :src="item.url" alt=""/>
        </el-carousel-item>
      </el-carousel>
    </div>
    <h1>优惠活动</h1>
    <div class="mid">
      <div class="activity">
        <div class="img0" v-for="(item,index) in activityList" :key="index">
          <img :src="baseUrl + item.pictureUrl" width="200px" height="200px">
        </div>
      </div>
    </div>
    <h1>课程展示</h1>
    <div class="bottom">
      <div class="course">
        <div class="img4" v-for="(item,index) in courseList" :key="index" @click="goCourse">
          <img v-bind:src="baseUrl+item.pictureUrl" width="200px" height="200px">
        </div>
      </div>
    </div>
    <div class="end">
      <h1>店铺展示</h1>
      <div class="out" v-for="(item,index) in storeList" :key="index">
        <div class="son">
          <img v-bind:src="baseUrl+item.pictureUrl" width="250px" height="200px">
        </div>
      </div>
    </div>
    <div class="footer">
      <h1 class="title">五百多家连锁店遍布全国，快来联系我们学习吧！</h1>
      <el-button>了解更多-></el-button>
    </div>
  </div>
</template>
<script>
  import axios from "axios";

  export default {
    data(){
      return{
        imgList:[
          {id:0,url:require('../assets/6ad79cc7fea95496c878c6ab112e6ea7.jpeg')},
          {id:1,url:require('../assets/491c2f52033045633864a5ec2c1eba9b.jpeg' )}
        ],
        storeList:[],
        CategoryList:[],
        courseList:[],
        activityList:[],
        baseUrl:axios.defaults.baseURL,
      }
    },
    mounted() {
      this.getStore()
      this.getCategory()
      this.getCourse()
      this.getActivity()
    },
    methods:{
      goCourse(){
        this.$router.push({
          path:'/course',
        })
      },
      godetail(item){
        this.$router.push({
          path:'',
          query: {

          }
        })
        console.log(item.id)
      },
      getStore(){
        this.$axios({
          method:'get',
          url:'/course/getStoreList'
        }).then((res)=>{
          this.storeList = res.data.data.slice(0,4)
          console.log(this.storeList)
        })
      },
      getCategory(){
        this.$axios({
          method:'get',
          url:'/course/getAllCourseCategory'
        }).then((res)=>{
          this.CategoryList = res.data.data
          console.log(this.CategoryList)
        })
      },
      getCourse(){
        this.$axios({
          method:'get',
          url:'/course/getRandomCourse',
          params:{
            number:6
          }
        }).then((res)=>{
          this.courseList = res.data.data
          console.log(this.courseList)
        })
      },
      getActivity(){
        this.$axios({
          method:'get',
          url:'/course/getRandomCourse',
          params:{
            number:4
          }
        }).then((res)=>{
          this.activityList = res.data.data
          console.log(this.activityList)
        })
      }
    }
  }
</script>
<style scoped>
  .title{
    margin-top: 0px;
    padding-top: 50px;
    color: white;
  }
  .activity{
    width: 80%;
    margin: auto;
  }
  .mid{
    width: 100%;
    display: flex;
  }
  .end{
    width: 100%;
    color: white;
    padding-top: 10px;
    background-color: rgba(0,0,0,0.9);
    height: 350px;
  }
  .img0{
    width: 25%;
    float: left;
    height: 200px;
  }
  .img4{
    width: 200px;
    float: left;
    height: 200px;
    margin: auto;
  }
  .out{
    margin-left: 10%;
  }
  .son{
    width: 20%;
    height: 200px;
    float: left;
  }
  .bottom{
    display: flex;
    margin-bottom: 20px;
  }
  .course{
    width: 100%;
    margin: auto;
  }
  .footer{
    width: 100%;
    height: 150px;
    background-color: rgba(0,0,0,0.75);
  }
</style>
