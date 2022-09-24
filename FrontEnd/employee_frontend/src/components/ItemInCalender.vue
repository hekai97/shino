<template>
<div class="small-item">
  {{obj.teacherName}} {{obj.courseName}} {{obj.beginTime}} - {{obj.endTime}}
</div>
</template>

<script>
export default {
  name: "ItemInCalender",
  props:{
    obj:{
      type:Object,
      default:function () {
        return "";
      }
    }
  },
  mounted() {
    // console.log(this.obj)
  },
  data() {
    return {
      // obj: {
      //   id: 0,
      //   storeId: 0,
      //   storeName: "string",
      //   courseId: 0,
      //   courseName: "string",
      //   teacherId: 0,
      //   teacherName: "string",
      //   userId: 0,
      //   userName: "string",
      //   createTime: "string",
      //   reservationDate: "string",
      //   beginTime: "2022-09-23T13:10:26.334Z",
      //   endTime: "2022-09-23T13:10:26.334Z"
      // }
    }
  }
}
</script>

<style scoped>
.small-item{
  font-size: 1px;
  background-color: #85e8e8;
  transform:scale(0.85);
  border-radius: 5px;
}
</style>
