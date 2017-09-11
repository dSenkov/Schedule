<%@ page import="domain.GroupSort" %>
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

    <title>Админка | Группы </title>
</head>
<body>
<div id="main" class="container">
    <div class="row align-items-center">
        <div class="col-8 align-items-center">
            <div class="row align-items-center">
                <div class="col-8">
                    <h2 class="text-center">Таблица групп ${faculty.name}</h2>
                </div>
            </div>

            <div class="row align-items-center" style="margin-top: 2%">
                <div class="col-8 align-items-center">
                    <form>
                        <div class="form-group">
                            <label for="name">Название:</label>
                            <br/>
                            <input type="text" id="name" name="name" value="${param.name}" class="form-control"/>
                        </div>
                        <div class="form-group">
                            Курс:
                            <br>
                            <label for="min">Минимальный:</label>
                            <input type="number" id="min" name="min" value="${param.min}" class="form-control"/>
                            <br>
                            <label for="max">Максимальный:</label>
                            <input type="number" id="max" name="max" value="${param.max}" class="form-control"/>
                        </div>
                        <div class="form-group">
                            <label for="sort">Сортировка:</label>
                            <select id="sort" name="sort" class="form-control">
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
                    <a href="/admin/facultys/${faculty.id}/newGroup">
                        <button type="button" class="btn btn-success btn-block">Добавить группу</button>
                    </a>
                    <hr>
                </div>
            </div>
            <div class="row align-items-center">
                <div class="col-8 align-items-center">
                    <div id="groups" class="row">
                        <table class="table table-bordered">
                            <tr>
                                <th class="text-center table-info">ID</th>
                                <th class="text-center table-info">Название</th>
                                <th class="text-center table-info">Курс</th>
                                <th class="text-center table-info">Операции</th>
                            </tr>
                            <c:forEach items="${groupList}" var="group">
                                <tr>
                                    <td style="vertical-align: middle" class="text-center table-info">${group.id}</td>
                                    <td style="vertical-align: middle" class="text-center table-info">${group.name}</td>
                                    <td style="vertical-align: middle" class="text-center table-info">${group.course}</td>
                                    <td style="vertical-align: middle" class="text-center table-info">
                                        <a href="/admin/facultys/${faculty.id}/groups/${group.id}">
                                            <button type="submit" class="btn btn-outline-dark btn-block">Редактировать</button>
                                        </a>

                                        <form method="post"     action="/admin/facultys/${faculty.id}/groups/${group.id}/delete">
                                            <button type="submit" class="btn btn-danger btn-block">Удалить</button>
                                        </form>

                                        <form action="/admin/facultys/${faculty.id}/groups/${group.id}/lessons">
                                            <button type="submit" class="btn btn-primary btn-block">Перейти к расписанию</button>
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
                                    <c:forEach begin="1" end="${groupCount % pageSize == 0 ? groupCount / pageSize : groupCount / pageSize + 1 }" varStatus="loop">
                                        <c:choose>
                                            <c:when test="${page == loop.index}">
                                                <li class="page-item active">
                                                    <span class="page-link">${loop.index}</span>
                                                </li>
                                            </c:when>
                                            <c:otherwise>
                                                <li class="page-item">
                                                    <a href="<c:url value="/admin/facultys/${faculty.id}/groups?${query}&page=${loop.index}"/>">
                                                        <button type="button">${loop.index}</button>
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
