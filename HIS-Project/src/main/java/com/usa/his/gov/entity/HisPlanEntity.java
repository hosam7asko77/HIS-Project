package com.usa.his.gov.entity;

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

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import com.usa.his.gov.config.PlanIdSequenceGenerator;

import lombok.Data;

@Data
@Entity
@Table(name="PALN_MASTER")
public class HisPlanEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "plan_seq")
    @GenericGenerator(
        name = "plan_seq", 
        strategy = "com.usa.his.gov.config.PlanIdSequenceGenerator", 
        parameters = {
            @Parameter(name = PlanIdSequenceGenerator.INCREMENT_PARAM, value = "1"),
            @Parameter(name = PlanIdSequenceGenerator.VALUE_PREFIX_PARAMETER, value = "HIS_Plan_"),
            @Parameter(name = PlanIdSequenceGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })
    @Column(name = "Plan_Id",length = 15)
	private String planId;
	@Column(name = "Plan_Name", length = 30, nullable = false)
	private String planName;
	@Column(name = "Plan_Discript", length = 255, nullable = false)
	private String discript;
	@Column(name = "Plan_Start_Date")
	@Temporal(TemporalType.DATE)
	private Date startDate;
	@Column(name = "Plan_End_Date")
	@Temporal(TemporalType.DATE)
	private Date endDate;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "User_Id")
	private HisUserDtlsEntity dtlsEntity;

}
