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
<h1>JSTL - c:redirect</h1>
<pre>
 - redirect 응답하기
</pre>

<c:if test="${param.search == 'naver'}">
    <c:redirect url="http://www.naver.com"/>
</c:if>
<c:if test="${param.search == 'daum'}">
    <c:redirect url="http://www.daum.net"/>
</c:if>

<c:if test="${param.search == 'poo'}">
    <c:redirect url="https://search.naver.com/search.naver?sm=tab_sug.top&where=nexearch&query=%EA%B3%B0%EB%8F%8C%EC%9D%B4+%ED%91%B8+%EB%8B%A4%EC%8B%9C+%EB%A7%8C%EB%82%98+%ED%96%89%EB%B3%B5%ED%95%B4&oquery=&tqi=TJVc4spVuE4ssZo3SHVssssstQ0-047153&acq=%EA%B3%B0%EB%8F%8C%EC%9D%B4&acr=1&qdt=0"/>
</c:if>

<p>search 라는 이름으로 검색 엔진을 지정하세요!</p>
<p>유효한 엔진은 'naver','daum' 입니다.</p>
</body>
</html>












