# 认证中心


负责人：郭世雄  
email：shixiong.guo@foxmail.com  


## 功能简介：
该中心用于拦截用户请求，判断用户权限，决定是否允许请求通过


## 项目介绍：
项目使用 springboot+mybatis+maven+rabbitmq 实现  
项目模仿 openstack 架构，将功能分为多个中心，为了提高灵活性，各个中心垂直划分为web模块和service模块，两者采用rpc交互，其他中心也可采用rpc调用本项目service模块。两个模块均需要连接到rabbitmq服务器。


## 项目之间的依赖：    
```
auth-api
       |
       | --> auth-spring-boot-service
       | --> auth-spring-boot-web
       
auth-common
       |
       | --> auth-spring-boot-service
       | --> auth-spring-boot-web
       
auth-rpc
       |
       | --> auth-spring-boot-service
       | --> auth-spring-boot-web
```


## 各个模块功能：
`auth-spring-boot-service：`负责处理业务逻辑，与数据库交互两部分功能  
`auth-spring-boot-web：`对外暴露接口，即controller模块，通过接口+rpc调用service模块  
`auth-api：`抽象出独立的接口，远程调用使用  
`auth-rpc：`rpc模块，此模块是在开源代码的基础上改进后使用的  
`auth-common：`开发项目中，发现多数都是curd操作，导致太多冗余代码，在完成项目后，经过代码重构，将基本操作提取出来封装成基本框架，提高代码复用，减少代码冗余  
`mybatis-generate：`生成对数据库表基本操作的sql


## 使用：
- 进入项目根目  
  cd auth-parent
- 将依赖模块安装到本地仓库  
  mvn install
- 打包，此处可以为jar，也可以为war，只需在pom文件指定即可  
  mvn package  
- 此时会在target目录生成相应的文件，如果为jar包，直接运行即可  
  java -jar [file name]  
- linux下后台运行，防止退出终端后程序停止  
  nohup java -jar [file name] &  
  