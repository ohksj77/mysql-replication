package com.replication.backend.book.command.infra;

import com.replication.backend.book.command.domain.Book;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaBookCommandRepository
        extends JpaRepository<Book, Long>, BookCommandRepository {}
