<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户信息展示</title>
<link rel="stylesheet" type="text/css" href="layui/css/layui.css">
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script src="layer/layer.js"></script>
</head>
<body>
	<hr>
	<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
  		<legend>用户信息表</legend>
	</fieldset>
	<table align="center" class="layui-table">
		<thead>
			<tr>
				<td>用户编号</td>
				<td>姓名</td>
				<td>电话</td>
				<td>公司</td>
				<td>籍贯</td>
				<td>操作</td>
			</tr>
		</thead>
		
		<c:forEach items="${list}" var="user">
			<tbody>
				<tr>
					<td><c:out value="${user.uid}"/></td>
					<td><c:out value="${user.uname}"/></td>
					<td><c:out value="${user.uphone}"/></td>
					<td><c:out value="${user.company}"/></td>
					<td><c:out value="${user.hometown}"/></td>
					<td>
						<div class="layui-btn-group">
						  <button type="button" class="layui-btn  layui-btn-warm" onclick="toUpdate(${user.uid})">修改</button>
						  <button type="button" class="layui-btn layui-btn-danger" id="ifdelete" onclick="checkdelete(${user.uid})">删除</button>
						</div>
					</td>
				</tr>
			</tbody>
		</c:forEach>
	</table>
	<hr>
</body>
</html>
<script type="text/javascript">
function checkdelete(uid){
	layer.confirm('确认要删除该用户吗?', {icon: 3, title:'提示'}, function(index){
		layer.msg('用户已删除', {icon: 1,time:4000});
		location.href="deletebyuid?uid="+uid;  
		layer.close(index);
	});
}
function toUpdate(uid){
	location.href="findbyuid?uid="+uid;
}
</script>

