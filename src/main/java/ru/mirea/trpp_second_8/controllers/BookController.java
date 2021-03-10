package ru.mirea.trpp_second_8.controllers;

import com.opencsv.bean.CsvToBeanBuilder;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import java.io.InputStreamReader;
import java.util.List;
import java.util.Optional;

/** Контроллер для работы с книгами. */
@Controller("/book")
public class BookController {

    /** Список сотрудников. */
    private final List<Book> bookList;

    /** Конструктор. */
    public BookController() {
        bookList = new CsvToBeanBuilder<Book>(new InputStreamReader(this.getClass().getResourceAsStream("/MOCK_DATA.csv"))).withType(Book.class).build().parse();
    }

    /**
     * Получить список книг.
     * @return список книг
     */
    @Get()
    public HttpResponse<List<Book>> getEmployee() {
        return HttpResponse.ok(bookList);
    }

    /**
     * Найти книгу по идентификатору.
     * @param id идентификатор книги
     * @return Книга, если есть, иначе 404 ошибка
     */
    @Get("/{id}")
    public HttpResponse<Book> findById(Long id) {
        Optional<Book> result = bookList.stream().filter(it -> it.getId().equals(id)).findAny();
        if (result.isPresent()) {
            return HttpResponse.ok(result.get());
        } else {
            return HttpResponse.notFound();
        }
    }
}
