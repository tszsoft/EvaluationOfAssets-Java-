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

<script type="text/javascript">
$(document).ready(function(){
    
    $("#btnLogin").click(function(){
        
        var strUserID = $("#uid").val();
        var strPassWD = $("#pswd").val();
        
        if (strUserID === null || strUserID === '') {
            $("#message_area_userid").css('display','');
            $("#msg_uid_err").text('用户名不能为空');
        }
        else if (strPassWD === null || strPassWD === '') {
            $("#message_area_userid").css('display','none');
            $("#message_area_password").css('display','');
            $("#msg_pass_err").text('密码不能为空');
        }
        else {
            $("#message_area_password").css('display','none');
            login();
        }
    });
    
/*     var message = ${message};
    var retCode = ${retCode};
    if (message === null || message === '') {
        
    }
    else if (retCode == 1) {
        $("#messageArea").css('display','');
    }
    else if (retCode == 2) {
        
    }
    else if (retCode == 3) {
        
    }
    else if (retCode == 4) {
        
    } */
    
    function login() {
         $.ajax({
            type: "POST",
//            contentType: "application/json; charset=utf-8",
//            contentType: false,
            dataType: "json",
            url: "${pageContext.request.contextPath}/view?path=login",
            data: $("#loginForm").serialize(),
            success: function (result) {
                console.log(result);
                if (result.retCode == "0") {
                    console.log("正常终了");
                    //$.get("${pageContext.request.contextPath}/view?path=loginSuccess");
                    window.location.href = "${pageContext.request.contextPath}/view?path=loginSuccess";
                }
                else if (result.retCode == "3") {
                    $("#message_area_userid").css('display','');
                    $("#message_area_password").css('display','none');
                    $("#msg_uid_err").text(result.message);
                }
                else if (result.retCode == "4") {
                    $("#message_area_userid").css('display','none');
                    $("#message_area_password").css('display','');
                    $("#msg_pass_err").text(result.message);
                };
            },
            error: function () {
                console.log("异常终了");
            }
        });
/*         var userid = $("#uid").val();
        var password = $("#pswd").val();
        $.post("${pageContext.request.contextPath}/login",
                {"userid":userid,"password":password},
                function (result) {
                    if (result.retCode == "0") {
                        console.log("正常终了");
                    } else {
                    	console.log("异常终了");
                    }
                },
                "json"); */
    }
    
});
</script>

<title>EOA</title>

</head>
<body style="font-family: 微软雅黑; padding: 0px; margin: 0px;">
<form id="loginForm" action="login" method="post">
<!-- <form id="loginForm"> -->
    <div align="center">
        <div style="width: 500px;margin-top: 30px;">
            <div class="ui-widget-header">
                <div class="title" align="center">
                    <h1>Welcome</h1>
                </div>
            </div>
            <div class="ui-widget-content">
                <div align="center">
                    <br/>
                    <table>
                        <tr>
                            <td style="width: 60px;" align="right"><span>用户名 : </span></td>
                            <td><input id="uid" name="userid" class="textarea" type="text" value="" placeholder="请输入用户名"></td>
                        </tr>
                        <tr id="message_area_userid" style="display: none;">
                            <td>
                            </td>
                            <td class="ui-widget">
                                <div class="ui-state-error ui-corner-all" style="padding: 0 .7em;">
                                    <span class="ui-icon ui-icon-alert" style="float: left; margin-right: .3em; margin-top: .16em;"></span>
                                    <span id="msg_uid_err"></span>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td style="width: 60px;" align="right"><span>密码 : </span></td>
                            <td><input id="pswd" name="password" class="textarea" type="password" value="" placeholder="请输入密码"></td>
                        </tr>
                        <tr id="message_area_password" style="display: none;">
                            <td>
                            </td>
                            <td class="ui-widget">
                                <div class="ui-state-error ui-corner-all" style="padding: 0 .7em;">
                                    <span class="ui-icon ui-icon-alert" style="float: left; margin-right: .3em; margin-top: .16em;"></span>
                                    <span id="msg_pass_err"></span>
                                </div>
                            </td>
                        </tr>
                    </table>
                </div>
                <div align="center">
                    <input id="btnLogin" class="ui-button ui-corner-all ui-widget" type="button" value="login" style="width: 200px;">
                </div>
                <br/>
            </div>
        </div>
    </div>
    <div class="footer">
    </div>
</form>

</body>
</html>