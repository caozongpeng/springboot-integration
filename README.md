# springboot-integration
基于springboot整合常用技术，比如mybatis、jpa、thymeleaf、swagger、lombok等

* 持久层：MyBatis、SpringJPA
* 视图层：无（接口返回JSON）、JSP、thymeleaf
* Swagger: swagger-ui、swagger-bootstrap-ui
* 单元测试：Junit
* 日志: Logback
* 配置文件：Properties、YAML
* 其他：lombok


### application.properties、application.yml使用
* 当使用`application.properties`的时候将 `application.yml`的内容全部注释掉
* 当使用`application.yml`的时候将 `application.properties`的内容全部注释掉

### swagger-ui、swagger-bootstrap-ui 使用
当需要使用`swagger-ui`原生ui的时候把pom.xml的依赖打开注释掉`swagger-bootstrap-ui`依赖即可,访问路径为 主机:端口/swagger-ui.html
```xml
<!-- swagger-ui  -->
<dependency>
  <groupId>io.springfox</groupId>
  <artifactId>springfox-swagger-ui</artifactId>
  <version>${swagger.version}</version>
</dependency>
```
当需要使用`swagger-bootstrap-ui`ui的时候把pom.xml的依赖打开注释掉`swagger-ui`依赖即可,访问路径为 主机:端口/doc.html
```xml
<!-- swagger-bootstrap-ui  -->
<dependency>
  <groupId>com.github.xiaoymin</groupId>
  <artifactId>swagger-bootstrap-ui</artifactId>
  <version>${swagger.bootstrap-ui.version}</version>
</dependency>
```

