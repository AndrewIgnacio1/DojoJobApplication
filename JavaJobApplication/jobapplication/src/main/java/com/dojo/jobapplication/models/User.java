package com.dojo.jobapplication.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

//<<---------------User Model--------------->>

@Entity
@Table(name="users")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Size(min=1, max=255, message="This field cannot be blank.")
	private String firstName;

	@Size(min=1, max=255, message="This field cannot be blank.")
	private String lastName;
	
	@Email(message="Invalid Email")
	@Size(min=1, max=255, message="This field cannot be blank.")
	private String email;
	
	@Size(min=8, max=255, message="Password must be atleast 8 characters.")
	private String password;
	
	@Size(min=8, max=255, message="Password must match.")
	@Transient
	private String confirmation;
	
	@Column (updatable = false)
	private Date createdAt;
	private Date updatedAt;
	
//	<<---------------One To Many Relationship--------------->>
	
	@OneToMany (mappedBy="user", fetch = FetchType.LAZY)
	private List<Job> jobs;
	
//	<<---------------Many To Many Relationship--------------->>
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name="users_applying_jobs",
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "job_id")
	)
	private List<Job> job;
	
//	<<---------------Defining Constructor--------------->>
	
	public User() {

	}
	
	public User(Long id, @Size(min = 1, max = 255, message = "This field cannot be blank.") String firstName,
		@Size(min = 1, max = 255, message = "This field cannot be blank.") String lastName,
		@Email(message = "Invalid Email") @Size(min = 1, max = 255, message = "This field cannot be blank.") String email,
		@Size(min = 8, max = 255, message = "Password must be atleast 8 characters.") String password,
		@Size(min = 8, max = 255, message = "Password must match.") String confirmation, Date createdAt, Date updatedAt,
		List<Job> jobs) {

	this.id = id;
	this.firstName = firstName;
	this.lastName = lastName;
	this.email = email;
	this.password = password;
	this.confirmation = confirmation;
	this.createdAt = createdAt;
	this.updatedAt = updatedAt;
	this.jobs = jobs;
	}

//	<<---------------Getters and Setters--------------->>

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmation() {
		return confirmation;
	}

	public void setConfirmation(String confirmation) {
		this.confirmation = confirmation;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<Job> getJobs() {
		return jobs;
	}

	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}

	public List<Job> getJob() {
		return job;
	}

	public void setJob(List<Job> job) {
		this.job = job;
	}
	
//	<<---------------Creating/Updating--------------->>

	@PrePersist
	protected void onCreate(){
		this.createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate(){
		this.updatedAt = new Date();
	}

}
