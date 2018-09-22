<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css" href="resources/CSS/jquery-ui.css">
<link rel="stylesheet" type="text/css" href="resources/CSS/jquery-ui.structure.css">
<link rel="stylesheet" type="text/css" href="resources/CSS/jquery-ui.theme.css">

<script type="text/javascript" src="resources/Script/jquery-3.3.1.js"></script>
<script type="text/javascript" src="resources/Script/jquery-ui.js"></script>

<title>Insert title here</title>

<style>
.header {
    width: 100px;
    align: center;
}

.login {
    width: 100px;
    align: center;
}

.footer {
    width: 100px;
    align: center;
}
</style>

</head>
<body style="font-family: 微软雅黑; padding: 0px; margin: 0px;">
<form action="login">
    <div class="ui-widget-header">
        <div class="title" align="center">
            <div class="ui-icon"></div><h1>Welcome</h1>
        </div>
    </div>
    <div class="ui-widget-content">
        <div align="center">
            <table>
                <tr>
                    <td style="width: 60px;" align="right"><span>用户名 : </span></td>
                    <td><input id="uid" class="textarea" type="text" value="" placeholder="请输入用户名"></td>
                </tr>
                <tr>
                    <td style="width: 60px;" align="right"><span>密码 : </span></td>
                    <td><input id="pswd" class="textarea" type="password" value="" placeholder="请输入密码"></td>
                </tr>
                <tr id="message_area_password">
                    <td>
                    </td>
                    <td class="ui-widget">
                        <div class="ui-state-error ui-corner-all" style="padding: 0 .7em;">
                            <span id="msg_pass_err">密码错误</span>
                        </div>
                    </td>
                </tr>
            </table>
        </div>
        <div align="center">
            <input class="ui-button ui-corner-all ui-widget" type="button" value="login" style="width: 200px;">
        </div>
    </div>
    <div class="footer">
    </div>
</form>
</body>
</html>