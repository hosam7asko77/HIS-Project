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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.usa.his.gov.user.entity.HisPlanEntity;

import lombok.Data;

@Data
@Entity
@Table(name = "CACE_PLAN_MASTER")
public class HisCasePlanEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer casePlanId;
	@Column(name="PLAN_NAME" , nullable = false)
	private String planName;
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	@Column(name = "CREATE_DATE", insertable = true, updatable = false)
	private Date createdDate;
	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	@Column(name = "UPDATE_DATE", insertable = false, updatable = true)
	private Date updateDate;
	

}
