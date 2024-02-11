package com.wipro.employeeLogin.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Assessment")
public class AssessmentRegistration {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Regno")
	private int regNo;
	@Column(name = "Uid")
	private int userId;
	@Column(name = "Type")
	@Enumerated(EnumType.STRING)
	private AssessmentType assessmentType;
	@Column(name = "Assessment")
	@Enumerated(EnumType.STRING)
	private AssessmentList assessment;
	@Column(name = "Date")
	private LocalDate date;

	public AssessmentRegistration() {

	}

	public AssessmentRegistration(int userId, AssessmentType assessmentType, AssessmentList assessment,
			LocalDate date) {
		super();
		this.userId = userId;
		this.assessmentType = assessmentType;
		this.assessment = assessment;
		this.date = date;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public AssessmentType getAssessmentType() {
		return assessmentType;
	}

	public void setAssessmentType(AssessmentType assessmentType) {
		this.assessmentType = assessmentType;
	}

	public AssessmentList getAssessment() {
		return assessment;
	}

	public void setAssessment(AssessmentList assessment) {
		this.assessment = assessment;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "AssessmentRegistration [userId=" + userId + ", assessmentType=" + assessmentType + ", assessment="
				+ assessment + ", date=" + date + "]";
	}

}
