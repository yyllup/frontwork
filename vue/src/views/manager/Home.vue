<template>
  <div>
    <div class="card" style="padding: 15px">
      您好，{{ user?.name }}！欢迎使用本系统
    </div>

    <div style="display: flex; margin: 10px 0">
      <div style="width: 50%;" class="card">
        <div style="margin-bottom: 30px; font-size: 20px; font-weight: bold">公告列表</div>
        <div >
          <el-timeline  reverse slot="reference">
            <el-timeline-item v-for="item in notices" :key="item.id" :timestamp="item.time">
              <el-popover
                  placement="right"
                  width="200"
                  trigger="hover"
                  :content="item.content">
                <span slot="reference">{{ item.title }}</span>
              </el-popover>
            </el-timeline-item>
          </el-timeline>
        </div>
      </div>
      <div style="width: 50%;height: 350px" class="card" id="pie1"></div>
    </div>
    <div style="display: flex; margin: 10px 0">
      <div style="width: 50%;height: 350px" class="card" id="pie2"></div>
      <div style="width: 50%" class="card" id="pie3"></div>
    </div>
  </div>
</template>

<script>
import * as echarts from "echarts";
let option = {
  title:{
    text:'',
    subtext:" ",
    left: 'center'
  },
  tooltip: {
    trigger: 'item',
    formatter:'{a} <br> {b} : {c} ({d}%)'
  },
  legend: {
    orient: 'vertical',
    left: 'left'
  },
  series: [
    {
      name: '',
      type: 'pie',
      radius: ['40%', '70%'],
      emphasis: {
        label: {
          show: true,
          fontSize: 16,
          fontWeight: 'bold'
        },
        itemStyle: {
          shadowBlur: 10,
          shadowOffsetX: 0,
          shadowColor: 'rgba(0, 0, 0, 0.5)'
        }
      },
      data: [
        { value: 1048, name: '失物广场' },
        { value: 735, name:  '招领广场' },

      ]
    }
  ]
};
let optionLost = {
  title:{
    text:'',
    subtext:" ",
    left: 'center'
  },
  tooltip: {
    trigger: 'item',
    formatter:'{a} <br>{b} :{c} ({d}%)'
  },
  legend: {
    orient: 'vertical',
    left: 'left'
  },
  series: [
    {
      name: '',
      type: 'pie',
      radius: ['40%', '70%'],
      emphasis: {
        label: {
          show: true,
          fontSize: 16,
          fontWeight: 'bold'
        },
        itemStyle: {
          shadowBlur: 10,
          shadowOffsetX: 0,
          shadowColor: 'rgba(0, 0, 0, 0.5)'
        }
      },
      data: [
        { value: 1048, name: '失物广场' },
        { value: 735, name:  '招领广场' },

      ]
    }
  ]
};//圆形百分比图pie2
let optionFind = {
  title:{
    text:'',
    subtext:" ",
    left: 'center'
  },
  tooltip: {
    trigger: 'item',
    formatter:'{a} <br>{b} :{c} ({d}%)'
  },
  legend: {
    orient: 'vertical',
    left: 'left'
  },
  series: [
    {
      name: '',
      type: 'pie',
      radius: ['40%', '70%'],
      emphasis: {
        label: {
          show: true,
          fontSize: 16,
          fontWeight: 'bold'
        },
        itemStyle: {
          shadowBlur: 10,
          shadowOffsetX: 0,
          shadowColor: 'rgba(0, 0, 0, 0.5)'
        }
      },
      data: [
        { value: 1048, name: '失物广场' },
        { value: 735, name:  '招领广场' },

      ]
    }
  ]
};
export default {
  name: 'Home',
  data() {
    return {
      user: JSON.parse(localStorage.getItem('xm-user') || '{}'),
      notices: []
    }
  },
  created() {
    this.$request.get('/notice/selectAll').then(res => {
      this.notices = res.data || []
    })
    this.loadTh()
    this.loadLost()
    this.loadFind()
  },
  methods:{
    loadTh(){
      this.$request.get('/echarts/all').then(res=>{
        if(res.code==='200')
        {
          let charDom=document.getElementById('pie1');
          let myChart=echarts.init(charDom);
          option.title.text=res.data.text;
          option.title.subtext=res.data.subtext;
          option.series[0].name=res.data.name;
          option.series[0].data=res.data.data;
          myChart.setOption(option);
        }
        else {
          this.$message.error(res.msg)
        }
      })

    },
    loadLost()
    {
      this.$request.get('/echarts/lost').then(res=>{
        if(res.code==='200')
        {
          let charDom=document.getElementById('pie2');
          let myChart=echarts.init(charDom);
          optionLost.title.text=res.data.text;
          optionLost.title.subtext=res.data.subtext;
          optionLost.series[0].name=res.data.name;
          optionLost.series[0].data=res.data.data;
          myChart.setOption(optionLost);
        }
        else {
          this.$message.error(res.msg)
        }
      })

    },
    loadFind()
    {
      this.$request.get('/echarts/find').then(res=>{
        if(res.code==='200')
        {
          let charDom=document.getElementById('pie3');
          let myChart=echarts.init(charDom);
          optionLost.title.text=res.data.text;
          optionLost.title.subtext=res.data.subtext;
          optionLost.series[0].name=res.data.name;
          optionLost.series[0].data=res.data.data;
          myChart.setOption(optionLost);
        }
        else {
          this.$message.error(res.msg)
        }
      })


    },
  }

}
</script>
