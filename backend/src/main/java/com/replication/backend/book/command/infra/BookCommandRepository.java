package com.replication.backend.book.command.infra;

import com.replication.backend.book.command.domain.Book;

public interface BookCommandRepository {

    Book save(final Book book);

    void deleteById(final Long id);
}
