<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.stu.model.*" %>
<%@page import="com.stu.servlet.*" %>
<%@page import="com.stu.ctrl.*" %>
<%@page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/friends.css">
</head>
<body>
    <center>
     <h1 style="color:white">你的好友现在有</h1>
        <input type="text" id="content" />
        <button onclick="search()" value="search">Search</button>
        <%
            Account account = (Account) session.getAttribute("account");
            List <Account> list = FriendsCtrl.getFriendAccountListById(account.getUser_id());
        %>
        <ul id="demo">
        <%
            
            for (Account acc : list) {
                if (acc.getUser_id() == account.getUser_id() || acc.getUser_id() == 1) {
                    continue;
                }
                out.println("<li><text>");
                out.println(acc.getUsername());
                out.println("</text> <button>Block</button></li>");
            }
        %>
        </center>
</body>
</html>