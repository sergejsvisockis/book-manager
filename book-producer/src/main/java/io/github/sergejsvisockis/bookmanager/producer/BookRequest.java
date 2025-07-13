package io.github.sergejsvisockis.bookmanager.producer;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class BookRequest {

    private String title;
    private String author;
    private String isbn;
}
