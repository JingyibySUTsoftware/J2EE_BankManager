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
	<br>
	<form action="tosearch" method="post" class="layui-form">
	<div class="layui-inline">
	    <div class="layui-input-block">
	      <input type="text" name="phone"placeholder="请输入要查询的手机号" autocomplete="off" class="layui-input">
	    </div>
  	</div>
  	<div class="layui-inline">
  		<button type="submit" class="layui-btn layui-btn-normal"><i class="layui-icon layui-icon-search">&nbsp;&nbsp;</i><cite>搜索</cite></button>
  	</div>
  	</form>
	<hr>
	<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
  		<legend>银行卡信息表</legend>
	</fieldset>
	<table align="center" class="layui-table">
		<thead>
			<tr>
				<td>卡号</td>
				<td>卡密码</td>
				<td>余额</td>
				<td>卡类型</td>
				<td>用户编号</td>
				<td>姓名</td>
				<td>电话</td>
				<td>公司</td>
				<td>籍贯</td>
				<td>操作</td>
			</tr>
		</thead>
		
		<c:forEach items="${list}" var="card">
			<tbody>
				<tr>
					<td><c:out value="${card.cid}"/></td>
					<td><c:out value="${card.cpssword}"/></td>
					<td><c:out value="${card.cmoney}"/></td>
					<td><c:out value="${card.ctype}"/></td>
					<td><c:out value="${card.bankuser.uid}"/></td>
					<td><c:out value="${card.bankuser.uname}"/></td>
					<td><c:out value="${card.bankuser.uphone}"/></td>
					<td><c:out value="${card.bankuser.company}"/></td>
					<td><c:out value="${card.bankuser.hometown}"/></td>
					<td>
						<div class="layui-btn-group">
						  <button type="button" class="layui-btn  layui-btn-warm" onclick="toUpdate(${card.cid})">修改</button>
						  <button type="button" class="layui-btn layui-btn-danger" id="ifdelete" onclick="checkdelete(${card.cid})">删除</button>
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
function checkdelete(cid){
	layer.confirm('确认要删除该卡信息吗?', {icon: 3, title:'提示'}, function(index){
		  layer.msg('此卡已删除', {icon: 1 ,time:4000});
		  location.href="deletebycid?cid="+cid;
		  layer.close(index);
	});
}
function toUpdate(cid){
	location.href="findbycid?cid="+cid;
}
</script>