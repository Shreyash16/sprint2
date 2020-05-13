package com.capgemini.onlinetestmanagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;



@Entity
@Table(name="questions")
@DynamicUpdate(true)
@DynamicInsert(true)
public class Questions {
	

	@Id
	@Column(name="Q_id")
	private Integer QId;
	
	
	@Column(name="Q_title")
	private String QTitle;
	
	
	@Column(name="Q_Options")
	private String QOptions;
	
	@Column(name="Q_answer")
	private Integer QAnswer;
	
	@Column(name="Q_marks")
	private Integer QMarks;
	
	@Column(name="Choose_ans")
	private Integer ChooseAns;
	
	@Column(name="Marks_scored")
	private Integer MarksScored;
	
	

	public Questions() {
		super();
	}

	public Questions(Integer QId, String QTitle, String QOptions, Integer QAnswer, Integer QMarks, Integer ChooseAns, Integer MarksScored) {
		super();
		this.QId = QId;
		this.QTitle = QTitle;
		this.QOptions = QOptions;
		this.QAnswer = QAnswer;
		this.QMarks = QMarks;
		this.ChooseAns = ChooseAns;
		this.MarksScored = MarksScored;
		
	}

	public Integer getQId() {
		return QId;
	}

	public void setQId(Integer QId) {
		this.QId = QId;
	}

	public String getQTitle() {
		return QTitle;
	}

	public void setQTitle(String QTitle) {
		this.QTitle = QTitle;
	}
	public String getQOptions() {
		return QOptions;
	}

	public void setQOptions(String QOptions) {
		this.QOptions = QOptions;
	}
	public Integer getQAnswer() {
		return QAnswer;
	}

	public void setQAnswer(Integer QAnswer) {
		this.QAnswer = QAnswer;
	}
	public Integer getQMarks() {
		return QMarks;
	}

	public void setQMarks(Integer QMarks) {
		this.QMarks = QMarks;
	}
	public Integer getChooseAns() {
		return ChooseAns;
	}

	public void setChooseAns(Integer ChooseAns) {
		this.ChooseAns = ChooseAns;
	}
	public Integer getMarksScored() {
		return MarksScored;
	}

	public void setMarksScored(Integer MarksScored) {
		this.MarksScored = MarksScored;
	}
	

	
	@Override
	public String toString() {
		return "Questions [QId=" + QId + ", QTitle=" + QTitle + ", QOptions="+ QOptions + ", QAnswer=" + QAnswer + ", QMarks=" + QMarks + ", ChooseAns=" + ChooseAns + ", MarksScored=" + MarksScored + "]";
	}
	
}
