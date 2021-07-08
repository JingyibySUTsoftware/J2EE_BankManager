<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录错误</title>
<style>
  #num{
      color: red;
  }
</style>
</head>
<body>
	<div><h2>登录失败！请检查您的填写的信息，还有<span id="num">5</span>秒返回到登录页面...</h2></div>
</body>
</html>
<script type="text/javascript">
	var n=5;
	var time=setInterval(function(){
    if(n>0){
        n--;
        document.getElementById("num").innerHTML=n;  
    }else{
        location.href="/BankManager/login";
        time.clearInterval();
    }
},1000)
</script>