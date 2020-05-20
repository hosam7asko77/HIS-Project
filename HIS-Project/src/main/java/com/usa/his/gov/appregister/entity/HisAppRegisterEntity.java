package com.usa.his.gov.appregister.entity;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name="APP_REGISETR_MASTER")
public class HisAppRegisterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AR_seq")
    @GenericGenerator(
        name = "AR_seq", 
        strategy = "com.usa.his.gov.config.PlanIdSequenceGenerator", 
        parameters = {
            @Parameter(name = PlanIdSequenceGenerator.INCREMENT_PARAM, value = "1"),
            @Parameter(name = PlanIdSequenceGenerator.VALUE_PREFIX_PARAMETER, value = "AR"),
            @Parameter(name = PlanIdSequenceGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
	@Column(name = "App_ID",length = 10, updatable = false)
	private String appId;
	@Column(name = "FRIST_NAME", length = 30, nullable = false)
	private String firstName;
	@Column(name = "LAST_NAME", length = 30, nullable = false)
	private String lastName;
	@Column(name = "EMAIL", length = 50, unique = true)
	private String email;
	@Temporal(TemporalType.DATE)
	@Column(name = "DOB")
	private Date Dob;
	@Column(name = "GENDER", length = 10, nullable = false)
	private String gender;
	@Column(name = "SSN_ID", length = 15, nullable = false)
	private String ssn;
	@Column(name = "PHONE_NUMBER", nullable = false)
	private Long phoneNumber;
	@Column(name = "DeleteStatus", nullable = false)
	private Boolean deleteStatus;
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	@Column(name = "CREATE_DATE", insertable = true, updatable = false)
	private Date createdDate;
	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	@Column(name = "UPDATE_DATE", insertable = false, updatable = true)
	private Date updatedDate;
	@ManyToOne(cascade = {CascadeType.DETACH,CascadeType.REFRESH})
	@JoinColumn(name = "User_Id")
	private HisUserDtlsEntity dtlsEntity;
	
}
