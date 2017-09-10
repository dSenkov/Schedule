<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="domain.GroupSort" %><%--
  Created by IntelliJ IDEA.
  User: Денис
  Date: 9/5/2017
  Time: 5:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Админка | Группы</title>
</head>
<body>
    <h2>Таблица групп ${faculty.name}</h2>
    <form>
        <p>
            <label for="name">Название:</label>
            <br>
            <input type="text" id="name" name="name" value="${param.name}"/>
        </p>
        <p>
            Курс:
            <br>
            <label for="min">Минимальный:</label>
            <input type="number" id="min" name="min" value="${param.min}"/>
            <br>
            <label for="max">Максимальный:</label>
            <input type="number" id="max" name="max" value="${param.max}"/>
        </p>
        <p>
            <label for="sort">Сортировка:</label>
            <select id="sort" name="sort">
                <option value="<%= GroupSort.NAME_ASC.name() %>"
                        <%= GroupSort.NAME_ASC.name().equals(request.getParameter("sort")) ? "selected" : "" %>>А-Я
                </option>
                <option value="<%= GroupSort.NAME_DESC.name() %>"
                        <%= GroupSort.NAME_DESC.name().equals(request.getParameter("sort")) ? "selected" : "" %>>Я-А
                </option>
                <option value="<%= GroupSort.COURSE_ASC.name() %>"
                        <%= GroupSort.COURSE_ASC.name().equals(request.getParameter("sort")) ? "selected" : "" %>>
                    Курс по возрастанию</option>
                <option value="<%= GroupSort.COURSE_DESC.name() %>"
                        <%= GroupSort.COURSE_DESC.name().equals(request.getParameter("sort")) ? "selected" : "" %>>
                    Курс по убыванию</option>
                <option value="<%= GroupSort.ID_ASC.name() %>"
                        <%= GroupSort.ID_ASC.name().equals(request.getParameter("sort")) ? "selected" : "" %>>
                    ID по возрастанию</option>
                <option value="<%= GroupSort.ID_DESC.name() %>"
                        <%= GroupSort.ID_DESC.name().equals(request.getParameter("sort")) ? "selected" : "" %>>
                    ID по убыванию</option>
            </select>
        </p>
        <button type="submit">Поиск</button>
    </form>
        <hr>
        <a href="/admin/facultys/${faculty.id}/newGroup">
            <button type="button">Добавить группу</button>
        </a>
        <hr>
    <table border="1" cellpadding="5">
        <tr>
            <th>ID</th>
            <th>Название</th>
            <th>Курс</th>
            <th>Операции</th>
        </tr>
        <c:forEach items="${groupList}" var="group">
            <tr>
                <td>${group.id}</td>
                <td>${group.name}</td>
                <td>${group.course}</td>
                <td>
                    <a href="/admin/facultys/${faculty.id}/groups/${group.id}">
                        <button type="submit">Редактировать</button>
                    </a>

                    <form method="post"     action="/admin/facultys/${faculty.id}/groups/${group.id}/delete">
                        <button type="submit">Удалить</button>
                    </form>

                    <form action="/admin/facultys/${faculty.id}/groups/${group.id}/lessons">
                        <button type="submit">Перейти к расписанию</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>

    <p>
        <c:set var="page" value="${param.page != null ? param.page : 1}"/>
        <c:set var="query" value="${pageContext.request.queryString != null ?
            pageContext.request.queryString.replaceFirst('&page=\\\\d+', '') : ''}"/>
        <c:forEach begin="1" end="${groupCount % pageSize == 0 ?
        groupCount / pageSize :
        groupCount / pageSize + 1 }" varStatus="loop">
            <c:choose>
                <c:when test="${page == loop.index}">
                    <button type="button" disabled>${loop.index}</button>
                </c:when>
                <c:otherwise>
                    <a href="<c:url value="/admin/facultys/${faculty.id}/groups?${query}&page=${loop.index}"/>">
                        <button type="button">${loop.index}</button>
                    </a>
                </c:otherwise>
            </c:choose>
        </c:forEach>
    </p>
</body>
</html>
