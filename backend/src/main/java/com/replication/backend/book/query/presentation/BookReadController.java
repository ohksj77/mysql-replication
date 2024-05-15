package com.replication.backend.book.query.presentation;

import com.replication.backend.book.query.application.BookQueryService;
import com.replication.backend.book.query.dto.BookResponse;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("books")
public class BookReadController {

    private final BookQueryService bookQueryService;

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public BookResponse findOne(@PathVariable final Long id) {
        return bookQueryService.findOne(id);
    }
}
