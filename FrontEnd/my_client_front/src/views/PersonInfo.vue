<template>
  <div class="content">
    <h1>个人信息</h1>
    <div class="form">
      <el-form ref="form" :model="userInfo" label-width="80px">
        <el-form-item label="用户名">
          <el-input v-if="canModify" v-model="userInfo.username"></el-input>
          <el-input v-else disabled v-model="userInfo.username"></el-input>
        </el-form-item>
        <el-form-item label="姓名">
          <el-input v-if="canModify" v-model="userInfo.name"></el-input>
          <el-input v-else disabled v-model="userInfo.name"></el-input>
        </el-form-item>
        <el-form-item label="邮箱">
          <el-input v-if="canModify" v-model="userInfo.email"></el-input>
          <el-input v-else disabled v-model="userInfo.email"></el-input>
        </el-form-item>
        <el-form-item label="手机号码">
          <el-input v-if="canModify" v-model="userInfo.phoneNumber"></el-input>
          <el-input v-else disabled v-model="userInfo.phoneNumber"></el-input>
        </el-form-item>
        <el-form-item label="性别">
          <el-select
            placeholder="请选择性别"
            v-model="userInfo.sex"
            v-if="canModify"
          >
            <el-option label="男" value="男"></el-option>
            <el-option label="女" value="女"></el-option>
          </el-select>
          <el-select
            placeholder="请选择性别"
            v-model="userInfo.sex"
            v-else
            disabled
          >
            <el-option label="男" value="男"></el-option>
            <el-option label="女" value="女"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="地址">
          <el-input v-if="canModify" v-model="userInfo.address"></el-input>
          <el-input v-else disabled v-model="userInfo.address"></el-input>
        </el-form-item>
        <el-form-item label="生日">
          <el-input v-if="canModify" v-model="userInfo.birthday"></el-input>
          <el-input v-else disabled v-model="userInfo.birthday"></el-input>
        </el-form-item>
        <el-form-item label="密码">
          <el-input v-if="canModify" v-model="userInfo.password"></el-input>
          <el-input v-else disabled v-model="userInfo.password"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button
            ref="submitButton"
            type="primary"
            v-if="!canModify"
            @click="changeInputStatus"
            >修改</el-button
          >
          <el-button ref="submitButton" type="primary" v-else @click="onSubmit"
            >保存</el-button
          >
          <el-button
            id="cancleButton"
            v-if="showCancleButton"
            @click="changeInputStatus"
            >取消</el-button
          >
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>
<script>
import axios from "axios";
export default {
  data() {
    return {
      showCancleButton: false,
      canModify: false,
      userInfo: {
        id: 0,
        username: "string",
        password: "string",
        nickName: "string",
        name: "string",
        phoneNumber: "string",
        address: "string",
        sex: "男",
        birthday: "2022-09-17T10:55:31.140Z",
        email: "string",
        pictureUrl: "string",
        registerTime: "2022-09-17T10:55:31.140Z",
        registerWay: "string",
        status: 0,
        lastLoginTime: "2022-09-17T10:55:31.140Z",
      },
    };
  },
  mounted() {
    this.getUserInfo();
  },
  methods: {
    onSubmit() {
      this.updateUserInfo();
    },
    getUserInfo() {
      axios({
        method: "post",
        url: "student/getUserInfo",
      }).then((response) => {
        if (response.data.status == 0) {
          this.userInfo = response.data.data;
        } else {
          console.log(response.data.message);
        }
      });
    },
    changeInputStatus() {
      this.canModify = !this.canModify;
      this.showCancleButton = !this.showCancleButton;
      this.getUserInfo();
    },
    updateUserInfo() {
      axios({
        method: "post",
        url: "student/updateUserInfo",
        data: this.userInfo,
      }).then((response) => {
        if (response.data.status == 0) {
          this.$message({
            message: "修改成功",
            type: "success",
          });
          this.changeInputStatus();
        } else {
          this.$message({
            message: response.data.message,
            type: "error",
          });
        }
      });
    },
  },
};
</script>
<style scoped>
.content {
  width: 100%;
}
.form {
  width: 70%;
  margin: auto;
}
h1 {
  margin-top: 0px;
}
</style>
