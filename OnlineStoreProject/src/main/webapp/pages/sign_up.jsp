<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css"
          integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">
    <link href="css/sign_in.css" rel="stylesheet">
    <link href="css/layout.css" rel="stylesheet">
    <title>Sign Up</title>
    <link rel="shortcut icon" type="image/x-icon" href="static/img/favicon.ico">
</head>
<body onload="loadInfo()">
<jsp:include page="layout.jsp"/>
<c:url value="/newuser" var="regUrl"/>
<div style="min-height: 80vh;">
    <form name="form" class="sign-in" action="${regUrl}" method="POST" onsubmit="return validate()">
        <h1 class="sign-in-title">Sign up</h1>
        <c:if test="${exists ne null}">
            <h6 class="sign-in-title" style="color: #d76b60">User already exists!</h6>
        </c:if>
        <input type="email" class="sign-in-input" id="email" name="email" value="${email}"
               placeholder="What's your email?" autofocus
               onkeydown="input(this)">
        <input type="password" class="sign-in-input" id="password" name="password" placeholder="Enter a password"
               onkeydown="input(this)">
        <input type="text" class="sign-in-input" id="name" name="name" placeholder="Your name" onkeydown="input(this)">
        <input type="text" class="sign-in-input" id="phone" name="phone" placeholder="Your phone"
               onkeydown="input(this)">
        <button type="submit" class="sign-in-button">Sign me up!</button>
        <a style="text-decoration: none;" href="/sign_in">
            <h6 class="sign-in-a">Sign in</h6>
        </a>
    </form>
</div>
<jsp:include page="footer.jsp"/>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="/js/sign_up.js"></script>
<script src="/js/layout.js"></script>
</body>
</html>