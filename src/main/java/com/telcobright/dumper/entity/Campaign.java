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
@Table(name = "campaign")
public class Campaign {

    @Id
    @Column(name = "CAMPAIGN_ID", length = 20)
    private String campaignId;

    @Column(name = "CAMPAIGN_NAME", length = 255)
    private String campaignName;

    @Column(name = "SENDER_ID", length = 255)
    private String senderId;

    @Column(name = "MESSAGE", columnDefinition = "longtext")
    private String message;

    @Column(name = "SMS_COUNT")
    private BigDecimal smsCount;

    @Column(name = "SMS_ENCODING", length = 60)
    private String smsEncoding;

    @Column(name = "SMS_TYPE", length = 255)
    private String smsType;

    @Column(name = "SCHEDULES", columnDefinition = "longtext")
    private String schedules;

    @Column(name = "SCHEDULE_STATUS", length = 255)
    private String scheduleStatus;

    @Column(name = "PARTY_ID", length = 20, nullable = false)
    private String partyId;

    @Column(name = "SENT_TASK_COUNT")
    private BigDecimal sentTaskCount;

    @Column(name = "FAILED_TASK_COUNT")
    private BigDecimal failedTaskCount;

    @Column(name = "PENDING_TASK_COUNT")
    private BigDecimal pendingTaskCount;

    @Column(name = "TOTAL_TASK_COUNT")
    private BigDecimal totalTaskCount;

    @Column(name = "LAST_UPDATED_STAMP")
    private LocalDateTime lastUpdatedStamp;

    @Column(name = "LAST_UPDATED_TX_STAMP")
    private LocalDateTime lastUpdatedTxStamp;

    @Column(name = "CREATED_STAMP")
    private LocalDateTime createdStamp;

    @Column(name = "CREATED_TX_STAMP")
    private LocalDateTime createdTxStamp;

    @Column(name = "is_flash", length = 255)
    private String isFlash;

    @Column(name = "is_unicode", length = 255)
    private String isUnicode;

    @Column(name = "policy", length = 255)
    private String policy;

    @Column(name = "EXPIRE_AT", length = 60)
    private String expireAt;
}
