package bootcamp.demo

class DemoController {

    def index() {

    }

    def saveUsingParamsConstructor() {
        Book book = new Book(params)
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

    def saveUsingProperties() {
        Book book = params.id ? Book.get(params.id) : new Book()
        book.properties = params
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
}
