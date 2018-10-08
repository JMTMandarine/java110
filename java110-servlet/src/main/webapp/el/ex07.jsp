<%@page import="java.util.HashMap"%>
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
<h1>EL - Map 객체에서 값 꺼내기</h1>
<%
HashMap<String,Object> map= new HashMap<>();
map.put("s01","만다린");
map.put("s02","마인부우");
map.put("s03","렁국장");

pageContext.setAttribute("map", map);
%>

map0 = ${map.s01}<br>
map1 = ${map['s02']}<br>
map2 = ${map["s03"]}<br>

<%-- 보관소가 아닌 로컬 변수는 EL에서 사용할 수 없다  
     반드시 저장된 것 만 쓸수있음. 예>pageContext.setAttribute(); 이후의 값들
--%>
${nameList[0]}<br>

</body>
</html>












