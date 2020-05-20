package com.usa.his.gov.dc.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
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
@Table(name = "CASE_CRIME_MASTER")
public class HisCrimeDtlsEntity {

	@Id
	@GeneratedValue(generator = "crime_gen_id")
	@SequenceGenerator(
			name = "crime_gen_id",
			sequenceName = "crime_id",
			initialValue = 1,
			allocationSize = 1
			)
	@Column(name = "CRIME_ID",length = 10)
	private Integer crimeId;
	@Column(name = "INCIDENT_TYPE",length = 100)
	private String incidentType;
    @Temporal(TemporalType.DATE)
    @Column(name = "INCIDENT_DATE")
	private Date incidentDate;
    @Column(name = "INCIDENT_STREET",length = 300)
	private String incidentStreet;
    @Column(name = "INCIDENT_CITY",length = 30)
	private String incidentCity;
    @Column(name = "INCIDENT_STATE",length = 30)
	private String incidentState;
    @Column(name = "INCIDENT_DESCRIBE",length = 500)
	private String incidentDescribe;
    @Column(name = "PEOPLE_INVOLVED",length = 5)
	private Integer peopelInvolved;
    @Column(name = "REPORT",length = 1000)
	private byte[] crimeReport;
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
