<template>
  <div class="main-content">
    <div style="width:80%;margin:0 auto " >
  <el-carousel :interval="4000" type="card" height="300px">
    <el-carousel-item v-for="item in carouseDate" :key="item">
      <img :src="item" alt="" style="width:100%;height:300px ">
    </el-carousel-item>
  </el-carousel>
      <div style="margin-top: 20px">
        <el-row :gutter="20">
          <el-col :span="8" >
            <div class="card" >
              <div style="display: flex">
                <div style="flex:1;color: navy;font-size: 18px;font-weight: 550 ">通知公告</div>
                <div style="flex:1;text-align: right; color: #666666 ;cursor: pointer "><a style="color: #666666" href="https://www.hnust.edu.cn/sylm/ggtz/index.htm">查看更多</a></div>
              </div>
              <br>
              <li><a style="color:#000b17" href="https://www.hnust.edu.cn/sylm/nwfb/a52353cb35ed4569be5ed2ea2c2d35bc.blk.htm"
                     target="_blank"><span>04-20 </span>关于2024年“五一”放假及作息时间调整的通知</a></li>
              <br>
              <li><a style="color: #000b17" href="https://www.hnust.edu.cn/sylm/nwfb/a52353cb35ed4569be5ed2ea2c2d35bc.blk.htm"
                     target="_blank"><span>04-25 </span>关于做好2024年度享受湘潭市政府特殊津贴人员选拔推荐工作的通知</a></li>
              <br>
              <li><a style="color: #000b17" href="https://www.hnust.edu.cn/sylm/nwfb/fc8b546cd9b6481c9bc2393c6c2b199f.blk.htm"
                     target="_blank"><span>04-24 </span>关于组织参加2024 年高校实验室安全工作培训会的通知</a></li>
              <br>
              <li><a style="color: #000b17" href="https://www.hnust.edu.cn/sylm/nwfb/9792b442606e4d3ebb99f3fa19193791.blk.htm"
                     target="_blank"><span>04-23 </span>关于开展全校实验室安全分级分类认定工作的通知</a></li>
            </div>
          </el-col>
          <el-col :span="8">
            <div class="card">
              <div style="display: flex">
                <div style="flex:1;color: navy;font-size: 18px;font-weight: 550 ">党建引领</div>
                <div style="flex:1;text-align: right; color: #666666;cursor: pointer"><a style="color: #666666"  href="https://news.hnust.edu.cn/djyl/index.htm">查看更多</a></div>
                <br>
              </div>
              <br>
              <li><a style="color:#000b17" href="https://news.hnust.edu.cn/djyl/14d5d6e0a11648238ca686ba57f32a8e.htm"
                     target="_blank"><span>04-25 </span>学校组织新提拔干部、年轻干部、关键岗位干部等重点对象集中开展纪律教育</a></li>
              <br>
              <li><a style="color: #000b17" href="https://www.hnust.edu.cn/sylm/nwfb/a52353cb35ed4569be5ed2ea2c2d35bc.blk.htm"
                     target="_blank"><span>04-24 </span>机电学院研究生第四党支部入选全国高校“百个研究生样板党支部”创建名单</a></li>
              <br>
              <li><a style="color: #000b17" href="https://news.hnust.edu.cn/djyl/c7f41af93519419ba27c07c3724265ac.htm"
                     target="_blank"><span>04-19 </span>学校举行党委理论学习中心组第5次集体学习（扩大）暨党纪学习教育读书班集体学习</a></li>
              <br>
              <li><a style="color: #000b17" href="https://news.hnust.edu.cn/djyl/1bcf81948d3e4bddb28fe0c8b902a361.htm"
                     target="_blank"><span>04-18 </span>省教育厅民族教育处党支部与我校组织部统战部联合党支部结对共建</a></li>
            </div>
          </el-col>
          <el-col :span="8">
            <div class="card">
              <div style="display: flex">
                <div style="flex:1;color: navy;font-size: 18px;font-weight: 550 ">综合新闻</div>
                <div style="flex:1;text-align: right; color: #666666;cursor: pointer"><a style="color: #666666"  href="https://news.hnust.edu.cn/kdyw/index.htm">查看更多</a></div>

              </div>
              <br>
              <li><a style="color:#000b17" href="https://news.hnust.edu.cn/kdyw/ed158ade40b84a77b353a97edb3ee692.htm"
                     target="_blank"><span>04-25 </span>教育部科技部自然资源部中共湖南省委联合发文向万步炎同志学习</a></li>
              <br>
              <li><a style="color: #000b17" href="https://news.hnust.edu.cn/xyxw/04970651ea9e4764b3edafb622e2f938.htm"
                     target="_blank"><span>04-26 </span>北京警察学院来校调研本科教育教学审核评估工作</a></li>
              <br>
              <li><a style="color: #000b17" href="https://news.hnust.edu.cn/kdyw/ca187ff9cbff49cea6d7f68d8ae429a9.htm"
                     target="_blank"><span>04-25 </span>矢志报国 向海图强</a></li>
              <br>
              <li><a style="color: #000b17" href="https://news.hnust.edu.cn/kdyw/b91fbb4bc918422a96f2fbddfa42f3f6.htm"
                     target="_blank"><span>04-25 </span>世界读书日暨2024年“一校一书”阅读推广活动启动</a></li>
              <br>

            </div>
          </el-col>
        </el-row>
      </div>
      <div style="margin-top: 20px">
        <el-row :gutter="20">
          <el-col :span="24" >
            <div class="card" >
              <div style="display: flex">
                <div style="flex:1;color: navy;font-size: 18px;font-weight: 550 ">学院</div>
              </div>
             <el-col :span="8">
               <br>
              <li><a style="color: #000b17" href="https://zaxy.hnust.edu.cn" target="_blank">资源环境与安全工程学院</a></li>
              <li><a style="color: #000b17" href="https://tmxy.hnust.edu.cn" target="_blank">土木工程学院</a></li>
              <li>
                <a style="color: #000b17" href="https://jd.hnust.edu.cn" target="_blank">机电工程学院</a>
              </li>

              <li><a style="color: #000b17" href="https://xinxi.hnust.edu.cn" target="_blank">信息与电气工程学院</a></li>

              <li><a style="color: #000b17" href="https://computer.hnust.edu.cn/" target="_blank">计算机科学与工程学院</a></li>

              <li><a style="color: #000b17" href="https://chem.hnust.edu.cn" target="_blank">化学化工学院</a></li>
             </el-col>
              <el-col :span="8">
                <br>
              <li><a style="color: #000b17" href="https://math.hnust.edu.cn/pub/sxxy/" target="_blank">数学与计算科学学院</a></li>

              <li><a style="color: #000b17" href="https://wlxy.hnust.edu.cn/" target="_blank">物理与电子科学学院</a></li>

              <li><a style="color: #000b17" href="https://life-science.hnust.edu.cn/" target="_blank">生命科学与健康学院</a></li>

              <li><a style="color: #000b17" href="https://hnkdjz.hnust.edu.cn/" target="_blank">建筑与艺术设计学院</a></li>

              <li><a style="color: #000b17" href="https://rwxy.hnust.edu.cn" target="_blank">人文学院</a></li>

              <li><a style="color: #000b17" href="https://wyxy.hnust.edu.cn" target="_blank">外国语学院</a></li>

              <li><a style="color: #000b17" href="https://marxism.hnust.edu.cn/" target="_blank">马克思主义学院</a></li>

              <li><a style="color: #000b17" href="https://jyxy.hnust.edu.cn" target="_blank">教育学院</a></li>
              </el-col>
              <br>
              <li><a style="color: #000b17" href="https://sxy.hnust.edu.cn/" target="_blank">商学院</a></li>

              <li><a style="color: #000b17" href="https://art.hnust.edu.cn/" target="_blank">齐白石艺术学院</a></li>

              <li><a style="color: #000b17" href="https://sports.hnust.edu.cn" target="_blank">体育学院（中国铁人三项运动学院）</a></li>

              <li><a style="color: #000b17" href="https://law.hnust.edu.cn" target="_blank">法学与公共管理学院（纪检监察学院）</a></li>

              <li><a style="color: #000b17" href="https://mse.hnust.edu.cn/" target="_blank">材料科学与工程学院</a></li>

              <li><a style="color: #000b17" href="https://dxy.hnust.edu.cn/index.htm" target="_blank">地球科学与空间信息工程学院</a></li>

              <li><a style="color: #000b17" href="https://sfxy.hnust.edu.cn/" target="_blank">师范学院</a></li>

              <li><a style="color: #000b17" href="https://yyxy.hnust.edu.cn/" target="_blank">黎锦晖音乐学院</a></li>


            </div>
          </el-col>
        </el-row>
      </div>
  </div>
  </div>
</template>

<script>
export default {
  name: "News",
  data() {
    return {
      activeName: '',
      carouseDate:[
        require('@/assets/imgs/new1.jpg'),
        require('@/assets/imgs/new2.png'),
        require('@/assets/imgs/new3.jpg'),
        require('@/assets/imgs/new4.jpg'),
        require('@/assets/imgs/new5.jpg'),
      ],
    };
},
  methods: {
    handleClick(tab, event) {
      console.log(tab, event);
    }
  }
};
</script>

<style scoped>
.el-carousel__item h3 {
  color: #475669;
  font-size: 14px;
  opacity: 0.75;
  line-height: 200px;
  margin: 0;
}

.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n+1) {
  background-color: #d3dce6;
}

</style>