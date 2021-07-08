<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>银行卡信息修改</title>
<link rel="stylesheet" type="text/css" href="layui/css/layui.css">
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script src="layui/layui.js"></script>
<script src="layer/layer.js"></script>
</head>
<body>
	<hr>
	<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
	  <legend>修改卡信息</legend>
	</fieldset>
	<form action="updatebycid" method="post" class="layui-form layui-form-pane" name="cardupdateForm" style="width: 500px">
		  <div class="layui-form-item">
    		<label class="layui-form-label">卡号</label>
    		<div class="layui-input-block">
      			<input type="text" name="cid" value="${card.cid}" readonly="readonly"autocomplete="off" class="layui-input">
    		</div>
  		  </div>
  		  <div class="layui-form-item">
    		<label class="layui-form-label">卡类型</label>
    		<div class="layui-input-block">
      			<input type="text" name="ctype" value="${card.ctype}" readonly="readonly"autocomplete="off" class="layui-input">
    		</div>
  		  </div>
  		  <div class="layui-form-item">
    		<label class="layui-form-label">原密码</label>
    		<div class="layui-input-block">
      			<input type="text" value="${card.cpssword}" readonly="readonly"autocomplete="off" class="layui-input">
    		</div>
  		  </div>
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
	layer.msg('卡信息修改成功！', {icon: 1,time:3000},function(){
		document.cardupdateForm.submit();
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