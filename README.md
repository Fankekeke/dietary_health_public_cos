### 基于SpringBoot + Vue的饮食监控管理系统.

膳食营养分析、智能热量追踪、健康食谱定制、营养摄入监控

###### 管理员：
用户管理 、消息管理 、公告管理 、贴子管理 、敏感词管理 、模块管理 、消息回复 、蔬菜百科 、留言板 、首页管理 、饮食健康 、菜品管理 、用户菜品 、代办任务 、饮食记录 、营养设定 、运动种类 、运动记录 、打卡记录 、用户运动、数据统计。

###### 用户：
账户注册登录、密码修改、我的关注 、我的收藏 、我的贴子 、系统消息 、留言板 、我的菜品 、系统食谱 、我的待办 、饮食记录 、运动订阅 、运动记录 、打卡记录。

##### 饮食与营养管理
###### 菜品管理/食谱： 维护详尽的菜品库与科学食谱，为用户提供专业的营养摄入参考方案。

###### 用户菜品/记录： 用户记录每日饮食内容，系统自动同步饮食数据，支持个性化菜谱定制。

###### 营养设定/百科： 管理员设定营养摄入标准并维护蔬菜百科，为用户科普健康的饮食知识。

##### 运动与健康追踪
###### 运动种类/订阅： 预设多种运动类型供用户选择订阅，构建多元化的个人健康提升计划。

###### 运动/打卡记录： 实时记录运动轨迹与打卡数据，通过量化指标直观展示用户身体状态变化。

###### 用户运动管理： 管理员监控全平台用户的运动趋势，提供科学的运动指导与任务监督。

##### 内容安全与互动社区
###### 贴子/留言管理： 提供分享交流的空间，支持发布心得与反馈，营造积极的健康社交氛围。

###### 敏感词/模块管理： 实时过滤不良信息并优化功能版块配置，确保社区环境绿色合规。

###### 消息管理/回复： 处理用户咨询并推送系统提醒，保障医患或平台与用户间的沟通效率。

##### 个人事务与提醒体系
###### 待办任务/订阅： 用户规划健康日程，系统定时提醒饮食补给与运动任务，培养良好习惯。

###### 关注/收藏/首页： 支持用户收藏优质内容并关注好友，通过首页管理展示最核心的健康动态。

#### 安装环境

JAVA 环境 

Node.js环境 [https://nodejs.org/en/] 选择14.17

Yarn 打开cmd， 输入npm install -g yarn !!!必须安装完毕nodejs

Mysql 数据库 [https://blog.csdn.net/qq_40303031/article/details/88935262] 一定要把账户和密码记住

redis

Idea 编译器 [https://blog.csdn.net/weixin_44505194/article/details/104452880]

WebStorm OR VScode 编译器 [https://www.jianshu.com/p/d63b5bae9dff]

#### 采用技术及功能

后端：SpringBoot、MybatisPlus、MySQL、Redis、
前端：Vue、Apex、Antd、Axios

平台前端：vue(框架) + vuex(全局缓存) + rue-router(路由) + axios(请求插件) + apex(图表)  + antd-ui(ui组件)

平台后台：springboot(框架) + redis(缓存中间件) + shiro(权限中间件) + mybatisplus(orm) + restful风格接口 + mysql(数据库)

开发环境：windows10 or windows7 ， vscode or webstorm ， idea + lambok


#### 前台启动方式
安装所需文件 yarn install 
运行 yarn run dev

#### 默认后台账户密码
[管理员]
admin
1234qwer

#### 项目截图
暂无

|  |  |
|---------------------|---------------------|
| ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/7cf2ebad-9adb-4e94-81cd-da748bca5ec3.png) | ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/a68bce4f-bb3c-402c-8f2f-b55744377f73.png) |
| ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/7d8d4c54-43b1-482f-a412-8e28c9b1f758.png) | ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/b16df7a6-0753-48c7-862e-593a62850c5c.png) |
| ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/9d1a11e4-e169-4985-8cf7-5ea2d0ef12a2.png) | ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/bb6ce298-427e-4e20-9448-8b805c7e8f72.png) |
| ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/9f7bcd30-dd0e-43e3-9c21-272bfd9b2dd7.png) | ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/d655926f-226f-4992-8ee4-49b7cb219035.png) |
| ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/63d0c89f-a820-49f8-ab15-5428f1fb9437.png) | ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/e04d4545-a0b3-4452-baf4-3e712c8d22d5.png) |
| ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/63e50c9f-fd90-40cd-a07d-bda92933d7ae.png) | ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/e91a3e50-a949-4c82-aa52-2c67ee8841c4.png) |
| ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/82c8b9b1-a7a8-4ab1-beeb-c48712881b18.png) | ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/e96676eb-cdf6-4ca0-a826-e8ed12994aed.png) |
| ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/715acc33-946c-4c0f-89a5-39afa2863287.png) | ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/eb7e3ff2-a074-4a2b-a7d2-03b8150fd6e0.png) |
| ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/716c8b57-7e00-477a-8e19-4dece18ac2c0.png) | ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/0b8e8c61-5069-4538-923b-187e3457413a.png) |
| ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/21046c69-48ea-4cec-8ff6-b2fa4a06a85e.png) | ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/1e06345d-482f-4636-8a90-b8b907a79643.png) |
| ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/92106fae-0427-466c-a43a-fe94418db042.png) | ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/02f84ffb-ca4c-46de-afe9-6b2a97c412af.png) |
| ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/50149802-8bb3-41ac-a717-7c5ffbb637bb.png) | ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/4c111944-a6ca-494f-bd61-1dc6f081b51d.png) |
| ![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/77697668-2591-49b5-bb7a-605be1dcfde8.png) |  |

