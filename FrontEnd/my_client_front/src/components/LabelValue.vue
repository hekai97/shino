<template>
  <div class="main-content">
    <div class="my-label">{{ label }}</div>
    <div class="my-value">{{ value }}</div>
  </div>
</template>

<script>
export default {
  name: "LabelValue",
  props: {
    label: {
      type: String,
      default: "",
    },
    value: {
      type: String,
      default: "",
    },
  },
};
</script>

<style scoped>
.main-content {
  display: flex;
  flex-direction: row;
  align-items: center;
  justify-content: center;
  width: 100%;
  height: 100%;
  /* border: 1px solid #ccc; */
  border-radius: 5px;
  padding: 10px;
  box-sizing: border-box;
}
.my-label {
  width: 30%;
  font-size: 14px;
  font-weight: 600;
  color: #333;
  text-align: center;
}
.my-value {
  width: 70%;
  font-size: 16px;
  font-weight: 600;
  color: #333;
}
</style>
