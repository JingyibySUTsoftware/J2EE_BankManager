<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>存款</title>
<link rel="stylesheet" type="text/css" href="layui/css/layui.css">
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script src="layer/layer.js"></script>
</head>
<body>
	<hr>
	<br>
	<form action="getmoney" method="post"  name="moneyForm" class="layui-form">
	<div class="layui-inline">
	    <div class="layui-input-block">
	      <input type="text" name="money"placeholder="请输入要取出的金额" autocomplete="off" class="layui-input">
	    </div>
  	</div>
  	<div class="layui-inline">
  		<button type="submit" onclick="submitbtn()" class="layui-btn layui-btn-normal"><i class="layui-icon layui-icon-ok-circle">&nbsp;&nbsp;</i><cite>确定取出</cite></button>
  	</div>
  	</form>
	<hr>
	<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
  		<legend>银行卡信息</legend>
	</fieldset>
	<table align="center" class="layui-table">
		<thead>
			<tr>
				<td>卡号</td>
				<td>余额</td>
				<td>卡类型</td>
			</tr>
		</thead>	
		<c:forEach items="${list}" var="card">
			<tbody>
				<tr>
					<td><c:out value="${card.cid}"/></td>
					<td><c:out value="${card.cmoney}"/></td>
					<td><c:out value="${card.ctype}"/></td>
				</tr>
			</tbody>
		</c:forEach>
	</table>
	<hr>
</body>
</html>
<script type="text/javascript">
function submitbtn(){
	layer.msg('取款交易已处理！', {icon: 1,time:3000},function(){
		document.moneyForm.submit();
	});
}
</script>
