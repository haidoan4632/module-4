<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 6/15/2023
  Time: 8:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form class="form-inline" method="post" action="/calculate">

  <div class="form-group">
    <label for="1">USD</label>
    <input type="number" name="money" id="1" class="form-control" value="${money}" aria-describedby="helpId">
  </div>
  <button type="submit" class="btn btn-primary">Convert</button>
</form>
<h3>Result: ${result} vnd </h3>
</body>
</html>
