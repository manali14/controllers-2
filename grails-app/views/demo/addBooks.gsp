<%@ page import="bootcamp.demo.Book" contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Controllers-II Demo</title>
    <meta name="layout" content="main">
</head>

<body>

<h3>Adding books for ${author?.name}</h3>
<g:form action="saveBooks">
    <g:hiddenField name="id" value="${author?.id}"/>
    <g:select name="books" from="${Book.list()}" value="${author?.books*.id}"
              optionKey="id" optionValue="title" multiple="yes"/>
    <g:submitButton name="save" value="Save"/>
</g:form>
</body>
</html>