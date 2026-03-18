<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Books</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
<h1>Book Management</h1>

<!-- Форма для добавления новой книги -->
<h3>Add a New Book</h3>
<form action="/books/create" method="post">
    Title: <input type="text" name="title" required><br>
    Genre: <input type="text" name="genre" required><br>
    Year: <input type="number" name="year" required><br>
    Rating: <input type="number" name="rating" step="0.1" required><br>
    <button type="submit">Add Book</button>
</form>

<h2>Books List</h2>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Title</th>
        <th>Genre</th>
        <th>Year</th>
        <th>Rating</th>
        <th>Actions</th>
    </tr>
    <c:forEach var="book" items="${books}">
        <tr>
            <td>${book.id}</td>
            <td>${book.title}</td>
            <td>${book.genre}</td>
            <td>${book.year}</td>
            <td>${book.rating}</td>
            <td>
                <!-- Форма для редактирования книги -->
                <form action="/books/${book.id}" method="get" style="display:inline;">
                    <button type="submit">Update</button>
                </form>

                <!-- Форма для удаления книги -->
                <form action="/books/delete/${book.id}" method="post" style="display:inline;">
                    <button type="submit">Delete</button>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
