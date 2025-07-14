package io.github.sergejsvisockis.bookmanager.lib;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@ToString
public class BookEvent implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String title;
    private String author;
    private String isbn;
}