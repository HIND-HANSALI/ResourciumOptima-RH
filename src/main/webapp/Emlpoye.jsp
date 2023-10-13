<%--
  Created by IntelliJ IDEA.
  User: Youcode
  Date: 13/10/2023
  Time: 10:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Save Employe</h1>
<form action="test" method="post">
    <label for="nom">Nom:</label>
    <input type="text" id="nom" name="nom" required><br>

    <label for="prenom">Prenom:</label>
    <input type="text" id="prenom" name="prenom" required><br>

    <label for="email">Email:</label>
    <input type="email" id="email" name="email" required><br>

    <input type="submit" value="Save Employe">
</form>

</body>
</html>
