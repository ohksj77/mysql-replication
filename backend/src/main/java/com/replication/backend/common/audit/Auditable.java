package com.replication.backend.common.audit;

public interface Auditable {
    BaseTime getBaseTime();

    void setBaseTime(final BaseTime baseTime);
}
