<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add / Edit Item</title>
</head>
<body>
    <h1>Add / Edit Item</h1>
    <form action="${action}" method="post">
        <input type="hidden" name="id" value="${item.id}" />
        <label>Name:</label>
        <input type="text" name="name" value="${item.name}" /><br/>
        <label>Price:</label>
        <input type="text" name="price" value="${item.price}" /><br/>
        <input type="submit" value="Save" />
    </form>
    <br/>
    <a href="itemList">Back to Item List</a>
</body>
</html>
