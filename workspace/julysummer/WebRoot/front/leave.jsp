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
		<link rel="stylesheet" href="${ctx}/front/css/leaveword.css" />
		<script type="text/javascript" src="${ctx}/front/ckeditor/ckeditor.js"></script>
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
		        <li><a href="learn">学无止境</a></li>
		        <li><a href="light">光影点滴</a></li>
		        <li class="active"><a href="javascript:void(0)">留言板</a></li>
		         <li class="dropdown">
		          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">更多<span class="caret"></span></a>
		          <ul class="dropdown-menu">
		            <li><a href="${ctx}/About.jsp">关于我</a></li>
		             <li id="addFavorite" ><a href="javascript:void(0)">点我收藏</a></li>
		          </ul>
		        </li>
		      </ul>
		      <%@ include file="searchMoudle.jsp" %>
		    </div><!-- /.navbar-collapse -->
		  </div><!-- /.container-fluid -->
		</nav>
	</header>
	
	<!--主体内容-->
	<span onclick="changebimg()" id="changebg" class="btn btn-warning">换换背景</span>
	 <section class="container-fluid">
      <div align="center" class="container-fluid col-md-12">
    	<ul class="timeline">
    			<c:forEach items="${lbList}" var="lbl">
                <li class="event">
                    <label></label>
                    <div class="thumb" style="background-image: url(front/img/7.jpg); background-size: contain;"></div>
                    <div class="inner">
                        <div class="btn-default col-md-12 h5">
	                        <span>留言侠客:<c:out value="${lbl.name}"></c:out></span>
	                        <spa>留言主题:<c:out value="${lbl.topic}"></c:out></span>
	                        <span>留言时间:<c:out value="${lbl.time}"></c:out></span>
                        </div>
                        <div class="btn-default">留言内容:</div>
                        <div>
                        	<c:out value="${lbl.content}"></c:out>
                        </div>
                    </div>
                </li>
                </c:forEach>
                <div class="col-md-10">
		   		<div id="review" class="reviewOther btn-default">
		   				<h3 class="eyerow">写下你的真知灼见，诉出你的肺腑心言:</h3>
				   		<script type="text/javascript">
				   			var cont=CKEDITOR.replace('leaveword');
				   			function clearIt(){
								CKEDITOR.instances['textArea3'].setData("");
				    		}
				   		</script>
	                    <form action="OtherReviewOther" method="post">
	                    	昵称:<input type="text" name="name" placeholder="输入昵称,不能为空"/>
	                    	邮箱号:<input type="text" name="email" placeholder="输入你的邮箱号,不能为空"/>
	                    	主题:<input type="text" name="topic" placeholder="输入留言主题,不能为空"/>
	                    	内容:<textarea class="ckeditor" name="leaveword" id="textArea3" rows="1" cols="1"></textarea>
	                    	<input class="btn btn-default" type="reset" value="重置"/>
	                    	<input class="btn btn-default" type="submit" value="回复"/>
	                    </form>
                 </div>
			</div>   
                 
           </ul>
    </div>
    </section>
<!--******************************************主题内容结束********************************************-->
    <!--脚部-->
 <%@ include file="footerMoudle.jsp" %>