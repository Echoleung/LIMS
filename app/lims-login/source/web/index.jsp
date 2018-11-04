<%--
  Created by IntelliJ IDEA.
  User: cay
  Date: 18-11-3
  Time: 下午1:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
    errorPage="WEB-INF/jsp/errorpage/ErrorPage.jsp" %>
<html>
  <head>
    <meta name="viewport" content="width=device-width,initial-scale=1.0,user-scale=no">
    <title>Login page</title>
    <link rel="stylesheet" href="resources/css/index.css">
  </head>
  <body>

    <section>
      <div >
        <img src="resources/img/banner_mac.png" alt="">
      </div>
      <div id="login">
        <form action="/Signin" method="post">
          <table>
            <tr>
              <td>Account:</td>
              <td><input type="text" name="account"></td>
            </tr>
            <tr>
              <td>Password:</td>
              <td><input type="password" name="password"></td>
            </tr>
            <tr>
              <td colspan="2"><button type="submit" id="submit">Sign In</button></td>
            </tr>
          </table>
        </form>
      </div>
    </section>
  </body>
</html>
