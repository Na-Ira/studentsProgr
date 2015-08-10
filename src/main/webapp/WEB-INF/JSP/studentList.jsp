<%@ page import="java.util.*" %>
<%@ page import="entity.Student" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8">
    <title>Students List</title>
</head>
<%--<div class="student_List">--%>
<body bgcolor="#dcdcdc">
<p><a href="Главная.html">на Главную</a></p>
<%--<jsp:include page="${currentPage}"/>--%>
<table bordercolor="#000000" border="1" width="700" hight="10" align="center" bgcolor="#FFFFFF">
    <tr>
        <th><h4><span style="font-size: large; color: #000000; font-family: comic sans, cursive">Система управления студентами и их успеваемостью</span>
        </h4></th>
    </tr>
</table>
<br>
<style type="text/css">
    .buttonGreate {
        width: 300px;
        line-hight: 70px;
        position: absolute;
        left: 180px;
        overflow: auto;
        margin-left: -150px
    }
</style>

<form action="/admin/student">
    <p><input type="button" value="Создать студента" class="buttonGreate"></p>
</form>
<br>
<style type="text/css">
    .buttonDelete {
        width: 300px;
        line-hight: 70px;
        position: absolute;
        right: 180px;
        overflow: auto;
    }
</style>

<form action="/admin/student">
    <p><input type="button" value="Удалить студента" class="buttonDelete"></p>
</form>
<br>

<br>
<input type="submit" value="Модификация выбранного студента"/> <input type="submit"
                                                                      value="Успеваемость выбранных студентов"/>
<%--<form action= "/admin/student" method="GET">--%>
<table border="1" width="70%" cols="5" align="center" border-collapse="collapse" bgcolor="#FFFFFF">
    <tr>
        <th width="50">&nbsp</th>
        <th width="200">Фамилия</th>
        <th width="150">Имя</th>
        <th width="100">Группа</th>
        <th width="150">Дата поступления</th>

    </tr>
    <c:forEach items="${listStudents}" var="students">
        <tr>
            <th width="50"><input type="checkbox"/></th>
            <td><c:out value="${students.sername}"/></td>
            <td><c:out value="${students.name}"/></td>
            <td><c:out value="${students.grope}"/></td>
            <td><c:out value="${students.date}"/></td>
                <%--<a href="delete?id=${students.id}">Удалить студента</a>--%>
        </tr>
    </c:forEach>
</table>
</body>
</html>
