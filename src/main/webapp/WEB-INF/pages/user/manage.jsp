<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <%@include file="../common/head.jsp"%>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>用户列表</title>
    <link rel="stylesheet" href="${staticPath}/styles/user/manage.css">
</head>
<body>
<div class="content-wrap">
    <h1>用户管理</h1>
    <div class="table">
        <table cellpadding="0" cellspacing="0" border="1px">
            <thead>
            <tr>
                <th>ID</th>
                <th>用户名</th>
                <th>密码</th>
                <th>昵称</th>
                <th>邮箱</th>
                <th>操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.username}</td>
                    <td>${user.password}</td>
                    <td>${user.nickname}</td>
                    <td>${user.email}</td>
                    <td>
                        <a href="javascript:;" class="btn-edit" data-id="${user.id}">编辑</a>
                        <a href="javascript:;" class="btn-delete" data-id="${user.id}">删除</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div class="opera">
            <button id="btnCreateUser" class="button normal">添加用户</button>
        </div>
    </div>
    <div id="createDialog" class="dialog">
        <div class="dialog-body">
            <h3>创建用户</h3>
            <form class="content">
                <dl class="prop">
                    <dt>用户名</dt>
                    <dd><input type="text" name="username" placeholder="请输入用户名" maxlength="10" /></dd>
                </dl>
                <dl class="prop">
                    <dt>密码</dt>
                    <dd><input type="text" name="password" placeholder="请输入密码" maxlength="10" /></dd>
                </dl>
                <dl class="prop">
                    <dt>邮箱</dt>
                    <dd><input type="text" name="email" placeholder="请输入昵称" maxlength="20" /></dd>
                </dl>
                <dl class="prop">
                    <dt>昵称</dt>
                    <dd><input type="text" name="nickname" placeholder="请输入昵称" maxlength="10" /></dd>
                </dl>
            </form>
            <div class="opera">
                <button class="btn-cancel button">取消</button>
                <button class="btn-confirm button normal margin-left">确定</button>
            </div>
        </div>
    </div>
    <div id="editDialog" class="dialog">
        <div class="dialog-body">
            <h3>编辑用户</h3>
            <form class="content">
                <input name="id" type="hidden">
                <dl class="prop">
                    <dt>用户名</dt>
                    <dd><input type="text" name="username" placeholder="请输入用户名" maxlength="10" /></dd>
                </dl>
                <dl class="prop">
                    <dt>密码</dt>
                    <dd><input type="text" name="password" placeholder="请输入密码" maxlength="10" /></dd>
                </dl>
                <dl class="prop">
                    <dt>邮箱</dt>
                    <dd><input type="text" name="email" placeholder="请输入昵称" maxlength="20" /></dd>
                </dl>
                <dl class="prop">
                    <dt>昵称</dt>
                    <dd><input type="text" name="nickname" placeholder="请输入昵称" maxlength="10" /></dd>
                </dl>
            </form>
            <div class="opera">
                <button class="btn-cancel button">取消</button>
                <button class="btn-confirm button normal margin-left">确定</button>
            </div>
        </div>
    </div>
</div>
<script>
    $(function() {
        // 事件绑定
        function initEvents() {
            // 添加用户
            $('#btnCreateUser').click(function() {
                $('#createDialog [name=username]').val('');
                $('#createDialog [name=password]').val('');
                $('#createDialog [name=nickname]').val('');
                $('#createDialog [name=email]').val('');
                $('#createDialog').addClass('show')
            });
            // 确认添加
            $('#createDialog .btn-confirm').click(function() {
                createUser()
            });
            // 编辑用户
            $('.btn-edit').click(function() {
                initEditor($(this).data('id'))
            });
            // 确认编辑
            $('#editDialog .btn-confirm').click(function() {
                updateUser()
            });
            // 取消创建、编辑
            $('.btn-cancel').click(function() {
                $('.dialog').removeClass('show')
            });
            // 删除用户
            $('.btn-delete').click(function() {
                deleteById($(this).data('id'))
            });
        }
        // 创建用户
        function createUser() {
            var param = {
                'username': $('#createDialog [name=username]').val().trim(),
                'password': $('#createDialog [name=password]').val().trim(),
                'nickname': $('#createDialog [name=nickname]').val().trim(),
                'email': $('#createDialog [name=email]').val().trim()
            };
            $.post(basePath + '/user/create', param, function(resp) {
                if (resp.success) {
                    window.location.reload();
                    return
                }
                alert("创建失败")
            })
        }
        // 初始化编辑面板
        function initEditor (id) {
            $.get(basePath + '/user/' + id, function(resp) {
                if (resp.success) {
                    $('#editDialog [name=id]').val(resp.data.id);
                    $('#editDialog [name=username]').val(resp.data.username);
                    $('#editDialog [name=password]').val(resp.data.password);
                    $('#editDialog [name=nickname]').val(resp.data.nickname);
                    $('#editDialog [name=email]').val(resp.data.email);
                    $('#editDialog').addClass('show');
                    return
                }
                alert('初始化编辑数据失败')
            }, 'json')
        }
        // 确认更新
        function updateUser() {
            var param = {
                'id': $('#editDialog [name=id]').val().trim(),
                'username': $('#editDialog [name=username]').val().trim(),
                'password': $('#editDialog [name=password]').val().trim(),
                'nickname': $('#editDialog [name=nickname]').val().trim(),
                'email': $('#editDialog [name=email]').val().trim()
            };
            $.post(basePath + '/user/updateById', param, function(resp) {
                if (resp.success) {
                    window.location.reload();
                    return
                }
                alert("更新失败")
            })
        }
        // 删除
        function deleteById(id) {
            if (confirm('确认删除该用户吗?')) {
                $.get(basePath + '/user/delete/' + id, function(resp) {
                    if (resp.success) {
                        window.location.reload();
                        return
                    }
                    alert('删除失败')
                })
            }
        }
        initEvents();
    })
</script>
</body>
</html>