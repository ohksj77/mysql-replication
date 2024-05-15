package com.replication.backend.common.audit;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.time.LocalDateTime;
import java.util.Optional;

public class AuditListener {
    @PrePersist
    public void setCreatedAt(final Auditable auditable) {
        final BaseTime baseTime =
                Optional.ofNullable(auditable.getBaseTime()).orElseGet(BaseTime::new);
        baseTime.setCreatedAt(LocalDateTime.now());
        auditable.setBaseTime(baseTime);
    }

    @PreUpdate
    public void setUpdatedAt(final Auditable auditable) {
        auditable.getBaseTime().setUpdatedAt(LocalDateTime.now());
    }
}
