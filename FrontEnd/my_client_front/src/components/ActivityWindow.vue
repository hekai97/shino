<template>
  <div class="dialog">
    <div class="left">
      <el-image :src="baseUrl + detail.pictureUrl"></el-image>
    </div>
    <div class="right">
      <h2>金情物语</h2>
      <div class="detail">
        <div>商品类型：{{ detail.courseTypeName }}</div>
        <div>课程分类：{{ detail.courseCategoryName }}</div>
        <div>课程原价：{{ detail.coursePrice }}</div>
        <div>课程现价：{{ detail.coursePrice }}</div>
        <div>课程内容：{{ detail.courseContent }}</div>
        <div>课程时长：120分钟</div>
        <div>课程积分：{{ detail.coursePoints }}</div>
        <div>课程等级：{{ detail.courseLevel }}</div>
        <div>课程创建时间：{{ detail.createdTime }}</div>
      </div>
      <div class="button">
        <el-button-group>
          <el-button
            type="primary"
            icon="el-icon-shopping-cart-full"
            style="background-color: orangered"
            >加入购物车</el-button
          >
          <el-button type="primary" style="background-color: orangered"
            >立即下单</el-button
          >
        </el-button-group>
      </div>
    </div>
  </div>
</template>
<script>
import axios from "axios";
export default {
  name: "ActivityWindow",
  props: {
    detail: {
      type: Object,
      default: function () {
        return {};
      },
    },
  },
  data() {
    return {
      baseUrl: axios.defaults.baseURL,
      dialogVisible: false,
    };
  },
  mounted() {
    console.log("xxxxs", this.info);
  },
  methods: {
    handleClose(done) {
      this.$confirm("确认关闭？")
        // eslint-disable-next-line no-unused-vars
        .then((_) => {
          done();
        })
        // eslint-disable-next-line no-unused-vars
        .catch((_) => {});
    },
  },
};
</script>
<style scoped>
.dialog {
  width: 100%;
}
.left {
  width: 60%;
  height: 300px;
  background-color: rosybrown;
  float: left;
  /* display: inline-block; */
  display: grid;
}
.right {
  width: 40%;
  height: 300px;
  overflow: auto;
  background-color: darkseagreen;
  display: inline-block;
}
.detail {
  text-align: left;
}
.button {
  display: flex;
  padding-top: 25px;
}
.el-button-group {
  align-self: center;
  margin: auto;
}
</style>
