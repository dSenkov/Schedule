<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <form method="post">
            <p>
                <label>Имя преподователя:</label>
                <select>
                <c:forEach items="${teacher-list}" var="teacher">
                    <jsp:useBean id="teacher" class="domain.POJOs.Teacher"/>
                <option value=${teacher}>${teacher.name}</option>
                </c:forEach>
                </select>
            </p>
            <button type="submit" value="/TeacherLessons/${teacher.id}">Расписание занятий</button>
            <button type="submit" value="/TeacherSession/${teacher.id}">Расписание сессии</button>
        </form>

</body>
</html>
