<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<style>
    body {
        background: url(${contextPath}/resources/img/bg.png);
        background-size: 100% 100%;
        background-color: #DDDDDD;
    }
</style>

<title>Welcome to EOA system</title>

</head>
<body>
    <form method="get" action="toLoginForm">
        <div align="center">
            <h1>
                <font color="#FFFFFF">Welcome to EOA system</font>
            </h1>
            <div>
                <input type="submit" value="登录" />
            </div>
        </div>
    </form>
</body>
</html>