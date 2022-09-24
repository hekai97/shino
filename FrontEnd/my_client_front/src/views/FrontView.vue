<template>
  <div>
    <div class="content-center">
      <el-carousel trigger="click" height="450px">
        <el-carousel-item v-for="item in imgList" :key="item.id">
          <el-image :src="item.pic" alt="" />
        </el-carousel-item>
      </el-carousel>
    </div>
    <div class="activity"><h1>优惠活动</h1></div>
    <div class="mid">
      <div class="activity">
        <div class="img0" v-for="(item, index) in activityList" :key="index">
          <el-image
            :src="baseUrl + item.pictureUrl"
            width="200px"
            height="200px"
          />
        </div>
      </div>
    </div>
    <div>
      <h1 class="course">课程展示</h1>
    </div>
    <div class="bottom">
      <div class="course">
        <div
          class="img4"
          v-for="(item, index) in courseList"
          :key="index"
          @click="goCourse"
        >
          <el-image
            v-bind:src="baseUrl + item.pictureUrl"
            width="200px"
            height="200px"
          />
        </div>
      </div>
    </div>
    <div class="end">
      <h1>店铺展示</h1>
      <div class="out">
        <div class="son" v-for="(item, index) in storeList" :key="index">
          <el-image
            v-bind:src="baseUrl + item.pictureUrl"
            width="250px"
            height="200px"
          />
        </div>
      </div>
    </div>
    <div class="footer">
      <h1 class="title">五百多家连锁店遍布全国，快来联系我们学习吧！</h1>
      <el-button>了解更多-></el-button>
    </div>
  </div>
</template>
<script>
import axios from "axios";
import pic1 from "../assets/491c2f52033045633864a5ec2c1eba9b.jpeg";
import pic2 from "../assets/6ad79cc7fea95496c878c6ab112e6ea7.jpeg";
export default {
  data() {
    return {
      imgList: [
        {
          id: 0,
          url: "@/assets/491c2f52033045633864a5ec2c1eba9b.jpeg",
          pic: pic1,
        },
        {
          id: 1,
          url: "@/assets/6ad79cc7fea95496c878c6ab112e6ea7.jpeg",
          pic: pic2,
        },
      ],
      storeList: [],
      CategoryList: [],
      courseList: [],
      activityList: [],
      baseUrl: axios.defaults.baseURL,
    };
  },
  mounted() {
    this.getStore();
    this.getCategory();
    this.getCourse();
    this.getActivity();
  },
  methods: {
    goCourse() {
      this.$router.push({
        path: "/index/course",
      });
    },
    godetail(item) {
      this.$router.push({
        path: "",
        query: {},
      });
      console.log(item.id);
    },
    getStore() {
      axios({
        method: "get",
        url: "/course/getStoreList",
      }).then((res) => {
        if (res.data.status == 0) {
          if (res.data.data.length < 4) {
            this.storeList = res.data.data;
          } else {
            for (let i = 0; i < 4; ++i) {
              this.storeList.push(res.data.data[i]);
            }
          }
        }
      });
    },
    getCategory() {
      axios({
        method: "get",
        url: "/course/getAllCourseCategory",
      }).then((res) => {
        this.CategoryList = res.data.data;
        console.log(this.CategoryList);
      });
    },
    getCourse() {
      axios({
        method: "get",
        url: "/course/getRandomCourse",
        params: {
          number: 6,
        },
      }).then((res) => {
        this.courseList = res.data.data.slice(0, 5);
        console.log(this.courseList);
      });
    },
    getActivity() {
      axios({
        method: "get",
        url: "/course/getRandomCourse",
        params: {
          number: 4,
        },
      }).then((res) => {
        this.activityList = res.data.data;
        console.log(this.activityList);
      });
    },
  },
};
</script>
<style scoped>
.activity {
  text-align: center;
}
.course {
  text-align: center;
}
.content-center {
  text-align: center;
}
.title {
  margin-top: 0px;
  padding-top: 50px;
  color: white;
}
.activity {
  width: 80%;
  margin: auto;
}
.mid {
  width: 100%;
  display: flex;
}
.end {
  width: 100%;
  color: white;
  text-align: center;
  padding-top: 10px;
  background-color: rgba(0, 0, 0, 0.9);
  /* height: 350px; */
}
.img0 {
  width: 25%;
  display: inline-flex;
  height: 200px;
}
.img4 {
  padding: 5px;
  width: 200px;
  display: inline-flex;
  height: 200px;
  margin: auto;
}
.out {
  margin: auto;
  width: 100%;
  height: 200px;
  display: inline-flex;
}
.son {
  width: 20%;
  /* height: 200px; */
  margin: auto;
}
.bottom {
  display: flex;
  margin-bottom: 20px;
  text-align: center;
}
.course {
  /* width: 100%; */
  margin: 0 auto;
}
.footer {
  width: 100%;
  height: 150px;
  text-align: center;
  background-color: rgba(0, 0, 0, 0.75);
}
</style>
