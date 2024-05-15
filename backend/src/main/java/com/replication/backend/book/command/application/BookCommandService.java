package com.replication.backend.book.command.application;

import com.replication.backend.book.command.domain.Book;
import com.replication.backend.book.command.dto.BookRequest;
import com.replication.backend.book.command.infra.BookCommandRepository;
import com.replication.backend.book.command.mapper.BookEntityMapper;
import com.replication.backend.common.dto.IdResponse;
import com.replication.backend.common.template.EntityLoader;
import com.replication.backend.config.database.CommandService;

import lombok.RequiredArgsConstructor;

@CommandService
@RequiredArgsConstructor
public class BookCommandService {

    private final BookCommandRepository bookCommandRepository;
    private final EntityLoader<Book, Long> bookLoader;
    private final BookEntityMapper bookEntityMapper;

    public IdResponse<Long> register(final BookRequest bookRequest) {
        final Book book = bookCommandRepository.save(bookEntityMapper.toEntity(bookRequest));
        return new IdResponse<>(book.getId());
    }

    public void deleteOne(final Long id) {
        bookCommandRepository.deleteById(id);
    }

    public void updateContent(final Long id, final BookRequest bookRequest) {
        final Book book = bookLoader.loadEntity(id);
        book.updateContent(bookRequest.title(), bookRequest.author(), bookRequest.isbn());
        bookCommandRepository.save(book);
    }
}
