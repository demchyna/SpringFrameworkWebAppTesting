<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List of Articles</title>
</head>
<body>
    <c:import url="header.jsp" />
    <c:import url="top-menu.jsp" />
    <div style="margin: 20px auto; width: max-content">
        <table border="1">
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Created At</th>
                <th>Author Id</th>
                <th>Actions</th>
            </tr>
            <c:forEach items="${articles}" var="article">
                <tr>
                    <td>${article.id}</td>
                    <td>${article.name}</td>
                    <td>${article.createdAt.toGMTString()}</td>
                    <td>${article.authorId}</td>
                    <td>
                        <a href="<c:url value="/article/show?id=${article.id}"/>">Show</a> /
                        <a href="<c:url value="/article/edit?id=${article.id}"/>">Edit</a> /
                        <a href="<c:url value="/article/remove?id=${article.id}"/>">Remove</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
