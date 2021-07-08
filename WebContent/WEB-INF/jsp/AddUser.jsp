<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户信息添加</title>
<link rel="stylesheet" type="text/css" href="layui/css/layui.css">
<script src="layui/layui.js"></script>
<script src="layer/layer.js"></script>
</head>
<body>
	<hr>
	<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
	  <legend>添加用户信息</legend>
	</fieldset>
	<form action="adduser" method="post" class="layui-form layui-form-pane" name="userForm" style="width: 500px">
  		  <div class="layui-form-item">
    		<label class="layui-form-label">姓名</label>
    		<div class="layui-input-block">
      			<input type="text" name="uname"  autocomplete="on" class="layui-input">
    		</div>
  		  </div>
  		  <div class="layui-form-item">
    		<label class="layui-form-label">电话</label>
    		<div class="layui-input-block">
      			<input type="text" name="uphone"  autocomplete="on" class="layui-input">
    		</div>
  		  </div>
		  <div class="layui-form-item">
    		<label class="layui-form-label">公司</label>
    		<div class="layui-input-block">
      			<input type="text" name="company"autocomplete="on" class="layui-input">
    		</div>
  		  </div>
  		  <div class="layui-form-item">
    		<label class="layui-form-label">籍贯</label>
    		<div class="layui-input-block">
      			<input type="text" name="hometown" autocomplete="on" class="layui-input">
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
</body>
</html>
<script type="text/javascript">
function submitbtn(){
	layer.msg('新用户信息已添加', {icon: 1,time:3000},function(){
		document.userForm.submit();
	});
}
</script>