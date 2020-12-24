<%--
  Created by IntelliJ IDEA.
  User: Mahmoudi
  Date: 12/8/2020
  Time: 5:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Welcome</title>
</head>
<body>
<h1 style="background-color:powderblue;"><p style="text-align:center">Kazemi Agency!</p></h1>

<p><h2>Welcome To Kazemi Agency!</h2></p>
<p><h3>Please Select your role.</h3></p>

<form action="role" method="post">
  <br></br>Roles: <select name="rol">
  <option >--Select Role</option>
  <option name="rol" value="admin">Admin</option>
  <option name="rol" value="customer">Customer</option>
</select><br>
  <br><input type="submit" value="Apply">
</form>
</body>
</html>
