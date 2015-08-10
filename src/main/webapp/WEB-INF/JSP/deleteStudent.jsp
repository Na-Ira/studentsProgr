<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Student</title>
  <table border="1" width="300" height=40px bgcolor="#FFFFFF" align="center">
      <tr>
        <th>Удалить студента</th>
      </tr>
    <c:forEach items="${id}" var="students">
      <td><c:out value="${students.id}"/></td>
    </c:forEach>
  </table>
</head>
<body>

</body>
</html>
