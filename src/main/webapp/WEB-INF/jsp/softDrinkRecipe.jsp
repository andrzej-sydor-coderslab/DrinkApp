<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Panel Administracyjny</title>

    <!-- Custom fonts for this template-->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="<c:url value="/theme/css/sb-admin-2.css"/>" rel="stylesheet">


</head>
<title>Przepis na drink</title>
</head>
<body>
<%@ include file="header.jsp" %>
<table>
    <tr>
        <th>Nazwa drinka</th>
        <th>Składniki</th>
        <th>Czas przygotowania</th>
        <th>Koszt drinka</th>
    </tr>
    <tr>
        <td> ${soft.name} </td>
        <td>${soft.ingredients}</td>
        <td>${soft.preparationTime}</td>
        <td>${soft.priceLevel}</td>
    </tr>
</table>
<br>
<h2>Opis przygotowania<h2></h2><br>
    ${soft.description}


    <%@ include file="footer.jsp" %>
</body>
</html>