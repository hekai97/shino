<template>
  <div>
    <p class="head">臻焙课工坊管理系统</p>
    <div class="log">
      <el-form class="logmain" ref="form" :model="form" :rules="rules">
          <el-form-item prop="inputuser">
                <el-input class="user" v-model="form.inputuser" placeholder="请输入用户名"  prefix-icon="iconfont el-icon-user"/>
          </el-form-item>
          <el-form-item prop="inputpwd">
                <el-input class="pwd" show-password type="password" v-model="form.inputpwd" placeholder="请输入密码" prefix-icon="iconfont el-icon-lock"/>
          </el-form-item>
          <el-form-item prop="inputyzm">
                <el-input class="yzm" v-model="form.inputyzm" placeholder="验证码" prefix-icon="iconfont el-icon-edit"/>
          </el-form-item>
          <el-button class="btn" type="primary" @click="OnSubmit('form')" round>登录</el-button>
      </el-form>
    </div>
  </div>

</template>

<script>
import { ElLoading } from 'element-plus'
import API from "@/plugins/axiosInstance";
export default {
  name: "ALogin",
  data(){
    return{
        form:{
          inputuser:'',
          inputpwd:'',
          // inputyzm:'',
      },
      rules:{
          inputuser: [
            {required:true,message:'用户名不能为空',trigger:'blur'}
          ],
          inputpwd: [
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
          //alert("111")
          API({
            url:'/admin/user/login',
            methods: 'post',
            data:form
          }).then(ref=>{
            if(ref.result){
                alert("success");
            }
            else{
              alert("fall");
            }
          })
          const loading = ElLoading.service({
            lock: true,
            text: 'Loading',
            background: 'rgba(0, 0, 0, 0.7)',
          })
          setTimeout(() => {
            loading.close()
          }, 2000)

        }else {
          alert("失败")
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