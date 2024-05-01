<template>
  <div class="main-content">
    <div style=" width:80%;margin: 20px auto">
      <div style="color: darkblue; font-size: 25px;font-weight: 550">欢迎来到失物广场，如果您看到了，请及时联系失主！！！</div>
      <div style="margin-top: 30px">
        <el-input placeholder="请输入标题查询" style="width: 200px" v-model="name" ></el-input>
        <el-button type="info" plain style="margin-left: 10px" @click="load(1)">查询</el-button>
        <el-button type="warning" plain style="margin-left: 10px" @click="reset">重置</el-button>
      </div>
      <div style="margin-top: 20px">
        <el-row :gutter="20">
          <el-col :span="6" v-for="item in lostData" style="margin-bottom: 20px">
            <div class="transition card">
              <div style="display: flex" ><!--由于后台还没有设置好现在使用静态处理-->
                <img :src="item.img" alt="" style="height: 75px; width: 75px;border: 1px solid #eeeeee;border-radius: 15px">
                <div style="margin-left: 10px">
                  <div style="font-weight: 550;color: #0066BC">{{ item.name}}</div>
                  <el-tooltip effect="light" content="聊天" placement="right" :hide-after="2000">
                    <i @click="chat(item.userId)" class="el-icon-chat-dot-round" style="font-size: 18px; margin-left: 3px; cursor: pointer"></i>
                  </el-tooltip>
                  <div style="margin-top: 10px;color:#666666;font-size: 12px">发布人:{{item.userName}}
                  </div> <!--根据用户id关联一下找出用户名称-->
                  <div style="margin-top: 5px;color:#666666;font-size: 12px">时间:{{ item.time}}</div>
                </div>
              </div>
              <div style="margin-top: 20px;text-align: center">
                <el-button type="info" size="mini" @click="viewContent(item.content)">查看详情</el-button>
                <el-button type="success" size="mini" @click="contact(item)">联系失主</el-button>

              </div>
            </div>
          </el-col>
        </el-row>
      </div>
      <div class="pagination">
        <el-pagination
            background
            @current-change="handleCurrentChange"
            :current-page="pageNum"
            :page-sizes="[5, 10, 20]"
            :page-size="pageSize"
            layout="total, prev, pager, next"
            :total="total">
        </el-pagination>
      </div>
    </div>
    <el-dialog title="详细信息" :visible.sync="viewVisible" width="80%" :close-on-click-modal="false" destroy-on-close>
      <div v-html="viewData" class="w-e-text w-e-text-container"></div>
    </el-dialog>
    <el-dialog title="留言信息" :visible.sync="fromVisible" width="40%" :close-on-click-modal="false" destroy-on-close>
      <el-form label-width="100px" style="padding-right: 50px" :model="form">
        <el-form-item prop="title" label="友情提示">
         <div style="color: #d19e05 ">请详细描述你的联系方式，方便对方联系到你</div>
        </el-form-item>
        <el-form-item prop="content" label="留言内容">
          <el-input type="textarea" :rows="5" v-model="content" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="fromVisible = false">取 消</el-button>
        <el-button type="primary" @click="submit">确 定</el-button>
      </div>
    </el-dialog>

  </div>
</template>

<script>
import E from 'wangeditor'

export default {

  data() {
    return {
      user: JSON.parse(localStorage.getItem('xm-user') || '{}'),
      name:null,
      pageNum: 1,
      pageSize: 8,
      total:0,
      lostData: [],
      viewVisible:false,
      viewData:null,
      fromVisible:false,
      content:null,
      from:{},


    }
  },
  mounted() {
    this.load(1)

  },
  // methods：本页面所有的点击事件或者其他函数定义区
  methods: {
    load(pageNum){
      if (pageNum) this.pageNum = pageNum
      this.$request.get('/lost/selectPage', {
        params: {
          pageNum: this.pageNum,
          pageSize: this.pageSize,
          name: this.name,
        }
      }).then(res => {
        this.lostData = res.data?.list
        this.total = res.data?.total
      })

    },
    chat(userId) {
      this.$request.post('/chatGroup/add', { chatUserId: userId, userId: this.user.id }).then(res => {
        this.$router.push('/front/chat')
      })
    },
    handleCurrentChange(pageNum)
    {
      this.pageNum=pageNum;
      this.load(this.pageNum);

    },
    reset() {
      this.name=null
      this.load(1)
    },
    viewContent(content)
    {
      this.viewData=content
      this.viewVisible=true

    },
    contact(item){
      this.form=JSON.parse(JSON.stringify(item))  //生成另一个对象和item相等但是他们是不同的对象
      this.fromVisible=true
    },
    submit(){
      if(this.user.id=== this.form.userId){
        this.$message.warning('您不能联系自己')
        this.fromVisible=false
        this.content=null
        return
      }
      let data={
        articleId: this.form.id,
        type:'失物广场',
        fromId: this.user.id,
        toId: this.form.userId,
        content:this.content
      }
      this.$request.post('/message/add',data).then(res => {
        if(res.code ==='200'){
          this.$message.success('留言成功，等待对方联系')
          this.content=null
          this.fromVisible=false
        }else{
          this.$message.error(res.msg)
        }
      })


    },



  }
}
</script>
