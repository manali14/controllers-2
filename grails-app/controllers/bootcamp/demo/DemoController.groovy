package bootcamp.demo

import bootcamp.demo.co.UserCO

class DemoController {

    def index() {

    }

    def saveUsingParamsConstructor() {
        Book book = new Book(params)
        if (!book.save(flush: true)) {
            book.errors.allErrors.each {
                println("Error : ${it}")
            }
            flash.error = "Error while saving Book"
            render(view: 'index')
        } else {
            flash.message = "Book created successfully."
            redirect(controller: 'book', action: 'show', id: book?.id)
        }
    }

    def saveUsingProperties() {
        Book book = params.id ? Book.get(params.id) : new Book()
        book.properties = params
        if (!book.save(flush: true)) {
            book.errors.allErrors.each {
                println("Error : ${it}")
            }
            flash.error = "Error while saving Book"
            render(view: 'index')
        } else {
            flash.message = "Book created successfully."
            redirect(controller: 'book', action: 'show', id: book?.id)
        }
    }

    def saveUsingBindData() {
        Book book = new Book()
        bindData(book, params, [exclude: 'description'])
        if (!book.save()) {
            book.errors.allErrors.each {
                println("Error : ${it}")
            }
            flash.error = "Error while saving Book"
            render(view: 'index')
        } else {
            flash.message = "Book created successfully."
            redirect(controller: 'book', action: 'show', id: book?.id)
        }
    }

    def paramsMajic() {
        println ">>>>>>>>>>>>>>>>Int Conversion>>>>>>>>>>>>>>>>>"
        Integer age = params.int('age')
        println ">>>>>>>>>>>>>>>>Date Conversion>>>>>>>>>>>>>>>>>"
        Date dob = params.date('dob', 'MM/dd/yyyy')
        println ">>>>>>>>>>>>>>>>List Conversion>>>>>>>>>>>>>>>>>"
        List names = params.list('names')
        println "Age: ${age}"
        println "Date of Birth : " + dob
        println "Names : ${names}"
        render(view: 'index')
    }

    def actionAsArgument(Integer age, String name) {
        println("Name:${name}")
        println("Age:${age}")
        render(view: 'index')
    }

    def addAuthor() {
        Book book = new Book(params)
        if (!book.validate()) {
            book.errors.allErrors.each {
                println("Error : ${it}")
            }
            flash.error = "Error while saving Book"
            render(view: 'index')
        } else {
            book.save(flush: true)
            flash.message = "Book created successfully."
            redirect(controller: 'book', action: 'show', id: book?.id)
        }
    }

    def addBooks() {
        Author author = Author.get(params.id) ?: Author.first()
        println("++++++++++++++++++${author.properties}")
        [author: author]
    }

//    http://localhost:8080/controllers-2/demo/saveBooks/1?books[0].title=java
//    http://localhost:8080/controllers-2/demo/saveBooks/1?books[0].title=java&books[3].title=grails - will ad one more book
    def saveBooks() {
        Author author = Author.get(params.id) ?: Author.first()
        author.properties = params
        author.books.each {
            author.addToBooks(it)
        }
        author.save(flush: true, failOnError: true)
        redirect(controller: 'author', action: 'show', id: author?.id)
    }

    def multipleDomain() {
        Book book = new Book(params['book'])
        Author author = new Author(params['author'])
        render("Book :: ${book.title} -- Author :: ${author.name}")
    }

//    http://localhost:8080/controllers-2/demo/commandObject?email=abc@gmail.com&name=abc
//    http://localhost:8080/controllers-2/demo/commandObject?email=abc@gmail.com
//    http://localhost:8080/controllers-2/demo/commandObject?email=abc.com&name=abc
    def commandObject(UserCO userCO) {
        if (userCO.validate()) {
            println("********************************************SUCCESS********************************************")
            render("********************************************SUCCESS********************************************")
        } else {
            println("********************************************FAILURE********************************************")
            render("********************************************FAILURE********************************************")
        }
    }
}
