package com.replication.backend.book.query.dto;

import lombok.Builder;

@Builder
public record BookResponse(Long id, String title, String author, String isbn) {}
