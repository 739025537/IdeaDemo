<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <meta charset="utf-8">
    <title>用户注册</title>
    <script src="${pageContext.request.contextPath}/js/jquery-1.12.4.js"></script>
    <script>
        // $(function () {
        //        alert("测试通过")
        // })
        
        function checkUserName() {
            var userName = document.getElementById("userName").value;
            $.ajax({
                type: "POST",
                url: "${pageContext.request.contextPath}/findUserByName",// 调用后台的控制层代码
                //data: { key:值   ,  key2:值2},//需要传的参数
                data: {
                    //userName:userName ,
                    "userName":userName
                },
                success: function(sbq){//这个是调用完后台代码，返回了这个sbq变量中的值然后执行的函数，
                     alert( "Data Saved: " + sbq );//"Data Saved:获取得就是输出得1或者0
                    document.getElementById("sbqFlag").value=sbq;//赋值给隐藏得表单

                    if(sbq==1){
                        document.getElementById("userNameErr").innerHTML="用户已经存在了";
                    }else {
                        document.getElementById("userNameErr").innerHTML="可以注册";
                    }
                }
            });
        }
        //当我点注册的时候，先进来这个方法，我们之前在讲js表单验证的时候有重点讲解
        function  checkAll() {
            var sbqFlag = document.getElementById("sbqFlag").value;
            if(sbqFlag==1){
                alert("不能提交代码")
                return false;
            }else {
                alert("可以提交代码")
                return false;
            }
        }
    </script>
</head>
<body>
<h1> 用户注册</h1>
<!-- <%-- 很多同学忘记写  name="sbqUname"/ 这一个url一定是能访问了再复制过来，这个url都不能访问复制过来没用--%>-->
<form action="${pageContext.request.contextPath}/addUser.do" method="post" onsubmit="return checkAll();">
            <input type="hidden" id="sbqFlag" value="1"><br>
    用户ID：<input type="text"  name="userId" /> <br />
    用户名：<input type="text" id="userName" name="userName" onchange="checkUserName()"/>
    <span id="userNameErr" style="color: red"></span><br />

    密码：  <input type="password" name="pwd"  /> <br />

    <input type="submit" value="提交" />
</form>
</body>
</html>
