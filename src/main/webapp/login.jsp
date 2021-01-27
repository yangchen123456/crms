<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 2
  Date: 2021/1/26
  Time: 20:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String count = request.getParameter("count");

%>
</body>
<%--<%= request.getParameter("count")%>--%>
<%--<%=application.getAttribute("count")%>--%>
${applicationScope.map.id}
${applicationScope.map.branch_name}
${applicationScope.map.location}

</html>
