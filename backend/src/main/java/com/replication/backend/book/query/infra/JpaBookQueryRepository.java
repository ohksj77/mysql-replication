package com.replication.backend.book.query.infra;

import com.replication.backend.book.command.domain.Book;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaBookQueryRepository extends JpaRepository<Book, Long>, BookQueryRepository {}
