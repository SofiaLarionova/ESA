<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Book</title>
</head>
<body>

<h1>Update Book</h1>

<form action="books" method="post">
    <jsp:useBean id="book" scope="request" type="ru.ssau.labs.models.Book"/>
    <input type="hidden" name="action" value="update">

    <input type="hidden" name="id" value="${book.id}">

    Title: <input type="text" name="title" value="${book.title}"><br>
    Genre: <input type="text" name="genre" value="${book.genre}"><br>
    Rating: <input type="text" name="rating" value="${book.rating}"><br>
    Year: <input type="text" name="year" value="${book.year}"><br>

    <button type="submit">Update Book</button>
</form>

<br>
<a href="books">Назад</a>

</body>
</html>