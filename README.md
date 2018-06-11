## Spring-Cloud-Archetype

> 集成了Redis MyBatyts Docker volumes RabbitMQ

- conf

    放配置文件的
    
- spring-cloud-conf:8877

    配置文件管理服务
    
- spring-cloud-engine

    放一些公共部分的车轮，数据库的mapper文件和实体类放在这里面
    
- spring-cloud-eureka:1234

    springCloud服务注册中心
    
- spring-cloud-gateway:8080

    网关
    
- spring-cloud-service

    放一些服务模块
    
- build-images.sh

    构建docker镜像的脚本
    
- rm-images.sh

    删除docker镜像的脚本
    
- docker-compose.yml

    容器启动的配置管理,端口映射，容器与宿主机的文件夹映射
    
    
```java
    //这个api只读取了git上面的配置文件
    http://127.0.0.1:8080/server-a/index
    
    //这个api读了数据库的数据，redis中的数据  还将得到的结果写入到了宿主机的./logger下面
    http://127.0.0.1:8080/server-b/index
    
```
     
