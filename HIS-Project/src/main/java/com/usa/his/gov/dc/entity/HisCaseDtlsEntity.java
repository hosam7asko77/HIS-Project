package com.usa.his.gov.dc.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.usa.his.gov.appregister.entity.HisAppRegisterEntity;
import com.usa.his.gov.user.entity.HisUserDtlsEntity;

import lombok.Data;

@Data
@Entity
@Table(name = "CASE_MASTER")
public class HisCaseDtlsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CASE_NUMBER" ,insertable = true, updatable = false ,length = 13)
	private Integer caseNumber;
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	@Column(name = "CREATE_DATE", insertable = true, updatable = false)
	private Date createdDate;
	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	@Column(name = "UPDATE_DATE", insertable = false, updatable = true)
	private Date updateDate;
	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.REFRESH})
	@JoinColumn(name = "User_Id")
	private HisUserDtlsEntity dtlsEntity;
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name="CASE_PLAN")
	private HisCasePlanEntity casePlanEntity;
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "FAMLY_DETAILS")
	private HisFamilyDtlsEntity familyDtlsEntity;
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "CRIME_DETAILS")
	private HisCrimeDtlsEntity crimeDtlsEntity;
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "JOB_DETAILS")
	private HisJobDtlsEntity jobDetailsEntity;
	@OneToMany(mappedBy="caseDtlsEntity",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<HisKidsDtlsEntity> kidsDtlsEntity;

}
