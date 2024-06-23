<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Order List</title>
</head>
<body>
    <h1>Order List</h1>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Order No</th>
                <th>Item ID</th>
                <th>Quantity</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${orderList}" var="order">
                <tr>
                    <td>${order.id}</td>
                    <td>${order.orderNo}</td>
                    <td>${order.itemId}</td>
                    <td>${order.qty}</td>
                    <td>
                        <a href="editOrder?id=${order.id}">Edit</a>
                        |
                        <a href="deleteOrder?id=${order.id}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <br/>
    <a href="addOrder">Add New Order</a>
</body>
</html>
