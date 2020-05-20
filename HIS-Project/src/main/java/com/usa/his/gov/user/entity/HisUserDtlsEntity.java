package com.usa.his.gov.user.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.usa.his.gov.dc.entity.HisCaseDtlsEntity;
import com.usa.his.gov.plan.entity.HisPlanEntity;

import lombok.Data;
/**
 * this is Entity class for his register which use to bind repository to send data in database
 * @author hosam7asko
 *
 */
@Data
@Entity
@Table(name = "USER_MASTER")
public class HisUserDtlsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "His_id_gen")
	@SequenceGenerator(name = "his_id_gen", allocationSize = 1, initialValue = 101, sequenceName = "HIS_USER_SEQ")
	@Column(name = "USER_ID", updatable = false)
	private Integer userId;
	@Column(name = "USER_PUBLIC_ID", updatable = false, nullable = false)
	private String publicId;
	@Column(name = "FRIST_NAME", length = 30, nullable = false)
	private String firstName;
	@Column(name = "LAST_NAME", length = 30, nullable = false)
	private String lastName;
	@Column(name = "EMAIL", length = 50, unique = true)
	private String email;
	@Column(name = "PASSWORD", length = 200, nullable = false)
	private String password;
	@Temporal(TemporalType.DATE)
	@Column(name = "DOB")
	private Date Dob;
	@Column(name = "GENDER", length = 10, nullable = false)
	private String gender;
	@Column(name = "SSN_ID", length = 15, nullable = false)
	private String ssn;
	@Column(name = "PHONE_NUMBER", nullable = false)
	private Long phoneNumber;
	@Column(name = "ROLE_TYPE", length = 10, nullable = false)
	private String roleType;
	@Column(name = "STATUS", length = 8 , nullable = false )
	private Boolean status;
	@Column(name = "ACTIVE_SW", length = 2)
	private String activeSwitch;
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	@Column(name = "CREATE_DATE", insertable = true, updatable = false)
	private Date createdDate;
	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	@Column(name = "UPDATE_DATE", insertable = false, updatable = true)
	private Date updatedDate;
	@OneToMany(mappedBy = "dtlsEntity",cascade = {CascadeType.DETACH,
			CascadeType.REFRESH,
			CascadeType.DETACH})
	private List<HisPlanEntity> planEntities;
	@OneToMany(mappedBy = "dtlsEntity",cascade = {CascadeType.DETACH,
			CascadeType.MERGE,
			CascadeType.PERSIST,
			CascadeType.REFRESH})
	private List <HisCaseDtlsEntity> caseDtlsEntities;
	
}
