<template>
  <div>
    <p class="head">臻焙课工坊员工端</p>
    <div class="log">
      <el-form class="logmain" ref="form" :model="form" :rules="rules">
        <p class="login" >登录</p>
        <el-form-item prop="account">
          <el-input v-model="form.account" class="user" placeholder="请输入用户名">
            <template #prefix>
              <el-icon class="el-input__icon"><User /></el-icon>
            </template>
          </el-input>
        </el-form-item>
        <el-form-item prop="password">
          <el-input class="pwd" show-password type="password" v-model="form.password" placeholder="请输入密码">
          <template #prefix>
            <el-icon class="el-input__icon"><Lock /></el-icon>
          </template>
          </el-input>
        </el-form-item>
        <el-form-item prop="inputyzm">
          <el-input class="yzm" v-model="form.inputyzm" placeholder="验证码">
            <template #prefix>
              <el-icon class="el-input__icon"><CircleCheck /></el-icon>
            </template>
          </el-input>
        </el-form-item>
        <el-form-item prop="remember">
        <el-checkbox v-model="form.remember" class="remember" >记住密码</el-checkbox>
        </el-form-item>
        <el-button class="btn" type="primary" @click="OnSubmit('form')" round>登录</el-button>
      </el-form>
    </div>
  </div>

</template>

<script>
import { ElLoading } from 'element-plus'
// import API from "@/plugins/axiosInstance";
import axios from 'axios'
import {
  User,
  Lock,
  CircleCheck
} from '@element-plus/icons-vue'
import router from "@/router";
import {sha3_256} from "js-sha3";

const {ElMessage} = require("element-plus");
export default {
  // eslint-disable-next-line vue/multi-word-component-names
  name: 'Mydemo',
  components: {
    User,
    Lock,
    CircleCheck
  },
  data () {
    return {
      form: {
        account: '',
        password: ''
        // inputyzm:'',
      },
      rules: {
        account: [
          { required: true, message: '用户名不能为空', trigger: 'blur' }
        ],
        password: [
          { required: true, message: '密码不能为空', trigger: 'blur' }
        ]
        // inputyzm:[
        //   {required:true,message:'验证码不能为空',trigger:'blur'}
        // ]
      }
    }
  },
  methods: {
    OnSubmit (form) {
      this.$refs[form].validate((valid) => {
        if (valid) {
          axios({
            method:'post',
            url:'/employee/user/login',
            params:{
              account:this.form.account,
              password:sha3_256(this.form.password)
            }
          }).then(res=>{
            if(res.data.status===0){
              const loading = ElLoading.service({
                  lock: true,
                  text: 'Loading',
                  background: 'rgba(0, 0, 0, 0.7)'
                })
                setTimeout(() => {
                  loading.close()
                  ElMessage("登录成功")
                  router.push({
                    name:"home"
                  })
                }, 2000)
            }else {
              ElMessage(res.data.message)
            }
          })

        } else {
          return false
        }
      })
    }
  }
}
</script>

<style scoped>
.head{
  font-size: 35px;
  color: #141415;
}
.login{
  font-size: 25px;
  color: #747976;
}
.log{
  border: 1px solid  #e9e9eb;
  width: 460px;
  /*writing-mode:vertical-lr;*/
  margin: 0 auto;
  box-shadow: -12px 12px 12px rgba(0,0,0,0.2);
}
.logmain{
  width: 400px;
  margin-left: 30px;
}
.user{
  margin-top: 20px;
  width: 400px;
  height: 50px;
}
.pwd{
  width: 400px;
  height: 50px;
  /*margin-top: 10px;*/
}
.yzm{
  width: 400px;
  height: 50px;
  /*margin-top: 10px;*/
}
.remember{
  width: 100px;
  height: 2px;
  margin-left: 10px;
  color: #42b983;
}
.btn{
  width: 150px;
  align-items: center;
  margin-left: 0px;
  margin-top: 30px;
  margin-bottom: 20px;
}
</style>
