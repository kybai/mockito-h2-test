package com.nine.mockitotest.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public abstract class BaseEntity implements Serializable {

	private static final long serialVersionUID = -2930616071203863460L;

	private Long id;

	private Date createTime;

	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@SequenceGenerator(name = "sequenceGenerator", sequenceName = "DEMO_BASE_SEQUENCE", allocationSize = 1)
	@GeneratedValue(generator = "sequenceGenerator", strategy = GenerationType.SEQUENCE)
	public Long getId() {
		return id;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_time")
	public Date getCreateTime() {
		return createTime;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
