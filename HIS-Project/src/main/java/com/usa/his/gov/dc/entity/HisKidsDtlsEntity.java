package com.usa.his.gov.dc.entity;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.UpdateTimestamp;

import com.usa.his.gov.config.PlanIdSequenceGenerator;
import com.usa.his.gov.user.entity.HisUserDtlsEntity;

import lombok.Data;

@Data
@Entity
@Table(name="CASE_KIDS_MASTER")
public class HisKidsDtlsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "kids_gen_id_seq")
    @SequenceGenerator(
    		name = "kids_id_seq",
    		sequenceName = "kids_gen_id_seq",
    		initialValue = 1,
    		allocationSize = 1
    		)
	@Column(name = "CHILD_ID",length = 10, updatable = false)
	private Integer childId;
	@Column(name = "CHILD_NAME", length = 30, nullable = false)
	private String childName;
	@Temporal(TemporalType.DATE)
	@Column(name = "DOB")
	private Date Dob;
	@Column(name = "GENDER", length = 10, nullable = false)
	private String gender;
	@Column(name = "SSN_ID", length = 15, nullable = false)
	private String ssn;
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	@Column(name = "CREATE_DATE", insertable = true, updatable = false)
	private Date createdDate;
	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	@Column(name = "UPDATE_DATE", insertable = false, updatable = true)
	private Date updatedDate;
	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.REFRESH})
	@JoinColumn(name = "CASE_NUMBER")
	private HisCaseDtlsEntity caseDtlsEntity;
	
}
