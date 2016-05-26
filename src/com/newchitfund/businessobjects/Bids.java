package com.newchitfund.businessobjects;

import java.io.Serializable;

public class Bids implements Serializable {
	
	String _bidID;
	String _memberID;
	String _memberName;
	String _bidAmount;
	String _bidDate;
	String _bidStatus;
	
	public Bids() {
		super();
	}

	public Bids(String _memberID, String _memberName, String _bidAmount,
			String _bidDate, String _bidStatus) {
		super();
		this._memberID = _memberID;
		this._memberName = _memberName;
		this._bidAmount = _bidAmount;
		this._bidDate = _bidDate;
		this._bidStatus = _bidStatus;
	}

	public Bids(String _bidID, String _memberID, String _memberName,
			String _bidAmount, String _bidDate, String _bidStatus) {
		super();
		this._bidID = _bidID;
		this._memberID = _memberID;
		this._memberName = _memberName;
		this._bidAmount = _bidAmount;
		this._bidDate = _bidDate;
		this._bidStatus = _bidStatus;
	}

	public String get_bidID() {
		return _bidID;
	}

	public void set_bidID(String _bidID) {
		this._bidID = _bidID;
	}

	public String get_memberID() {
		return _memberID;
	}

	public void set_memberID(String _memberID) {
		this._memberID = _memberID;
	}

	public String get_memberName() {
		return _memberName;
	}

	public void set_memberName(String _memberName) {
		this._memberName = _memberName;
	}

	public String get_bidAmount() {
		return _bidAmount;
	}

	public void set_bidAmount(String _bidAmount) {
		this._bidAmount = _bidAmount;
	}

	public String get_bidDate() {
		return _bidDate;
	}

	public void set_bidDate(String _bidDate) {
		this._bidDate = _bidDate;
	}

	public String get_bidStatus() {
		return _bidStatus;
	}

	public void set_bidStatus(String _bidStatus) {
		this._bidStatus = _bidStatus;
	}
	
}
