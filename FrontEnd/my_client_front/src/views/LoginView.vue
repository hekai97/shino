<template>
  <div class="box">
    <el-tabs type="border-card" style="height: 400px" stretch="true">
      <el-tab-pane label="登录" class="tab">
        <h1>用户登录</h1>
        <el-form ref="form" :model="form" label-width="80px" :rules="rules">
          <el-form-item prop="account" label="账号">
            <el-input :maxlength="15" v-model="form.account"></el-input>
          </el-form-item>
          <el-form-item prop="password" label="密码">
            <el-input v-model="form.password" type="password"></el-input>
          </el-form-item>
          <el-form-item class="loginbtn">
            <el-button type="primary" @click="login()">立即登录</el-button>
            <el-button>重置</el-button>
          </el-form-item>
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
          label-width="80px"
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
              <el-form-item prop="email" label="邮箱">
                <el-input v-model="reform.email"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
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
      const reg =
        /^\w+((-\w+)|(\.\w+))*\\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
      if (reg.test(value)) {
        callback();
      } else {
        callback(new Error("邮箱格式错误"));
      }
    };
    return {
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
    register() {
      this.$refs.reform.validate((valid) => {
        //加密
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
                  this.$router.push("/index");
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
                this.$router.push("/index");
              }
            });
          }
        }
      });
    },
  },
};
</script>
