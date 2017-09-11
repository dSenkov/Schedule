<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">

    <title>${isNew ? "Новый факультет" : "Редактирование факультета ".concat(faculty.name)}</title>
</head>
<body>
<div id="main" class="container">

    <div class="row align-items-center" style="margin-top: 15%">
        <div class="col-12 align-items-center">
            <c:if test="${updateIsSuccessful}">
                <div class="alert alert-success mt-5">Изменения сохранены</div>
            </c:if>
        <div class="row align-items-center">
            <form:form modelAttribute="faculty" cssClass="align-content-center">
                <form:hidden path="id"/>
                <h4 class="align-items-center">Название:</h4>
                <form:input path="name"  cssClass="align-content-center"/>
                <form:errors path="name" cssClass="text-danger" cssStyle="align-self: center"/>
                <br><br>
                <a href="/admin/facultys"><button type="button" class="btn btn-primary">Вернуться</button></a>
                <br><br>
                <button type="submit" class="btn btn-success">Сохранить</button>
            </form:form>
        </div>
        </div>
    </div>
</div>
</body>
</html>
