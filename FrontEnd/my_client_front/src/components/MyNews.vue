<template>
  <div class="news-area">
    <NewsComponent
      v-for="(item, index) in newsList"
      :key="index"
      :title="item.title"
      :content="item.content"
    ></NewsComponent>
  </div>
</template>
<script>
import NewsComponent from "../components/NewsComponent.vue";
export default {
  name: "MyNews",
  components: {
    NewsComponent,
  },
  data() {
    return {
      newsList: [
        {
          title: "新闻1",
          content: ["新闻1  内容1", "新闻1  内容2", "新闻1  内容3"],
        },
        {
          title: "新闻2",
          content: ["新闻1  内容1", "新闻1  内容2", "新闻1  内容3"],
        },
        {
          title: "新闻3",
          content: ["新闻1  内容1", "新闻1  内容2", "新闻1  内容3"],
        },
        {
          title: "新闻4",
          content: ["新闻1  内容1", "新闻1  内容2", "新闻1  内容3","新闻1 内容4"],
        }
      ],
    };
  },
};
</script>
<style scoped>
.news-area {
  width: 50%;
  height: 100%;
}
</style>
