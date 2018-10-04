<%@page import="java.util.ArrayList"%>
<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"
    isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP액션태크</title>
</head>
<body>
<h1>jsp:useBean - 보관소에 객체가 없을 때?</h1>
<pre>
 - 보관소에 객체가 없으면 기본으로 객체를 만든다.                
</pre>

<%
ArrayList<String> list1= new ArrayList<>();
list1.add("만다린");
list1.add("마인부우");
list1.add("렁국장");
request.setAttribute("names1", list1);
%>

<jsp:useBean scope="request" id="names1" class="java.util.ArrayList"/>
<jsp:useBean scope="request" id="names2" class="java.util.ArrayList"/>
<!--
위의 태그는 다음과 같이 동작하는 자바 코드로 변환된다.
자바 코드
java.util.ArrayList names1=
    (java.util.ArrayList)request.getAttribute("names1");
if(names1==null){
    names1 = new java.util.String();
    request.setAttribute("names1",names1);
}
  -->
    
<p>names1.get(1): <%=names1.get(1)%></p>
<p>names2.size(): <%=names2.size()%></p>

<!-- names2는 현재 setAttribute를 실행하지않아 위의 자바코드 동작처럼 실행하여 
     안에 값이없는 지정된 클래스 속성의 객체를 만든다.
     주의!! null값이 아님 -->
</body>
</html>








































