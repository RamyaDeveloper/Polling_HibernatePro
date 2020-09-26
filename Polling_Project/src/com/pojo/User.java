package com.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "poll")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "question")
	private String question;
	
	@Column(name = "yes")
	private int yes;
	
	@Column(name = "no")
	private int no;
	
	@Column(name = "not_sure")
	private int not_sure;
	
	@Column(name = "keywords")
	private String keywords;

	/**
	 * @return the keywords
	 */
	public String getKeywords() {
		return keywords;
	}

	/**
	 * @param keywords the keywords to set
	 */
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	/**
	 * @return the question
	 */
	public String getQuestion() {
		return question;
	}

	/**
	 * @param question the question to set
	 */
	public void setQuestion(String question) {
		this.question = question;
	}

	/**
	 * @return the yes
	 */
	public int getYes() {
		return yes;
	}

	/**
	 * @param yes the yes to set
	 */
	public void setYes(int yes) {
		this.yes = yes;
	}

	/**
	 * @return the no
	 */
	public int getNo() {
		return no;
	}

	/**
	 * @param no the no to set
	 */
	public void setNo(int no) {
		this.no = no;
	}

	/**
	 * @return the not_sure
	 */
	public int getNot_sure() {
		return not_sure;
	}

	/**
	 * @param not_sure the not_sure to set
	 */
	public void setNot_sure(int not_sure) {
		this.not_sure = not_sure;
	}

	public User() {
		super();
	}

	public User(String question, int yes, int no, int not_sure,String keywords) {
		super();
		this.question = question;
		this.yes = yes;
		this.no = no;
		this.not_sure = not_sure;
		this.keywords=keywords;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [id=" + id + ", question=" + question + ", yes=" + yes + ", no=" + no + ", not_sure=" + not_sure
				+ ", keywords=" + keywords + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	
	
}
