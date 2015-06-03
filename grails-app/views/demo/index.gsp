<%@ page import="bootcamp.demo.Author" contentType="text/html;charset=UTF-8" %>
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

<div>
    Params Majic :
    <a href="${createLink(controller: 'demo', action: 'paramsMajic', params: [age: 14, dob: "14/12/1990", names: ['test1', 'test2']])}">
        ${createLink(controller: 'demo', action: 'paramsMajic', params: [age: 14, dob: "14/12/1990", names: ['test1', 'test2']])}
    </a>
</div>

<div>
    Action as Argument :
    <a href="${createLink(controller: 'demo', action: 'actionAsArgument', params: [name: "Groovy & Grails", age: 20])}">
        ${createLink(controller: 'demo', action: 'actionAsArgument', params: [name: "Groovy & Grails", age: 20])}
    </a>
</div>

<div>
    Bind another Object :
    <a href="${createLink(controller: 'demo', action: 'addAuthor', params: [title: "Groovy & Grails", 'author.id': Author.first()?.id])}">
        ${createLink(controller: 'demo', action: 'actionAsArgument', params: [title: "Groovy & Grails", 'author.id': Author.first()?.id])}
    </a>
</div>

<div>
    Multiple Domains :
    <a href="${createLink(controller: 'demo', action: 'multipleDomain', params: ['book.title': 'Groovy & Grails', 'author.name': 'Greame Rocher'])}">
    ${createLink(controller: 'demo', action: 'multipleDomain', params: ['book.title': 'Groovy & Grails', 'author.name': 'Greame Rocher'])}
    </a>
</div>
</body>
</html>