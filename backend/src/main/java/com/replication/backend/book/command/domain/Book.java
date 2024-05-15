package com.replication.backend.book.command.domain;

import com.replication.backend.common.audit.AuditListener;
import com.replication.backend.common.audit.Auditable;
import com.replication.backend.common.audit.BaseTime;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.hibernate.annotations.SoftDelete;

@Getter
@Entity
@SoftDelete
@EntityListeners(AuditListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Book implements Auditable {

    @Id @GeneratedValue private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private String isbn;

    @Setter @Embedded private BaseTime baseTime;

    @Builder
    public Book(final String title, final String author, final String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public void updateContent(final String title, final String author, final String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }
}
