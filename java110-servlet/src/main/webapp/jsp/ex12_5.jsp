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
<h1>jsp:useBean - type 속성과 class속성 동시 사용하기</h1>
<pre>
  복붙하자요 
  &lt;jsp:useBean
      scope
</pre>

<%
ArrayList<String> list1= new ArrayList<>();
list1.add("만다린");
list1.add("마인부우");
list1.add("렁국장");
request.setAttribute("names1", list1);
%>

<jsp:useBean scope="request" 
             id="names1" 
             type="java.util.List<String>"
             class="java.util.ArrayList"/>
    
<p>names1.get(2): <%=names1.get(2)%></p>

</body>
</html>








































