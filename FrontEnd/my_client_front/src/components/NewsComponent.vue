<template>
  <div class="news-body">
    <div class="news-title">{{ title }}</div>
    <li class="news-content" v-for="(item, index) in content" :key="index">
      {{ item }}
    </li>
  </div>
</template>
<script>
export default {
  name: "NewsComponent",
  props: {
    title: {
      type: String,
      default: function () {
        return "";
      },
    },
    content: {
      type: Array,
      default: function () {
        return [];
      },
    },
  },
  data() {
    return {};
  },
  methods: {},
};
</script>
<style scoped>
.news-body {
  width: 100%;
  height: 100%;
}
.news-title {
  width: 100%;
  height: 50px;
  line-height: 50px;
  font-size: 20px;
  font-weight: bold;
}
</style>
