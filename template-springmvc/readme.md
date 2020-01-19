# 一个SSM的template
> spring、spring mvc、mybatis

## 项目说明
### 基本功能
1. 用户简单的登录认证
2. 用户发红包
3. 用户抢红包
4. 用户统计红包领取功能

### 数据库(mysql)
USER_TABLE：用户表  
  (id,username,password,nickname,createTime)    
RED_PACKET_TABLE：红包表  
  (id,createTime,user_id,totalNum,totalAmount,restNum,remark,version)   
RED_PACKET_DETAIL_TABLE：红包详情表  
  (id,packet_id,createTime,amount,user_id)  

详情见：src/main/sql/red-packet.sql

### 各层的划分规范（个人浅见）
1. dao层使用mybatis，首先根据数据库表、视图、创建mapper，其次使用根据具体的业务需要创建mapper
2. service层根据具体的业务划分类和方法
3. web层（controller）根据前端需要的接口来创建类和方法


## 技术依赖
1. spring
2. spring-mvc
3. mybatis
4. redis
5. mysql

## 遇到的问题记录
1. 自己抛出的异常需要回滚的时候，需要抛出RuntimeException
2. mapper不能实现重载，如果想做可以通过一个对象传入进入参数的处理

> 未完待续