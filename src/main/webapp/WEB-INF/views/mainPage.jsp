<%@ page import="dao.interfaces.GroupDao" %>
<%@ page import="dao.implementations.GroupDaoImpl" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Выбор группы</title>
</head>
<body>
       <form method="post">
           <p>
               <label>Факультет:</label>
               <select>
                   <c:forEach items="${facultyList}" var="faculty">
                       <jsp:useBean id="faculty" class="domain.POJOs.Faculty"/>
                       <option value="${faculty}">${faculty.name}</option>
                   </c:forEach>
               </select>
           </p>
           <p>
               <label>Группа:</label>
           </p>
           <button type="submit" value="">Загрузить</button>
       </form>
       <a href="/login"><button>Войти</button></a>
</body>
</html>
