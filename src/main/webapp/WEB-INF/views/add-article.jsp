<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add Article</title>
</head>
<body>
    <c:import url="header.jsp" />
    <c:import url="top-menu.jsp" />
    <div style="margin: 20px auto; width: max-content">
        <sf:form method="post" action="/article/add" modelAttribute="article">
            <table>
                <tr>
                    <td><sf:label path="name">Name:</sf:label></td>
                    <td><sf:input path="name" /></td>
                </tr>
                <tr>
                    <td><sf:label path="content">Text:</sf:label></td>
                    <td><sf:textarea path="content" /></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Submit" /></td>
                    <td style="text-align: right"><input type="reset" value="Reset" /></td>
                </tr>
            </table>
            <sf:hidden path="createdAt" />
            <sf:hidden path="authorId" />
        </sf:form>
    </div>

</body>
</html>
