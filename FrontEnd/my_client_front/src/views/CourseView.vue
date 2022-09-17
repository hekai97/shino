<template>
  <div>
    <el-container>
      <el-header>
        <div class="head"></div>
      </el-header>
      <el-main>
        <div class="content">
          <div class="tab">
            <el-tabs type="border-card" @tab-click="tabChange">
              <el-tab-pane
                v-for="(item, index) in CategoryList"
                :key="index"
                :label="item.categoryName"
              >
                <div
                  v-for="(item, index) in coursePageable.content"
                  :key="index"
                  class="img"
                  @click="showDialog(item)"
                >
                  <el-image :src="baseUrl + item.pictureUrl" fit="cover" />
                </div>
              </el-tab-pane>
            </el-tabs>
          </div>
          <div class="other"></div>
        </div>
        <div class="footer">
          <el-pagination
            v-model="coursePageable"
            @size-change="handleSizeChange"
            @current-change="handleCurrentChange"
            :current-page="coursePageable.number + 1"
            :page-sizes="[10, 20, 30, 40]"
            :page-size="coursePageable.size"
            layout="total, sizes, prev, pager, next, jumper"
            :total="coursePageable.totalElements"
            :paper-count="coursePageable.totalPages"
            @prev-click="prevClick"
            @next-click="nextClick"
          >
          </el-pagination>
        </div>
        <div class="call">
          <h1 class="title">五百多家连锁店遍布全国，快来联系我们学习吧！</h1>
        </div>
      </el-main>
    </el-container>
    <el-dialog v-model="dialogVisible" width="60%" :before-close="handleClose">
      <ActivityWindow :detail="detail"></ActivityWindow>
    </el-dialog>
  </div>
</template>
<script>
import ActivityWindow from "../components/ActivityWindow.vue";
import axios from "axios";
export default {
  components: {
    ActivityWindow,
  },
  data() {
    return {
      activeIndex: "/course",
      CategoryList: [],
      courseList: [],

      //分页发送的数据定义
      pageable: {
        currentCategoryIndex: -1,
        page: 0,
        size: 20,
      },
      // 分页回复的数据格式定义
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
        numberOfElements: 0,
        first: true,
        last: true,
        empty: true,
      },

      dialogVisible: false,
      baseUrl: axios.defaults.baseURL,
      detail: {
        courseTypeName: "",
        courseCategoryName: "",
        coursePrice: "",
        courseContent: "",
        courseLevel: "",
        coursePoints: "",
        createdTime: "",
        pictureUrl: "",
      },
    };
  },
  async mounted() {
    await this.getCategory();
    this.getCourse();
  },
  methods: {
    showDialog(item) {
      this.dialogVisible = true;
      this.detail.courseTypeName = item.courseTypeName;
      this.detail.courseCategoryName = item.courseCategoryName;
      this.detail.coursePrice = item.coursePrice;
      this.detail.courseContent = item.courseContent;
      this.detail.courseLevel = item.courseLevel;
      this.detail.coursePoints = item.coursePoints;
      this.detail.createdTime = item.createdTime;
      this.detail.pictureUrl = item.pictureUrl;
      console.log("bbbb", this.detail);
    },
    async getCategory() {
      axios({
        method: "get",
        url: "/course/getAllCourseCategory",
      }).then((res) => {
        this.CategoryList = res.data.data;
        console.log(this.CategoryList);
      });
    },
    tabChange(item) {
      console.log("当前选中的分类是：", item.index);
      this.pageable.currentCategoryIndex = item.index;
      this.pageable.page = 0;
      this.pageable.size = 20;
      this.getCourse();
    },
    getCourse() {
      //-1是因为首次加载时没有数据，因此用指明这是第一次加载，此时会拿到分类id为1的数据，这个方法过于取巧，
      //表明在如果分类id没有1的时候会没有数据，因此，该方法不可取，但是，这里没办法，只能这样
      let categoryId = -1;
      if (this.pageable.currentCategoryIndex != -1) {
        console.log(this.CategoryList);
        categoryId = this.CategoryList[this.pageable.currentCategoryIndex].id;
        // console.log(myid);
      } else {
        categoryId = 1;
      }
      axios({
        method: "get",
        url: "/course/getCoursesPageableByCategoryId",
        params: {
          page: this.pageable.page,
          size: this.pageable.size,
          id: categoryId,
        },
      }).then((res) => {
        // this.courseList = res.data.data.content;
        // console.log("哈哈哈哈哈哈哈哈哈", this.courseList);
        this.coursePageable = res.data.data;
        console.log("数据为", this.coursePageable);
      });
    },
    handleSizeChange(val) {
      this.pageable.size = val;
      this.getCourse();
      console.log(`每页 ${val} 条`);
    },
    handleCurrentChange(val) {
      this.pageable.page = val - 1;
      this.getCourse();
      console.log(`当前页: ${val}`);
    },
    handleClose(done) {
      this.$confirm("确认关闭？")
        // eslint-disable-next-line no-unused-vars
        .then((_) => {
          done();
        })
        // eslint-disable-next-line no-unused-vars
        .catch((_) => {});
    },
    prevClick() {
      this.pageable.page--;
      this.getCourse();
      console.log("上一页");
    },
    nextClick() {
      this.pageable.page++;
      this.getCourse();
      console.log("下一页");
    },
  },
};
</script>
<style scoped>
.head {
  width: 100%;
  height: 100px;
  background-color: cadetblue;
}
.img {
  display: inline-flex;
  width: 200px;
  height: 200px;
}
.content {
  width: 100%;
}
.tab {
  width: 75%;
  overflow: auto;
  float: left;
  background-color: lightseagreen;
}
.other {
  width: 25%;
  float: right;
  height: 533px;
  background-color: rosybrown;
}
.rowone .colone {
  width: 25%;
  height: 150px;
  display: inline-block;
  background-color: bisque;
}
.rowone .coltwo {
  width: 25%;
  height: 150px;
  display: inline-block;
  background-color: lightblue;
}
.rowone .colthree {
  width: 25%;
  height: 150px;
  display: inline-block;
  background-color: thistle;
}
.rowtwo .colone {
  width: 25%;
  height: 150px;
  display: inline-block;
  background-color: thistle;
}
.rowtwo .coltwo {
  width: 25%;
  height: 150px;
  display: inline-block;
  background-color: darkgray;
}
.rowtwo .colthree {
  width: 25%;
  height: 150px;
  display: inline-block;
  background-color: cornflowerblue;
}
.rowthree .colone {
  width: 25%;
  height: 150px;
  display: inline-block;
  background-color: darkseagreen;
}
.rowthree .coltwo {
  width: 25%;
  height: 150px;
  display: inline-block;
  background-color: thistle;
}
.rowthree .colthree {
  width: 25%;
  height: 150px;
  display: inline-block;
  background-color: peachpuff;
}
.footer {
  width: 100%;
  height: 50px;
  display: flex;
}
.el-pagination {
  margin: auto;
  align-self: center;
}
.call {
  width: 100%;
  height: 150px;
  display: flex;
  background-color: rgba(0, 0, 0, 0.4);
}
.title {
  align-self: center;
  margin: auto;
  color: white;
}
</style>
