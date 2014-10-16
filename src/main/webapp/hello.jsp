<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cataloguero</title>
</head>
<body>

<h1>${requestScope.message}</h1>
    <form action = "servelet" method = "get">
        Password: <input type = "Text" name = "Password"> <br>
        Name: <input type = "Name" name = "UserName"> <br>
        LastName: <input type = "lastName" name = "LastName"> <br>
        Phone: <input type = "Phone" name = "Phone"> <br>
        Email: <input type = "Email" name = "Email"> <br>
        Address: <input type = "Address" name = "Address"> <br>
        <input type = "Save" value = "Save">
     </form>

</body>
</html>