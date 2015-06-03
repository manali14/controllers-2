<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
<head>
    <title>Controllers-II Demo</title>
    <meta name="layout" content="main">
</head>

<body>

<div>
    Params Constructor :
    <a href="${createLink(controller: 'demo', action: 'saveUsingParamsConstructor', params: [title: "Book1"])}">
        ${createLink(controller: 'demo', action: 'saveUsingParamsConstructor', absolute: true, params: [title: "Book1"])}
    </a>
</div>

<div>
    Using Properties :
    <a href="${createLink(controller: 'demo', action: 'saveUsingProperties', params: [title: "Book1"])}">
        ${createLink(controller: 'demo', action: 'saveUsingProperties', params: [title: "Book1"])}
    </a>
</div>

<div>
    Using Bind Data :
    <a href="${createLink(controller: 'demo', action: 'saveUsingBindData', params: [title: "Book1", description: "Book1 description"])}">
        ${createLink(controller: 'demo', action: 'saveUsingBindData', params: [title: "Book1", description: "Book1 description"])}
    </a>
</div>
</body>
</html>