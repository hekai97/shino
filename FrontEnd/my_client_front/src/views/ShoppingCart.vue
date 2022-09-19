<template>
  <div v-if="unpaidOrderItem.length == 0" style="text-align: center">
    购物车中没有东西，快去下单吧！
  </div>
  <div v-else>
    <el-table :data="unpaidOrderItem">
      <!-- <el-table-column type="selection"></el-table-column> -->
      <el-table-column type="expand">
        <template #default="props">
          <div>
            <el-table :data="props.row.unpaidOrderDetail">
              <el-table-column>
                <template #default="p">
                  <el-image
                    style="width: 100px; height: 100px"
                    :src="baseURL + p.row.pictureUrl"
                    fit="fill"
                  >
                  </el-image>
                </template>
              </el-table-column>
              <el-table-column
                prop="courseName"
                label="课程名称"
              ></el-table-column>
              <el-table-column
                prop="courseType"
                label="课程类别"
              ></el-table-column>
              <el-table-column
                prop="categoryName"
                label="课程分类"
              ></el-table-column>
              <el-table-column prop="price" label="价格"></el-table-column>
            </el-table>
          </div>
        </template>
      </el-table-column>
      <el-table-column prop="orderNumber" label="订单号"> </el-table-column>
      <el-table-column prop="statusDesc" label="状态"></el-table-column>
      <el-table-column prop="totalAmount" label="总价"></el-table-column>
      <el-table-column>
        <template #default="myrow">
          <el-button type="primary" plain @click="payOrder(myrow.row)">
            结算
          </el-button>
          <el-button type="warning" plain @click="cancelOrder(myrow.row)">
            删除
          </el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
import axios from "axios";
export default {
  data() {
    return {
      baseURL: axios.defaults.baseURL,
      unpaidOrderItem: [
        {
          id: 0,
          orderNumber: "string",
          createdTime: "2022-09-19T12:00:55.398Z",
          payTime: "2022-09-19T12:00:55.398Z",
          status: 0,
          statusDesc: "string",
          paymentWay: "string",
          totalAmount: 0,
          userId: 0,
          username: "string",
          //用来存放每个订单的订单项
          unpaidOrderDetail: [
            {
              id: 0,
              orderId: 0,
              courseId: 0,
              courseName: "string",
              courseTypeId: 0,
              courseType: "string",
              categoryName: "string",
              price: 0,
              pictureUrl: "/images/courses/bread.jpg",
            },
            {
              id: 0,
              orderId: 0,
              courseId: 0,
              courseName: "string",
              courseTypeId: 0,
              courseType: "string",
              categoryName: "string",
              price: 0,
              pictureUrl: "/images/courses/bread.jpg",
            },
          ],
        },
      ],
      payOrderEntity: {
        out_trade_no: "",
        total_amount: 0,
        subject: "",
        body: "",
      },
    };
  },
  mounted() {
    // this.getUnpaidOrderItem();
  },
  methods: {
    //获取未支付订单
    getUnpaidOrderItem() {
      axios({
        method: "post",
        url: "/order/getUserUnPaidOrderList",
      }).then((response) => {
        if (response.data.status == 0) {
          this.unpaidOrderItem = response.data.data;
          for (let i = 0; i < this.unpaidOrderItem.length; i++) {
            axios({
              method: "post",
              url: "/order/getUserOrderDetailByOrderNumber",
              data: {
                orderItemId: this.unpaidOrderItem[i].id,
              },
            }).then((res) => {
              if (res.data.status == 0) {
                this.unpaidOrderItem[i].unpaidOrderDetail = res.data.data;
              } else {
                this.$message.error(res.data.message);
              }
            });
          }
        } else {
          this.$message.error(response.data.message);
          this.unpaidOrderItem = [];
        }
      });
    },
    //取消订单
    cancelOrder(item) {
      axios({
        method: "post",
        url: "/order/cancelOrder",
        data: {
          orderItemId: item.id,
        },
      }).then((response) => {
        if (response.data.status == 0) {
          this.$message.success(response.data.message);
          this.getUnpaidOrderItem();
        } else {
          this.$message.error(response.data.message);
        }
      });
    },
    //支付订单
    payOrder(item) {
      console.log(item);
    },
  },
};
</script>
<style scoped>
.total {
  text-align: left;
  width: 100%;
}
.button {
  margin-top: 20px;
}
</style>
