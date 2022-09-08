<template>
  <el-container>
    <el-header>
      <div class="menu">
        <el-menu :default-active="activeIndex" class="el-menu-demo" mode="horizontal" @select="handleSelect">
          <el-menu-item index="1">网站首页</el-menu-item>
          <el-menu-item index="2"></el-menu-item>
          <el-menu-item index="3">店铺展示</el-menu-item>
          <el-menu-item index="4">课程展示</el-menu-item>
          <el-menu-item index="5"><a href="https://www.ele.me" target="_blank">新闻资讯</a></el-menu-item>
          <el-menu-item index="6">关于我们</el-menu-item>
          <el-menu-item index="7">个人中心</el-menu-item>
        </el-menu>
      </div>
    </el-header>
    <el-main>
      <div>
        <el-carousel trigger="click" height="450px">
          <el-carousel-item v-for="item in imgList" :key="item.id">
            <img :src="item.url" alt=""/>
          </el-carousel-item>
        </el-carousel>
      </div>
      <div class="mid">
        <h1>优惠活动</h1>
        <div class="img0"></div>
        <div class="img1"></div>
        <div class="img2"></div>
        <div class="img3"></div>
      </div>
      <div class="bottom">
        <h1>课程展示</h1>
        <div class="img4"></div>
        <div class="img5"></div>
        <div class="img6"></div>
        <div class="img7"></div>
      </div>
      <div class="end">
        <h1>店铺展示</h1>
        <div class="out">
          <div class="son"></div>
          <div class="son"></div>
          <div class="son"></div>
          <div class="son"></div>
        </div>
      </div>
      <div class="footer">
        <h1 class="title">五百多家连锁店遍布全国，快来联系我们学习吧！</h1>
      </div>
    </el-main>
  </el-container>
</template>
<script>
  export default {
    data(){
      return{
        activeIndex: '1',
        activeIndex2: '1',
        imgList:[
          {id:0,url:require('../assets/6ad79cc7fea95496c878c6ab112e6ea7.jpeg')},
          {id:1,url:require('../assets/491c2f52033045633864a5ec2c1eba9b.jpeg' )}
        ],
      }
    },
    methods:{
      handleSelect(key, keyPath) {
        console.log(key, keyPath);
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
  .menu{
    text-align:center;
  }
  .el-menu{
    display: inline-block;
  }
  .mid{
    width: 100%;
  }
  .end{
    width: 100%;
    color: white;
    padding-top: 150px;
    background-color: rgba(0,0,0,0.8);
    height: 400px;
  }
  .img0{
    width: 25%;
    background-color: red;
    float: left;
    height: 150px;
  }
  .img1{
    width: 25%;
    background-color: orangered;
    float: left;
    height: 150px;
  }
  .img2{
    width: 25%;
    background-color: yellow;
    float: left;
    height: 150px;
  }
  .img3{
    width: 25%;
    background-color: green;
    float: left;
    height: 150px;
  }
  .img4{
    width: 25%;
    background-color: cornflowerblue;
    float: left;
    height: 150px;
  }
  .img5{
    width: 25%;
    background-color: palevioletred;
    float: left;
    height: 150px;
  }
  .img6{
    width: 25%;
    background-color: lightseagreen;
    float: left;
    height: 150px;
  }
  .img7{
    width: 25%;
    background-color: rosybrown;
    float: left;
    height: 150px;
  }
  .out{
    margin-left: 10%;
  }
  .son{
    border: solid white 1px;
    width: 20%;
    height: 200px;
    float: left;
  }
  .bottom{
    margin-top: 200px;
  }
  .footer{
    width: 100%;
    height: 150px;
    background-color: rgba(0,0,0,0.4);
  }
</style>
