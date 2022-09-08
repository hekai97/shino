<template>
  <div id="myChart"></div>
</template>

<script>
import * as echarts from 'echarts'	// 引入echarts
export default {
  name: 'PieChart',
  data () {
    return {
      echartsOption: {	// echarts选项，所有绘图数据和样式都在这里设置
        legend: {	//图表上方的图例
          data: ['腾讯', '阿里巴巴', '华为', '字节跳动']
        },
        tooltip: {   //鼠标放到图上的数据展示样式
          trigger: 'axis'
        },
        series: [{
          name: '公司市值占比',
          type: 'pie',
          barWidth: '60%',
          data: [	// 扇形图数据格式： {value, name}
            {value: 0.35, name: '腾讯'},		// value不一定是比例，echarts会自动转换
            {value: 0.2, name: '阿里巴巴'},
            {value: 0.25, name: '华为'},
            {value: 0.2, name: '字节跳动'},
          ],
        }],
      }
    }
  },
  mounted () {
    let myChart = echarts.init(document.getElementById('myChart'), 'light')	// 初始化echarts, theme为light
    myChart.setOption(this.echartsOption)	// echarts设置选项
  }
}
</script>

<style>
#myChart{
  width: 50%;
  height: 100px;
  margin: 0 auto;
  margin-top: 5%;
}
</style>

