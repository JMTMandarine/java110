<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL</title>
</head>
<body>
<h1>EL - 배열에서 값 꺼내기</h1>
<%
pageContext.setAttribute("names", new String[]{"만다린","마인부우","렁국장"});
%>

name 0 = ${names[0]}<br>
name 1 = ${names[1]}<br>
name 2 = ${names[2]}<br>
name 3 = ${names[3]}<br>



</body>
</html>












