<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/2/17
  Time: 21:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script>
        //定义json格式数据
        //var  userJson = {键：值};  一个值
        // var  userJson = {键：值,键2：值2};  一个值
        var userJson={"name":"张三","sex":"男","age":23};
        //两种方法获取值
        // var name=userJson.name;
        // var sex=userJson["sex"];
        // alert(name);
        // alert(sex);
        //嵌套格式   [{},{},{}]
        //var userJSons=[{"name":"张三","age":23,'sex':"男"},{"name":"李四","age":18,'sex':"男"}
        var userjsons=[
            {"name":"张三","sex":"男","age":23},
            {"name":"李四","sex":"男","age":23},
            {"name":"王五","sex":"男","age":23}
        ];
        var name=userjsons[0].name;
        // alert(name);
        //循环遍历
        for( var keys in userjsons){
            alert(userjsons[keys].name);
        }
        //json 转为字符串
        var  userJson2={"name":"张三","age":23,'sex':"男"};
        var userStr = JSON.stringify(userJson2);
        alert(typeof userStr);


        //很多情况下，从后台传递过来的时候就是字符串 必需转为json
        var jsonUser = JSON.parse(userStr);//这是把字符串的json数据转为json格式
        alert(typeof jsonUser);
    </script>
</head>
<body>

</body>
</html>
