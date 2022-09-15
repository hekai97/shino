<template>
<!--  <div id="app">-->
<!--    <img src="./assets/logo.png">-->
<!--    <div>-->
<!--      <p>-->
<!--        If Element is successfully added to this project, you'll see an-->
<!--        <code v-text="'<el-button>'"></code>-->
<!--        below-->
<!--      </p>-->
<!--      <el-button>el-button</el-button>-->
<!--    </div>-->
<!--    <HelloWorld msg="Welcome to Your Vue.js App"/>-->
<!--  </div>-->
<!--  <navigaation/>-->
<!--  <nav>-->
<!--    <router-link to="/">Home</router-link> |-->
<!--    <router-link to="/about">About</router-link>-->
<!--  </nav>-->
<!--      <router-view/>-->
<!--<myHome/>-->
<!--  <ALogin/>-->
  <router-view/>
<!--  <LineChart/>-->

</template>

<script>
//import myHome from "@/views/Home"
// import ALogin from "@/views/Login";
// import LineChart from "@/views/chsrts"
export default {
  name: 'app',
  components: {
     //myHome,
    // ALogin
    // LineChart
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
