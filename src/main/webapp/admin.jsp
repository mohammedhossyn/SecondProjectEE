<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Second Project EE</title>
    <meta charset="UTF-8">
    <jsp:include page="needs.jsp"></jsp:include>
</head>
<body>

<jsp:include page="nav.jsp"></jsp:include>

<div class="mid">
    <div class="dataForm">
        <form action="/admin" method="post">
            First Name: <input type="text" name="firstname" placeholder="Enter Name"> <br> <br>
            Last Name: <input type="text" name="lastname" placeholder="Enter Family"> <br> <br>
            <input type="submit">
        </form>
    </div>
    <div class="dataTable">
        <table>
            <thead>
            <tr>
                <th>ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Status</th>
                <th>Operation</th>
            </tr>
            </thead>
                <tbody>
                <c:forEach var="admin" items="${sessionScope.adminList}">
                <tr>
                    <td>${admin.id}</td>
                    <td>${admin.firstName}</td>
                    <td>${admin.lastName}</td>
                    <td>${admin.status}</td>
                    <td>
                        <button>Edit</button>
                        <button>Remove</button>
                    </td>
                </tr>
                </c:forEach>
                </tbody>
        </table>
    </div>
</div>

<jsp:include page="foot.jsp"></jsp:include>
</body>
</html>