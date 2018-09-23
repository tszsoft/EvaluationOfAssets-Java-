<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录成功</title>
</head>
<body>
    <form id="openPage" method="get" action="">
    
        <!-- message area -->
        <div align="center">
            <h1>${message}</h1>
        </div>
        
        <div align="center">
            <table align="center" width="150px" height="300px">
                <tr height="5%">
                    <td align="center">
                        <input type="button" value="UserList" style="width:120px;height:30px;" onclick="toUserList()" />
                    </td>
                </tr>
            </table>
        </div>
        
        <script type="text/javascript">
            function toUserList() {
                document.getElementById("openPage").action = "UserList";
                document.getElementById("openPage").submit();
            }
        </script>
    </form>
</body>
</html>