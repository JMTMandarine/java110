<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL</title>
</head>
<body>
<h1>JSTL - c:forTokens</h1>
<pre>
 - 반복문을 만든다.
</pre>

<h2>ForTokens</h2>
<%
pageContext.setAttribute("names1","만다린,마인부우,렁국장,객체왕,종규킹");
%>
<ul>
<c:forTokens items="${pageScope.names1}" var="n" delims=",">
    <li>${n}</li>
</c:forTokens>
</ul>


<h2>ForTokens</h2>
<%
pageContext.setAttribute("qs","name=홍길동&age=20&tel=111-222");
%>
<ul>
<c:forTokens items="${pageScope.qs}" var="n" delims="&">
    <li>${n}</li>
</c:forTokens>
</ul>

</body>
</html>












