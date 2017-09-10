<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Выбор группы</title>
</head>
<body>
    <form action="/schedule">
        <p>
            <label>Группа:</label><br>
            <select name="selectedGroup">
                <c:forEach items="${groupList}" var="group">
                    <jsp:useBean id="group" class="domain.POJOs.Group"/>
                    <option value="${group.id}">${group.name}</option>
                </c:forEach>
            </select>
        </p>
        <button type="submit">Показать раписание</button>
    </form>
    <hr>
    <a href="/"><button>На главную</button></a>
    <br><br>
    <a href="/login"><button>Войти</button></a>
</body>
</html>
