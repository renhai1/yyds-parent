﻿﻿## 1、项目介绍

尚医通即为网上预约挂号系统，网上预约挂号是近年来开展的一项便民就医服务，旨在缓解看病难、挂号难的就医难题，许多患者为看一次病要跑很多次医院，最终还不一定能保证看得上医生。网上预约挂号全面提供的预约挂号业务从根本上解决了这一就医难题。随时随地轻松挂号！不用排长队！

## 2、技术点

后端：
* SpringBoot：简化新Spring应用的初始搭建以及开发过程
* SpringCloud：基于Spring Boot实现的云原生应用开发工具，SpringCloud使用的技术：（SpringCloudGateway、Spring Cloud Alibaba Nacos、Spring Cloud Alibaba Sentinel、SpringCloud Task和SpringCloudFeign等）
* MyBatis-Plus：持久层框架
* Redis：内存缓存（验证码有效时间、支付二维码有效时间）
* MongoDB：面向文档的NoSQL数据库（医院相关数据）
* EasyExcel：操作excel表格，进行行读写操作
* RabbitMQ：消息中间件（订单相关操作）
* HTTPClient: Http协议客户端
* Nginx：负载均衡
* Mysql：关系型数据库


前端：
* Vue.js：web 界面的渐进式框架
* Node.js： JavaScript 运行环境
* Axios：Axios 是一个基于 promise 的 HTTP 库
* NPM：包管理器
* Babel：转码器
* Webpack：打包工具
* ECharts：图标展示

其他：
* Lombok
* Swagger2：Api接口文档工具
* Docker	：容器技术
* Git：代码管理工具
* 阿里云oss
* 阿里云短信服务
* 微信登录、支付
* 定时任务

## 3、业务流程

