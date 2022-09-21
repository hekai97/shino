<!--已经上完课的页面-->
<template>
  <div class="main">
    <div v-if="courseAlreadyDoneList.length == 0">您没有已经完成的订单！</div>
    <el-card
      v-else
      class="my-card"
      v-for="item in courseAlreadyDoneList"
      :key="item.id"
    >
      <div class="content">
        <div class="left">
          <el-image :src="baseURL + item.pictureUrl"></el-image>
        </div>
        <div class="middle">
          <div class="title">
            <b>{{ item.courseName }}</b>
          </div>
          <div class="detail">
            分类：{{ item.categoryName }} | 价格：￥{{ item.price }}
          </div>
          <div class="detail">
            上课时间：{{ item.courseReservation.date }}
            {{ item.courseReservation.orderBeginTime }} -
            {{ item.courseReservation.orderEndTime }}
          </div>
        </div>
        <div class="right">
          <div class="information-text">已完成</div>
          <el-button type="primary" @click="showDetail(item.id)"
            >查看详情</el-button
          >
        </div>
      </div>
    </el-card>
  </div>
  <el-dialog v-model="showDialog">
    <LabelValue
      :label="'课程名称'"
      :value="courseAlreadyDoneList[selectedItemId].courseName"
    ></LabelValue>
    <LabelValue
      :label="'预约日期'"
      :value="courseAlreadyDoneList[selectedItemId].courseTable.reservationDate"
    ></LabelValue>
    <LabelValue
      :label="'开始时间'"
      :value="courseAlreadyDoneList[selectedItemId].courseTable.beginTime"
    ></LabelValue>
    <LabelValue
      :label="'结束时间'"
      :value="courseAlreadyDoneList[selectedItemId].courseTable.endTime"
    ></LabelValue>
    <LabelValue
      :label="'商店名称'"
      :value="courseAlreadyDoneList[selectedItemId].courseTable.storeName"
    ></LabelValue>
    <LabelValue
      :label="'教师名称'"
      :value="courseAlreadyDoneList[selectedItemId].courseTable.teacherName"
    ></LabelValue>
    <LabelValue
      :label="'核销码'"
      :value="courseAlreadyDoneList[selectedItemId].writeOffCodeNumber"
    ></LabelValue>
    <el-button style="margin: 0 auto" type="primary" @click="showDialog = false"
      >确 定</el-button
    >
  </el-dialog>
</template>

<script>
import axios from "axios";
import LabelValue from "../components/LabelValue.vue";
export default {
  components: {
    LabelValue,
  },
  data() {
    return {
      selectedItemId: 0,
      showDialog: false,
      baseURL: axios.defaults.baseURL,
      courseAlreadyDoneList: [
        {
          id: 0,
          courseId: 0,
          orderDetailId: 0,
          writeOffCodeNumber: "string",
          reserveId: 0,
          courseTableId: 0,
          orderId: 0,
          orderNumber: "string",
          price: 0,
          categoryName: "string",
          courseName: "string",
          pictureUrl: "/images/courses/bread.jpg",
          courseReservation: {
            id: 0,
            courseId: 0,
            storeId: 0,
            date: "2022-09-19",
            beginTime: "08:00:00",
            endTime: "10:00:00",
            arrangementDate: "2022-09-19T01:31:48.568Z",
            orderBeginTime: "2022-09-19T01:31:48.568Z",
            orderEndTime: "2022-09-19T01:31:48.568Z",
            orderId: 0,
            operateTime: "2022-09-19T01:31:48.568Z",
            display: 0,
            startTime: "2022-09-19T01:31:48.568Z",
            state: 0,
          },
          courseTable: {
            id: 0,
            storeId: 0,
            storeName: "string",
            courseId: 0,
            courseName: "string",
            teacherId: 0,
            teacherName: "string",
            userId: 0,
            userName: "string",
            createTime: "string",
            reservationDate: "2022-09-19",
            beginTime: "13:30:00",
            endTime: "15:30:00",
          },
        },
      ],
    };
  },
  mounted() {
    this.getUserAlreadyDoneList();
  },
  methods: {
    getUserAlreadyDoneList() {
      axios({
        method: "get",
        url: "order/getReservationsOrderGoods",
      }).then((response) => {
        if (response.data.status == 0) {
          let obj = new Array();
          for (let i = 0; i < response.data.data.length; i++) {
            if (response.data.data[i].courseReservation.status == 1) {
              obj.push(response.data.data[i]);
            }
          }
          if (obj.length > 0) {
            this.courseAlreadyDoneList = obj;
          } else {
            this.courseAlreadyDoneList = [];
          }
        } else {
          this.$message.error(response.data.message);
          this.courseAlreadyDoneList = [];
        }
      });
    },
    showDetail(id) {
      this.selectedItemId = id;
      this.showDialog = true;
    },
  },
};
</script>

<style scoped>
.main {
  width: 70%;
}
.my-card {
  width: 100%;
  margin: 10px 0 0 0;
}
.content {
  width: 100%;
  display: flex;
  /* border: 1px solid #ebeef5; */
}
.left {
  width: 20%;
}
.middle {
  width: 50%;
}
.right {
  width: 30%;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}
.title {
  text-align: center;
}
.detail {
  text-align: center;
}
.information-text {
  margin: 0 0 20% 0;
}
</style>
