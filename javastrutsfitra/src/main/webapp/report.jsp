<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Report</title>
    <!-- Include any necessary CSS or JS files -->
</head>
<body>
    <h1>Report</h1>
    
    <table border="1">
        <thead>
            <tr>
                <th>Item Name</th>
                <th>Total Orders</th>
                <th>Total Inventory</th>
                <th>Total Revenue</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="row" items="${report}">
                <tr>
                    <td>${row[0]}</td>
                    <td>${row[1]}</td>
                    <td>${row[2]}</td>
                    <td>${row[3]}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</body>
</html>
