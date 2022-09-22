<template>
  <div class="box">
    <el-tabs
      type="border-card"
      style="width: 750px; height: 400px"
      stretch="true"
    >
      <el-tab-pane label="登录" class="tab">
        <div class="login-head">
          <h1>用户登录</h1>
        </div>
        <el-form ref="form" :model="form" label-width="80px" :rules="rules">
          <div class="item">
            <el-form-item prop="account" label="账号">
              <el-input :maxlength="20" v-model="form.account"></el-input>
            </el-form-item>
            <el-form-item prop="password" label="密码">
              <el-input v-model="form.password" type="password"></el-input>
            </el-form-item>
            <el-form-item class="loginbtn">
              <el-button type="primary" @click="login()">立即登录</el-button>
              <el-button>重置</el-button>
              <el-link
                href="/forgetPassword"
                type="info"
                class="forget-password-link"
                >忘记密码</el-link
              >
            </el-form-item>
          </div>
          <el-checkbox ref="check" v-model="agree" class="checkbox"
            >我已仔细阅读并同意用户条款及协议</el-checkbox
          >
        </el-form>
      </el-tab-pane>
      <el-tab-pane label="注册">
        <h2 class="rehead">用户注册</h2>
        <el-form
          ref="reform"
          :model="reform"
          label-width="100px"
          class="reform"
          :rules="rerules"
        >
          <el-row>
            <el-col :span="12">
              <el-form-item prop="username" label="用户名">
                <el-input v-model="reform.username"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item prop="birthday" label="出生日期">
                <el-date-picker v-model="reform.birthday"></el-date-picker>
              </el-form-item>
            </el-col>
          </el-row>
          <!--新增邮箱验证-->
          <el-row>
            <el-col :span="12">
              <el-form-item prop="phoneNumber" label="手机号码">
                <el-input v-model="reform.phoneNumber"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item prop="sex" label="性别">
                <el-select placeholder="请选择性别" v-model="reform.sex">
                  <el-option label="男" value="男"></el-option>
                  <el-option label="女" value="女"></el-option>
                </el-select>
              </el-form-item>
            </el-col>
          </el-row>
          <!---->
          <el-row>
            <el-col :span="12">
              <el-form-item prop="email" label="邮箱">
                <el-input v-model="reform.email">
                  <template #append>
                    <el-button
                      v-if="timerCount == 0"
                      type="primary"
                      @click="sendEmail"
                      :disabled="!reform.email"
                      >发送验证码</el-button
                    >
                    <el-button v-else type="primary" disabled
                      >已发送 {{ this.timerCount }}</el-button
                    >
                  </template>
                </el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item prop="code" label="验证码">
                <el-input v-model="reform.code"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-row>
            <el-col :span="12">
              <el-form-item label="密码" prop="password">
                <el-input
                  type="password"
                  v-model="reform.password"
                  autocomplete="off"
                ></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="确认密码" prop="repassword">
                <el-input
                  type="password"
                  v-model="reform.repassword"
                  autocomplete="off"
                ></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-form-item class="registerbtn">
            <el-button type="primary" @click="register()">立即注册</el-button>
            <el-button>取消</el-button>
          </el-form-item>
          <el-checkbox v-model="reagree" class="recheckbox"
            >我已仔细阅读并同意用户条款及协议</el-checkbox
          >
        </el-form>
      </el-tab-pane>
    </el-tabs>
  </div>
