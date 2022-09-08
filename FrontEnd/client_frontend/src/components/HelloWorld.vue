<template>
  <div class="box">
    <el-tabs type="border-card" style="height:400px">
      <el-tab-pane label="登录" class="tab">
        <h1>用户登录</h1>
        <el-form ref="form" :model="form" label-width="80px" :rules="rules">
          <el-form-item prop="account" label="账号">
            <el-input :maxlength="15" v-model="form.account" ></el-input>
          </el-form-item>
          <el-form-item prop="password" label="密码">
            <el-input v-model="form.password" type="password"></el-input>
          </el-form-item>
          <el-form-item class="loginbtn">
            <el-button type="primary" @click="login()">立即登录</el-button>
            <el-button>重置</el-button>
          </el-form-item>
          <el-checkbox ref="check" v-model="agree" class="checkbox">我已仔细阅读并同意用户条款及协议</el-checkbox>
        </el-form>
      </el-tab-pane>
      <el-tab-pane label="注册">
        <h2 class="rehead">用户注册</h2>
        <el-form ref="reform" :model="reform" label-width="80px" class="reform" :rules="rerules">
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
                <el-input type="password" v-model="reform.password" autocomplete="off"></el-input>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item label="确认密码" prop="repassword">
                <el-input type="password" v-model="reform.repassword" autocomplete="off"></el-input>
              </el-form-item>
            </el-col>
          </el-row>
          <el-form-item class="registerbtn">
            <el-button type="primary" @click="register()">立即注册</el-button>
            <el-button>取消</el-button>
          </el-form-item>
          <el-checkbox v-model="reagree" class="recheckbox">我已仔细阅读并同意用户条款及协议</el-checkbox>
        </el-form>
      </el-tab-pane>
    </el-tabs>
  </div>
</template>
<script>
import "../styles/index.css"
export default {
  data() {
    return {
      agree:false,
      form:{
        account:'',
        password:'',
      },
      reform:{
        username:'',
        email:'',
        phoneNumber:'',
        sex:'',
        password:'',
        repassword:'',
      },
      reagree: false,
      rules:{
        account:[
          {required:true,message:'账号不能为空，请输入账号！',trigger:'blur'}
        ],
        password:[
          {required:true,message:'密码不能为空，请输入密码!',trigger:'blur'}
        ]
      },
      rerules:{
        username:[
          {required:true,message:'用户名不能为空，请输入用户名！',trigger:'blur'}
        ],
        email:[
          {required:true,message:'邮箱不能为空，请输入邮箱！',trigger:'blur'}
        ],
        phoneNumber:[
          {required:true,message:'手机号码不能为空，请输入手机号码！',trigger:'blur'}
        ],
        sex:[
          {required:true,message:'性别不能为空，请选择性别！',trigger:['blur','change']}
        ],
        password:[
          {required:true,message:'密码不能为空，请输入密码！',trigger:'blur'}
        ],
        repassword:[
          {required:true,message:'请输入密码！',trigger:'blur'}
        ]
      }
    }
  },
  methods:{

    login(){
      this.$refs.form.validate((valid) => {
        if(valid){
          if(this.agree == false){
            this.$confirm('您是否已仔细阅读并同意用户条款及协议？','提示',{
              confirmButtonText: '同意',
              cancelButtonText: '取消',
              type: 'warning'
            }).then(()=>{
              this.agree = true
              this.$axios({
                method : "post",
                data : this.form,
                url:'http://43.143.167.8:8080'+'/student/login'
              }).then((res)=>{
                console.log(res.data)
                if(data){
                  alert("登录成功！")
                  this.$router.push("/index")
                }
              })
            })
          }
          else {
            this.$axios({
              method : "post",
              data : this.form,
              url:'http://43.143.167.8:8080'+'/student/login'
            }).then((res)=>{
              console.log(res.data)
              if(data){
                alert('登录成功！')
                this.$router.push("/index")
              }
            })
          }
        }
        else {}
      })
    },
    register(){
      this.$refs.reform.validate((valid) => {
        if(valid){
          if(this.reagree == false){
            this.$confirm('您是否已仔细阅读并同意用户条款及协议？','提示',{
              confirmButtonText: '同意',
              cancelButtonText: '取消',
              type: 'warning'
            }).then(()=>{
              this.reagree = true
              this.$axios({
                method : "post",
                data : this.reform,
                url:'http://43.143.167.8:8080'+'/student/register'
              }).then((res)=>{
                console.log(res.data)
                if(data)
                {
                  alert('注册成功！')
                  this.$router.push("/index")
                }
              })
            })
          }
          else {
            this.$axios({
              method : "post",
              data : this.reform,
              url:'http://43.143.167.8:8080'+'/student/register'
            }).then((res)=>{
              console.log(res.data)
              if(data){
                alert('注册成功！')
                this.$router.push("/index")
              }
            })
          }
        }else{}
      })
    }
  }
};
</script>
