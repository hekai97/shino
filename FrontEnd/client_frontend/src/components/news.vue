<template>
  <el-container>
    <el-header>
      <div class="head"></div>
    </el-header>
    <el-main>
      <div class="tab">
        <el-tabs type="border-card">
          <el-tab-pane label="分类一">
            <div class="content">
              <div class="row">
                <div class="left">

                </div>
                <div class="right">
                  <h4>富强、民主、文明、和谐</h4>
                  <el-row>
                    <el-col :span="6">
                      <div>第一条：</div>
                    </el-col>
                    <el-col span="18">

                    </el-col>
                  </el-row>
                  <el-row>
                    <el-col :span="6">
                      <div>第二条：</div>
                    </el-col>
                    <el-col span="18">

                    </el-col>
                  </el-row>
                  <el-row>
                    <el-col :span="6">
                      <div>第三条：</div>
                    </el-col>
                    <el-col span="18">

                    </el-col>
                  </el-row>
                </div>
              </div>
            </div>
            <div class="footer">
              <el-pagination
                @size-change="handleSizeChange"
                @current-change="handleCurrentChange"
                :current-page="currentPage4"
                :page-sizes="[100, 200, 300, 400]"
                :page-size="100"
                layout="total, sizes, prev, pager, next, jumper"
                :total="400">
              </el-pagination>
            </div>
          </el-tab-pane>
          <el-tab-pane label="分类二">分类二</el-tab-pane>
        </el-tabs>
      </div>
      <div class="call">
        <h1 class="title">五百多家连锁店遍布全国，快来联系我们学习吧！</h1>
      </div>
    </el-main>
  </el-container>
</template>
<script>
export default {
  data(){
    return{
      currentPage4: 4
    }
  },
  methods:{
    handleSizeChange(val) {
      console.log(`每页 ${val} 条`);
    },
    handleCurrentChange(val) {
      console.log(`当前页: ${val}`);
    }
  }
}
</script>
<style scoped>
.head{
  width: 100%;
  height: 100px;
  background-color: cadetblue;
}
.content{
  width: 80%;
}
.row{
  height: 100px;
}
.left{
  width: 30%;
  float: left;
  background-color: rosybrown;
  height: 100px;
}
.right{
  width: 70%;
  float: right;
  text-align: left;
}
h4{
  margin-top: 0px;
  margin-bottom: 10px;
}
.call{
  width: 100%;
  height: 150px;
  display: flex;
  background-color: rgba(0,0,0,0.4);
}
.title{
  align-self: center;
  margin:auto;
  color: white;
}
</style>
