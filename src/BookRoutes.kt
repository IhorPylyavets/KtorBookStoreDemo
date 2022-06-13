package com.learning

import io.ktor.application.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*

fun Route.books() {
    val dataManager = DataManager()
    route("/book") {
        get("/") {
            call.respond(dataManager.allBooks())
        }

        put("/{id}") {
            val id = call.parameters.get("id")
            val book = call.receive(Book::class)
            val updatedBook = dataManager.updateBook(book)
            call.respond(updatedBook)
        }

        post("/") {
            val book = call.receive(Book::class)
            val newBook = dataManager.addNewBook(book)
            call.respond(newBook)
        }

        delete("/{id}") {
            val id = call.parameters.get("id").toString()
            val deletedBook = dataManager.deleteBookById(id)
            call.respond(deletedBook)
        }
    }
}
