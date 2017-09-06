<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Денис
  Date: 9/5/2017
  Time: 4:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${isNew ? "Новый факультет" : "Редактирование факультета ".concat(faculty.name)}</title>
</head>
<body>
    <form:form modelAttribute="faculty">
        <form:hidden path="id"/>
        <label for="name">Название:</label><br>
        <form:input path="name" />
        <form:errors path="name" cssStyle="color: red"/>
        <br><br>
        <a href="/admin/facultys"><button type="button">Вернуться</button></a>
        <button type="submit">Сохранить</button>
    </form:form>

    <c:if test="${updateIsSuccessful}">
        <span style="color: green;">Изменения сохранены.</span>
    </c:if>
</body>
</html>
