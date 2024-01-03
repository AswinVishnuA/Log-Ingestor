package com.ava.logmanager.services;

import com.ava.logmanager.models.LogData;
import com.ava.logmanager.repositories.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class LogService {

    @Autowired
    private LogRepository logRepository;

    public void ingestLog(LogData logData) {
        logRepository.save(logData);
    }

    public List<LogData> searchLogs(String level, String message, String resourceId, Date searchStartDate, Date searchEndDate) {

        return logRepository.findLogsByParameters(level,message,resourceId,searchStartDate,searchEndDate);
    }
}
