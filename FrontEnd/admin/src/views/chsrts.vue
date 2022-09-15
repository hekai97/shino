<template>
  <div id="myChart"></div>
</template>

<script>
import *as echarts from 'echarts'	// 引入echarts
export default {
  name: 'LineChart',
  data () {
    return {
      echartsOption: {	// echarts选项，所有绘图数据和样式都在这里设置
        xAxis: {
          type: 'value',
          data: ['腾讯', '阿里巴巴', '华为', '字节跳动'],   // x轴数据
          name: '日期',   // x轴名称
          nameTextStyle: {	// x轴名称样式
            fontWeight: 600,
            fontSize: 18
          }
        },
        yAxis: {
          type: 'category',
          name: '公司盈利率',   // y轴名称
          nameTextStyle: {	// y轴名称样式
            fontWeight: 600,
            fontSize: 18
          }
        },
        tooltip: {   //鼠标放到图上的数据展示样式
          trigger: 'axis'
        },
        series: [{  //series中加入每个bar的数据
          name: '公司盈利率',
          type: 'bar',
          barWidth: '60%',
          data: [0.35, 0.2, 0.25, 0.15],
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
  width: 100%;
  height: 500px;
}
</style>
