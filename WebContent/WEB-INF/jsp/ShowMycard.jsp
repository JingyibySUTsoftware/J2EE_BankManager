<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>银行卡信息展示</title>
<link rel="stylesheet" type="text/css" href="layui/css/layui.css">
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script src="layer/layer.js"></script>
</head>
<body>
	<hr>
	<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
  		<legend>我的银行卡信息</legend>
	</fieldset>
	<table align="center" class="layui-table">
		<thead>
			<tr>
				<td>卡号</td>
				<td>余额</td>
				<td>卡类型</td>
				<td>持卡人姓名</td>
				<td>电话</td>
			</tr>
		</thead>
		
		<c:forEach items="${list}" var="card">
			<tbody>
				<tr>
					<td><c:out value="${card.cid}"/></td>
					<td><c:out value="${card.cmoney}"/></td>
					<td><c:out value="${card.ctype}"/></td>
					<td><c:out value="${card.bankuser.uname}"/></td>
					<td><c:out value="${card.bankuser.uphone}"/></td>
				</tr>
			</tbody>
		</c:forEach>
	</table>
	<hr>
</body>
</html>