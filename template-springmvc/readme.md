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
  (id,createTime,user_id,totalNum,totalAmount,restNum,remark)   
RED_PACKET_DETAIL_TABLE：红包详情表  
  (id,packet_id,createTime,amount)  

详情见：src/main/sql/red-packet.sql


## 技术依赖
1. spring
2. spring-mvc
3. mybatis
4. redis
5. mysql

> 未完待续