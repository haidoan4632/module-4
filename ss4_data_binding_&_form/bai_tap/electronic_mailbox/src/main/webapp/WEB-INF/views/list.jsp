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
    <title>Title</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

</head>
<body>
<h2 style="text-align: center" class=""> Email</h2>
<h4 style="color: green" class="text-center">${mess}</h4>
<table style="width:40%;height:300px" class="table table-bordered">
  <tr>
    <td>
      <strong>Language : </strong> ${program.languages}
    </td>
  </tr>
  <tr>
    <td>
      <strong>Page Size  : </strong> ${program.pageSize}
    </td>
  </tr>
  <tr>
    <td>
      <strong>Spams filter : </strong> ${program.spamsFilter}
    </td>
  </tr>
  <tr>
    <td>
      <strong>Signature : </strong>${program.signature}
    </td>
  </tr>
  <tr>
    <td>
      <a class="btn btn-secondary" href="update-form" role="button">Update</a>
    </td>
  </tr>
</table>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>
