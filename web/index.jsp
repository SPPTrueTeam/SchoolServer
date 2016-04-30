<%--
  Created by IntelliJ IDEA.
  User: Евгений
  Date: 30.04.2016
  Time: 13:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  <head>
    <title>Hello world</title>
  </head>
  <body>
  <h1>Hello World From Struts2</h1>
  <form action="hello">
    <label>Please enter your name</label><br/>
    <input type="text" name="name"/>
    <input type="submit" value="Say Hello"/>
  </form>
  </body>
</html>
