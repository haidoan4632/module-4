<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 6/16/2023
  Time: 10:52 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Hiển thị gia vị với Sandwich</title>
</head>
<body>
<form action="/b" method="get">
    <input type="checkbox" name="name" value="lettuce">rau xà lách
    <br>
    <input type="checkbox" name="name" value="tomato">cà chua
    <br>
    <input type="checkbox" name="name" value="mustard">mù tạc
    <br>
    <input type="checkbox" name="name" value="sprouts">giá đỗ
    <br>
    <button type="submit"> Chọn gia vị kèm theo</button>
</form>



<form>
        <p>  Danh sách gia vị đi kèm: ${ten}</p>
</form>



</body>
</html>
