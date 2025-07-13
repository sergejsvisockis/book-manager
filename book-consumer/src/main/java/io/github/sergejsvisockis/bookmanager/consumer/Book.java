package io.github.sergejsvisockis.bookmanager.consumer;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_id_gen")
    @SequenceGenerator(name = "book_id_gen",
            sequenceName = "book_seq",
            initialValue = 1000,
            allocationSize = 1)
    private Long id;
    private String title;
    private String author;
    private String isbn;

}
