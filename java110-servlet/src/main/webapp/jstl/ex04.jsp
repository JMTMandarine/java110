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
 - 보관소에 저장된 값을 제거한다.
</pre>
<%
pageContext.setAttribute("name","만다린");
request.setAttribute("name","마인부우");
session.setAttribute("name","렁국장");
application.setAttribute("name","객체왕");
%>                  
                  
1: ${pageScope.name}<br>
2: ${requestScope.name}<br>
3: ${sessionScope.name}<br>
4: ${applicationScope.name}<br>

<hr>
<c:remove var="name" scope="page"/>
1: ${pageScope.name}<br>
2: ${requestScope.name}<br>
3: ${sessionScope.name}<br>
4: ${applicationScope.name}<br>

<hr>
<c:remove var="name" scope="request"/>
1: ${pageScope.name}<br>
2: ${requestScope.name}<br>
3: ${sessionScope.name}<br>
4: ${applicationScope.name}<br>

<hr>
<c:remove var="name" scope="session"/>
1: ${pageScope.name}<br>
2: ${requestScope.name}<br>
3: ${sessionScope.name}<br>
4: ${applicationScope.name}<br>

<hr>
<c:remove var="name" scope="application"/>
1: ${pageScope.name}<br>
2: ${requestScope.name}<br>
3: ${sessionScope.name}<br>
4: ${applicationScope.name}<br>

</body>
</html>












