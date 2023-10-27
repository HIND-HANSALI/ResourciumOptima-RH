<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="css/style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">

    <title>JSP - Hello World</title>
</head>
<body>
<%--<h1><%= "Hello World!" %></h1>--%>

<nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container">
        <a class="navbar-brand" href="#">
            ResourciumOptima
            <!-- <img src="cwlogo.png" style="width: 70px;" alt="BRAND"> -->

        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
            <div class="navbar-nav ms-auto">
                <a class="nav-link active" aria-current="page" href="#">Home</a>
                <a class="nav-link" href="#">Features</a>
                <a class="nav-link" href="#">Pricing</a>
                <a class="nav-link me-5" href="Register">Register</a>
            </div>
            <a href="Login" class="btn btn-outline-secondary shadow-sm d-sm d-block">login</a>
            <!-- <a href="#" class="btn btn-outline-secondary shadow-/sm d-sm d-block ms-3">try for free</a> -->
        </div>
    </div>
</nav>
<!-- section -->
<section class="hero">
    <div class="container">
        <div class="row">
            <!-- text; -->
            <div class="col-md-6">
                <div class="text">
                    Unleash the Power of Resoucium Optime, the Ultimate HR Application
<%--                    and Transform Your Web Development Experience into Something Truly Extraordinary!--%>
                </div>
                <div>
                    <a href="hello-servlet">Hello Servlet</a><br>
                    <a href="Test">Hello Test</a><br>
                    <a href="Equipement">Les Equipements</a>
                </div>
                <div class="buttons">
                    <a href="#" class="btn btn-primary">study case</a>
                    <a href="#" class="btn btn-outline-secondary ms-3">study case</a>

                </div>
            </div>
            <!-- image -->
            <div class="col-md-6">
                <img src="css/rh.jpg" style="height: 500px;" alt="jeu" class="w-100">

            </div>


        </div>


    </div>

</section>



<%--<h1>Save Department</h1>--%>
<%--<form action="hello-servlet" method="post">--%>
<%--    <label for="nom">Nom:</label>--%>
<%--    <input type="text" id="nom" name="nom" required><br>--%>

<%--    <label for="description">Description:</label>--%>
<%--    <textarea id="description" name="description" rows="4" required></textarea><br>--%>

<%--    <input type="submit" value="Save Department">--%>
<%--</form>--%>
</body>
</html>