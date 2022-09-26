<template>
  <div class="main">
    <div v-if="courseReservationList.length == 0" class="no">您没有预约的订单！</div>
    <el-card
      v-else
      class="my-card"
      v-for="item in courseReservationList"
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
            预约时间：{{ item.courseReservation.date }}
            {{ item.courseReservation.beginTime }} -
            {{ item.courseReservation.endTime }}
          </div>
        </div>
        <div class="right">
          <div class="information-text">已预约</div>
          <div v-if="item.courseTableId == null">等待员工排课中</div>
          <el-button
            v-else
            type="primary"
            @click="showDetail(courseReservationList.indexOf(item))"
          >
            查看详情</el-button
          >
        </div>
      </div>
    </el-card>
  </div>
  <el-dialog v-model="showDialog">
    <LabelValue
      :label="'课程名称'"
      :value="courseReservationList[selectedItemId].courseTable.courseName"
    ></LabelValue>
    <LabelValue
      :label="'预约日期'"
      :value="courseReservationList[selectedItemId].courseTable.reservationDate"
    ></LabelValue>
    <LabelValue
      :label="'开始时间'"
      :value="courseReservationList[selectedItemId].courseTable.beginTime"
    ></LabelValue>
    <LabelValue
      :label="'结束时间'"
      :value="courseReservationList[selectedItemId].courseTable.endTime"
    ></LabelValue>
    <LabelValue
      :label="'商店名称'"
      :value="courseReservationList[selectedItemId].courseTable.storeName"
    ></LabelValue>
    <LabelValue
      :label="'教师名称'"
      :value="courseReservationList[selectedItemId].courseTable.teacherName"
    ></LabelValue>
    <LabelValue
      :label="'核销码'"
      :value="courseReservationList[selectedItemId].writeOffCodeNumber"
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
      courseReservationList: [
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
    this.courseReservationList = [];
    this.getUserReservationList();
  },
  methods: {
    getUserReservationList() {
      axios({
        method: "get",
        url: "order/getReservationsOrderGoods",
      }).then((response) => {
        if (response.data.status == 0) {
          console.log(response.data.data);
          let obj = new Array();
          for (let i = 0; i < response.data.data.length; i++) {
            if (response.data.data[i].courseReservation.state == 0) {
              obj.push(response.data.data[i]);
            }
          }
          if (obj.length > 0) {
            this.courseReservationList = obj;
          } else {
            this.courseReservationList = [];
          }

          console.log(this.courseReservationList);
        } else {
          this.$message.error(response.data.message);
          this.courseReservationList = [];
        }
      });
    },
    showDetail(index) {
      this.selectedItemId = index;
      console.log(this.selectedItemId);
      this.showDialog = true;
    },
  },
};
</script>

<style scoped>
.no{
  text-align: center;
}
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
