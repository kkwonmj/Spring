<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
	isELIgnored="false" 
	import = "java.util.*, sec02.ex01.*"   
%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% request.setCharacterEncoding("utf-8"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%-- <jsp:useBean id = "m" class = "MemberBean" />
<jsp:setProperty property="*" name="m"/>
<%
	MemberDAO memDAO = new MemberDAO();
	memDAO.addMember(m);
	List membersList = memDAO.listMembers(); --%>
	request.setAttribute("membersList", membersList);
%>
<title>멤버 액션</title>
</head>
<body>
<jsp:forward page="membersList.jsp" />
</body>
</html>