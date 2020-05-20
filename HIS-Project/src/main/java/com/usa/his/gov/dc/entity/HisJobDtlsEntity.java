package com.usa.his.gov.dc.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name = "CASE_JOB_MASTER")
public class HisJobDtlsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "job_gen_id_seq")
    @SequenceGenerator(
    		name = "job_id_seq",
    		sequenceName = "job_gen_id_seq",
    		initialValue = 1,
    		allocationSize = 1
    		)
    @Column(name = "JOB_ID")
	private Integer jobId;
    @Column(name = "OCCUPATION")
	private String occupation;
    @Column(name = "ORG_NAME")
	private String orgName;
    @Column(name = "JOB_TYPE")
	private String jobType;
    @Column(name = "JOB_POSITION")
	private String jobPosition;
    @Temporal(TemporalType.DATE)
    @Column(name = "START_JOB")
	private Date startJob;
    @Column(name = "INCOME")
	private Double income;
	// TFS stand for Tax For Salary
    @Column(name = "INCOME_TAX_SALRY")
	private Double incomeTFS;
    @Column(name = "INCOME_TYPE")
	private String incomeType;
	//FOR stand for from other resource
	private Double incomeFOR;
    @Column(name = "INCOM_FRO_TYPE")
	private String incomeFORType;
	// FOR stand for Tax from other resource
    @Column(name = "INCOME_TAX_OTHER_RESOURC")
	private Double incomeTFOR;
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	@Column(name = "CREATE_DATE", insertable = true, updatable = false)
	private Date createdDate;
	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	@Column(name = "UPDATE_DATE", insertable = false, updatable = true)
	private Date updateDate;
	@OneToOne(cascade = CascadeType.ALL)
	private HisCaseDtlsEntity caseDtlsEntity;
}
