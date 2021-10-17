<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
<h2>Formularz dodawania drinka</h2>
<form:form method="post" modelAttribute="drink">

    <form:hidden path="id"/>

    Nazwa: <form:input path="name" /> <br />
    <form:errors path="name"/><br/>
    Składniki: <form:textarea path="ingredients"/> <br />
    <form:errors path="ingredients"/><br/>
    Czas przygotowania (minuty): <form:select path="preparationTime" items="${preparationTime}"/> <br />
    <form:errors path="preparationTime"/><br/>
    Koszt drinka: <form:select path="priceLevel" items="${drinkCosts}"/><br/>
    <form:errors path="priceLevel"/><br/>
    Opis przygotowania <form:textarea path="description"/> <br />
    <form:errors path="description"/><br/>
    <input type="submit">

</form:form>
<%@ include file="footer.jsp" %>