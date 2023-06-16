<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 6/16/2023
  Time: 2:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>Calculator</title>
</head>
<body>
<div>

    <form action="/b" method="get">
        <h1>Calculator</h1>
        <input name="number1" type="number" placeholder="Input number1">
        <input name="number2" type="number" placeholder="Input number2">

        <button name="operation" value="+">Addition(+)</button>
        <button name="operation" value="-">Subtraction(-)</button>
        <button name="operation" value="*">Multiplication(x)</button>
        <button name="operation" value="/">Division(/)</button>
    </form>
</div>

<p>Kêt quả: ${result}</p>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
      integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</body>
</html>
