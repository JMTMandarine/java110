<%@page import="java.util.ArrayList"%>
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
<h1>EL - List 객체에서 값 꺼내기</h1>
<%
ArrayList<String> nameList= new ArrayList<>();
nameList.add("만다린");
nameList.add("렁국장");
nameList.add("마인부우");

pageContext.setAttribute("names", nameList);
%>

name 0 = ${names[0]}<br>
name 1 = ${names[1]}<br>
name 2 = ${names[2]}<br>
name 3 = ${names[3]}<br>

<%-- 보관소가 아닌 로컬 변수는 EL에서 사용할 수 없다  
     반드시 저장된 것 만 쓸수있음. 예>pageContext.setAttribute(); 이후의 값들
--%>
${nameList[0]}<br>

</body>
</html>












