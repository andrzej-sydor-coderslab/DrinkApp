<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- znacznik viewport odpowiada za poprawne wyświetlanie strony na ekranach różnego rozmiaru-->
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>DrinkApp - drinkuj ze smakiem</title>

    <!-- Custom fonts for this template-->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
          rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="<c:url value="/theme/css/sb-admin-2.css"/>" rel="stylesheet">


</head>
<%@ include file="header.jsp" %>

<section class="dashboard-section">
    <div class="container pt-4 pb-4">
        <div class="border-dashed view-height">
            <div class="container w-25">
                <!-- fix action, method -->
                <!-- add name attribute for all inputs -->
                <form class="padding-small text-center" method="post" action="/register">
                    <h1 class="text-color-darker">Rejestracja</h1>
                    <div class="form-group">
                        <input type="text" class="form-control" id="name" name="firstName" placeholder="podaj imię">
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control" id="surname" name="lastName" placeholder="podaj nazwisko">
                    </div>
                    <div class="form-group">
                        <input type="text" class="form-control" id="email" name="email" placeholder="podaj email">
                    </div>
                    <div class="form-group">
                        <input type="password" class="form-control" id="password" name="password" placeholder="podaj hasło">
                    </div>
                    <%--<div class="form-group">
                        <input type="password" class="form-control" id="repassword" name="password" placeholder="powtórz hasło">
                    </div>--%>
                    <button class="btn btn-color rounded-0" type="submit">Wyślij</button>
                </form>
            </div>
        </div>
    </div>
</section>
<%@ include file="footer.jsp" %>