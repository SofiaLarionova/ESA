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
    <title>Books</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
<h1>Book Management</h1>

<!-- Форма для добавления новой книги -->
<h3>Add a New Book</h3>
<form action="books" method="post">
    <input type="hidden" name="action" value="save">
    Title: <input type="text" name="title"><br>
    Genre: <input type="text" name="genre"><br>
    Rating: <input type="text" name="rating"><br>
    Year: <input type="text" name="year"><br>
    <button type="submit">Save Book</button>
</form>

<h2>Books List</h2>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Title</th>
        <th>Genre</th>
        <th>Rating</th>
        <th>Year</th>
        <th>Actions</th>
    </tr>
    <jsp:useBean id="books" scope="request" type="java.util.List"/>
    <c:forEach var="book" items="${books}">
        <tr>
            <td>${book.id}</td>
            <td>${book.title}</td>
            <td>${book.genre}</td>
            <td>${book.rating}</td>
            <td>${book.year}</td>
            <td>
                <form action="books" method="post" style="display:inline;">
                    <input type="hidden" name="action" value="delete">
                    <input type="hidden" name="id" value="${book.id}">
                    <button type="submit">Delete</button>
                </form>
                <form action="books" method="get" style="display:inline;">
                    <input type="hidden" name="action" value="edit">
                    <input type="hidden" name="id" value="${book.id}">
                    <button type="submit">Update</button>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>