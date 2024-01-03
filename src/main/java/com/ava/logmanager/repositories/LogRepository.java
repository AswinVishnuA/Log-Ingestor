package com.ava.logmanager.repositories;

import com.ava.logmanager.models.LogData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.sql.Date;
import java.util.List;

@Repository
public interface LogRepository extends JpaRepository<LogData, Long> {

    @Query("SELECT log FROM LogData log WHERE "
            + "(:level IS NULL OR log.level = :level) AND "
            + "(:message IS NULL OR log.message LIKE %:message%) AND "
            + "(:resourceId IS NULL OR log.resourceId = :resourceId) AND "
            + "(:searchStartDate IS NULL OR log.timestamp >= :searchStartDate) AND "
            + "(:searchEndDate IS NULL OR log.timestamp <= :searchEndDate)")
    List<LogData> findLogsByParameters(
            @Param("level") String level,
            @Param("message") String message,
            @Param("resourceId") String resourceId,
            @Param("searchStartDate") Date searchStartDate,
            @Param("searchEndDate") Date searchEndDate);

}