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
<h1>네이버 검색 URL 만들기</h1>
<pre>
 https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=1&ie=utf8&query=%EB%A7%8C%EB%8B%A4%EB%A6%B0
</pre>

<c:url value="https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=1&ie=utf8&query=%EB%A7%8C%EB%8B%A4%EB%A6%B0" var="naverUrl">
    <c:param name="where" value="nexearch"/>
    <c:param name="sm" value="top_hty"/>
    <c:param name="fbm" value="1"/>
    <c:param name="ie" value="utf8"/>
    <c:param name="query" value="만다린"/>
</c:url>
<p>${naverUrl}</p>


</body>
</html>












