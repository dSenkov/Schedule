<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">

    <title>Вход</title>
</head>
<body>
    <div id="main" class="container">
        <div class="row align-items-center">
            <div class="col-12 align-items-center">
                <h4 class="display-4 text-center">Расписание НТУУ "КПИ"</h4>
            </div>
        </div>
        <div class="row align-items-center">
            <div class="col-12 align-items-center">
                <p style="text-align: center"><img src="resources/img/kpi.jpg" width="200" height="200" class="rounded-circle" /></p>
            </div>
        </div>

        <c:if test="${param.error != null}">
           <div class="alert alert-danger" style="margin-top: 10%">Неправильный логин или пароль.</div>
        </c:if>

        <div class="row align-items-center" style="margin-top: 10%">
            <div class="col-12 align-items-center">
                <form method="post" style="text-align: center">
                    <p>
                        <h4 class="text-center">Логин:</h4><br>
                        <input type="password" name="login" class="form-control" placeholder="Введите логин"/>
                    </p>
                    <br><br>
                    <p>
                        <h4 class="text-center">Пароль:</h4><br>
                        <input type="password" name="password" class="form-control" placeholder="Введите пароль"/>
                    </p>
                    <br>
                    <p>
                        <button type="submit" class="btn btn-primary">Войти</button>
                    </p>
                </form>

            </div>
        </div>
        <div class="row align-items-center" style="margin-top: 25%; margin-bottom: 2%">
            <div class="col-12" style="text-align: center">
                <a href="/" style="text-align: center"><button class="btn btn-primary">На главную</button></a>
            </div>
        </div>
    </div>
    <%--c:if test="${param.error != null}">
        <label>Неправильный логин или пароль.</label>
    </c:if>
        <form method="post">
            <p>
                <label>Логин:</label>
                <br/>
                <input type="password" name="login"     placeholder="Введите логин"/>
            </p>
            <p>
                <label>Пароль:</label>
                <br/>
                <input type="password" name="password"  placeholder="Введите пароль"/>
            </p>
            <button type="submit">Войти</button>
        </form>
    <hr>
    <a href="/"><button>На главную</button></a>--%>
</body>
</html>
