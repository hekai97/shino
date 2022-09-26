<template>
  <div>
    <div class="content">
      <div class="left">
        <el-image :src="baseURL + store.pictureUrl" style="width: 500px;height: 600px;align-self: center"></el-image>
      </div>
      <div class="right">
        <div class="name">
          <h2>{{ store.storeName }}</h2>
        </div>
        <div class="detail">
          <div>门店编号：{{ store.storeNumber }}</div>
          <div>门店类型：{{ store.type }}</div>
          <div>门店地址：{{ store.address }}</div>
          <div>门店简介：{{ store.summary }}</div>
          <div>门店店长：{{ store.storeManagerName }}</div>
        </div>
      </div>
    </div>
    <div>
      <div class="other">
        <div class="open">
          <h2>本店开设的课程</h2>
        </div>
        <div class="row-one">
          <div
            class="col-one"
            v-for="item in coursePageable.content"
            :key="item.id"
            @click="showDialog(item)"
          >
            <el-image :src="baseURL + item.pictureUrl"></el-image>
          </div>
        </div>
      </div>
    </div>
    <div class="footer">
      <el-pagination
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        @prev-click="prevClick"
        @next-click="nextClick"
        :current-page="coursePageable.number + 1"
        :page-sizes="[2, 4, 6]"
        :page-size="coursePageable.size"
        :pager-count="coursePageable.totalPages"
        layout="total, sizes, prev, pager, next, jumper"
        :total="coursePageable.totalElements"
      >
      </el-pagination>
    </div>
  </div>
  <el-dialog v-model="showDialogVisible" width="60%">
    <ActivityWindow :detail="selectedItem"></ActivityWindow>
  </el-dialog>
</template>
<script>
import axios from "axios";
import ActivityWindow from "../components/ActivityWindow.vue";
export default {
  components: {
    ActivityWindow,
  },
  data() {
    return {
      showDialogVisible: false,
      selectedItem: {},
      baseURL: axios.defaults.baseURL,
      currentPage4: 4,
      store: {
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
      pageable: {
        page: 0,
        size: 6,
      },
      coursePageable: {
        totalElements: 0,
        totalPages: 0,
        size: 0,
        content: [
          {
            id: 0,
            courseCategoryId: 0,
            courseCategoryName: "string",
            courseName: "string",
            courseNumber: "string",
            courseTypeId: 0,
            courseTypeName: "string",
            coursePrice: 0,
            coursePoints: 0,
            slidePosition: 0,
            description: "string",
            courseUrl: "string",
            pictureUrl: "string",
            courseContent: "string",
            courseLevel: "string",
            isPublic: 0,
            creator: "string",
            createdTime: "string",
            updater: "string",
            updatedTime: "string",
            carouselImg: "string",
          },
        ],
        number: 0,
        sort: {
          empty: true,
          sorted: true,
          unsorted: true,
        },
        pageable: {
          offset: 0,
          sort: {
            empty: true,
            sorted: true,
            unsorted: true,
          },
          pageNumber: 0,
          pageSize: 0,
          paged: true,
          unpaged: true,
        },
        first: true,
        last: true,
        numberOfElements: 0,
        empty: true,
      },
    };
  },
  mounted() {
    this.store = JSON.parse(this.$route.query.item);
    this.getCoursesByStoreId();
  },
  methods: {
    showDialog(item) {
      this.selectedItem = item;
      this.showDialogVisible = true;
    },
    handleSizeChange(val) {
      this.pageable.size = val;
      this.getCoursesByStoreId();
      console.log(`每页 ${val} 条`);
    },
    handleCurrentChange(val) {
      this.pageable.page = val - 1;
      this.getCoursesByStoreId();
      console.log(`当前页: ${val}`);
    },
    prevClick() {
      this.pageable.page = this.pageable.page - 1;
      this.getCoursesByStoreId();
      console.log("上一页");
    },
    nextClick() {
      this.pageable.page = this.pageable.page + 1;
      this.getCoursesByStoreId();
      console.log("下一页");
    },
    getCoursesByStoreId() {
      axios({
        method: "get",
        url: "course/getCoursesPageableByStoreId",
        params: {
          storeId: this.store.id,
          page: this.pageable.page,
          size: this.pageable.size,
        },
      }).then((res) => {
        this.coursePageable = res.data.data;
        console.log(this.coursePageable);
      });
    },
  },
};
</script>
<style scoped>
.name{
  text-align: center;
}
.open{
  text-align: center;
}
.left {
  width: 50%;
  float: left;
  height: auto;
  display: flex;
  justify-content: center;
  /* background-color: skyblue; */
}
.right {
  width: 50%;
  float: right;
  height: 200px;
}
.detail {
  text-align: left;
}
.other {
  text-align: left;
}
.footer {
  margin: 0 auto;
  display: table;
}
.row-one .col-one {
  width: 25%;
  height: 150px;
  display: inline-grid;
  background-color: bisque;
}
.row-one .col-two {
  width: 25%;
  height: 150px;
  display: inline-block;
  background-color: lightblue;
}
.row-one .col-three {
  width: 25%;
  height: 150px;
  display: inline-block;
  background-color: thistle;
}
</style>
