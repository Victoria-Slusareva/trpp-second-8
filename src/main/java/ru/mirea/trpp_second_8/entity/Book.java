package ru.mirea.trpp_second_8.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.opencsv.bean.CsvBindByName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/** Сущность Книги. */
@Getter
@Setter
@ToString
public class Book {

    /** Идентификатор. */
    @JsonProperty("id")
    @CsvBindByName(column = "id")
    private Long id;
    /** Название. */
    @JsonProperty("name")
    @CsvBindByName(column = "name")
    private String name;
    /** Автор. */
    @JsonProperty("author")
    @CsvBindByName(column = "author")
    private String author;
    /** ISBN. */
    @JsonProperty("isbn")
    @CsvBindByName(column = "isbn")
    private String isbn;
    /** Дата издания. */
    @JsonProperty("created")
    @CsvBindByName(column = "created")
    private String created;

}
