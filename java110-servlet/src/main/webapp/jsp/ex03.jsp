<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<% //스크립트릿: 자바코드를 두는태그
int a;
%>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
<% 
 a=100;
 int b = a++;
%>
<h1>스크립트릿(scriptlet)</h1>
<pre>
- JSP파일 안에 작성하는 자바코드이다.
- 자바코드:
     스크립트릿 태그 안에 작성한 자바코드는 _jspService() 안에 그대로 복사된다.
</pre>
<% 
 out.println("<p>a ="+a+" </p>");
 out.println("<p>a ="+b+" </p>");
 %>
</body>
</html>