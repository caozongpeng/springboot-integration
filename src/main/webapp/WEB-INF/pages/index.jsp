<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <%@ include file="common/head.jsp" %>
    <title>Thanks !!!</title>
    <link rel="stylesheet" href="${staticPath}/styles/index.css" />
</head>
<body>
<div class="config">
    <h1>感谢使用懒猴子CG构建SpringBoot框架</h1>
    <ul>
        <li><label>持久层</label><span>MyBatis</span> <span>SpringJPA</span></li>
        <li><label>视图层</label><span>JSP</span> <span>thymeleaf</span></li>
        <li><label>单元测试</label><span>JUnit</span></li>
        <li><label>Swagger</label><span>有(采用Swagger-UI)</span> <span>有(采用Swagger-Bootstrap-UI)</span></li>
        <li><label>Lombok</label><span>有</span></li>
        <li><label>示例代码</label><span>有</span><a href="${basePath}/user/manage" target="_blank">查看示例功能</a></li>
        <li><label>数据库</label><span>懒猴子CG示例数据库</span></li>
    </ul>
</div>
</body>
</html>