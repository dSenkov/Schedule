<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>${isNew ? "Новая группа" : "Редактирование группы ".concat(group.name)}</title>
</head>
<body>
    <form:form method="post" modelAttribute="group">
        Faculty = ${faculty} <br>
        Group = ${group}
        <form:hidden path="id"/>
        <p>
            <label for="name">Название:</label><br>
            <form:input path="name" />
            <form:errors path="name" cssStyle="color: red"/><br>
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
        <a href="/admin/facultys/${faculty.id}/groups"><button type="button">Вернуться</button></a>
        <button type="submit">Сохранить</button>
    </form:form>

<c:if test="${updateIsSuccessful}">
    <span style="color: green;">Изменения сохранены.</span>
</c:if>
</body>
</html>
