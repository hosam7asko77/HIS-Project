package com.usa.his.gov.dc.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import lombok.Data;

@Data
@Entity
@Table(name = "CASE_FAMILY_MASTER")
public class HisFamilyDtlsEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer caseFamilyId;
	@Column(name = "FATHER_NAME" ,length = 50)
	private String fatherName;
	@Column(name = "MOTHER_NAME" ,length = 50)
	private String matherName;
	@Column(name = "BRATHER_NUMBER" ,length = 10)
	private Integer numberBrather;
	@Column(name = "SESTER_NUMBER" ,length = 2)
	private Integer numberSester;
	@Column(name = "WIFE_NAME" ,length = 50)
	private String wifeName;
	@Column(name = "WIFE_AGE" ,length = 2)
	private Integer wifeAge;
	@Column(name = "RELATIONSHIP" ,length = 10)
	private String relationship;
	@Column(name = "HAVE_CHILD")
	private Boolean haveChild;
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	@Column(name = "CREATE_DATE", insertable = true, updatable = false)
	private Date createdDate;
	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	@Column(name = "UPDATE_DATE", insertable = false, updatable = true)
	private Date updateDate;

}
