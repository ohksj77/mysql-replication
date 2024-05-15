package com.replication.backend.book.query.mapper;

import com.replication.backend.book.command.domain.Book;
import com.replication.backend.book.query.dto.BookResponse;

import org.springframework.stereotype.Component;

@Component
public class BookDtoMapper {

    public BookResponse toResponse(final Book book) {
        return BookResponse.builder()
                .id(book.getId())
                .title(book.getTitle())
                .author(book.getAuthor())
                .isbn(book.getIsbn())
                .build();
    }
}
