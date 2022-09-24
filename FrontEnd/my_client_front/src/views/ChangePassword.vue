<template>
  <div class="reset-password-body">
    <el-form ref="form" :model="form" :rules="formRule" label-width="80px">
      <el-form-item label="原密码" prop="oldPassword">
        <el-input
          v-model="form.oldPassword"
          type="password"
          placeholder="请输入原密码"
        ></el-input>
      </el-form-item>
      <el-form-item label="新密码" prop="newPassword">
        <el-input
          v-model="form.newPassword"
          type="password"
          placeholder="请输入新密码"
        ></el-input>
      </el-form-item>
      <el-form-item label="确认密码" prop="confirmPassword">
        <el-input
          v-model="form.confirmPassword"
          type="password"
          placeholder="请再次输入新密码"
        ></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="submitForm"
      >确认修改</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>
<script>
import axios from "axios";

export default {
  data() {
    return {
      form: {
        account: "",
        oldPassword: "",
        newPassword: "",
        confirmPassword: "",
      },
      formRule: {
        oldPassword: [
          { required: true, message: "请输入原密码", trigger: "blur" },
        ],
        newPassword: [
          { required: true, message: "请输入新密码", trigger: "blur" },
        ],
        confirmPassword: [
          { required: true, message: "请再次输入新密码", trigger: "blur" },
        ],
      },
    };
  },
  mounted() {
    this.getUserInfo();
  },
  methods: {
    submitForm() {
      this.$refs.form.validate((valid) => {
        if (this.form.account == "") {
          this.$message.error("请先登录");
          return;
        }
        if (valid) {
          if (this.form.newPassword !== this.form.confirmPassword) {
            this.$message.error("两次输入的密码不一致");
            return;
          }
          axios({
            method: "post",
            url: "/student/resetPassword",
            params: {
              account: this.form.account,
              oldPassword: this.form.oldPassword,
              newPassword: this.form.newPassword,
            },
          }).then((res) => {
            if (res.data.code === 0) {
              this.$message.success("修改成功");
              this.$router.push("/login");
            } else {
              this.$message.error(res.data.message);
            }
          });
        } else {
          console.log("error submit!!");
          return false;
        }
      });
    },
    getUserInfo() {
      axios({
        method: "post",
        url: "student/getUserInfo",
      }).then((response) => {
        if (response.data.status == 0) {
          this.form.account = response.data.data.email;
        } else {
          console.log(response.data.message);
        }
      });
    },
  },
};
</script>
<style scoped>
.reset-password-body {
  width: 60%;
  margin: auto;
}
.el-button{
  margin: auto;
}
</style>
