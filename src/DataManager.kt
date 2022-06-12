package com.learning

class DataManager {
    var books = ArrayList<Book>()

    private fun gimmeId() = books.size.toString()

    fun initialize() {
        for (i in 1..10) {
            books.add(Book(gimmeId(), "Book name ${gimmeId()}", "Author ${gimmeId()}", 100.0f))
        }
    }

    fun addNewBook(book: Book) {
        books.add(book)
    }

    fun updateBook(book: Book): Book? {
        val foundBook = books.find {
            it.id == book.id
        }
        foundBook?.title = book.title
        foundBook?.author = book.author
        foundBook?.price = book.price
        return foundBook
    }

    fun deleteBook(book: Book): Book? {
        val foundBook = books.find {
            it.id == book.id
        }
        books.remove(foundBook)
        return foundBook
    }
}
