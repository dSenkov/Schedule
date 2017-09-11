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

    <title>${isNew ? "Новая группа" : "Редактирование группы ".concat(group.name)}</title>
</head>
<body>
    <div id="main" class="container">

        <div class="row align-items-center" style="margin-top: 15%">
            <div class="col-12 align-items-center">
                <c:if test="${updateIsSuccessful}">
                <div class="alert alert-success mt-5">Изменения сохранены</div>
                </c:if>
        <div class="row align-items-center">
        <form:form method="post" modelAttribute="group" cssClass="align-content-center">
            <form:hidden path="id"/>
            <p>
              <h4 class="align-items-center">Название:</h4><br>
                <form:input path="name" />
                <form:errors path="name" cssClass="text-danger" cssStyle="align-self: center"/><br>
            </p>
            <p>
                <label>Курс:</label> <br/>
                <label for="radio1">1</label>
                <form:radiobutton id="radio1" path="course" value="1" checked="checked"/><br>
                <label for="radio2">2</label>
                <form:radiobutton id="radio2" path="course" value="2"/><br>
                <label for="radio3">3</label>
                <form:radiobutton id="radio3" path="course" value="3"/><br>
                <label for="radio4">4</label>
                <form:radiobutton id="radio4" path="course" value="4"/><br>
                <label for="radio5">5</label>
                <form:radiobutton id="radio5" path="course" value="5"/><br>
                <label for="radio6">6</label>
                <form:radiobutton id="radio6" path="course" value="6"/><br>
            </p>
                <form:hidden path="faculty.id" value="${faculty.id}"/>
            <a href="/admin/facultys/${faculty.id}/groups"><button class="btn btn-warning" type="button">Вернуться</button></a>
            <button type="submit" class="btn btn-primary">Сохранить</button>
        </form:form>
     </div>
</body>
</html>
