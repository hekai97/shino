<template>
    <div class="d1">
<!--      <div @click="change" :class="t1">HTML</div>-->
<!--      <div @click="change" :class="t1">CSS</div>-->
<!--      <div @click="change" :class="t1">JavaScript</div>-->
<!--      <div @click="change" :class="t1">Vue.js</div>-->
      <a href="#" v-for="(item,index) in navs" :key="index" :class="{'show':item.active}" @click="changeColor(item,index)">
               {{item.name}}
      </a>
      <div class="b">选择了{{activeName}}</div>
    </div>

</template>

<script>
export default {
  // eslint-disable-next-line vue/multi-word-component-names
  name: "Navigaation",
  data(){
    return{
      // t1:'cd1',
      // t2:'cd2'
      navs:[
        {name:'HTML',active:false},
        {name:'CSS',active:false},
        {name:'JavaScript',active:false},
        {name:'Vue.js',active:false},
      ],
      activeName:''
    }
  },
  methods:{
    // change(){
    //   this.t1=this.t2;
    // }
    changeColor(item,index){
      // this.navs[index].active=!item.active
      for(var i=0;i<this.navs.length;i++){
        this.navs[i].active=false;
      }
      this.navs[index].active=true;
      this.activeName=item.name
    }
  }


}
</script>

<style scoped>
.d1{
  width: 500px;
  margin: auto;
}
/*.cd1{*/
/*  width: 100px;*/
/*  height: 50px;*/
/*  float: left;*/
/*  text-align: center;*/
/*  line-height: 50px;*/
/*  border: 1px solid black;*/
/*  background-color: #42b983;*/
/*  color: aliceblue;*/
/*}*/
/*.cd2{*/
/*  width: 100px;*/
/*  height: 50px;*/
/*  float: left;*/
/*  text-align: center;*/
/*  line-height: 50px;*/
/*  border: 1px solid black;*/
/*  background-color: #E35885;*/
/*  color: aliceblue;*/
/*}*/

*{
  margin: 0;
  padding: 0;
}
a {
  display: inline-block;
  padding: 18px 30px;
  color: #fff !important;
  font-weight: bold;
  font-size: 16px;
  text-decoration: none !important;
  line-height: 1;
  background-color: #17ff22;
  -webkit-transition: background-color 0.25s;
  -moz-transition: background-color 0.25s;
  transition: background-color 0.25s;
  cursor: pointer;
}

.show {
  background-color: #e35885;
}

.b {
  display: inline-block;
  padding: 5px 10px;
  background-color: #64B448;
  border-radius: 2px;
  font-size: 18px;
  color: #fff;
}

</style>
