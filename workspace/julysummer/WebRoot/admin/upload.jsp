<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE  html>
<html>
<meta charset="UTF-8"/>
<link rel="stylesheet" href="${ctx}/front/css/bootstrap.min.css" />
<body>
<form class="btn btn-default" action='doUpload' method='post' enctype='multipart/form-data'>
请选择要上传的相片<input class="btn btn-success" type='file' name='upfile' size='50'>
<input class="btn btn-success" type='submit' value='上传'>
</form>  
</body>
</html>