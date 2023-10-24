<%--
  Created by IntelliJ IDEA.
  User: Youcode
  Date: 24/10/2023
  Time: 11:12
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Reservation</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body>
<section class="h-100 h-custom" >
  <div class="container py-5 h-100">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col-lg-8 col-xl-6">
        <div class="card rounded-3">
          <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-registration/img3.webp"
               class="w-100" style="border-top-left-radius: .3rem; border-top-right-radius: .3rem;"
               alt="Sample photo">
          <div class="card-body p-4 p-md-5">
            <h3 class="mb-4 pb-2 pb-md-0 mb-md-5 px-md-2">Make Reservation</h3>

            <form class="px-md-2"  action="Reservation" method="post">

                <div class="col-md-6 mb-4">
                    <label for="exampleDatepicker1" class="form-label">Date reservation</label>
                    <input type="date" class="form-control" id="exampleDatepicker1"
                           placeholder="Enter date Allocation" name="dateDebut" />
                </div>
                <div class="col-md-6 mb-4">
                    <label class="form-label" for="dateAchat">Date Retour</label>
                    <input type="date" id="dateAchat" class="form-control"
                           placeholder="Enter date Retour" name="dateFin"/>
                </div>
                <c:if test="${not empty equipmentNotFound}">
                    <p>${equipmentNotFound}</p>
                </c:if>

                <div class=" mb-3">
                    <label class="form-label" for="equipement">Equipement</label>
                    <select id="equipement" class="form-control" name="equipementId">
                    <c:forEach var="equipement" items="${equipementValues}">
                    <option value="${equipement.id}">${equipement.nom}</option>
                    </c:forEach>
                    </select>
                </div>

                <div class="col-12">
                    <button type="submit" class="btn btn-primary btn-lg mb-3">Reserve</button>
                </div>
            </form>

          </div>
        </div>
      </div>
    </div>
  </div>
</section>


</body>
</html>
