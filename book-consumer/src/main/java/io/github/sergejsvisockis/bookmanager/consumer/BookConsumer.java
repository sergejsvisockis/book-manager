package io.github.sergejsvisockis.bookmanager.consumer;

import io.github.sergejsvisockis.bookmanager.lib.BookEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookConsumer {

    private final BookRepository bookRepository;

    @JmsListener(destination = "${book.queue}")
    public void consumeBook(BookEvent event) {

        Book book = new Book();
        book.setTitle(event.getTitle());
        book.setAuthor(event.getAuthor());
        book.setIsbn(event.getIsbn());

        bookRepository.save(book);
    }
}
