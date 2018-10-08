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
<h1>JSTL - c:out</h1>
<pre>
 - 보관소에 값을 저장한다.
   &lt;c:set var="변수명" scope="page|request|session|application"
         "value="보관소에 저장할 값" default="기본 값"/>
   &lt;c:out value="출력될 값">기본값&lt;c:out>
</pre>
                  
                  
<c:set var="name1" scope="request" value="만다링!"/>
1: ${requestScope.name1}<br>
2: ${pageScope.name1}<br>

<%-- scope 미지정시 기본이 page임 --%>
<c:set var="name2" value="만다링!"/>
1: ${requestScope.name2}<br>
2: ${pageScope.name2}<br>

<c:set var="name3">만다링!!!!</c:set>
1: ${requestScope.name3}<br>
2: ${pageScope.name3}<br>

<h2>객체의 프로퍼티 값 설정하기</h2>
<jsp:useBean id="m1" class="bitcamp.java110.Member"/>
<jsp:setProperty name="m1" property="no" value="100"/>
<c:set target="${pageScope.m1}" property="email" value="hong@test.com"></c:set>
${pageScope.m1.no}<br>
${pageScope.m1.email}<br>

</body>
</html>












