<template>
  <div class="main">
    <div v-if="courseNoReservation.length == 0" class="if">
      您没有未预约的订单！
    </div>
    <el-card
      v-else
      class="my-card"
      v-for="item in courseNoReservation"
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
        </div>
        <div class="right">
          <div class="information-text">未预约</div>
          <el-button type="primary" @click="openDialog(item)">预约</el-button>
        </div>
      </div>
    </el-card>
  </div>

  <el-dialog v-model="showReservationDialog" title="预约面板" width="500px">
    <el-form :model="reservationForm" label-width="150px">
      <el-form-item label="预约课程">
        <el-label>{{ reservationForm.courseName }}</el-label>
      </el-form-item>
      <el-form-item label="预约门店">
        <el-select v-model="reservationForm.storeId" placeholder="请选择门店">
          <el-option
            v-for="item in storeList"
            :key="item.id"
            :label="item.storeName"
            :value="item.id"
          ></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="预约日期">
        <el-date-picker
          v-model="reservationForm.reservationTime"
          type="date"
          format="YYYY/MM/DD"
          value-format="YYYY-MM-DD"
          placeholder="选择预约时间"
        ></el-date-picker>
      </el-form-item>
      <el-form-item label="预约时间段">
        <el-select
          v-model="reservationForm.reservationNumber"
          placeholder="请选择时间段"
        >
          <el-option
            v-for="item in courseTimeConfig"
            :key="item.id"
            :label="课程时间段"
            :value="item.time"
          ></el-option>
        </el-select>
      </el-form-item>
    </el-form>
    <span class="dialog-footer">
      <el-button @click="showReservationDialog = false">取 消</el-button>
      <el-button type="primary" @click="createReservation">确 定</el-button>
    </span>
  </el-dialog>
</template>

<script>
import axios from "axios";
export default {
  data() {
    return {
      showReservationDialog: false,
      baseURL: axios.defaults.baseURL,
      courseTimeConfig: [
        {
          id: 1,
          time: "09:00-11:00",
        },
        {
          id: 2,
          time: "13:30-15:30",
        },
        {
          id: 3,
          time: "16:00-18:00",
        },
        {
          id: 4,
          time: "19:30-21:30",
        },
      ],
      courseNoReservation: [
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
        },
      ],
      storeList: [
        {
          id: 0,
          storeNumber: "string",
          storeName: "string",
          type: "string",
          storeManagerId: 0,
          storeManagerName: "string",
          address: "string",
          pictureUrl: "string",
          summary: "string",
        },
      ],
      reservationForm: {
        courseName: "string",
        orderDetailId: "",
        storeId: "",
        reservationTime: "",
        reservationNumber: "",
      },
    };
  },
  mounted() {
    this.courseNoReservation = [];
    this.getCourseNoReservation();
    this.getAllStoreList();
  },
  methods: {
    getCourseNoReservation() {
      axios({
        method: "get",
        url: "/order/getNoReservationsOrderGoods",
      }).then((response) => {
        if (response.data.status == 0) {
          this.courseNoReservation = response.data.data;
          console.log(this.courseNoReservation);
        } else {
          this.$message.error(response.data.message);
          this.courseNoReservation = [];
        }
      });
    },
    createReservation() {
      console.log(this.reservationForm);
      if (
        this.reservationForm.storeId == "" ||
        this.reservationForm.reservationTime == "" ||
        this.reservationForm.reservationNumber == ""
      ) {
        this.$message({
          message: "请填写完整信息！",
          type: "warning",
        });
        return;
      }
      for (let i = 0; i < this.courseTimeConfig.length; ++i) {
        if (
          this.reservationForm.reservationNumber ==
          this.courseTimeConfig[i].time
        ) {
          this.reservationForm.reservationNumber = this.courseTimeConfig[i].id;
          break;
        }
      }
      axios({
        method: "post",
        url: "/order/userCreateReservations",
        params: {
          orderDetailId: this.reservationForm.orderDetailId,
          storeId: this.reservationForm.storeId,
          time: this.reservationForm.reservationTime,
          group: this.reservationForm.reservationNumber,
        },
      }).then((response) => {
        if (response.data.status == 0) {
          this.$message({
            message: "预约成功！",
            type: "success",
          });
          this.showReservationDialog = false;
          this.getCourseNoReservation();
        } else {
          this.$message({
            message: response.data.message,
            type: "error",
          });
        }
      });
    },
    getAllStoreList() {
      axios({
        method: "get",
        url: "/course/getStoreList",
      }).then((response) => {
        this.storeList = response.data.data;
      });
    },
    openDialog(item) {
      this.reservationForm.courseName = item.courseName;
      this.reservationForm.orderDetailId = item.orderDetailId;
      this.showReservationDialog = true;
    },
  },
};
</script>

<style scoped>
.main {
  width: 70%;
}
.if {
  text-align: center;
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
.dialog-footer {
  display: block;
  text-align: center;
}
</style>
