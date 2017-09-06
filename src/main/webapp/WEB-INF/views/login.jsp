<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Денис
  Date: 8/28/2017
  Time: 2:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Вход</title>
</head>
<body>
    <c:if test="${param.error != null}">
        <label>Неправильный логин или пароль.</label>
    </c:if>
        <form method="post">
            <p>
                <label>Логин:</label>
                <br/>
                <input type="password" name="login"     placeholder="Введите логин"/>
            </p>
            <p>
                <label>Пароль:</label>
                <br/>
                <input type="password" name="password"  placeholder="Введите пароль"/>
            </p>
            <button type="submit">Войти</button>
        </form>
    <hr>
    <a href="/"><button>На главную</button></a>
</body>
</html>
