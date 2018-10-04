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
<h1>jsp:useBean - type 속석</h1>
<pre>
 - 지정한 type의 객체가 보관소에 없으면 예외발생!! 객체를 만들지 않는다.
 위의 태그는 다음과 같이 동작하는 자바 코드로 변환된다.
자바 코드
java.util.ArrayList names1=
    (java.util.ArrayList)request.getAttribute("names1");
if(names1==null){
    throw new Exception("해당 타입의 객체가 없습니다.");
}
</pre>

<%
ArrayList<String> list1= new ArrayList<>();
list1.add("만다린");
list1.add("마인부우");
list1.add("렁국장");
request.setAttribute("names1", list1);
%>

<jsp:useBean scope="request" id="names1" type="java.util.ArrayList"/>
<jsp:useBean scope="request" id="names2" type="java.util.ArrayList"/>
<%-- 
Class = 객체가 없을시 값이없는 객체 생성
type  = 객체가 없을시 에러를 던짐

 --%>
    
<p>names1.get(1): <%=names1.get(1)%></p>
<p>names2.size(): <%=names2.size()%></p>

</body>
</html>








































