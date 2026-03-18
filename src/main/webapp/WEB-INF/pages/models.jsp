<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 1/6/2025
  Time: 5:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Models</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
<h1>CV-Models Management</h1>

<!-- Форма для добавления новой книги -->
<h3>Add a New CV-Models</h3>
<form action="/models/create" method="post">
    <input type="hidden" name="action" value="save">
    Name: <input type="text" name="modelName"><br>
    Release: <input type="text" name="releaseDate"><br>
    Score: <input type="text" name="score"><br>
    <button type="submit">Save CV-Model</button>
</form>

<h2>Models List</h2>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Release</th>
        <th>Score</th>
    </tr>
    <jsp:useBean id="models" scope="request" type="java.util.List"/>
    <c:forEach var="model" items="${models}">
        <tr>
            <td>${model.id}</td>
            <td>${model.modelName}</td>
            <td>${model.releaseDate}</td>
            <td>${model.top5Score}</td>
            <td>
                <!-- Форма для редактирования книги -->
                <form action="/models/${model.id}" method="get" style="display:inline;">
                    <button type="submit">Update</button>
                </form>

                <!-- Форма для удаления книги -->
                <form action="/models/delete/${model.id}" method="post" style="display:inline;">
                    <button type="submit">Delete</button>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>