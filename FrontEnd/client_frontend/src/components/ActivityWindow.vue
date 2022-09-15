<template>
    <div class="dialog">
      <div class="left"></div>
      <div class="right">
        <h2>金情物语</h2>
        <div class="detail">
          <div>商品类型：{{this.detail.courseTypeName}}</div>
          <div>课程分类：</div>
          <div>课程原价：</div>
          <div>课程现价：</div>
          <div>课程内容：</div>
          <div>课程时长：</div>
          <div>课程积分：</div>
          <div>课程等级：</div>
          <div>课程创建时间：</div>
        </div>
        <div class="button">
          <el-button-group>
            <el-button type="primary" icon="el-icon-shopping-cart-full" style="background-color:orangered;">加入购物车</el-button>
            <el-button type="primary" style="background-color:orangered;">立即下单</el-button>
          </el-button-group>
        </div>
      </div>
    </div>
</template>
<script>
export default {
  name:'ActivityWindow',
  props:{
    detail:{
      type:Object,
      default:function() {
        return {

        }
      }
    }
  },
  data(){
    return{
      dialogVisible: false,
    }
  },
  mounted() {
    console.log('xxxxs',this.info)
  },
  methods:{
    handleClose(done) {
      this.$confirm('确认关闭？')
        .then(_ => {
          done();
        })
        .catch(_ => {});
    }
  }
}
</script>
<style scoped>
  .dialog{
    width: 100%;
  }
  .left{
    width:60%;
    height: 300px;
    background-color: rosybrown;
    float: left;
    display: inline-block;
  }
  .right{
    width: 40%;
    height: 300px;
    overflow: auto;
    background-color: darkseagreen;
    display: inline-block;
  }
  .detail{
    text-align: left;
  }
  .button{
    display: flex;
    padding-top: 25px;
  }
  .el-button-group{
    align-self: center;
    margin: auto;
  }
</style>
