<template>
  <div class="forget-body">
    <el-card class="forget-card">
      <el-form
        ref="forgetPasswordForm"
        :model="forgetPasswordEntity"
        :rules="forgetPasswordEntityRules"
        label-width="15%"
      >
        <h3 style="text-align: center">忘记密码</h3>
        <el-form-item label="邮箱" prop="email">
          <el-input
            v-model="forgetPasswordEntity.email"
            placeholder="请输入邮箱"
          >
            <template #append>
              <el-button v-if="!isSend" type="primary" @click="sendEmail"
                >发送验证码</el-button
              >
              <el-button v-else type="primary" disabled
                >已发送 {{ this.timerCount }}</el-button
              >
            </template>
          </el-input>
        </el-form-item>
        <el-form-item label="验证码" prop="code">
          <el-input
            v-model="forgetPasswordEntity.code"
            placeholder="请输入验证码"
          ></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="password">
          <el-input
            v-model="forgetPasswordEntity.password"
            type="password"
            placeholder="请输入密码"
          ></el-input>
        </el-form-item>
        <el-form-item label="确认密码" prop="confirmPassword">
          <el-input
            v-model="forgetPasswordEntity.confirmPassword"
            placeholder="请确认密码"
            type="password"
          ></el-input>
        </el-form-item>
        <el-button
          type="primary"
          @click="forgetPasswordSubmit"
          style="margin: 0 45%"
          >提交</el-button
        >
      </el-form>
    </el-card>
  </div>
</template>
<script>
import axios from "axios";
import { sha3_256 } from "js-sha3";

export default {
  data() {
    return {
      timerCount: 0,
      isSend: false,
      forgetPasswordEntity: {
        email: "",
        code: "",
        password: "",
        confirmPassword: "",
      },
      forgetPasswordEntityRules: {
        email: [
          { required: true, message: "请输入邮箱", trigger: "blur" },
          { type: "email", message: "请输入正确的邮箱", trigger: "blur" },
        ],
        code: [
          { required: true, message: "请输入验证码", trigger: "blur" },
          { min: 6, max: 6, message: "请输入6位验证码", trigger: "blur" },
        ],
        password: [
          { required: true, message: "请输入密码", trigger: "blur" },
          { min: 6, max: 20, message: "请输入6-20位密码", trigger: "blur" },
        ],
        confirmPassword: [
          { required: true, message: "请确认密码", trigger: "blur" },
          { min: 6, max: 20, message: "请输入6-20位密码", trigger: "blur" },
        ],
      },
    };
  },
  methods: {
    sendEmail() {
      this.$refs.forgetPasswordForm.validateField("email", (valid) => {
        if (valid) {
          axios({
            method: "post",
            url: "/mail/getCode",
            params: {
              email: this.forgetPasswordEntity.email,
            },
          }).then((res) => {
            if (res.data.status == 0) {
              this.$message.success("验证码发送成功");
              this.createTimer();
            } else {
              this.$message.error(res.data.message);
            }
          });
        } else {
          this.$message({
            message: "请输入正确的邮箱",
            type: "error",
          });
        }
      });
    },
    forgetPasswordSubmit() {
      this.$refs.forgetPasswordForm.validate((valid) => {
        if (valid) {
          //先检查密码是否相等，在检查验证码是否正确，最后加密发送请求
          if (
            this.forgetPasswordEntity.password !=
            this.forgetPasswordEntity.confirmPassword
          ) {
            this.$message({
              message: "两次密码不一致",
              type: "error",
            });
            return;
          }
          axios({
            method: "post",
            url: "/mail/verifyCode",
            params: {
              code: this.forgetPasswordEntity.code,
            },
          }).then((res) => {
            if (res.data.status != 0) {
              this.$message({
                message: "验证码错误",
                type: "error",
              });
              return;
            } else {
              axios({
                method: "post",
                url: "/student/forgetPassword",
                params: {
                  account: this.forgetPasswordEntity.email,
                  password: sha3_256(this.forgetPasswordEntity.password),
                },
              }).then((response) => {
                if (response.data.status == 0) {
                  this.$message({
                    message: "修改成功",
                    type: "success",
                  });
                  this.$router.push("/login");
                } else {
                  this.$message({
                    message: response.data.message,
                    type: "error",
                  });
                }
              });
            }
          });
        } else {
          this.$message.error("请检查输入");
        }
      });
    },
    //创建一个定时器，60秒后才能再次发送验证码
    createTimer() {
      this.isSend = true;
      this.timerCount = 60;
      let timer = setInterval(() => {
        if (this.timerCount > 0 && this.timerCount <= 60) {
          this.timerCount--;
        } else {
          clearInterval(timer);
          this.timerCount = 60;
          this.isSend = false;
        }
      }, 1000);
    },
  },
};
</script>
<style scoped>
.forget-body {
  margin-top: 10%;
  display: flex;
  width: 100%;
  height: 100%;
  /* background-color: #f5f5f5; */
  justify-content: center;
}
.forget-card {
  width: 50%;
}
</style>
