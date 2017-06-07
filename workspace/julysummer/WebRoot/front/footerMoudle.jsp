<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
    <footer>
    
   			<span> 友情链接:</span>
   			<c:forEach items="${allLink}" var="lik">
   				<span><a target="_blank" href="http://<c:out value="${lik.linkLoveURL}"/>"><c:out value="${lik.linkName}"/></a></span>
   			</c:forEach>
   		
        <span><p>&copy; Company 2014</p></span>
    </footer>
    <div id="gotop" onclick="flytotop();" class="totop"><a href="#"><img src="${ctx}/front/img/fighter2.png"></a></div>
    <script src="${ctx}/front/js/jquery-1.11.3.min.js" type="text/javascript" charset="utf-8"></script>
    <script src="${ctx}/front/js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>   
    <script src="${ctx}/front/js/my.js" type="text/javascript" charset="utf-8"></script>
    <script src="${ctx}/front/js/light.js" type="text/javascript" charset="utf-8"></script>
	</body>
</html>