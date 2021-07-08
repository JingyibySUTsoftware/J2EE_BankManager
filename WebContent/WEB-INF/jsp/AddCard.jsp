<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>银行卡信息添加</title>
<link rel="stylesheet" type="text/css" href="layui/css/layui.css">
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script src="layui/layui.js"></script>
<script src="layer/layer.js"></script>
</head>
<body>
	<hr>
	<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
	  <legend>添加卡信息</legend>
	</fieldset>
	<form action="addcard" method="post" class="layui-form layui-form-pane" name="cardForm" style="width: 500px">
  		  <div class="layui-form-item">
    		<label class="layui-form-label">新密码</label>
    		<div class="layui-input-block">
      			<input type="password" name="password"lay-verify="required" placeholder="请输入新密码" autocomplete="off" class="layui-input">
    		</div>
  		  </div>
  		  <div class="layui-form-item">
    		<label class="layui-form-label">再次输入</label>
    		<div class="layui-input-block">
      			<input type="password" lay-verify="required|confirmPass" placeholder="请再次输入密码" autocomplete="off" class="layui-input">
    		</div>
  		  </div>
  		  <div class="layui-form-item">
    		<label class="layui-form-label">金额</label>
    		<div class="layui-input-block">
      			<input type="text" name="cmoney" placeholder="请输入预存金额" autocomplete="on" class="layui-input">
    		</div>
  		  </div>
		   <div class="layui-form-item">
		    <label class="layui-form-label">卡类型</label>
		    <div class="layui-input-block">
		      <select name="ctype">
		        <option value=""></option>
		        <option value="储蓄卡">储蓄卡</option>
		        <option value="信用卡">信用卡</option>
		      </select>
		    </div>
		  </div>
  		  <div class="layui-form-item">
    		<label class="layui-form-label">ID</label>
    		<div class="layui-input-block">
      			<input type="text" name="ID"placeholder="请输入新银行卡的ID" autocomplete="on" class="layui-input">
    		</div>
  		  </div>
  		<div class="layui-form-item">
    		<div class="layui-input-block">
		      <button type="submit" class="layui-btn layui-btn-normal" onclick="submitbtn()" lay-submit="">添加</button>
		      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
    		</div>
  		</div>
	</form>
	<hr>
	<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
  		<legend>用户简略表</legend>
	</fieldset>
	<table align="center" class="layui-table">
		<thead>
			<tr>
				<td>ID</td>
				<td>姓名</td>
				<td>电话</td>
			</tr>
		</thead>
		<c:forEach items="${list}" var="user">
			<tbody>
				<tr>
					<td><c:out value="${user.uid}"/></td>
					<td><c:out value="${user.uname}"/></td>
					<td><c:out value="${user.uphone}"/></td>
				</tr>
			</tbody>
		</c:forEach>
	</table>
</body>
</html>
<script type="text/javascript">
function submitbtn(){
	layer.msg('新卡信息已添加', {icon: 1,time:3000},function(){
		document.cardForm.submit();
	});
}
layui.use("form", function() {
	var form = layui.form;
	form.verify({
	    confirmPass:function(value){
	        if($('input[name=password]').val() !== value)
	            return '两次密码输入不一致！';
	    }
	});
});
</script>