<template>
  <div>
    <a-row style="margin-top: 15px">
      <a-col :span="24">
        <div style="background: #ECECEC; padding: 30px;" v-if="user.roleId == 75">
          <a-row :gutter="16">
            <a-col :span="8">
              <a-card hoverable>
                <a-row>
                  <a-col :span="24" style="font-size: 13px;margin-bottom: 8px;font-family: SimHei">本日热量摄入 <span style="font-size: 12px">建议摄入：</span><span style="color: #fa541c">{{ titleData.heatRule }} 卡</span></a-col>
                  <a-col :span="4"><a-icon type="arrow-up" style="font-size: 30px;margin-top: 3px"/></a-col>
                  <a-col :span="18" style="font-size: 28px;font-weight: 500;font-family: SimHei">
                    {{ titleData.heat }}
                    <span style="font-size: 20px;margin-top: 3px">卡</span>
                  </a-col>
                </a-row>
              </a-card>
            </a-col>
            <a-col :span="8">
              <a-card hoverable>
                <a-row>
                  <a-col :span="24" style="font-size: 13px;margin-bottom: 8px;font-family: SimHei">本日蛋白质摄入 <span style="font-size: 12px">建议摄入：</span><span style="color: #fa541c">{{ titleData.proteinRule }} 克</span></a-col>
                  <a-col :span="4"><a-icon type="arrow-up" style="font-size: 30px;margin-top: 3px"/></a-col>
                  <a-col :span="18" style="font-size: 28px;font-weight: 500;font-family: SimHei">
                    {{ titleData.protein }}
                    <span style="font-size: 20px;margin-top: 3px">克</span>
                  </a-col>
                </a-row>
              </a-card>
            </a-col>
            <a-col :span="8">
              <a-card hoverable>
                <a-row>
                  <a-col :span="24" style="font-size: 13px;margin-bottom: 8px;font-family: SimHei">本日脂肪摄入 <span style="font-size: 12px">建议摄入：</span><span style="color: #fa541c">{{ titleData.fatRule }} 克</span></a-col>
                  <a-col :span="4"><a-icon type="arrow-up" style="font-size: 30px;margin-top: 3px"/></a-col>
                  <a-col :span="18" style="font-size: 28px;font-weight: 500;font-family: SimHei">
                    {{ titleData.fat }}
                    <span style="font-size: 20px;margin-top: 3px">克</span>
                  </a-col>
                </a-row>
              </a-card>
            </a-col>
          </a-row>
        </div>
      </a-col>
    </a-row>
    <a-row style="margin-top: 15px" v-if="user.roleId == 75">
      <a-col :span="24">
        <a-skeleton active v-if="loading" />
        <apexchart v-if="!loading" type="bar" height="250" :options="chartOptions1" :series="series1"></apexchart>
      </a-col>
      <a-col :span="24">
        <a-skeleton active v-if="loading" />
        <apexchart  v-if="!loading" type="line" height="250" :options="chartOptions" :series="series"></apexchart>
      </a-col>
      <a-col :span="24">
        <a-skeleton active v-if="loading" />
        <apexchart v-if="!loading" type="bar" height="250" :options="chartOptions4" :series="series4"></apexchart>
      </a-col>
    </a-row>
  </div>
</template>

