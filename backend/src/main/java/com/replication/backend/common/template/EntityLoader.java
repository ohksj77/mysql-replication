package com.replication.backend.common.template;

public interface EntityLoader<T, ID> {
    T loadEntity(final ID id);
}
