<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Book</title>
</head>
<body>

<h1>Update Book</h1>
<jsp:useBean id="book" scope="request" type="ru.ssau.labs.spring.model.Book"/>

<form action="/books/update/${book.id}" method="post">
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