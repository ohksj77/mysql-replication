package com.replication.backend.book.query.application;

import com.replication.backend.book.command.domain.Book;
import com.replication.backend.book.query.dto.BookResponse;
import com.replication.backend.book.query.infra.BookQueryRepository;
import com.replication.backend.book.query.mapper.BookDtoMapper;
import com.replication.backend.common.exception.EntityNotFoundException;
import com.replication.backend.common.template.EntityLoader;
import com.replication.backend.config.database.QueryService;

import lombok.RequiredArgsConstructor;

@QueryService
@RequiredArgsConstructor
public class BookQueryService implements EntityLoader<Book, Long> {

    private final BookQueryRepository bookQueryRepository;
    private final BookDtoMapper bookDtoMapper;

    public BookResponse findOne(final Long id) {
        return bookDtoMapper.toResponse(loadEntity(id));
    }

    public Book loadEntity(final Long id) {
        return bookQueryRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
}
