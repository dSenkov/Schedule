<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Денис
  Date: 9/8/2017
  Time: 7:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Редактирование пары</title>
</head>
<body>
        <form:form method="post" modelAttribute="lesson">
            <p>
                <label>Предмет:</label><br>
                <form:input path="subject"/>
                <form:errors cssStyle="color:red"/>
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
                <form:errors cssStyle="color:red"/>
            </p>
            <p>
                <label>Корпус:</label><br>
                <form:input path="building"/>
                <form:errors cssStyle="color:red"/>
            </p>
            <p>
                <label>Аудитория</label><br>
                <form:input path="classroom"/>
                <form:errors cssStyle="color:red"/>
            </p>
            <a href="/admin/facultys/${faculty.id}/groups/${group.id}/lessons"><button type="button">Вернуться</button></a>
            <button type="submit">Сохранить</button>
        </form:form>
</body>
</html>
