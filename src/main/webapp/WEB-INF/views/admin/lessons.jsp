<%@ page import="java.time.DayOfWeek" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Админка | Расписание</title>
</head>
<body>
    <h2>Расписание группы ${group.name}</h2>
    <br>
    <h4>I неделя</h4>
        <table border="1" cellpadding="5">
            <tr>
                <th></th>
                <th>1<br>8.30 - 10.05</th>
                <th>2<br>10.25 - 12.00</th>
                <th>3<br>12.20 - 13.55</th>
                <th>4<br>14.15 - 15.50</th>
                <th>5<br>16.10 - 17.45</th>
            </tr>
            <c:forEach var="day" begin="0" end="5">
                <tr>
                    <th>${viewService.getDayByNumber(day+1)}</th>
                    <c:forEach var="lessonNumber" begin="1" end="5">
                        <c:choose>
                                <c:when test="${lessonsOfTheFirstWeek.get(day).containsKey(lessonNumber)}">
                                    <td>
                                        <c:set var="lesson1W" value="${lessonsOfTheFirstWeek.get(day).get(lessonNumber)}"/>
                                        <jsp:useBean id="lesson1W" type="domain.POJOs.Lesson"/>
                                            ${lesson1W.subject} <a href = "/admin/facultys/${faculty.id}/groups/${group.id}/lessons/${lesson1W.id}/delete"><button>X</button></a> <br>
                                            ${viewService.lessonTypeToRussian(lesson1W.type)}
                                            ${lesson1W.building}-${lesson1W.classroom} <br>
                                            ${lesson1W.teacher}
                                    </td>
                                </c:when>
                                <c:otherwise>
                                    <td align="center">
                                        <a href="/admin/facultys/${faculty.id}/groups/${group.id}/lessons/newLesson?firstWeek=${true}&day=<%=DayOfWeek.of((Integer) pageContext.getAttribute("day") + 1 )%>&lessonNumber=${lessonNumber}">
                                            <button>+</button>
                                        </a>
                                    </td>
                                </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </tr>
            </c:forEach>
        </table>
    <br><br>
    <h4>II неделя</h4>
    <table border="1" cellpadding="5">
        <tr>
            <th></th>
            <th>1<br>8.30 - 10.05</th>
            <th>2<br>10.25 - 12.00</th>
            <th>3<br>12.20 - 13.55</th>
            <th>4<br>14.15 - 15.50</th>
            <th>5<br>16.10 - 17.45</th>
        </tr>
        <c:forEach var="day" begin="0" end="5">
            <tr>
                <th>${viewService.getDayByNumber(day+1)}</th>
                <c:forEach var="lessonNumber" begin="1" end="5">
                    <c:choose>
                            <c:when test="${lessonsOfTheSecondWeek.get(day).containsKey(lessonNumber)}">
                                <td>
                                    <c:set var="lesson2W" value="${lessonsOfTheSecondWeek.get(day).get(lessonNumber)}"/>
                                    <jsp:useBean id="lesson2W" type="domain.POJOs.Lesson"/>
                                        ${lesson2W.subject} <a href = "/admin/facultys/${faculty.id}/groups/${group.id}/lessons/${lesson2W.id}/delete"><button>X</button></a> <br>
                                        ${viewService.lessonTypeToRussian(lesson2W.type)}
                                        ${lesson2W.building}-${lesson2W.classroom} <br>
                                        ${lesson2W.teacher}
                                </td>
                            </c:when>
                            <c:otherwise>
                                <td align="center">
                                    <a href="/admin/facultys/${faculty.id}/groups/${group.id}/lessons/newLesson?firstWeek=${false}&day=${day}&lessonNumber=${lessonNumber}">
                                        <button>+</button>
                                    </a>
                                </td>
                            </c:otherwise>
                    </c:choose>
                </c:forEach>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
