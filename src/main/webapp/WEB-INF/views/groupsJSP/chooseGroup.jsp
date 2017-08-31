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
    <title>Выбор группы</title>
</head>
<body>
        <form:form>
            <p>
                <label for="faculty">Выберите факультет:</label>
                <form:select path="faculty" items="${faculty-list} "/>
            </p>
            <p>
                <label for="groups">Выберите группу:</label>
            </p>
        </form:form>
</body>
</html>
