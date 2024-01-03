package com.ava.logmanager.models;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Map;

@Entity
public class LogData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String level;
    private String message;
    private String resourceId;
    @Column(name = "timestamp", columnDefinition = "DATE")
    private java.sql.Date timestamp;
    private String traceId;
    private String spanId;
    private String commit;

    @ElementCollection
    @CollectionTable(name = "log_metadata", joinColumns = @JoinColumn(name = "log_id"))
    @MapKeyColumn(name = "metadata_key")
    @Column(name = "metadata_value")
    private Map<String, String> metadata;


    public LogData() {
    }

    public LogData(String level, String message, String resourceId, Date timestamp, String traceId,
                   String spanId, String commit, Map<String, String> metadata) {
        this.level = level;
        this.message = message;
        this.resourceId = resourceId;
        this.timestamp = timestamp;
        this.traceId = traceId;
        this.spanId = spanId;
        this.commit = commit;
        this.metadata = metadata;
    }

    @Override
    public String toString() {
        return "LogData{" +
                "id=" + id +
                ", level='" + level + '\'' +
                ", message='" + message + '\'' +
                ", resourceId='" + resourceId + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", traceId='" + traceId + '\'' +
                ", spanId='" + spanId + '\'' +
                ", commit='" + commit + '\'' +
                ", metadata=" + metadata +
                '}';
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    public String getSpanId() {
        return spanId;
    }

    public void setSpanId(String spanId) {
        this.spanId = spanId;
    }

    public String getCommit() {
        return commit;
    }

    public void setCommit(String commit) {
        this.commit = commit;
    }

    public Map<String, String> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, String> metadata) {
        this.metadata = metadata;
    }

}