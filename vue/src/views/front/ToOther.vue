<template>
  <div class="main-content">
    <div style="width:70%;margin:20px auto">
      <div style="font-size: 20px;color: #000b17;margin: 10px">我联系的({{total}})</div>
      <div class="table">
        <el-table :data="tableData" strip >
          <el-table-column prop="id" label="序号" width="70" align="center" sortable></el-table-column>
          <el-table-column label="物品图片">
            <template v-slot="scope">
              <div style="display: flex; align-items: center">
                <el-image style="width: 40px; height: 40px; border-radius: 50%" v-if="scope.row.articleImg"
                          :src="scope.row.articleImg" :preview-src-list="[scope.row.articleImg]"></el-image>
              </div>
            </template>
          </el-table-column>
          <el-table-column prop="articleName" label="物品名称"></el-table-column>
          <el-table-column prop="toName" label="发布人"></el-table-column>
          <el-table-column prop="content" label="联系内容"></el-table-column>
          <el-table-column prop="type" label="类型"></el-table-column>
          <el-table-column prop="time" label="联系时间"></el-table-column>
          <el-table-column label="操作" align="center" width="180">
            <template v-slot="scope">
              <el-button size="mini" type="danger" plain @click="del(scope.row.id)">删除</el-button>
            </template>
          </el-table-column>
        </el-table>

        <div class="pagination" style="margin-top: 20px">
          <el-pagination
              background
              @current-change="handleCurrentChange"
              :current-page="pageNum"
              :page-sizes="[5, 10, 20]"
              :page-size="pageSize"
              layout="total, prev, pager, next"
              :total="0">
          </el-pagination>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import E from 'wangeditor'

export default {

  data() {
    return {
      user: JSON.parse(localStorage.getItem('xm-user') || '{}'),//获取当前用户
      tableData: [],
      pageNum:1,
      pageSize: 6,
    }
  },
  mounted() {
    this.loadData(1)
    //加载数据库内容
  },
  // methods：本页面所有的点击事件或者其他函数定义区
  methods: {
    loadData(pageNum)
    {
      if(pageNum) this.pageNum=pageNum;
      this.$request.get('/message/selectPage',{
        params:{//条件判断一下
          fromId: this.user.id,
          pageNum:this.pageNum,
          pageSize:this.pageSize,
          total: 0,
        }
      }).then(res=>{//请求数据库查询
        if(res.code==='200')
        {
          this.tableData = res.data?.list
          this.total = res.data?.total
        }
      })
    },
    del(id) {   // 单个删除
      this.$confirm('您确定删除吗？', '确认删除', {type: "warning"}).then(response => {
        this.$request.delete('/message/delete/' + id).then(res => {
          if (res.code === '200') {   // 表示操作成功
            this.$message.success('操作成功')
            this.loadData(1)
          } else {
            this.$message.error(res.msg)  // 弹出错误的信息
          }
        })
      }).catch(() => {
      })
    },
    handleCurrentChange(pageNum)
    {
      this.pageNum=pageNum;
      this.loadData(this.pageNum);
    }

  }
}
</script>
