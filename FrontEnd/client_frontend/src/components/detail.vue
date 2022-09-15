<template>
  <div>
    <div class="content">
      <div class="left">

      </div>
      <div class="right">
        <h1>上海黄埔店</h1>
        <div class="detail">
          <div>门店编号：</div>
          <div>门店类型：</div>
          <div>门店地址：</div>
          <div>门店简介：</div>
          <div>门店电话：</div>
        </div>
      </div>
    </div>
    <div>
      <div class="other">
        <h1>本店开设的课程</h1>
        <div class="row-one">
          <div class="col-one"></div>
          <div class="col-two"></div>
          <div class="col-three"></div>
        </div>
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
  </div>
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
  .left{
    width: 50%;
    float: left;
    height: 200px;
    background-color: skyblue;
  }
  .right{
    width: 50%;
    float: right;
    height: 200px;
  }
  .detail{
    text-align: left;
  }
  .other{
    text-align: left;
  }
  .row-one .col-one{
    width: 25%;
    height: 150px;
    display: inline-block;
    background-color: bisque;
  }
  .row-one .col-two{
    width: 25%;
    height: 150px;
    display: inline-block;
    background-color: lightblue;
  }
  .row-one .col-three{
    width: 25%;
    height: 150px;
    display: inline-block;
    background-color: thistle;
  }
</style>
