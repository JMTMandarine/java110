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
<h1>jsp:useBean - scope의 기본값은 page이다.</h1>
<%
//테스트를 위해 기존의 세션에 보관된 데이터를 제거!
session.invalidate();
session= request.getSession();

//보관소에 값을 넣음
application.setAttribute("name", "만다린");//ServletContext 보관소
session.setAttribute("name", "마인부우");//HttpSession 보관소
request.setAttribute("name", "렁국장");//ServletRequest 보관소
pageContext.setAttribute("name","종규킹");//PageContext 보관소
%>

<jsp:useBean id="name" class="java.lang.String"/>

<!--
위의 태그는 다음과 같이 동작하는 자바 코드로 변환된다.
자바 코드
java.lang.String name=
    (java.lang.String)pageContext.getAttribute("name");
if(name==null){
    name = new java.lang.String();
    pageContext.setAttribute("name",name);
}
  -->
    
<p>이름: <%=name %></p>
</body>
</html>








































