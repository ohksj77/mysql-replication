package com.replication.backend.book.command.mapper;

import com.replication.backend.book.command.domain.Book;
import com.replication.backend.book.command.dto.BookRequest;

import org.springframework.stereotype.Component;

@Component
public class BookEntityMapper {

    public Book toEntity(final BookRequest bookRequest) {
        return Book.builder()
                .title(bookRequest.title())
                .author(bookRequest.author())
                .isbn(bookRequest.isbn())
                .build();
    }
}
