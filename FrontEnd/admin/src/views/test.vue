<template>

</template>

<script>
export default {
  name: "test",
  methods:{
    myfunction(){
      const myObject=new URLSearchParams();
      const myObject2=new FormData();
      myObject.set("page","123");
      myObject.set("size","123");
      axios({
        uri:xxxx,
        data:myObject
      })
    },
    myfunction2(){
      const myObject={
        id:12,
        name:wxxx
      }
      axios({
        uri:xxxx,
        data:myObject
      })
    }

  }
}
</script>
<style scoped>

</style>

<!--<template>-->
<!--    <v-distpicker></v-distpicker>-->
<!--</template>-->

<!--<script>-->
<!--import VDistpicker from "v-distpicker";-->
<!--export default {-->
<!--  name: "Mytest",-->
<!--  components:{VDistpicker}-->
<!--}-->
<!--</script>-->
<!--<style>-->

<!--</style>-->

