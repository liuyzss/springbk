<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title></title>
  <script>
    alert("hello") ;

    var url = 'ws://'+window.location.host+'/marco';
    var sock = new WebSocket(url);
    sock.onopen = function () {
      console.log("Opening");
      sayMarco();
    }
    sock.onclose = function() {
      console.log("closing");
    }
    sock.onmessage = function (e){
      console.log("received msg", e.data);
      setTimeout(function(){sayMarco()},2000);
    }
    function sayMarco(){
      console.log("sending marco")
      sock.send("macro")
    }
  </script>
</head>
<body>
<h1>findUser</h1>
<table>
  <c:forEach items="${users}" var="u">
    <tr>
      <td>${u.id}</td>
      <td>${u.username}</td>
      <td>${u.birthday}</td>
    </tr>
  </c:forEach>

</table>
</body>
</html>