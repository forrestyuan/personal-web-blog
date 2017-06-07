<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.yfc.valueBean.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
pageContext.setAttribute("ctx",path);
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
		<title>julysummer</title>
		<link rel="stylesheet" href="${ctx}/front/css/bootstrap.min.css" />
		<link rel="stylesheet" href="${ctx}/front/css/all.css" />
		<link rel="stylesheet" href="${ctx}/front/css/learn.css" />
	</head>
	<body>
	<header>
	    <!--background-->
		<div id="bg"><img id="bimg" src="${ctx}/front/img/bg.jpg" alt="" /></div>
	    <!--导航栏-->
		<nav id="nav1" class="navbar navbar-inverse ">
		  <div class="container-fluid">
		    <!-- Brand and toggle get grouped for better mobile display -->
		    <div class="navbar-header">
		      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
		        <span class="sr-only">Toggle navigation</span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		      </button>
		      <a class="navbar-brand">ForrestYuan</a>
		    </div>
		    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
		      <ul class="nav navbar-nav">
		        <li><a href="${ctx}/">首页<span class="sr-only">(current)</span></a></li>
		        <li class="active"><a href="javascript:void(0)">学无止境</a></li>
		        <li><a href="light">光影点滴</a></li>
		        <li><a href="leave">留言板</a></li>
		         <li class="dropdown">
		          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">更多<span class="caret"></span></a>
		          <ul class="dropdown-menu">
		            <li><a href="About.jsp">关于我</a></li>
		            <li id="addFavorite" ><a href="javascript:void(0)">点我收藏</a></li>
		          </ul>
		        </li>
		      </ul>
		     <%@ include file="searchMoudle.jsp" %>
		    </div><!-- /.navbar-collapse -->
		  </div><!-- /.container-fluid -->
		</nav>
	</header>
<!--***********************************************主题内容**************************************************-->
	<!--主体内容-->
	<span onclick="changebimg()" id="changebg" class="btn btn-warning">换换背景</span>
	<span id="leavemeword" class="btn btn-danger" role="button"><a href="leaveword.html">给我留言</a></span>
	<div class="col-md-12"><!--这是面包屑导航-->
    	<span class="eyerow">where you are: <a href="${ctx}/">首页</a>&gt;&gt;&gt;<a href="learn">学无止境</a> &gt;&gt;&gt;搜索结果页:</span>
    </div>
  	<div align="center"><h1>不......-_- sorry,文章不存在......</h1></div>
    </section> <!-- /container -->
    
<!--******************************************主题内容结束********************************************-->
    <!--脚部-->
<%@ include file="footerMoudle.jsp" %>