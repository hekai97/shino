<template>
  <div>
    <p class="head">臻焙课工坊管理系统</p>
    <div class="log">
      <el-form class="logmain" ref="form" :model="form" :rules="rules">
          <el-form-item prop="account">
            <el-input class="user" v-model="form.account" placeholder="请输入用户名"  :prefix-icon="User"></el-input>
          </el-form-item>
          <el-form-item prop="password">
                <el-input class="pwd" show-password type="password" v-model="form.password" placeholder="请输入密码" :prefix-icon="Lock"/>
          </el-form-item>
          <el-form-item prop="inputyzm">
                <el-input class="yzm" v-model="form.inputyzm" placeholder="验证码" :prefix-icon="Edit"/>
          </el-form-item>
          <el-button class="btn" type="primary" @click="OnSubmit('form')" round>登录</el-button>
      </el-form>
    </div>
  </div>

</template>

<script>
import { ElLoading } from 'element-plus'
// import  {useRouter} from "vue-router";
// import router from '@/router/index.js'
import { ElMessage } from 'element-plus'
import { User ,Lock,Edit} from '@element-plus/icons-vue'
import axios from 'axios'
import router from "@/router";
export default {
  name: "ALogin",
  setup(){
    return {
      User,Lock,Edit
    }
  },
  data(){
    return{
        form:{
         account:'',
          password:'',
          // inputyzm:'',
      },
      rules:{
          account: [
            {required:true,message:'用户名不能为空',trigger:'blur'}
          ],
          password: [
            {required:true,message:'密码不能为空',trigger:'blur'}
          ],
          // inputyzm:[
          //   {required:true,message:'验证码不能为空',trigger:'blur'}
          // ]
      }
    }
  },
  methods:{
    OnSubmit(form){
      this.$refs[form].validate((valid) => {
        if(valid){
          console.log(this.form);
          axios({
            method: 'post',
            url: '/admin/user/login',
            params:{
              account:this.form.account,
              password:this.form.password
            }
          }).then(response=>{
             // alert(response.data.message)
            console.log(response)
            if(response.data.status===1){
              ElMessage(response.data.message)
            }else{
              // alert(response.data.data.name);
              const loading = ElLoading.service({
                lock: true,
                text: 'Loading',
                background: 'rgba(0, 0, 0, 0.7)',
              })
              setTimeout(() => {
                loading.close()
                ElMessage('登录成功')
                router.push({
                  name:'firsthome',
                  query:{
                    adminname:response.data.data.name,
                  }
                })
              }, 2000)
            }
          })


        } else {
          console.log('error submit!!');
          return false;
        }
      });
    }
  }
}
</script>

<style scoped>
.head{
  font-size: 35px;
  color: #909399;
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
  margin-top: 50px;
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
.btn{
  width: 150px;
  align-items: center;
  margin-left: 0px;
  margin-top: 30px;
  margin-bottom: 20px;
}
</style>