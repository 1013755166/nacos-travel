# 旅游分享平台-综合项目实战

**项目描述**

项目是基于微服务架构开发的旅游分享平台，旨在为用户提供一个分享旅游经历、交流旅游攻略的平台，帮助用户更好地规划旅行、相互分享经验、结交旅行伙伴、鼓励人们记录旅行过程中的美好事物。

**项目主要使用的技术**

项目使用nacos作为服务注册中心和配置中心，feign用于实现微服务之间的远程调用，thymeleaf用于生成动态的HTML页面，mybatis-plus提供便捷的CRUD操作,gateway用于对外暴露微服务,sentinel用于微服务的流量控制、熔断降级、系统保护等,MySQL用于存储和管理相关数据。

## 项目的需求分析

旅游分享平台的功能：用户登录注册、评论、景点展示和搜索、游记管理

**用户管理：**实现用户登录和注册、用户可以查看个人游记并进行修改和删除等、查看个人发布的相关评论

**景点管理：**提供旅游景点信息，包括名称、描述、位置等

**游记管理：**展示用户旅游过程中的游记记录

**评论管理：**用户可以在景点和笔记下方评论，其他用户可以查看评论

**搜索功能：**用户可以浏览和搜索景点和笔记

## 数据库设计

1. **用户表（user）**

   用户ID（userid）

   用户名（username）

   密码（password）

   邮箱（email）

   手机号码（phone）

2. **旅游目的地表（destination）**

   目的地ID（id）

   目的地名称（name）

   目的地描述（description）

   目的地位置（location）

3. **旅游笔记表（note）**

   笔记ID（id）

   用户ID（userid）

   笔记名称（notename）

   笔记描述（description）

   记录地点（location）

   记录时间（createtime）

   修改时间（modifytime）

4. **评论表（review）**

   评论ID（id）

   用户ID（userid）

   评论内容（content）

   评论时间（reviewtime）

5. **评论关联表（review-nd）**

   表ID(id)

   笔记ID（noteid）

   目的地ID（desid）

   评论ID（reid）

## 接口文档例子

![image-20230709154131845](C:\Users\xiachonger\AppData\Roaming\Typora\typora-user-images\image-20230709154131845.png)

1. 用户相关接口：

- 用户注册接口
  - 请求方式：POST
  - 请求路径：/user/register
  - 请求参数：
    - username: 用户名
    - password: 密码
    - email: 邮箱
    - phone: 手机号码
  - 返回结果：
    - 成功：{ "code": 200, "message": "注册成功" }
    - 失败：{ "code": 400, "message": "注册失败" }

- 用户登录接口

  - 请求方式：POST

  - 请求路径：/api/user/login

  - 请求参数：

    - username: 用户名
    - password: 密码

  - 返回结果：

    - 成功：{ "code": 200, "message": "登录成功", "data": "xxxxx" }

    - 失败：{ "code": 401, "message": "登录失败" }

      

