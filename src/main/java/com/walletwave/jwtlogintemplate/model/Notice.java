package com.walletwave.jwtlogintemplate.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Entity
@Getter @Setter
@Table(name = "notice_details")
public class Notice {

    @Id
    @Column(name = "notice_id")
    private long noticeId;

    @Column(name = "notice_summary")
    private String noticeSummary;

    @Column(name = "notice_details")
    private String noticeDetails;

    @Column(name = "notic_beg_dt")
    private LocalDateTime noticBegDt;

    @Column(name = "notic_end_dt")
    private LocalDateTime noticEndDt;

    @JsonIgnore
    @Column(name = "create_dt")
    private LocalDateTime createDt;

    @JsonIgnore
    @Column(name = "update_dt")
    private LocalDateTime updateDt;

}
