package com.replication.backend.book.command.presentation;

import com.replication.backend.book.command.application.BookCommandService;
import com.replication.backend.book.command.dto.BookRequest;
import com.replication.backend.common.dto.IdResponse;

import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("books")
public class BookWriteController {

    private final BookCommandService bookCommandService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public IdResponse<Long> register(@RequestBody @Valid final BookRequest bookRequest) {
        return bookCommandService.register(bookRequest);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateOne(
            @PathVariable final Long id, @RequestBody @Valid final BookRequest bookRequest) {
        bookCommandService.updateContent(id, bookRequest);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOne(@PathVariable final Long id) {
        bookCommandService.deleteOne(id);
    }
}
