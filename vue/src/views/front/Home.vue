<template>
  <div class="main-content">
    <div style="width:80%;margin:0 auto " >
      <el-carousel height="320px">
        <el-carousel-item v-for="item in carouseDate" :key="item">
         <img :src="item" alt="" style="width:100%;height:320px ">//动态渲染
        </el-carousel-item>
      </el-carousel>
      <div style="margin-top: 20px">
        <el-row :gutter="20">
          <el-col :span="12" >
            <div class="card" >
              <div style="display: flex">
              <div style="flex:1;color: navy;font-size: 18px;font-weight: 550 ">最新发布失物</div>
              <div style="flex:1;text-align: right; color: #666666 ;cursor: pointer" @click="$router.push('/front/lostSquare')">查看更多</div>
              </div>
              <div style="margin-top: 30px" >
                <el-row :gutter="20">
                    <el-col :span="12" v-for="item in lostData" style="margin-bottom: 20px">
                      <div class="transition card">
                      <div style="display: flex" ><!--由于后台还没有设置好现在使用静态处理-->
                        <img :src="item.img" alt="" style="height: 75px; width: 75px;border: 1px solid #eeeeee;border-radius: 15px">
                        <div style="margin-left: 10px">
                          <div style="font-weight: 550;color: #0066BC">{{ item.name}}</div>
                          <div style="margin-top: 10px;color:#666666;font-size: 12px">发布人:{{ item.userName}}
                            <el-tooltip effect="light" content="聊天" placement="right" :hide-after="2000">
                              <i @click="chat(item.userId)" class="el-icon-chat-dot-round" style="font-size: 18px; margin-left: 3px; cursor: pointer"></i>
                            </el-tooltip>
                          </div> <!--根据用户id关联一下找出用户名称-->
                          <div style="margin-top: 5px;color:#666666;font-size: 12px">时间:{{ item.time}}</div>
                        </div>
                      </div>
                      <div style="margin-top: 20px;text-align: center">
                        <el-button type="info" size="mini" @click="viewDetail(item.content)">查看详情</el-button>
                        <el-button type="success" size="mini" @click="contact(item,'失物广场')">联系失主</el-button>
                      </div>
                      </div>
                    </el-col>
                </el-row>
              </div>
            </div>
          </el-col>
          <el-col :span="12">
            <div class="card">
              <div style="display: flex">
                <div style="flex:1;color: navy;font-size: 18px;font-weight: 550 ">最新发布招领</div>
                <div style="flex:1;text-align: right; color: #666666;cursor: pointer" @click="$router.push('/front/findSquare')">查看更多</div>
              </div>
              <div style="margin-top: 30px" >
                <el-row :gutter="20">
                  <el-col :span="12" v-for="item in findData" style="margin-bottom: 20px">
                    <div class="transition card">
                      <div style="display: flex" ><!--由于后台还没有设置好现在使用静态处理-->
                        <img :src="item.img" alt="" style="height: 75px; width: 75px;border: 1px solid #eeeeee;border-radius: 15px">
                        <div style="margin-left: 10px">
                          <div style="font-weight: 550;color: #0066BC">{{ item.name}}</div>
                          <div style="margin-top: 10px;color:#666666;font-size: 12px">发布人:{{ item.userName}}
                            <el-tooltip effect="light" content="聊天" placement="right" :hide-after="2000">
                              <i @click="chat(item.userId)" class="el-icon-chat-dot-round" style="font-size: 18px; margin-left: 3px; cursor: pointer"></i>
                            </el-tooltip>
                          </div> <!--根据用户id关联一下找出用户名称-->
                          <div style="margin-top: 5px;color:#666666;font-size: 12px">时间:{{ item.time}}</div>
                        </div>
                      </div>
                    <div style="margin-top: 20px;text-align: center">
                      <el-button type="info" size="mini"@click="viewDetail(item.content)">查看详情</el-button>
                      <el-button type="success" size="mini" @click="contact(item,'招领广场')" >联系拾到者</el-button>

                    </div>
                  </div>
                </el-col>
              </el-row>
            </div>
            </div>
          </el-col>
        </el-row>

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

import router from "@/router";

export default {

  data() {
    return {
      carouseDate:[
          require('@/assets/imgs/front3.jpg'),
        require('@/assets/imgs/front4.jpg'),
        require('@/assets/imgs/front2.jpg'),
        require('@/assets/imgs/front1.jpg'),
      ],
      lostData: [],
      findData: [],
      viewVisible:false,
      viewData:null,
      fromVisible:false,
      content:null,
      form: {},
      type: null,
      user: JSON.parse(localStorage.getItem('xm-user') || '{}'),


    }
  },
  mounted() {
    this.loadData()
  },
  // methods：本页面所有的点击事件或者其他函数定义区
  methods: {
    router() {
      return router
    },
    chat(userId) {
      this.$request.post('/chatGroup/add', { chatUserId: userId, userId: this.user.id }).then(res => {
        this.$router.push('/front/chat')
      })
    },
    loadData()
    {
        this.$request.get('/lost/selectNew4').then( res =>{
          if(res.code ==='200'){
            this.lostData = res.data
          }else{
              this.$message.error(res.msg)
          }
        });
      this.$request.get('/find/selectNew4').then( res =>{
        if(res.code ==='200'){
          this.findData = res.data
        }else{
          this.$message.error(res.msg)
        }
      })
    },
    viewDetail(content){
      this.viewData=content
      this.viewVisible=true
    },
    contact(item,type)
    {
      this.form=JSON.parse(JSON.stringify(item))
      this.type=type
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
        type:this.type,
        fromId: this.user.id,
        toId: this.form.userId,
        content:this.content
      }
      this.$request.post('/message/add',data).then(res => {
        if(res.code ==='200'){
          this.$message.success('留言成功，等待对方联系')
          this.content=null
          this.fromVisible=false
          this.type=null
        }else{
          this.$message.error(res.msg)
        }
      })


    },



  }
}
</script>
