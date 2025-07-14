package io.github.sergejsvisockis.bookmanager.producer;

import io.github.sergejsvisockis.bookmanager.lib.BookEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BookProducerApi {

    private final BookProducer bookProducer;

    @PostMapping("/api/book")
    public ResponseEntity<BookResponse> postBook(@RequestBody BookRequest request) {

        BookEvent book = new BookEvent();
        book.setTitle(request.title());
        book.setAuthor(request.author());
        book.setIsbn(request.isbn());
        bookProducer.enqueue(book);

        return ResponseEntity
                .ok()
                .body(new BookResponse(book.getTitle()));
    }

    public record BookRequest(String title, String author, String isbn) {
    }

    public record BookResponse(String title) {
    }
}
