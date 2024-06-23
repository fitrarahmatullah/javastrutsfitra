<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add / Edit Order</title>
</head>
<body>
    <h1>Add / Edit Order</h1>
    <form action="${action}" method="post">
        <input type="hidden" name="id" value="${order.id}" />
        <label>Order No:</label>
        <input type="text" name="orderNo" value="${order.orderNo}" /><br/>
        <label>Item ID:</label>
        <input type="text" name="itemId" value="${order.itemId}" /><br/>
        <label>Quantity:</label>
        <input type="text" name="qty" value="${order.qty}" /><br/>
        <input type="submit" value="Save" />
    </form>
    <br/>
    <a href="orderList">Back to Order List</a>
</body>
</html>
