<template>
  <el-container>
    <el-main>
      <div class="container">
        <div class="left">
          <div>
            <div class="head">
              <h1>店铺展示</h1>
            </div>
            <div class="search">
              <el-input
                placeholder="请输入内容"
                size="small"
                prefix-icon="el-icon-search"
              >
              </el-input>
            </div>
          </div>
          <div class="row">
            <div
              class="col-one"
              v-for="item in storeListPageable.content"
              :key="item.id"
            >
              <el-image
                :src="baseURL + item.pictureUrl"
                fit="fill"
                @click="goStoreDetail(item)"
              ></el-image>
              <!-- <div>{{ item.id }}</div> -->
            </div>
            <!-- <div class="col-two"></div>
            <div class="col-three"></div> -->
          </div>
          <!-- <div class="row-0">
            <div class="col-one"></div>
            <div class="col-two"></div>
            <div class="col-three"></div>
          </div>
          <div class="row-1">
            <div class="col-one"></div>
            <div class="col-two"></div>
            <div class="col-three"></div>
          </div> -->
          <div class="footer">
            <el-pagination
              v-model="storeListPageable"
              @size-change="handleSizeChange"
              @current-change="handleCurrentChange"
              @prev-click="prevClick"
              @next-click="nextClick"
              :current-page="storeListPageable.number + 1"
              :page-sizes="[9, 18, 27, 36]"
              :page-size="storeListPageable.size"
              layout="total, sizes, prev, pager, next, jumper"
              :total="storeListPageable.totalElements"
              :pager-count="storeListPageable.totalPages"
            >
            </el-pagination>
          </div>
        </div>
        <div class="right"></div>
      </div>
    </el-main>
  </el-container>
</template>
<script>
import axios from "axios";
export default {
  data() {
    return {
      baseURL: axios.defaults.baseURL,
      currentPage4: 4,
      // 分页发送的数据格式定义
      pageable: {
        page: 0,
        size: 9,
      },
      // 分页回复的数据格式定义
      storeListPageable: {
        totalElements: 0,
        totalPages: 0,
        size: 0,
        content: [
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
    this.getStoreListPageable();
  },
  methods: {
    handleSizeChange(val) {
      this.pageable.size = val;
      this.getStoreListPageable();
      console.log(`每页 ${val} 条`);
    },
    handleCurrentChange(val) {
      this.pageable.page = val - 1;
      this.getStoreListPageable();
      console.log(`当前页: ${val}`);
    },
    prevClick() {
      this.pageable.page--;
      this.getStoreListPageable();
      console.log("prev");
    },
    nextClick() {
      this.pageable.page++;
      this.getStoreListPageable();
      console.log("next");
    },
    getStoreListPageable() {
      axios({
        method: "get",
        url: "/course/getStoresPageable",
        params: {
          page: this.pageable.page,
          size: this.pageable.size,
        },
      }).then((response) => {
        this.storeListPageable = response.data.data;
        console.log(this.storeListPageable);
      });
    },
    goStoreDetail(item) {
      this.$router.push({
        path: "/storeDetail",
        query: {
          item: JSON.stringify(item),
        },
      });
    },
  },
};
</script>
<style scoped>
.container {
  width: 100%;
}
.left {
  width: 60%;
  min-height: calc(100vh - 200px);
  float: left;
}
.right {
  width: 40%;
  float: right;
}
.head {
  float: left;
}
.footer {
  display: table;
  margin: 0 auto;
}
h1 {
  margin-top: 0px;
}
.search {
  width: 30%;
  float: right;
}
.row {
  margin-top: 50px;
}
.row-0 {
  margin-top: 15px;
}
.row .col-one {
  width: 30%;
  background-color: rosybrown;
  margin: 1% 1.5%;
  height: auto;
  display: inline-flex;
}
.row .col-two {
  width: 33%;
  height: 200px;
  background-color: darkseagreen;
  display: inline-block;
}
.row .col-three {
  width: 33%;
  background-color: darkgray;
  display: inline-block;
  height: 200px;
}
.row-0 .col-one {
  width: 33%;
  background-color: darkgray;
  height: 200px;
  display: inline-block;
}
.row-0 .col-two {
  width: 33%;
  height: 200px;
  background-color: rosybrown;
  display: inline-block;
}
.row-0 .col-three {
  width: 33%;
  background-color: darkseagreen;
  display: inline-block;
  height: 200px;
}
.row-1 {
  margin-top: 15px;
}
.row-1 .col-one {
  width: 33%;

  background-color: darkseagreen;
  height: 200px;
  display: inline-block;
}
.row-1 .col-two {
  width: 33%;
  height: 200px;
  background-color: darkgray;

  display: inline-block;
}
.row-1 .col-three {
  width: 33%;
  background-color: rosybrown;
  display: inline-block;
  height: 200px;
}
</style>
