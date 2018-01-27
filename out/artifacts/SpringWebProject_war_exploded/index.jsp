<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>hello</title>
</head>
<body>


<form action="/uploadFile" method="post" enctype="multipart/form-data">

    <%--<input type="text" name="name">--%>
    <input type="file" name="file"/>

    <input type="submit" value="upload"/>

</form>


</body>
</html>
