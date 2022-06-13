package com.learning

class DataManager {

    private var books = ArrayList<Book>()

    private fun gimmeId() = books.size.toString()

    init {
        for (i in 1..10) {
            val currentId = gimmeId()
            books.add(Book(currentId, "Book name $currentId", "Author $currentId", 100.0f))
        }
    }

    fun addNewBook(book: Book): Book {
        books.add(book)
        return book
    }

    private fun findBookById(bookId: String): Book? {
        val foundBook = books.find {
            it.id == bookId
        }
        return foundBook
    }

    fun updateBook(book: Book): Book {
        val foundBook = findBookById(book.id)
        foundBook?.title = book.title
        foundBook?.author = book.author
        foundBook?.price = book.price
        return foundBook!!
    }

    fun deleteBook(book: Book): Book {
        val foundBook = findBookById(book.id)
        books.remove(foundBook)
        return foundBook!!
    }

    fun deleteBookById(bookId: String): Book {
        val foundBook = findBookById(bookId)
        books.remove(foundBook)
        return foundBook!!
    }

    fun allBooks() = books
}
