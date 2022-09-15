<template>
  <div>
    <el-table
      ref="multipleTable"
      :data="tableData"
      tooltip-effect="dark"
      style="width: 100%"
      @selection-change="handleSelectionChange">
      <el-table-column
        type="selection"
        width="80">
      </el-table-column>
      <el-table-column
        label="课程"
        width="240">
        <template slot-scope="scope">{{ scope.row.course }}</template>
      </el-table-column>
      <el-table-column
        prop="name"
        label="课程信息"
        width="240">
      </el-table-column>
      <el-table-column
        prop="type"
        label="课程类型"
        show-overflow-tooltip>
      </el-table-column>
      <el-table-column
        prop="price"
        label="价格"
        show-overflow-tooltip>
      </el-table-column>
    </el-table>
    <div style="margin-top: 20px">
      <div class="total">合计（不含运费）：</div>
    </div>
    <div class="button">
      <el-button @click="toggleSelection()">结算</el-button>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      tableData: [{
        course: '课程A',
        name: 'A',
        type:'A',
        price:'1'
      }, {
        course: '课程B',
        name: 'B',
        type:'B',
        price:'2'
      }, {
        course: '课程C',
        name: 'C',
        type:'C',
        price:'3'
      }, {
        course: '课程D',
        name: 'D',
        type:'D',
        price:'4'
      },],
      multipleSelection: [],
      num:'',
      total:''
    }
  },
  computed:{

  },
  methods: {
    toggleSelection(rows) {
      if (rows) {
        rows.forEach(row => {
          this.$refs.multipleTable.toggleRowSelection(row);
        });
      } else {
        this.$refs.multipleTable.clearSelection();
      }
    },
    handleSelectionChange(val) {
      this.multipleSelection = val;
    }
  }
}
</script>
<style scoped>
.total{
  text-align: left;
  width: 100%;
}
.button{
  margin-top: 20px;
}
</style>
