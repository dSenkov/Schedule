<%@ page import="service.implementations.ViewService" %>
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
                                    ${lessonsOfTheFirstWeek.get(day).get(lessonNumber).subject} <button>X</button> <br>
                                    ${viewService.lessonTypeToRussian(lessonsOfTheFirstWeek.get(day).get(lessonNumber).type)}
                                    ${lessonsOfTheFirstWeek.get(day).get(lessonNumber).building}-${lessonsOfTheFirstWeek.get(day).get(lessonNumber).classroom} <br>
                                    ${lessonsOfTheFirstWeek.get(day).get(lessonNumber).teacher}
                            </td>
                        </c:when>
                        <c:otherwise>
                            <td align="center">
                                <button>+</button>
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
                                    ${lessonsOfTheSecondWeek.get(day).get(lessonNumber).subject} <button>X</button> <br>
                                    ${viewService.lessonTypeToRussian(lessonsOfTheSecondWeek.get(day).get(lessonNumber).type)}
                                    ${lessonsOfTheSecondWeek.get(day).get(lessonNumber).building}-${lessonsOfTheSecondWeek.get(day).get(lessonNumber).classroom} <br>
                                    ${lessonsOfTheSecondWeek.get(day).get(lessonNumber).teacher}
                            </td>
                        </c:when>
                        <c:otherwise>
                            <td align="center">
                                <button>+</button>
                            </td>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