![](https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/work/936e9baf53eb9a217af4f89c616dc19.png)

#### 演示视频

暂无

#### 获取方式

Email: fan1ke2ke@gmail.com

WeChat: `Storm_Berserker`

`附带部署与讲解服务，因为要恰饭资源非免费，伸手党勿扰，谢谢理解😭`

> 1.项目纯原创，不做二手贩子 2.一次购买终身有效 3.项目讲解持续到答辩结束 4.非常负责的答辩指导 5.**黑奴价格**

> 项目部署调试不好包退！功能逻辑没讲明白包退！

#### 其它资源

[2025年-答辩顺利通过-客户评价🍜](https://berserker287.github.io/2025/06/18/2025%E5%B9%B4%E7%AD%94%E8%BE%A9%E9%A1%BA%E5%88%A9%E9%80%9A%E8%BF%87/)

[2024年-答辩顺利通过-客户评价👻](https://berserker287.github.io/2024/06/06/2024%E5%B9%B4%E7%AD%94%E8%BE%A9%E9%A1%BA%E5%88%A9%E9%80%9A%E8%BF%87/)

[2023年-答辩顺利通过-客户评价🐢](https://berserker287.github.io/2023/06/14/2023%E5%B9%B4%E7%AD%94%E8%BE%A9%E9%A1%BA%E5%88%A9%E9%80%9A%E8%BF%87/)

[2022年-答辩通过率100%-客户评价🐣](https://berserker287.github.io/2022/05/25/%E9%A1%B9%E7%9B%AE%E4%BA%A4%E6%98%93%E8%AE%B0%E5%BD%95/)

[毕业答辩导师提问的高频问题](https://berserker287.github.io/2023/06/13/%E6%AF%95%E4%B8%9A%E7%AD%94%E8%BE%A9%E5%AF%BC%E5%B8%88%E6%8F%90%E9%97%AE%E7%9A%84%E9%AB%98%E9%A2%91%E9%97%AE%E9%A2%98/)

[50个高频答辩问题-技术篇](https://berserker287.github.io/2023/06/13/50%E4%B8%AA%E9%AB%98%E9%A2%91%E7%AD%94%E8%BE%A9%E9%97%AE%E9%A2%98-%E6%8A%80%E6%9C%AF%E7%AF%87/)

[计算机毕设答辩时都会问到哪些问题？](https://www.zhihu.com/question/31020988)

[计算机专业毕业答辩小tips](https://zhuanlan.zhihu.com/p/145911029)

#### 接JAVAWEB毕设，纯原创，价格公道，诚信第一

`网站建设、小程序、H5、APP、各种系统 选题+开题报告+任务书+程序定制+安装调试+项目讲解+论文+答辩PPT`

More info: [悲伤的橘子树](https://berserker287.github.io/)

<p><img align="center" src="https://fank-bucket-oss.oss-cn-beijing.aliyuncs.com/img/%E5%90%88%E4%BD%9C%E7%89%A9%E6%96%99%E6%A0%B7%E5%BC%8F%20(3).png" alt="fankekeke" /></p>
