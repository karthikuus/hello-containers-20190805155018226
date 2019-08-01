package com.baabbee.iframex.beans;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "frame_request")
public class FrameRequest {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "frame_request_id")
	private Long id;
	
	@Column(name = "frame_request_size")
	private String size;
	
	@Column(name = "frame_request_color")
	private String color;
	
	@Column(name = "frame_request_material")
	private String material;
	
	@Column(name = "frame_request_status")
	private String status;
	
	@Column(name = "created_date")
	private Date createdDate;
	
	@Column(name = "last_modified_date")
	private Date lastModifiedDate;
	
	@Column(name="gender")
	private String gender;
	
	//commented to make the mapping unidirectional from the parent Ben_request
	/*@ManyToOne
	@JoinColumn(name = "ben_request_id")
	private BeneficiaryRequest benefRequest;*/
	
	/*@OneToOne
	@JoinColumn(name="frame_id")
	private Frame frame;*/
	
	@OneToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinTable(name="FRAMEREQUEST_FRAME", 
	joinColumns = @JoinColumn(name="FRAME_REQUEST_ID"),
	inverseJoinColumns = @JoinColumn(name="FRAME_ID"))
	private Frame frame;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}
	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
	/*public BeneficiaryRequest getUserRequest() {
		return benefRequest;
	}
	public void setUserRequest(BeneficiaryRequest userRequest) {
		this.benefRequest = userRequest;
	}*/
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	
	public Frame getFrame() {
		return frame;
	}
	public void setFrame(Frame frame) {
		this.frame = frame;
	}
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "FrameRequest [id=" + id + ", size=" + size + ", color=" + color + ", material=" + material + ", status="
				+ status + ", createdDate=" + createdDate + ", lastModifiedDate=" + lastModifiedDate + ", gender="
				+ gender + ", frame=" + frame + "]";
	}

}
