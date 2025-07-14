package io.github.sergejsvisockis.bookmanager.consumer;

import io.github.sergejsvisockis.bookmanager.lib.BookEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class BookConsumer {

    private final BookRepository bookRepository;

    @JmsListener(destination = "${book.queue}")
    public void consumeBook(BookEvent event) {
        log.info("Received book event: {}", event);

        Book book = new Book();
        book.setTitle(event.getTitle());
        book.setAuthor(event.getAuthor());
        book.setIsbn(event.getIsbn());

        bookRepository.save(book);
    }
}
