<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update CV-Model</title>
</head>
<body>

<h1>Update CV-Model</h1>

<form action="models" method="post">
    <jsp:useBean id="model" scope="request" type="ru.ssau.labs.models.CvModel"/>
    <input type="hidden" name="action" value="update">

    <input type="hidden" name="id" value="${model.id}">

    Title: <input type="text" name="name" value="${model.name}"><br>
    Genre: <input type="text" name="release" value="${model.release}"><br>
    Rating: <input type="text" name="score" value="${model.score}"><br>

    <button type="submit">Update Model</button>
</form>

<br>
<a href="models">Назад</a>

</body>
</html>