<script>
import {mapState} from 'vuex'
export default {
  name: 'Home',
  computed: {
    ...mapState({
      multipage: state => state.setting.multipage,
      user: state => state.account.user
    })
  },
  data () {
    return {
      pagination: {
        onChange: page => {
          console.log(page)
        },
        pageSize: 2
      },
      bulletinList: [],
      titleData: {
        heat: 0,
        protein: 0,
        fat: 0,
        heatRule: 0,
        proteinRule: 0,
        fatRule: 0
      },
      loading: false,
      series: [{
        name: '热量',
        data: []
      }],
      chartOptions: {
        chart: {
          type: 'line',
          height: 300
        },
        xaxis: {
          categories: []
        },
        stroke: {
          curve: 'stepline'
        },
        dataLabels: {
          enabled: false
        },
        title: {
          text: '近十天热量消耗统计',
          align: 'left'
        },
        markers: {
          hover: {
            sizeOffset: 4
          }
        }
      },
      series1: [],
      chartOptions1: {
        chart: {
          type: 'bar',
          height: 300
        },
        title: {
          text: '近十天热量摄入统计',
          align: 'left'
        },
        plotOptions: {
          bar: {
            horizontal: false,
            columnWidth: '55%'
          }
        },
        dataLabels: {
          enabled: false
        },
        stroke: {
          show: true,
          width: 2,
          colors: ['transparent']
        },
        xaxis: {
          categories: []
        },
        yaxis: {
          title: {
            text: ''
          }
        },
        fill: {
          opacity: 1
        },
        tooltip: {
          y: {
            formatter: function (val) {
              return val + ' 卡'
            }
          }
        }
      },
      series4: [],
      chartOptions4: {
        chart: {
          type: 'bar',
          height: 300
        },
        title: {
          text: '近十天体重记录统计',
          align: 'left'
        },
        plotOptions: {
          bar: {
            horizontal: false,
            columnWidth: '55%'
          }
        },
        dataLabels: {
          enabled: false
        },
        stroke: {
          show: true,
          width: 2,
          colors: ['transparent']
        },
        xaxis: {
          categories: []
        },
        yaxis: {
          title: {
            text: ''
          }
        },
        fill: {
          opacity: 1
        },
        tooltip: {
          y: {
            formatter: function (val) {
              return val + ' kg'
            }
          }
        }
      },
      series2: [],
      chartOptions2: {
        chart: {
          type: 'donut',
          height: 300
        },
        labels: [],
        title: {
          text: '类型统计',
          align: 'left'
        },
        responsive: [{
          breakpoint: 380,
          options: {
            chart: {
              width: 200
            },
            legend: {
              position: 'bottom'
            }
          }
        }]
      },
      series3: [{
        name: 'SAMPLE A',
        data: [
          [16.4, 5.4], [21.7, 2], [25.4, 3], [19, 2], [10.9, 1], [13.6, 3.2], [10.9, 7.4], [10.9, 0], [10.9, 8.2], [16.4, 0], [16.4, 1.8], [13.6, 0.3], [13.6, 0], [29.9, 0], [27.1, 2.3], [16.4, 0], [13.6, 3.7], [10.9, 5.2], [16.4, 6.5], [10.9, 0], [24.5, 7.1], [10.9, 0], [8.1, 4.7], [19, 0], [21.7, 1.8], [27.1, 0], [24.5, 0], [27.1, 0], [29.9, 1.5], [27.1, 0.8], [22.1, 2]]
      }, {
        name: 'SAMPLE B',
        data: [
          [36.4, 13.4], [1.7, 11], [5.4, 8], [9, 17], [1.9, 4], [3.6, 12.2], [1.9, 14.4], [1.9, 9], [1.9, 13.2], [1.4, 7], [6.4, 8.8], [3.6, 4.3], [1.6, 10], [9.9, 2], [7.1, 15], [1.4, 0], [3.6, 13.7], [1.9, 15.2], [6.4, 16.5], [0.9, 10], [4.5, 17.1], [10.9, 10], [0.1, 14.7], [9, 10], [12.7, 11.8], [2.1, 10], [2.5, 10], [27.1, 10], [2.9, 11.5], [7.1, 10.8], [2.1, 12]]
      }, {
        name: 'SAMPLE C',
        data: [
          [21.7, 3], [23.6, 3.5], [24.6, 3], [29.9, 3], [21.7, 20], [23, 2], [10.9, 3], [28, 4], [27.1, 0.3], [16.4, 4], [13.6, 0], [19, 5], [22.4, 3], [24.5, 3], [32.6, 3], [27.1, 4], [29.6, 6], [31.6, 8], [21.6, 5], [20.9, 4], [22.4, 0], [32.6, 10.3], [29.7, 20.8], [24.5, 0.8], [21.4, 0], [21.7, 6.9], [28.6, 7.7], [15.4, 0], [18.1, 0], [33.4, 0], [16.4, 0]]
      }],
      chartOptions3: {
        chart: {
          height: 350,
          type: 'scatter',
          zoom: {
            enabled: true,
            type: 'xy'
          }
        },
        title: {
          text: '近十天收入统计',
          align: 'left'
        },
        xaxis: {
          tickAmount: 10,
          labels: {
            formatter: function (val) {
              return parseFloat(val).toFixed(1)
            }
          }
        },
        yaxis: {
          tickAmount: 7
        }
      }
    }
  },
  mounted () {
    console.log(this.user)
    this.loading = true
    this.selectHomeData()
    this.queryHeatByUserToday()
    setTimeout(() => {
      this.loading = false
    }, 200)
  },
  methods: {
    queryHeatByUserToday () {
      this.$get('/cos/weight-record-info/queryHeatByUserToday', {userId: this.user.userId}).then((r) => {
        this.titleData = r.data
        console.log(JSON.stringify(this.titleData))
      })
    },
    selectHomeData () {
      this.$get('/cos/weight-record-info/selectRateWithDays', {userId: this.user.userId}).then((r) => {
        console.log(r.data)
        let values = []
        let values1 = []
        if (r.data.caloriesIn !== null && r.data.caloriesIn.length !== 0) {
          if (this.chartOptions1.xaxis.categories.length === 0) {
            this.chartOptions1.xaxis.categories = Array.from(r.data.caloriesIn, ({days}) => days)
          }
          let itemData = { name: '摄入', data: Array.from(r.data.caloriesIn, ({amount}) => amount) }
          values.push(itemData)
          this.series1 = values
        }
        if (r.data.weight !== null && r.data.weight.length !== 0) {
          if (this.chartOptions4.xaxis.categories.length === 0) {
            this.chartOptions4.xaxis.categories = Array.from(r.data.weight, ({days}) => days)
          }
          let itemData = { name: '体重', data: Array.from(r.data.weight, ({weight}) => weight) }
          values1.push(itemData)
          this.series4 = values1
        }
        this.series[0].data = Array.from(r.data.caloriesOut, ({amount}) => amount)
        this.chartOptions.xaxis.categories = Array.from(r.data.caloriesOut, ({days}) => days)
      })
    }
  }
}
</script>

<style scoped>

</style>
