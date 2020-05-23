package com.usa.his.gov.elg.model;

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

import lombok.Data;
@Data

public class CdTriggersModel {

	private Integer caseNum;
	private String notice;
	private Date createdDate;
	private String trgStatus;
	private Date updateDate;
	private String batchName;
}
