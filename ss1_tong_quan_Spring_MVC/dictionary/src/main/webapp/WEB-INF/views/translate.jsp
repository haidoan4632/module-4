<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 6/15/2023
  Time: 8:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form class="form-input " method="post" action="/translate">
    <div class="form-group">
        <label for="1">English</label>
        <input type="text" name="english" id="1" class="form-control" value="${english}" aria-describedby="helpId">
    </div>
    <button type="submit" class="btn btn-primary">submit</button>
</form>
<h3>result: ${result} </h3>
</body>
</html>
