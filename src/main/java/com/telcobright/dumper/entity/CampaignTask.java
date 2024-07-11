package com.telcobright.dumper.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "campaign_task")
public class CampaignTask {

    @Id
    @Column(name = "CAMPAIGN_TASK_ID", length = 20)
    private String campaignTaskId;

    @Column(name = "PHONE_NUMBER", length = 60, nullable = false)
    private String phoneNumber;

    @Column(name = "TERMINATING_CALLED_NUMBER", length = 60)
    private String terminatingCalledNumber;

    @Column(name = "ORIGINATING_CALLING_NUMBER", length = 60)
    private String originatingCallingNumber;

    @Column(name = "TERMINATING_CALLING_NUMBER", length = 60)
    private String terminatingCallingNumber;

    @Column(name = "MESSAGE", columnDefinition = "longtext")
    private String message;

    @Column(name = "SMS_COUNT")
    private BigDecimal smsCount;

    @Column(name = "SMS_ENCODING", length = 60)
    private String smsEncoding;

    @Column(name = "CAMPAIGN_ID", length = 20, nullable = false)
    private String campaignId;

    @Column(name = "PACKAGE_ID", length = 20)
    private String packageId;

    @Column(name = "ROUTE_ID", length = 20)
    private String routeId;

    @Column(name = "STATUS", length = 60)
    private String status;

    @Column(name = "STATUS_EXTERNAL", length = 255)
    private String statusExternal;

    @Column(name = "STATUS_EXTERNAL_UPDATED_AT")
    private LocalDateTime statusExternalUpdatedAt;

    @Column(name = "ERROR_CODE", length = 60)
    private String errorCode;

    @Column(name = "ERROR_CODE_EXTERNAL", length = 255)
    private String errorCodeExternal;

    @Column(name = "TASK_ID_EXTERNAL", length = 255)
    private String taskIdExternal;

    @Column(name = "SMS_ID", length = 255)
    private String smsId;

    @Column(name = "RETRY_COUNT", nullable = false)
    private BigDecimal retryCount;

    @Column(name = "RETRY_HISTORY", columnDefinition = "longtext")
    private String retryHistory;

    @Column(name = "NEXT_RETRY_TIME", length = 60)
    private String nextRetryTime;

    @Column(name = "LAST_RETRY_TIME", length = 60)
    private String lastRetryTime;

    @Column(name = "ALL_RETRY_TIMES", columnDefinition = "longtext")
    private String allRetryTimes;

    @Column(name = "TASK_DETAIL_JSON", columnDefinition = "longtext")
    private String taskDetailJson;

    @Column(name = "PARENT_ID", length = 20)
    private String parentId;

    @Column(name = "MULTIPART_SEGMENT_NUMBER")
    private BigDecimal multipartSegmentNumber;

    @Column(name = "INSTANCES", columnDefinition = "longtext")
    private String instances;

    @Column(name = "LAST_UPDATED_STAMP")
    private LocalDateTime lastUpdatedStamp;

    @Column(name = "LAST_UPDATED_TX_STAMP")
    private LocalDateTime lastUpdatedTxStamp;

    @Column(name = "CREATED_STAMP")
    private LocalDateTime createdStamp;

    @Column(name = "CREATED_TX_STAMP")
    private LocalDateTime createdTxStamp;

    @Column(name = "DELIVERED_ON", columnDefinition = "longtext")
    private String deliveredOn;

    @Column(name = "SENT_ON", columnDefinition = "longtext")
    private String sentOn;

}