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
<h1>JSTL - c:if</h1>
<pre>
 - 다중 조건문들 만든다
 - 자바위 switch와 유사하다.
</pre>

<h2>배열</h2>
<%
pageContext.setAttribute("names",new String[]{"만다린","마인부우","렁국장"});
%>
<ul>
<c:forEach items="${pageScope.names}" var="n">
    <li>${n}</li>
</c:forEach>
</ul>

<h2>Collection 객체</h2>
<%
List<String> names2=new ArrayList<>();
names2.add("만다린");
names2.add("마인부우");
names2.add("렁국장");
pageContext.setAttribute("names2",names2);
%>
<ul>
<c:forEach items="${pageScope.names2}" var="n">
    <li>${n}</li>
</c:forEach>
</ul>

<h2>Collection 객체</h2>
<%
Map<String,Object> names3=new HashMap<>();
names3.put("s01","만다린");
names3.put("s02","부우부");
names3.put("s03","청국장");
pageContext.setAttribute("names3",names3);
%>
<ul>
<%-- Map 객체에 대해 반복문을 돌리면 var로 저장하는 것은
     key value를 갖고 있는 Entry 객체이다. --%>
<c:forEach items="${pageScope.names3}" var="n">
    <li>${n.key} : ${n.value} </li>
</c:forEach>
</ul>

<h2>CVS(comma separated value)</h2>
<%
pageContext.setAttribute("names4","만다린,마인부우,렁국장,객체왕,종규킹");
%>
<ul>
<%-- Map 객체에 대해 반복문을 돌리면 var로 저장하는 것은
     key value를 갖고 있는 Entry 객체이다. --%>
<c:forEach items="${pageScope.names4}" var="n">
    <li>${n}</li>
</c:forEach>
</ul>
</body>
</html>












