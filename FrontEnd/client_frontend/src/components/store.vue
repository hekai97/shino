<template>
  <el-container>
    <el-main>
      <div class="container">
        <div class="left">
          <div>
            <div class="head">
              <h1>店铺展示</h1>
            </div>
            <div class="search">
              <el-input
                placeholder="请输入内容"
                size="small"
                prefix-icon="el-icon-search">
              </el-input>
            </div>
          </div>
          <div class="row">
            <div class="col-one"></div>
            <div class="col-two"></div>
            <div class="col-three"></div>
          </div>
          <div class="row-0">
            <div class="col-one"></div>
            <div class="col-two"></div>
            <div class="col-three"></div>
          </div>
          <div class="row-1">
            <div class="col-one"></div>
            <div class="col-two"></div>
            <div class="col-three"></div>
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
        </div>
        <div class="right"></div>
      </div>
    </el-main>
  </el-container>
</template>
<script>
export default {
  data(){
    return{
      currentPage4: 4
    }
  },
  methods:{
    handleSizeChange(val) {
      console.log(`每页 ${val} 条`);
    },
    handleCurrentChange(val) {
      console.log(`当前页: ${val}`);
    }
  }
}
</script>
<style scoped>
  .container{
    width: 100%;
  }
  .left{
    width: 60%;
    min-height:calc(100vh - 200px) ;
    float: left;
  }
  .right{
    width: 40%;
    float: right;
  }
  .head{
    float: left;
  }
  h1{
    margin-top: 0px;
  }
  .search{
    width: 30%;
    float: right;
  }
  .row{
    margin-top: 50px;
  }
  .row-0{
    margin-top: 15px;
  }
  .row .col-one{
    width: 25%;
    background-color: rosybrown;
    height: 100px;
    display: inline-block;
  }
  .row .col-two{
    width: 25%;
    height: 100px;
    background-color: darkseagreen;
    display: inline-block;
  }
  .row .col-three{
    width: 25%;
    background-color: darkgray;
    display: inline-block;
    height: 100px;
  }
  .row-0 .col-one{
    width: 25%;
    background-color:darkgray ;
    height: 100px;
    display: inline-block;
  }
  .row-0 .col-two{
    width: 25%;
    height: 100px;
    background-color: rosybrown;
    display: inline-block;
  }
  .row-0 .col-three{
    width: 25%;
    background-color: darkseagreen;
    display: inline-block;
    height: 100px;
  }
  .row-1{
    margin-top: 15px;
  }
  .row-1 .col-one{
    width: 25%;

    background-color: darkseagreen;
    height: 100px;
    display: inline-block;
  }
  .row-1 .col-two{
    width: 25%;
    height: 100px;
    background-color:darkgray ;

    display: inline-block;
  }
  .row-1 .col-three{
    width: 25%;
    background-color: rosybrown;
    display: inline-block;
    height: 100px;
  }
</style>
