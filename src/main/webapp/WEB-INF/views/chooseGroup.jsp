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

    <title>Выбор группы</title>
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

        <div class="row align-items-center">
            <div class="col-12 align-items-center" style="margin-top: 10%">
                <form action="/schedule" style="text-align: center">
                    <p>
                        <h4 class="text-center">Группа:</h4>
                        <select class="custom-select" name="selectedGroup">
                            <c:forEach items="${groupList}" var="group">
                                <jsp:useBean id="group" class="domain.POJOs.Group"/>
                                <option value="${group.id}">${group.name}</option>
                            </c:forEach>
                        </select>
                    </p>
                    <br>
                    <p>
                        <button type="submit" class="btn btn-primary">Показать расписание</button>
                    </p>
                </form>
            </div>
        </div>
        <div class="row align-items-center">
            <div class="col-12" style="margin-top: 20%; text-align: center">
                <a href="/"><button class="btn btn-primary">На главную</button></a>
                <br><br>
                <a href="/login" style="text-align: center"><button class="btn btn-warning">Войти</button></a>
            </div>
        </div>
    </div>
</body>
</html>
