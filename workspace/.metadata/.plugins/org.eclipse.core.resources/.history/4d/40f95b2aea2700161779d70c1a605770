<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
    <ul class="nav navbar-nav navbar-right">
	          <form name="formSearch" id="search" class="navbar-form navbar-left" action="goSearch">
					<div class="form-group">
						<input name="search" class="form-control" type="text" autocomplete="on" placeholder="寻，你所爱！！" />
					</div>
					<div class="form-group">
						<input class="btn btn-success" type="submit" value="千寻一下"/>
					</div>	
	          </form>
	          	<li><a id="showsearch" onclick="showsearch()" href="javascript:void(0)">千寻一下</a></li>
	          	<li><a id="hidesearch" onclick="hidesearch()" href="javascript:void(0)">搜索完毕</a></li>
		        <% 
					AdminBean adBean=null;
					adBean=(AdminBean)request.getSession(true).getAttribute("login");
					if(adBean!=null){	        
		         %>
		         	<li><a href="manage?go=0&id=0">管理后台</a></li>
		         	<li><a href="logout">退出</a></li>
		         <%
		         }else{
		         %>
		        	 <li><a href="${ctx}/login.jsp">登录</a></li>
		         <%
		         }
		          %>
		        	
		      </ul>
