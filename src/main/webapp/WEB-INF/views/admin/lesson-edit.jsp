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

    <title>${"Редактирование пары"}</title>
</head>
<body>
<div class="row align-items-center" style="margin-top: 15%">
    <div class="col-12 align-items-center">
        <c:if test="${updateIsSuccessful}">
        <div class="alert alert-success mt-5">Изменения сохранены</div>
        </c:if>
        <form:form method="post" modelAttribute="lesson" cssClass="align-content-center">
            <form:hidden path="number" />
            <form:hidden path="day" />
            <form:hidden path="firstWeek" />
            <form:hidden path="group.id" />
            <p>
            <h4 class="align-items-center">Предмет:</h4><br>
                <form:input path="subject"/>
                <form:errors path="subject" cssClass="text-danger" cssStyle="align-self: center"/>
            </p>
            <p>
                <label>Тип:</label><br>
                <form:radiobutton id="radio1" path="type" value="LECTURE" checked="checked"/>
                <label for="radio1">Лекция</label><br>
                <form:radiobutton id="radio2" path="type" value="PRACTISE"/>
                <label for="radio2">Практика</label><br>
                <form:radiobutton id="radio3" path="type" value="LAB"/>
                <label for="radio3">Лабораторная</label><br>
                <form:radiobutton id="radio4" path="type" value="CONSULTATION"/>
                <label for="radio4">Консультация</label>
            </p>
            <p>
                <label>Преподователь:</label><br>
                <form:input path="teacher"/>
                <form:errors path="teacher" cssStyle="color:red"/>
            </p>
            <p>
                <label>Корпус:</label><br>
                <form:input type="number" path="building"/>
                <form:errors path="building" cssStyle="color:red"/>
            </p>
            <p>
                <label>Аудитория</label><br>
                <form:input type = "number" path="classroom"/>
                <form:errors path="classroom" cssStyle="color:red"/>
            </p>
            <a href="/admin/facultys/${faculty.id}/groups/${group.id}/lessons"><button type="button" class="btn btn-warning">Вернуться</button></a>
            <button type="submit" class="btn btn-primary">Сохранить</button>
        </form:form>

    </div>
</div>
</body>
</html>
