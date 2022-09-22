<template>
  <div class="suggestion-area">
    <el-input v-model="suggestion.question" placeholder="请输入问题"></el-input>
    <el-input
      v-model="suggestion.description"
      placeholder="请输入问题描述"
      :rows="5"
      type="textarea"
    ></el-input>
    <el-button type="primary" class="submit-button" @click="submitSuggestion"
      >提交</el-button
    >
  </div>
</template>
<script>
import axios from "axios";

export default {
  data() {
    return {
      suggestion: {
        phone: "",
        question: "",
        description: "",
      },
    };
  },
  mounted() {
    this.getUserinfo();
  },
  methods: {
    getUserinfo() {
      axios({
        method: "post",
        url: "/student/getUserInfo",
      }).then((res) => {
        if (res.data.status == 0) {
          this.suggestion.phone = res.data.data.phoneNumber;
        } else {
          this.$message.error(res.data.message);
        }
      });
    },
    submitSuggestion() {
      console.log(this.suggestion);
      if (this.suggestion.question == "" || this.suggestion.description == "") {
        this.$message.error("请填写完整信息");
        return;
      }
      axios({
        method: "post",
        url: "/suggest/createSuggest",
        data: this.suggestion,
      }).then((res) => {
        if (res.data.status == 0) {
          this.$message.success("提交成功");
          this.suggestion.question = "";
          this.suggestion.description = "";
        } else {
          this.$message.error(res.data.message);
        }
      });
    },
  },
};
</script>
<style scoped>
.suggestion-area {
  width: 50%;
  margin: 0 auto;
}
.submit-button {
  margin-left: 45%;
  margin-top: 20px;
}
</style>
