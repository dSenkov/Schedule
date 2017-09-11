<%@ page import="domain.FacultySort" %>
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

    <title>Админка | Факультеты </title>
</head>
<body>
    <div id="main" class="container">
        <div class="row align-items-center">
            <div class="col-8 align-items-center">
                <div class="row align-items-center">
                    <div class="col-8">
                        <h2 class="text-center">Таблица факультетов</h2>
                        <h2 class="text-center">НТУУ "КПИ"</h2>
                    </div>
                </div>

                <div class="row align-items-center">
                    <div class="col-8 align-items-center">
                        <form>
                            <div class="form-group">
                                <label for="name">Название:</label>
                                <br/>
                                <input type="text" id="name" name="name" value="${param.name}" class="form-control"/>
                            </div>
                            <div class="form-group">
                                <label for="sort">Сортировка:</label>
                                <br>
                                <select id="sort" name="sort" class="form-control">
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
                            </div>
                            <div class="form-group text-center">
                                <button type="submit" class="btn btn-primary">Поиск</button>
                            </div>
                         </form>
                    </div>
                </div>
                <div class="row align-items-center">
                    <div class="col-8 align-items-center">
                        <hr>
                            <a href="/admin/newFaculty">
                                <button type="button" class="btn btn-success btn-block">Добавить факультет</button>
                            </a>
                        <hr>
                    </div>
                </div>
                <div class="row align-items-center">
                    <div class="col-8 align-items-center">
                        <div id="facultys" class="row">
                            <table class="table table-bordered">
                                <tr>
                                    <th class="text-center table-info">ID</th>
                                    <th class="text-center table-info">Название</th>
                                    <th class="text-center table-info">Операции</th>
                                </tr>
                                <c:forEach items="${facultyList}" var="faculty">
                                    <tr>
                                        <td style="vertical-align: middle" class="text-center table-info">${faculty.id}</td>
                                        <td style="vertical-align: middle" class="text-center table-info">${faculty.name}</td>
                                        <td style="vertical-align: middle" class="text-center table-info">
                                            <a href="/admin/facultys/${faculty.id}">
                                                <button type="submit" class="btn btn-outline-dark btn-block">Редактировать</button>
                                            </a>

                                            <form method="post"     action="/admin/facultys/${faculty.id}/delete">
                                                <button type="submit" class="btn btn-danger btn-block">Удалить</button>
                                            </form>

                                            <form action="/admin/facultys/${faculty.id}/groups">
                                                <button type="submit" class="btn btn-primary btn-block">Перейти к списку групп</button>
                                            </form>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </div>
                        <div class="row">
                            <div class="col-6" style="text-align: left">
                                <%-- Paginator --%>
                                <nav>
                                    <c:set var="page" value="${param.page != null ? param.page : 1}"/>
                                    <c:set var="query" value="${pageContext.request.queryString != null ? pageContext.request.queryString.replaceFirst('&page=\\\\d+', '') : ''}"/>
                                    <ul class="pagination">
                                        <c:forEach begin="1" end="${facultyCount % pageSize == 0 ? facultyCount / pageSize : facultyCount / pageSize + 1 }" varStatus="loop">
                                            <c:choose>
                                                <c:when test="${page == loop.index}">
                                                    <li class="page-item active">
                                                        <span class="page-link">${loop.index}</span>
                                                    </li>
                                                </c:when>
                                                <c:otherwise>
                                                    <li class="page-item">
                                                        <a href="<c:url value="/admin/facultys?${query}&page=${loop.index}"/>" class="page-link">
                                                                ${loop.index}
                                                        </a>
                                                    </li>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:forEach>
                                    </ul>
                                </nav>
                            </div>
                            <div class="col-6" style="text-align: right">
                                <a href="/"><button class="btn btn-primary">На главную</button></a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
