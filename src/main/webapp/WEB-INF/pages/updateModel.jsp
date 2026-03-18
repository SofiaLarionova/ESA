<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update CV-Model</title>
</head>
<body>

<h1>Update CV-Model</h1>

<jsp:useBean id="model" scope="request" type="ru.ssau.labs.spring.model.CvModel"/>
<form action="/models/update/${model.id}" method="post">
    <input type="hidden" name="id" value="${model.id}">
    Title: <input type="text" name="modelName" value="${model.modelName}"><br>
    Genre: <input type="text" name="releaseDate" value="${model.releaseDate}"><br>
    Rating: <input type="text" name="score" value="${model.top5Score}"><br>
    <button type="submit">Update Model</button>
</form>

<br>
<a href="models">Назад</a>

</body>
</html>