package com.example.aop.history.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class History {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idx;

	@Column
	private long userIdx;

	@Column
	private Date updateDate;

	public History() {
	}

	public History(long userIdx) {
		this.userIdx = userIdx;
		this.updateDate = new Date();
	}

	public long getIdx() {
		return idx;
	}

	public void setIdx(long idx) {
		this.idx = idx;
	}

	public long getUserIdx() {
		return userIdx;
	}

	public void setUserIdx(long userIdx) {
		this.userIdx = userIdx;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	@Override
	public String toString() {
		return "History{" +
				"idx=" + idx +
				", userIdx=" + userIdx +
				", updateDate=" + updateDate +
				'}';
	}
}
