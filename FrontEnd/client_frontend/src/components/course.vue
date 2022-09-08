<template>
  <el-container>
    <el-header>
      <div class="head"></div>
    </el-header>
    <el-main>
      <div class="content">
        <div class="tab">
          <el-tabs type="border-card">
            <el-tab-pane label="分类一">
              <div class="rowone">
                <div class="colone"></div>
                <div class="coltwo"></div>
                <div class="colthree"></div>
              </div>
              <div class="rowtwo">
                <div class="colone"></div>
                <div class="coltwo"></div>
                <div class="colthree"></div>
              </div>
              <div class="rowthree">
                <div class="colone"></div>
                <div class="coltwo"></div>
                <div class="colthree"></div>
              </div>
            </el-tab-pane>
            <el-tab-pane label="分类二">分类二</el-tab-pane>
            <el-tab-pane label="分类三">分类三</el-tab-pane>
            <el-tab-pane label="分类四">分类四</el-tab-pane>
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
</template>
<script>
  export default {
    data(){
      return{
        currentPage1: 5,
        currentPage2: 5,
        currentPage3: 5,
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
  .head{
    width: 100%;
    height: 100px;
    background-color: cadetblue;
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