</template>
<script>
import "@/assets/index.css";
import { sha3_256 } from "js-sha3";
import axios from "axios";
export default {
  data() {
    var check = (rule, value, callback) => {
      if (value !== this.reform.password) {
        callback(new Error("两次输入密码不一致!"));
      } else {
        callback();
      }
    };
    const checkPhone = (rule, value, callback) => {
      const reg = /^1(3|4|5|6|7|8|9)\d{9}$/;
      if (reg.test(value)) {
        callback();
      } else {
        callback(new Error("手机号码格式有误"));
      }
    };
    const checkEmail = (rule, value, callback) => {
      const reg = /^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$/;
      if (reg.test(value)) {
        callback();
      } else {
        callback(new Error("邮箱格式错误"));
      }
    };
    return {
      timerCount: 0,
      agree: false,
      form: {
        account: "",
        password: "",
      },
      reform: {
        username: "",
        email: "",
        phoneNumber: "",
        sex: "",
        password: "",
        repassword: "",
        birthday: "",
        code: "",
      },
      reagree: false,
      rules: {
        account: [
          {
            required: true,
            message: "账号不能为空，请输入账号！",
            trigger: "blur",
          },
        ],
        password: [
          {
            required: true,
            message: "密码不能为空，请输入密码!",
            trigger: "blur",
          },
        ],
      },
      rerules: {
        username: [
          {
            required: true,
            message: "用户名不能为空，请输入用户名！",
            trigger: "blur",
          },
        ],
        email: [
          {
            required: true,
            message: "邮箱不能为空，请输入邮箱！",
            trigger: "blur",
          },
          { validator: checkEmail, trigger: "blur" },
        ],
        phoneNumber: [
          {
            required: true,
            message: "手机号码不能为空，请输入手机号码！",
            trigger: "blur",
          },
          { validator: checkPhone, trigger: "blur" },
        ],
        sex: [
          {
            required: true,
            message: "性别不能为空，请选择性别！",
            trigger: ["blur", "change"],
          },
        ],
        password: [
          {
            required: true,
            message: "密码不能为空，请输入密码！",
            trigger: "blur",
          },
        ],
        repassword: [
          { required: true, message: "请输入密码！", trigger: "blur" },
          { validator: check, trigger: "blur" },
        ],
        birthday: [
          {
            required: true,
            message: "生日不能为空，请选择生日！",
            trigger: "blur",
          },
        ],
        code: [
          {
            required: true,
            message: "验证码不能为空，请检查你的邮箱！",
            trigger: "blur",
          },
        ],
      },
    };
  },
  methods: {
    login() {
      this.$refs.form.validate((valid) => {
        if (valid) {
          if (this.agree == false) {
            this.$confirm("您是否已仔细阅读并同意用户条款及协议？", "提示", {
              confirmButtonText: "同意",
              cancelButtonText: "取消",
              type: "warning",
            }).then(() => {
              this.agree = true;
              const my_params = new URLSearchParams();
              my_params.set("account", this.form.account);
              my_params.set("password", sha3_256(this.form.password));
              console.log(sha3_256(this.form.password));
              axios({
                method: "post",
                data: my_params,
                url: "/student/login",
              }).then((res) => {
                if (res.data.status == 0) {
                  alert("登录成功！");
                  this.$router.push("/index");
                } else {
                  console.log(res);
                }
              });
            });
          } else {
            const my_params = new URLSearchParams();
            my_params.set("account", this.form.account);
            my_params.set("password", sha3_256(this.form.password));
            axios({
              method: "post",
              data: my_params,
              url: "/student/login",
            }).then((res) => {
              if (res.data.status == 0) {
                console.log(res.data.status);
                alert("登录成功！");
                this.$router.push("/index");
              } else {
                console.log(res);
              }
            });
          }
        }
      });
    },
    async register() {
      this.$refs.reform.validate(async (valid) => {
        let codeVerify = await this.checkVerifyCode(this.reform.code);
        console.log(codeVerify);
        if (!codeVerify) {
          this.$message.error("验证码错误");
          return;
        }
        this.reform.password = sha3_256(this.reform.password);
        console.log(this.reform.password);
        if (valid) {
          if (this.reagree == false) {
            this.$confirm("您是否已仔细阅读并同意用户条款及协议？", "提示", {
              confirmButtonText: "同意",
              cancelButtonText: "取消",
              type: "warning",
            }).then(() => {
              this.reagree = true;
              axios({
                method: "post",
                data: this.reform,
                url: "/student/register",
              }).then((res) => {
                console.log(res.data.message);
                if (res.data.status == 0) {
                  alert("注册成功！");
                  this.$router.push("/login");
                }
              });
            });
          } else {
            axios({
              method: "post",
              data: this.reform,
              url: "/student/register",
            }).then((res) => {
              console.log(res.data.message);
              if (res.data.status == 0) {
                alert("注册成功！");
                this.$router.push("/login");
              }
            });
          }
        }
      });
    },
    sendEmail() {
      this.$refs.reform.validateField("email", (valid) => {
        if (valid) {
          axios({
            method: "post",
            url: "/mail/getCode",
            params: {
              email: this.reform.email,
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
    async checkVerifyCode(p_code) {
      const result = await axios({
        method: "post",
        url: "/mail/verifyCode",
        params: {
          code: p_code,
        },
      }).then((res) => {
        if (res.data.status == 0) {
          return true;
        } else {
          return false;
        }
      });
      return result;
    },
    createTimer() {
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
.el-link {
  margin-left: 10px;
}
.item {
  margin-left: -35px;
}
.login-head {
  text-align: center;
  position: relative;
  left: 50%;
  transform: translateX(-50%);
}
.el-checkbox {
  margin-left: 25px;
}
.reform {
  display: inline-block;
}
</style>
