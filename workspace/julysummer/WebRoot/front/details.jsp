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
		<link rel="stylesheet" href="${ctx}/front/css/index.css" />
		<link rel="stylesheet" href="${ctx}/front/css/detail.css" />
		<script type="text/javascript" src="${ctx}/front/ckeditor/ckeditor.js"></script>
	</head>
	<body>
	<header>
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
		        <li class="active"><a href="learn">学无止境</a></li>
		        <li><a href="light">光影点滴</a></li>
		        <li><a href="leave">留言板</a></li>
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
<!--***********************************************主体内容**************************************************-->
    <section class="container main">
    <div class="col-md-12"><!--这是面包屑导航-->
    	<span class="eyerow">where you are: <a href="${ctx}/">首页</a>&gt;&gt;&gt;<a href="learn">学无止境</a> &gt;&gt;&gt;文章详情页</span>
    </div>
    	<!--左边部分-->
    <div class="col-md-4">
    	<div class="leftInfo">
    		<h3 class="eyerow">Show Time:</h3>
		    <h3 id="countTime"></h3>
    	</div>
    	<div class="leftInfo">
    		<h3 class="eyerow">热门文章:</h3>
		    <div class="hotArticle">
		    	<ol>
		    		<c:forEach items="${hotArticle}" var="hot">
		    			<li><a href="${ctx}/detail?id=<c:out value="${hot.articleId}"/>"><c:out value="${hot.title}"/></a><span><img src="${ctx}/front/img/hot.gif" alt="" /></span></li>
					</c:forEach>
		    	</ol>
		    </div>
    	</div>
    	<div class="leftInfo">
    		<h3 class="eyerow">最近留言:</h3>
		    <div class="latestDiscuss">
		    	<ul>
			    	<c:forEach items="${latestLeave}" var="latest">
			    		<li><p><c:out value="${latest.content}"/><span>--<c:out value="${latest.time}"/></span></p></li>
					</c:forEach>
		    	</ul>
		    </div>
    	</div>
    	<div class="leftInfo">
    		<h3 class="eyerow">Cloud Tag:</h3>
		    <div class="cloud">
		    	 <c:forEach items="${typeList}"  var="gb">
			   		<span><a href="learn?type=<c:out value="${gb.type}"/>"><c:out value="${gb.type}"/></a></span>
			    </c:forEach>
		    </div>
    	</div>
    </div>
    <!--右边部分-->
    <div class="col-md-8">
    	<div class="article">
    		<h3 class="eyerow">This is an article for you:</h3>
    		<h2 class="h2"><c:out value="${articleDetails.title}"/><span><img src="${ctx}/front/img/bea.gif" alt="" /></span></h2>
    		<div class="article_Info">
    			<span>文章类型:<c:out value="${articleDetails.type}"/></span>
    			<span>发布日期:<c:out value="${articleDetails.time}"/></span>
    			<span>浏览数:<c:out value="${articleDetails.viewCounts}"/></span>
    			<span>评论数:<c:out value="${discussCounts}"/></span>
    		</div>
    		<div class="description">
    			<h4 align="left">简介:</h4>
    			<h5 class="alert-info"><c:out value="${articleDetails.description}"/></h5>
    		</div>
		    <p><c:out value="${articleDetails.content}"/></p>
    	</div>
    	<div class="col-md-12">
    		<div class="showDiscuss col-md-12" id="showDiscuss">
    			<c:forEach items="${discussList}" var="discussContent">
					<div class="col-md-12 discuss_mainbody">
    					<span><img src="${ctx}/front/img/load.gif" alt="头像" /></span>
    					<div class="eyerow"></span><span>User: <c:out value="${discussContent.name}"/>---&gt;发表评论:</span><span> 日期: <c:out value="${discussContent.time}"/></div>
    					<h4 class="h4"><c:out value="${discussContent.content}" escapeXml="false" /></h4>
    				</div>
				</c:forEach>
    		</div>
    		<div class="col-md-7">
    			<h3 class="eyerow">写下你的真知灼见，诉出你的肺腑心言:</h3>
		   		<script type="text/javascript">
		   			var cont=CKEDITOR.replace('ArticleDiscuss');
		   			function clearIt(){
						CKEDITOR.instances['TextArea2'].setData("");
		    		}
		   		</script>
		   		<form action="${ctx}/addDiscussServlet" method="post">
		   			<input type="text" name="id" hidden value="<c:out value="${articleDetails.articleId}"/>"/>
			   		<textarea name="ArticleDiscuss" id="TextArea2"  cols="80" rows="10" class="ckeditor"></textarea>
			   		<input  type="text" name="dicussUserName" placeholder="输入您的用户名" />
			   		<input  type="text" name="dicussUserEmail" placeholder="输入您的邮箱号"/>
			   		<input class="btn btn-success" role="button"   type="submit" value="提交"/>
			   		<input class="btn btn-success" role="button"  type="reset" value="重置"  onclick="clearIt()"/>
			   	</form>
			</div>   
		</div>
    </div>
    </section> <!-- /container -->
<!--******************************************主题内容结束********************************************-->
    <!--脚部-->
<%@ include file="footerMoudle.jsp" %>
