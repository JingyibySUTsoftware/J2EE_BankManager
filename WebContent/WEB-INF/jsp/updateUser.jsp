<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户信息修改</title>
<link rel="stylesheet" type="text/css" href="layui/css/layui.css">
<script src="layui/layui.js"></script>
<script src="layer/layer.js"></script>
</head>
<body>
	<hr>
	<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
	  <legend>修改用户信息</legend>
	</fieldset>
	<form action="updatebyuid" method="post" class="layui-form layui-form-pane"  name="userupdateForm"style="width: 500px">
		  <div class="layui-form-item">
    		<label class="layui-form-label">编号</label>
    		<div class="layui-input-block">
      			<input type="text" name="uid" value="${user.uid}" readonly="readonly"autocomplete="off" class="layui-input">
    		</div>
  		  </div>
  		  <div class="layui-form-item">
    		<label class="layui-form-label">姓名</label>
    		<div class="layui-input-block">
      			<input type="text" name="uname" value="${user.uname}" autocomplete="off" class="layui-input">
    		</div>
  		  </div>
  		  <div class="layui-form-item">
    		<label class="layui-form-label">电话</label>
    		<div class="layui-input-block">
      			<input type="text" name="uphone" value="${user.uphone}" autocomplete="off" class="layui-input">
    		</div>
  		  </div>
		  <div class="layui-form-item">
    		<label class="layui-form-label">公司</label>
    		<div class="layui-input-block">
      			<input type="text" name="company" value="${user.company}" autocomplete="off" class="layui-input">
    		</div>
  		  </div>
  		  <div class="layui-form-item">
    		<label class="layui-form-label">籍贯</label>
    		<div class="layui-input-block">
      			<input type="text" name="hometown" value="${user.hometown}" autocomplete="off" class="layui-input">
    		</div>
  		  </div>
  		<div class="layui-form-item">
    		<div class="layui-input-block">
		      <button type="submit" class="layui-btn layui-btn-normal" onclick="submitbtn()" lay-submit="">确认修改</button>
		      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
    		</div>
  		</div>
	</form>
	<hr>
</body>
</html>
<script type="text/javascript">
function submitbtn(){
	layer.msg('用户信息修改成功！', {icon: 1,time:3000},function(){
		document.userupdateForm.submit();
	});
}
</script>