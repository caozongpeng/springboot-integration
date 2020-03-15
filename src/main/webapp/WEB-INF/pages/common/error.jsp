<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <%@ include file="head.jsp" %>
    <title>出错啦～</title>
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
        }
        .error {
            width: 640px;
            text-align: center;
            padding-bottom: 60px;
        }
        h1 {
            font-size: 120px;
        }
    </style>
</head>
<body>
<div class="error">
    <h1>404</h1>
    <p>错误详情: ${error}</p>
</div>
</body>
</html>