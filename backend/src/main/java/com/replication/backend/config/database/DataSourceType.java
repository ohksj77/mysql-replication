package com.replication.backend.config.database;

public enum DataSourceType {
    MASTER,
    SLAVE;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
