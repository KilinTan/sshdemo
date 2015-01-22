<%--
  Created by IntelliJ IDEA.
  User: qilin
  Date: 15-1-22
  Time: 上午11:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>List</title>
</head>
<body>
<c:forEach var="userInfo" items="${userInfoList}">
  <p>${userInfo.id} ---> ${userInfo.name}, Gender: ${userInfo.gender}</p>
</c:forEach>
</body>
</html>
