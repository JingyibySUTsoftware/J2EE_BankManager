<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>太平洋银行管理系统 欢迎！ - User</title>
  <link rel="stylesheet" href="layui/css/layui.css">
  <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
</head>
<body>
<div class="layui-layout layui-layout-admin">
  <div class="layui-header">
    <div class="layui-logo layui-hide-xs">太平洋银行系统</div>
    <!-- 头部区域（可配合layui 已有的水平导航） -->
    <ul class="layui-nav layui-bg-blue">
      <!-- 移动端显示 -->
      <li class="layui-nav-item layui-show-xs-inline-block layui-hide-sm" lay-header-event="menuLeft">
        <i class="layui-icon layui-icon-spread-left"></i>
      </li> 
      <li class="layui-nav-item layui-hide-xs"><a data-src="/BankManager/findmycard"><i class="layui-icon layui-icon-tabs">&nbsp;&nbsp;</i><cite>银行卡信息</cite></a></li>
      <li class="layui-nav-item">
        <a href="javascript:;"><i class="layui-icon layui-icon-rmb">&nbsp;&nbsp;</i><cite>交易处理</cite></a>
        <dl class="layui-nav-child">
          <dd><a data-src="/BankManager/tosetmoney">存款</a></dd>
          <dd><a data-src="/BankManager/togetmoney">取款</a></dd>
          <dd><a data-src="/BankManager/totransf">转账</a></dd>
        </dl>
      </li>
    </ul>
    <ul class="layui-nav layui-layout-right">
      <li class="layui-nav-item layui-hide layui-show-md-inline-block">
        <a href="javascript:;">
          <img src="image/user.jpg" class="layui-nav-img">
          ${uname}
        </a>
        <dl class="layui-nav-child">
          <dd><a href="">设置</a></dd>
          <dd><a href="#" id="logout">退出</a></dd>
        </dl>
      </li>
      <li class="layui-nav-item" lay-header-event="menuRight" lay-unselect>
        <a href="javascript:;">
          <i class="layui-icon layui-icon-more-vertical"></i>
        </a>
      </li>
    </ul>
  </div>
  
<!--   <div class="layui-side layui-bg-black"> -->
<!--     <div class="layui-side-scroll"> -->
<!--       左侧导航区域（可配合layui已有的垂直导航） -->
<!--       <ul class="layui-nav layui-nav-tree" lay-filter="test"> -->
<!--         <li class="layui-nav-item"> -->
<!--           <a class="" href="javascript:;"><i class="layui-icon layui-icon-rmb">&nbsp;&nbsp;</i><cite>交易处理</cite></a> -->
<!--           <dl class="layui-nav-child"> -->
<!--             <dd><a data-src="/BankManager/tosetmoney">存款</a></dd> -->
<!--             <dd><a data-src="/BankManager/togetmoney">取款</a></dd> -->
<!--             <dd><a data-src="/BankManager/totransf">转账</a></dd> -->
<!--           </dl> -->
<!--         </li> -->
<!--         <li class="layui-nav-item"> -->
<!--           <a href="javascript:;"><i class="layui-icon layui-icon-tabs">&nbsp;&nbsp;</i><cite>银行卡信息</cite></a> -->
<!--           <dl class="layui-nav-child"> -->
<!--             <dd><a data-src="/BankManager/findmycard">我的银行卡</a></dd> -->
<!--           </dl> -->
<!--         </li> -->
<!--         <li class="layui-nav-item"><a data-src="/BankManager/toabout"><i class="layui-icon layui-icon-auz">&nbsp;&nbsp;</i><cite>关于</cite></a></li> -->
<!--       </ul> -->
<!--     </div> -->
<!--   </div> -->
  
  <div class="layui-body">
     <iframe frameborder="0" scrolling="yes" style="width: 100%" src="" id="aa">
    </iframe>
  </div>
  
  <div class="layui-footer">
    <!-- 底部固定区域 -->
    	Copyright©2020-2021  BankManager.com All Rights Reserved
  </div>
</div>
<script src="layui/layui.js"></script>
<script>
layui.use(['layer'],function(){
	$ = layui.$;
	var layer = layui.layer;
	$("#logout").click(function(){
		layer.confirm('你确定要退出吗？',{icon:5,title:'退出系统'},function(index){
			layer.close(index);
			location.href="logoutuser";
		},function(index){
		    //停止运作
			layer.close(index);
		})
	});
});
//获取src值
  $(".layui-nav-item a").on("click",function(){
      var address =$(this).attr("data-src");
      $("iframe").attr("src",address);
      var frame = $("#aa");
    //一下代码是根据窗口高度在设置iframe的高度
      var frameheight = $(window).height();
      console.log(frameheight);
      frame.css("height",frameheight);
  });
  $(".layui-nav-item layui-hide-xs a").on("click",function(){
      var address =$(this).attr("data-src");
      $("iframe").attr("src",address);
      var frame = $("#aa");

      var frameheight = $(window).height();
      console.log(frameheight);
      frame.css("height",frameheight);
  });
//一下代码是根据窗口高度在设置iframe的高度
   
//JS 
layui.use(['element', 'layer', 'util'], function(){
  var element = layui.element
  ,layer = layui.layer
  ,util = layui.util
  ,$ = layui.$;
  
  //头部事件
  util.event('lay-header-event', {
    //左侧菜单事件
    menuLeft: function(othis){
      layer.msg('展开左侧菜单的操作', {icon: 0});
    }
    ,menuRight: function(){
      layer.open({
        type: 1
        ,content: '<div style="padding: 15px;">这里没有啥内容，非要写点的话就是这个页面是关于用户登陆之后的银行管理系统，就酱~</div>'
        ,area: ['260px', '100%']
        ,offset: 'rt' //右上角
        ,anim: 5
        ,shadeClose: true
      });
    }
  });
  
});
</script>
</body>
</html>