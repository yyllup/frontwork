<template>
  <div class="main-content">
    <div style="width: 70%;margin: 30px auto">
      <div style="font-size: 20px; margin: 20px 0">请对平台提出建议或者反馈</div>
      <div>
        <el-input v-model="content" type="textarea" :rows="6" placeholder="请输入你的反馈建议" ></el-input>
      </div>
      <div style="text-align: center;margin-top: 10px">
        <el-button type="primary" style="width: 40%;" @click="submit">提交</el-button>
      </div>
      <div style="margin: 20px 0;font-size: 20px; color: #005ca9;font-weight: 550">
        看看其他用户发表的意见与反馈({{suggestionData.length}})
      </div>
      <div>
        <template>
          <el-table :data="suggestionData" stripe style="width: 100%;color: #000b17;font-size: 13px">
            <el-table-column prop="avatar" label="头像"  show-overflow-tooltip>
              <template v-slot="scope">
                <div style="display: flex; align-items: center">
                  <el-image style="width: 45px; height: 45px; border-radius: 100%" v-if="scope.row.avatar"
                            :src="scope.row.avatar" :preview-src-list="[scope.row.avatar]"></el-image>
                </div>
              </template>
            </el-table-column>
            <el-table-column prop="userName" label="用户名称" width="150" />
            <el-table-column prop="content" label="意见与反馈" width="240" />
            <el-table-column prop="time" label="时间" color="#666666"/>

          </el-table>
        </template>

      </div>
    </div>

  </div>
</template>

<script>
import E from 'wangeditor'

export default {

  data() {
    return {
      user: JSON.parse(localStorage.getItem('xm-user') || '{}'),
      content: null,
       suggestionData : []
    }
  },
  mounted() {
    this.loadSuggestion()
  },
  // methods：本页面所有的点击事件或者其他函数定义区
  methods: {
    loadSuggestion()
    {
        this.$request.get('suggestion/selectAll').then(res=>{
          if(res.code==='200')
          {
                this.suggestionData=res.data
          }else
          {
            this.$message.error(res.msg)
          }
        })
    },
    submit()
    {
      let data={
        userId: this.user.id,
        content: this.content
      }//调用接口
      this.$request.post('/suggestion/add', data).then(res=>{
        if(res.code==='200')
        {
          this.$message.success('提交成功')
          this.content=null
          this.loadSuggestion()

        }else
        {
          this.$message.error(res.msg)
        }


          })

    },


  }
}
</script>
