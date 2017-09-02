<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Денис
  Date: 8/26/2017
  Time: 10:54 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Выбор преподователя</title>
</head>
<body>
        <form:form modelAttribute="teacher">
            <p>
                <label for="teacherName">Имя преподователя:</label>
                <form:select path="teacherName" items="${teacher-list}"/>
            </p>
            <p>
                <form:radiobutton path="scheduleType" value="lessons"/>Расписание занятий
                <form:radiobutton path="scheduleType" value="session"/>Расписание сессии
            </p>
            <button type="submit">Загрузить</button>
        </form:form>

</body>
</html>
