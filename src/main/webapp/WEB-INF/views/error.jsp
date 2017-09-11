<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
          integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">

    <title>Ошибка</title>
</head>
<body>
<div id="main" class="container">
    <div class="row align-items-center">
        <div class="col-12 align-items-center">
            <h4 class="display-4 text-center">Ууупс, что-то пошло не так...</h4>
        </div>
    </div>
    <div class="row align-items-center">
        <div class="col-12 align-items-center">
            <p style="text-align: center"><img src="resources/img/kpi.jpg" width="200" height="200"
                                               class="rounded-circle"/></p>
        </div>
    </div>
    <div class="row align-items-center">
        <div class="col-12 align-items-center">
            <p>Скорее всего, сейчас в базе данных отстутствует либо данная группа, либо ее расписание, либо и то, и
                другое.
                Пожалуйста, попробуйте еще раз позже.</p>
        </div>
    </div>
</div>
</body>
</html>
