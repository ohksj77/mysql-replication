package com.replication.backend.common.audit;

import jakarta.persistence.Embeddable;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BaseTime {
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
