<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add / Edit Inventory</title>
</head>
<body>
    <h1>Add / Edit Inventory</h1>
    <form action="${action}" method="post">
        <input type="hidden" name="id" value="${inventory.id}" />
        <label>Item ID:</label>
        <input type="text" name="itemId" value="${inventory.itemId}" /><br/>
        <label>Quantity:</label>
        <input type="text" name="qty" value="${inventory.qty}" /><br/>
        <label>Type:</label>
        <input type="text" name="type" value="${inventory.type}" /><br/>
        <input type="submit" value="Save" />
    </form>
    <br/>
    <a href="inventoryList">Back to Inventory List</a>
</body>
</html>
