<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Inventory List</title>
</head>
<body>
    <h1>Inventory List</h1>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Item ID</th>
                <th>Quantity</th>
                <th>Type</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${inventoryList}" var="inventory">
                <tr>
                    <td>${inventory.id}</td>
                    <td>${inventory.itemId}</td>
                    <td>${inventory.qty}</td>
                    <td>${inventory.type}</td>
                    <td>
                        <a href="editInventory?id=${inventory.id}">Edit</a>
                        |
                        <a href="deleteInventory?id=${inventory.id}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <br/>
    <a href="addInventory">Add New Inventory</a>
</body>
</html>
