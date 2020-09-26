package com.pojo;

import java.util.ArrayList;
import java.util.List;

public class Pairing {
	int count;
	String keyword;
	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}
	/**
	 * @param count the count to set
	 */
	public void setCount(int count) {
		this.count = count;
	}
	/**
	 * @return the keyword
	 */
	public String getKeyword() {
		return keyword;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Pairing [count=" + count + ", keyword=" + keyword + "]";
	}
	public Pairing() {
		super();
	}
	public Pairing(int count, String keyword) {
		super();
		this.count = count;
		this.keyword = keyword;
	}
	/**
	 * @param keyword the keyword to set
	 */
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public List<Pairing> usepair(){
	List<Pairing> objs=new ArrayList<Pairing>();
	return objs;
	}
}
