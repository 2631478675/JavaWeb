<%--
  Created by IntelliJ IDEA.
  User: liuyu
  Date: 2017/10/5
  Time: 10:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>文件上传</title>
</head>
<body>
<!--
  enctype="multipart/form-data" : 编码类型（内容类型）比如每个文件都有扩展名
  post方法 : 安全，没有大小限制（使用流进行传输，而不是使用URL）
-->
<form action="Servlet" method="post" enctype="multipart/form-data">
  文件上传:<input type="file" name="upfile"/>
  <br/>
  备注：<input type="text" name="description"/>
  <br/>
  <input type="submit" value="提交">
</form>
</body>
</html>
