<%@ page import="domain.FacultySort" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Денис
  Date: 9/5/2017
  Time: 4:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Админка | Факультеты</title>
</head>
<body>
<h2>Таблица факультетов НТУУ "КПИ"</h2>
        <form>
            <p>
                <label for="name">Название:</label>
                <br/>
                <input type="text" id="name" name="name" value="${param.name}"/>
            </p>
            <p>
                <label for="sort">Сортировка:</label>
                <br>
                <select id="sort" name="sort">
                    <option value="<%= FacultySort.NAME_ASC.name() %>"
                            <%= FacultySort.NAME_ASC.name().equals(request.getParameter("sort")) ? "selected" : "" %>>А-Я
                    </option>
                    <option value="<%= FacultySort.NAME_DESC.name() %>"
                            <%= FacultySort.NAME_DESC.name().equals(request.getParameter("sort")) ? "selected" : "" %>>Я-А
                    </option>
                    <option value="<%= FacultySort.ID_ASC.name() %>"
                            <%= FacultySort.ID_ASC.name().equals(request.getParameter("sort")) ? "selected" : "" %>>ID по возрастанию
                    </option>
                    <option value="<%= FacultySort.ID_DESC.name() %>"
                            <%= FacultySort.ID_DESC.name().equals(request.getParameter("sort")) ? "selected" : "" %>>ID по убыванию
                    </option>
                </select>
            </p>
            <button type="submit">Поиск</button>
        </form>
    <hr>
        <a href="/admin/newFaculty">
            <button type="button">Добавить факультет</button>
        </a>
    <hr>
        <table border="1" cellpadding="5">
            <tr>
                <th>ID</th>
                <th>Название</th>
                <th>Операции</th>
            </tr>
            <c:forEach items="${facultyList}" var="faculty">
                <tr>
                    <td>${faculty.id}</td>
                    <td>${faculty.name}</td>
                    <td>
                        <a href="/admin/facultys/${faculty.id}">
                            <button type="submit">Редактировать</button>
                        </a>

                        <form method="post"     action="/admin/facultys/${faculty.id}/delete">
                            <button type="submit">Удалить</button>
                        </form>

                        <form action="/admin/facultys/${faculty.id}/groups">
                            <button type="submit">Перейти к списку групп</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>

    <p>
    <c:set var="page" value="${param.page != null ? param.page : 1}"/>
    <c:set var="query" value="${pageContext.request.queryString != null ?
            pageContext.request.queryString.replaceFirst('&page=\\\\d+', '') : ''}"/>
    <c:forEach begin="1" end="${facultyCount % pageSize == 0 ?
        facultyCount / pageSize :
        facultyCount / pageSize + 1 }" varStatus="loop">
        <c:choose>
            <c:when test="${page == loop.index}">
                <button type="button" disabled>${loop.index}</button>
            </c:when>
            <c:otherwise>
                <a href="<c:url value="/admin/facultys?${query}&page=${loop.index}"/>">
                    <button type="button">${loop.index}</button>
                </a>
            </c:otherwise>
        </c:choose>
    </c:forEach>
    </p>
</body>
</html>
