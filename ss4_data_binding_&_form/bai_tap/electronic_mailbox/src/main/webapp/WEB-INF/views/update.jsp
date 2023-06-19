<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 6/17/2023
  Time: 3:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Program update electric email</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<h2 style="text-align: center">Setting</h2>
<div class="container">

  <form:form action="program" method="post" modelAttribute="program">
    <table class="table">
      <thead>
      <tr>
        <td>
        <form:select path="languages">
          <form:option value="English"></form:option>
          <form:option value="Vietnamese"></form:option>
          <form:option value="Japanese"></form:option>
          <form:option value="Chinese"></form:option>
        </form:select>
        </td>
      </tr>
      <tr>
        <td>
          <form:label path="pageSize">Page Size : </form:label>
          Show <form:select path="pageSize">
          <form:option value="5"></form:option>
          <form:option value="10"></form:option>
          <form:option value="15"></form:option>
          <form:option value="25"></form:option>
          <form:option value="50"></form:option>
          <form:option value="100"></form:option>
        </form:select> emails per page
        </td>
      </tr>
      <tr>
        <td>
          <form:label path="spamsFilter">Spams Filter : </form:label>
          <form:checkbox path="spamsFilter" value="Enable spams filter"/> Enable spams filter
        </td>
      </tr>
      <tr>
        <td>
          <form:label path="signature">Signature : </form:label>
          <form:textarea type="text" path="signature"/>
        </td>
      </tr>
      <tr>
        <td>
          <input type="submit" value="Update" class="btn btn-primary">
          <input type="button" value="Cancel" class="btn btn-primary" onclick="window.location='hello-servlet'">
        </td>
      </tr>
      </thead>
    </table>
  </form:form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>
