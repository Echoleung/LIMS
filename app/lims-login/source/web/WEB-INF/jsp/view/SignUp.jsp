<%--
  Created by IntelliJ IDEA.
  User: cay
  Date: 18-11-3
  Time: 下午11:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         isELIgnored="false"
         errorPage="../errorpage/ErrorPage.jsp" %>
<html>
<head>
    <meta name="viewport" content="width=device-width,initial-scale=1.0,user-scale=no">
    <title>Sign Up</title>
    <style>
        html,body{
            width: 100%;
            height: 100%;
            margin: 0;
        }
        body{
            display: flex;
            justify-content: center;

        }
        section{
            width: 50%;
            max-width: 1000px;
            min-width: 300px;
            min-height: 560px;
            display: flex;
            justify-content: center;
        }
        tr{
            margin: 6rem 0;
            padding: 2rem 0;
        }
        td{
            display: block;
        }
        table{
            margin-top: 8%;
            padding: 2rem 5rem 7rem 5rem;
            border: 2px none deepskyblue;
            border-radius: 5px;
        }
        input,select{
            border-radius: 5px;
            background-color: white;
        }
        button{
            height: 1.4rem;
            width: 100%;
            border-radius: 5px;
            background-color: #34c9ff;
        }
        input{
            height: 1.5rem;
            width: 15rem;
        }

    </style>
</head>
<body>
    <section>
        <form action="/Signup" method="post">
            <table>
                <tr style="margin-bottom: 6rem">
                    <td>Hi, <b id="accout" account="${user.account}">"${user.account}"</b></td>
                    <td>you must sign up to active your account</td>
                </tr>
                <tr class="flex_col">
                    <td>please input your nickname:</td>
                    <td>
                        <input type="text" name="nickname">
                    </td>
                </tr>
                <tr class="flex_col">
                    <td>please input your realname:</td>
                    <td>
                        <input type="text" name="realname">
                    </td>
                </tr>
                <tr class="flex_col">
                    <td>please input your age</td>
                    <td>
                        <input type="text" name="age">
                    </td>
                </tr>
                <tr class="flex_col">
                    <td>Select your position:
                        <select name="position" size="1">
                            <option value="0">master</option>
                            <option value="1">director</option>
                            <option value="2">teacher</option>
                            <option value="3">student</option>
                        </select>
                    </td>
                    <td></td>
                </tr>
                <tr class="flex_col">
                    <td>please input your password:</td>
                    <td>
                        <input type="password" name="password">
                    </td>
                </tr>
                <tr class="flex_col">
                    <td>check your password:</td>
                    <td>
                        <input type="password" name="passwordcheck">
                    </td>
                </tr>
                <tr>
                    <td><button type="submit" name="account" value="${user.account}">Submit</button></td>
                </tr>
            </table>
        </form>
    </section>
    <script src="/resources/js/SignUp.js"></script>
</body>
</html>