![请添加图片描述](https://img-blog.csdnimg.cn/ec865bb9f4e042618246906beb626f22.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBA5pif5rW35bCR5bm0,size_20,color_FFFFFF,t_70,g_se,x_16)

## 4、项目架构

![请添加图片描述](https://img-blog.csdnimg.cn/8504d13f2fb24d749cc576e7c7d5127d.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBA5pif5rW35bCR5bm0,size_20,color_FFFFFF,t_70,g_se,x_16)
## 5、项目源码（包含sql）

gitee 后端地址：[https://gitee.com/StarSea007/yyds-parent](https://gitee.com/StarSea007/yyds-parent)

gitee 后台前端地址：[https://gitee.com/StarSea007/yyds-vue-font](https://gitee.com/StarSea007/yyds-vue-font)

gitee 用户前端地址：[https://gitee.com/StarSea007/yyds-vue-site](https://gitee.com/StarSea007/yyds-vue-site)


## 6、启动步骤

1. 项目克隆到本地，导入到idea中
2. docker，启动mongodb，rabbitmq
3. nacos, 在目录下，打开bin文件夹，双击`startup.cmd`
4. redis，在目录下，使用cmd，然后输入 `redis-server redis.windows.conf`
5. 修改配置文件地址（包含mysql、nacos、redis、mongodb、rabbitmq、短信、微信登录 / 支付），启动前后端项目
6. 访问地址如下：
* 模拟医院的管理系统地址：http://localhost:9998/
* 预约挂号管理端地址：http://localhost:9528/
* 预约挂号用户端地址：http://localhost:3000/
* 医院设置后台swagger地址（举例）：http://localhost:8201/swagger-ui.html
* Rabbitmq访问地址（guest/guest）：http://ip:15672/


注意：前期学习阶段使用了nginx, 在目录下，使用cmd，然后输入nginx.exe。

> 说明：
> 
> sql文件 在 yyds-parent/sql 文件夹中
> 
> 课件及模板 在 yyds-parent/doc 文件夹中

## 7、项目模块说明

**后端项目**：
```java
yyds-parent：根目录，管理子模块
	common：公共模块父节点
		common-util：工具类模块，所有模块都可以依赖于它
		rabbit-util：rabbitmq业务封装
		service-util：service服务的工具包，包含service服务的公共配置类，所有service模块依赖于它
  doc：课件文档及笔记
	hospital-manage：医院接口模拟端
	model：实体类模块
	server-gateway：服务网关
	service：api接口服务父节点
		service-cmn：字典api接口服务
		service-hosp：医院api接口服务
		service-order：订单api接口服务
		service-oss：文件存储api接口服务
		service-sms：短信api接口服务
		service-statistics：统计api接口服务
		service-task：定时任务服务
		service-user：用户api接口服务
	service-client：feign服务调用父节点
		service-cmn-client：字典api接口
		service-hosp-client：医院api接口
		service-order-client：订单api接口
		service-user-client：用户api接口
  sql：项目涉及的sql文件
```

**后台前端项目**：

* 预约挂号管理端

```java
yyds-vue-font
	bulid：构建相关
	config：全局配置
	src：源代码
		api：所有请求
		assets：主题 字体等静态资源
		components：全局公共组件
		icons：项目所有svg icons
		router：路由
		store：全局store管理
		styles：全局样式
		utils：全局公用方法
		views：视图	
		App.vue：入口页面
		main.js：入口 加载组件 初始化等
		permission.js：权限管理
	static：静态资源
	.babelrc：babel-loader配置
	.eslintrc.js：eslint配置项
	.gitignore：git忽略项
	package.json：依赖管理
```

* 预约挂号用户端

```java
yyds-vue-site
	assets：资源目录
	components：组件目录
	layouts：布局页面
	pages：页面目录
	plugins：插件目录
	nuxt.config.js：nuxt.js应用的个性化配置
```


## 8、项目功能总结

**后台页面包括**：

```java
数据管理
	数据字典（字典树形展示、导入、导出）
医药管理
	医院设置（列表、添加、修改、删除）
	医药列表（列表、详情、排班、下线）
会员管理
	会员列表（列表、查看、锁定）
	认证审批列表
订单管理
	订单列表（列表、详情）
统计管理
	预约统计
```

**前端页面包括**：

```java
首页数据展示
	医院列表
医院详情展示
	医院科室展示
用户登录功能
	手机号登录（短信验证码发送）
	微信登录
用户实名认证
就诊人管理
	列表、添加、详情、删除	
预约挂号功能
	排版和挂号详情信息
	确认挂号信息
	生成预约挂号订单
	挂号订单支付（微信）
	取消预约订单
就医提醒功能
```

## 9、效果图

### 后台管理端
![在这里插入图片描述](https://img-blog.csdnimg.cn/9a847fee32f5492ebd7214ad2c288627.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBA5pif5rW35bCR5bm0,size_20,color_FFFFFF,t_70,g_se,x_16)



![在这里插入图片描述](D:\javaitem\ideaVsCode\review\images\watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBA5pif5rW35bCR5bm0,size_20,color_FFFFFF,t_70,g_se,x_16.png)

### 前端展示端

![在这里插入图片描述](https://img-blog.csdnimg.cn/75006c32bbcf49218882400024b27504.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBA5pif5rW35bCR5bm0,size_20,color_FFFFFF,t_70,g_se,x_16)



![在这里插入图片描述](https://img-blog.csdnimg.cn/3bf92a0ec2df46afa7b86cbde23e49a1.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBA5pif5rW35bCR5bm0,size_20,color_FFFFFF,t_70,g_se,x_16)



![在这里插入图片描述](https://img-blog.csdnimg.cn/c848a58622b343b2a843283edd53433a.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBA5pif5rW35bCR5bm0,size_20,color_FFFFFF,t_70,g_se,x_16)

### 数据库
![在这里插入图片描述](https://img-blog.csdnimg.cn/73a6e29a94ef4149bfb7707a0ab91975.png?x-oss-process=image/watermark,type_d3F5LXplbmhlaQ,shadow_50,text_Q1NETiBA5pif5rW35bCR5bm0,size_20,color_FFFFFF,t_70,g_se,x_16)

> 项目如有bug、优化建议，或者更好的处理方式都可以留言评论
>
> 博客地址：[https://blog.csdn.net/weixin_45606067/article/details/122582995](https://blog.csdn.net/weixin_45606067/article/details/122582995)
>
> 学习 **谷粒学院** 的小伙伴可以查看：[https://blog.csdn.net/weixin_45606067/category_10427871.html](https://blog.csdn.net/weixin_45606067/category_10427871.html)
