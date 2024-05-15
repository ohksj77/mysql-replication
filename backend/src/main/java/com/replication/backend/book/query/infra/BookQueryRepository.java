package com.replication.backend.book.query.infra;

import com.replication.backend.book.command.domain.Book;

import java.util.Optional;

public interface BookQueryRepository {

    Optional<Book> findById(final Long id);
}
