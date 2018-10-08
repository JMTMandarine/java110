<%@page import="bitcamp.java110.Member"%>
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
<h1>EL - 일반객체에서 값 꺼내기</h1>
<%
Member member = new Member();
member.setNo(100);
member.setName("만다린");
member.setEmail("MandaLee@test.com");
member.setTel("1111-2222");
pageContext.setAttribute("member", member);
%>

Object0 = ${member.no}<br>
Object1 = ${member['no']}<br>
Object2 = ${member["no"]}<br>
Object4 = ${member.getNo()}<br>

<%-- 보관소가 아닌 로컬 변수는 EL에서 사용할 수 없다  
     반드시 저장된 것 만 쓸수있음. 예>pageContext.setAttribute(); 이후의 값들
--%>
${nameList[0]}<br>

</body>
</html>












