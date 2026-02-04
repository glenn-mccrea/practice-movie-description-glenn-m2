//package com.example.springBoot2.controllers;
//
//import com.example.springBoot2.models.Book;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/books")
//public class BookController {
//    private final List<Book> books = List.of(
//        new Book("The Catcher in the Rye", "J.D. Salinger", 1951, 234),
//        new Book("To Kill a Mockingbird", "Harper Lee", 1960, 281),
//        new Book("1984", "George Orwell", 1949, 328)
//    );
//
//    @GetMapping
//    public List<Book> getBooks() {
//        return books;
//    }
//}

package com.example.springBoot2.controllers;

import com.example.springBoot2.models.Book;
import com.example.springBoot2.repositories.BookRepository;
import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
//1
    @GetMapping("")
    public List<Book> getAllItems() {
        return bookRepository.findAll();
    }
//2
    @GetMapping("/{id}")
    public Book getItem(@PathVariable int id) {
        return bookRepository.findById(id).orElse(null);
    }
//3
    @PostMapping("")
    public Book addItem(@RequestBody Book book) {
        return bookRepository.save(book);
    }
//4
    @PutMapping("/{id}")
    public Book updateItem(@PathVariable int id, @RequestBody Book book) {
        book.setId(id);
        return bookRepository.save(book);
    }
//5
    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable int id) {
        bookRepository.deleteById(id);
    }

}
