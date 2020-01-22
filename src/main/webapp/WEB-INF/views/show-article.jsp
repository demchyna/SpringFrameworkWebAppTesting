<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Article: ${article.name}</title>
</head>
<body>
    <c:import url="header.jsp" />
    <c:import url="top-menu.jsp" />
    <div style="margin: 20px auto; width: 80%">
        <h2>${article.name}</h2>
        <h6>Author: <i>${article.authorId}</i>, Created: <i>${article.createdAt.toGMTString()}</i></h6>
        <p>${article.content}</p><br>
        <form>
            <input type="submit" formaction="/article/edit" formmethod="get" value="Edit">
            <input type="submit" formaction="/article/remove" formmethod="get" value="Delete">
            <input type="hidden" name="id" value="${article.id}" />
        </form>
    </div>

</body>
</html>
