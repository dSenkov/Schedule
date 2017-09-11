<%@ page import="java.time.DayOfWeek" %>
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

    <title>Расписание группы ${group.name}</title>
</head>

<body>
    <div id="main" class="container">
        <div class="row align-items-center" style="margin-top: 1%">
            <div class="col-12">
                <h2 class="text-center">Расписание группы ${group.name}</h2>
            </div>
        </div>
        <div class="row align-items-center">
            <div class="col-12">
                <br>
                <table class="table table-bordered">
                    <tr>
                        <th style="vertical-align: middle" class="text-center bg-info"><font color="#f0f8ff"/> I неделя</th>
                        <th class="text-center table-info">1<br>8.30 - 10.05</th>
                        <th class="text-center table-info">2<br>10.25 - 12.00</th>
                        <th class="text-center table-info">3<br>12.20 - 13.55</th>
                        <th class="text-center table-info">4<br>14.15 - 15.50</th>
                        <th class="text-center table-info">5<br>16.10 - 17.45</th>
                    </tr>
                    <c:forEach var="day" begin="0" end="5">
                        <tr>
                            <th style="vertical-align: middle" class="text-center table-info">${viewService.getDayByNumber(day+1)}</th>
                            <c:forEach var="lessonNumber" begin="1" end="5">
                                <c:choose>
                                        <c:when test="${lessonsOfTheFirstWeek.get(day).containsKey(lessonNumber)}">
                                            <td class="text-center">
                                                <c:set var="lesson1W" value="${lessonsOfTheFirstWeek.get(day).get(lessonNumber)}"/>
                                                <jsp:useBean id="lesson1W" type="domain.POJOs.Lesson"/>
                                                    ${lesson1W.subject} <a href = "/admin/facultys/${faculty.id}/groups/${group.id}/lessons/${lesson1W.id}/delete"><button class="btn btn-danger">X</button></a> <br>
                                                    ${viewService.lessonTypeToRussian(lesson1W.type)}
                                                    ${lesson1W.building}-${lesson1W.classroom} <br>
                                                    ${lesson1W.teacher}
                                            </td>
                                        </c:when>
                                        <c:otherwise>
                                            <td class="text-center">
                                                <a href="/admin/facultys/${faculty.id}/groups/${group.id}/lessons/newLesson?firstWeek=${true}&day=<%=DayOfWeek.of((Integer) pageContext.getAttribute("day") + 1 )%>&lessonNumber=${lessonNumber}">
                                                    <button class="btn btn-success">+</button>
                                                </a>
                                            </td>
                                        </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
        <div class="row align-items-center">
            <div class="col-12">
                <table class="table table-bordered">
                    <tr>
                        <th style="vertical-align: middle" class="text-center bg-info"><font color="#f0f8ff"/>II неделя</th>
                        <th class="text-center table-info">1<br>8.30 - 10.05</th>
                        <th class="text-center table-info">2<br>10.25 - 12.00</th>
                        <th class="text-center table-info">3<br>12.20 - 13.55</th>
                        <th class="text-center table-info">4<br>14.15 - 15.50</th>
                        <th class="text-center table-info">5<br>16.10 - 17.45</th>
                    </tr>
                    <c:forEach var="day" begin="0" end="5">
                        <tr>
                            <th style="vertical-align: middle" class="text-center table-info">${viewService.getDayByNumber(day+1)}</th>
                            <c:forEach var="lessonNumber" begin="1" end="5">
                                <c:choose>
                                        <c:when test="${lessonsOfTheSecondWeek.get(day).containsKey(lessonNumber)}">
                                            <td class="text-center">
                                                <c:set var="lesson2W" value="${lessonsOfTheSecondWeek.get(day).get(lessonNumber)}"/>
                                                <jsp:useBean id="lesson2W" type="domain.POJOs.Lesson"/>
                                                    ${lesson2W.subject} <a href = "/admin/facultys/${faculty.id}/groups/${group.id}/lessons/${lesson2W.id}/delete"><button class="btn btn-danger">X</button></a> <br>
                                                    ${viewService.lessonTypeToRussian(lesson2W.type)}
                                                    ${lesson2W.building}-${lesson2W.classroom} <br>
                                                    ${lesson2W.teacher}
                                            </td>
                                        </c:when>
                                        <c:otherwise>
                                            <td class="text-center">
                                                <a href="/admin/facultys/${faculty.id}/groups/${group.id}/lessons/newLesson?firstWeek=${false}&day=${day}&lessonNumber=${lessonNumber}">
                                                    <button class="btn btn-success">+</button>
                                                </a>
                                            </td>
                                        </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </tr>
                    </c:forEach>
                </table>
             </div>
        </div>
        <div class="row align-items-center">
            <div class="col-6" style="text-align: left; margin-bottom: 2%">
                <a href="/"><button class="btn btn-primary">На главную</button></a>
            </div>
        </div>
    </div>
</body>
</html>
