<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>login</title>
    <link rel="stylesheet" type="text/css" href="layui/css/layui.css">
    <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
    <style>
        body{
            background-image: url("image/wallhaven-724791.jpg");
            background-position: center center;
            background-size: cover;
            background-repeat: no-repeat;
            background-attachment: fixed;
        }
        .loginForm{
            width: 350px;
            height: 360px;
            background-color: white;
            padding: 30px 20px;
            margin-top: 50%;
            border-radius: 5px;
            box-shadow: 0 0 5px black;
            box-sizing: border-box;
        }
    </style>
</head>
<body>
    <div class="layui-container">
        <div class="layui-row">
            <div class="layui-col-md4 layui-col-md-offset4">
                <div class="loginForm">
                    <h2 align="center">太平洋银行系统</h2>
                    <div class="layui-tab">
					  <ul class="layui-tab-title">
					    <li class="layui-this">管理员登录</li>
					    <li>用户登录</li>
					  </ul>
					  <div class="layui-tab-content">
					    <div class="layui-tab-item layui-show">
					    	<form class="layui-form" action="checkaccount" method="post">
					                <div class="layui-form-item">
					                    <label>管理员:</label>
					                    <div class="layui-form-block">
					                        <input type="text" name="mid" required lay-verify="required"
					                        placeholder="请输入管理员账号" class="layui-input">
					                    </div>
					                </div>
					
					                <div class="layui-form-item">
					                    <label>密码:</label>
					                    <div class="layui-form-block">
					                        <input type="password" name="mpass" required lay-verify="required"
					                        placeholder="请输入密码" class="layui-input">
					                    </div>
					                </div>
									<span style="display: none"id="msg">${Needloginmsg}</span>
					                <div class="layui-form-item">
					                    <div class="layui-form-block">
					                        <button class="layui-btn" lay-submit lay-filter="loginForm">登录</button>
					                    </div>
					                </div>
				          	</form>
					    </div>
					    <div class="layui-tab-item">
				    		<form class="layui-form" action="checkaccount" method="post">
				                <div class="layui-form-item">
				                    <label>卡号:</label>
				                    <div class="layui-form-block">
				                        <input type="text" name="cid" required lay-verify="required"
				                        placeholder="请输入您的银行卡号" class="layui-input">
				                    </div>
				                </div>
				
				                <div class="layui-form-item">
				                    <label>密码:</label>
				                    <div class="layui-form-block">
				                        <input type="password" name="cpassword" required lay-verify="required"
				                        placeholder="请输入银行卡密码" class="layui-input">
				                    </div>
				                </div>
								<span style="display: none" id="msg">${Needloginmsg}</span>
				                <div class="layui-form-item">
				                    <div class="layui-form-block">
				                        <button class="layui-btn" lay-submit lay-filter="loginForm">登录</button>
				                    </div>
				                </div>
           					</form>
					    </div>
					  </div>
				</div>
                </div>
            </div>
        </div>
    </div>
    <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
    <script src="layui/layui.js"></script>
    <script>
	    var msg=$("#msg").html();
	    if(msg==""){
	    	layer.msg('欢迎使用！', {icon: 6});
	    }else{
	    	layer.msg('请先登录！', {icon: 7});
	    }
	    
    	layui.use('element', function(){
	    	  var element = layui.element;
	    });
	    
    </script>
</body>
</html>