package com.replication.backend.common.exception;

public class EntityNotFoundException extends IllegalArgumentException {

    private static final String MESSAGE = "조회할 데이터가 없습니다.";

    public EntityNotFoundException() {
        super(MESSAGE);
    }
}
