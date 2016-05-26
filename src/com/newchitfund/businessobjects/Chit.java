package com.newchitfund.businessobjects;

import java.io.Serializable;

public class Chit implements Serializable {

	String _chitID;
	String _chitName;
	String _ownerID;
	String _ownerName;
	String _adminID;
	String _chitAmount;
	String _noOfMembers;
	String _noOfMonths;
	String _ownerMonth;
	String _startDate;
	String _bidDate;
	String _paymentDate;
	String _createdOn;
	String _modifiedOn;
	String _status;
	
	public Chit() {
		super();
	}

	public String get_chitID() {
		return _chitID;
	}

	public void set_chitID(String _chitID) {
		this._chitID = _chitID;
	}

	public String get_chitName() {
		return _chitName;
	}

	public void set_chitName(String _chitName) {
		this._chitName = _chitName;
	}

	public String get_ownerID() {
		return _ownerID;
	}

	public void set_ownerID(String _ownerID) {
		this._ownerID = _ownerID;
	}

	public String get_ownerName() {
		return _ownerName;
	}

	public void set_ownerName(String _ownerName) {
		this._ownerName = _ownerName;
	}

	public String get_adminID() {
		return _adminID;
	}

	public void set_adminID(String _adminID) {
		this._adminID = _adminID;
	}

	public String get_chitAmount() {
		return _chitAmount;
	}

	public void set_chitAmount(String _chitAmount) {
		this._chitAmount = _chitAmount;
	}

	public String get_noOfMembers() {
		return _noOfMembers;
	}

	public void set_noOfMembers(String _noOfMembers) {
		this._noOfMembers = _noOfMembers;
	}

	public String get_noOfMonths() {
		return _noOfMonths;
	}

	public void set_noOfMonths(String _noOfMonths) {
		this._noOfMonths = _noOfMonths;
	}

	public String get_ownerMonth() {
		return _ownerMonth;
	}

	public void set_ownerMonth(String _ownerMonth) {
		this._ownerMonth = _ownerMonth;
	}

	public String get_startDate() {
		return _startDate;
	}

	public void set_startDate(String _startDate) {
		this._startDate = _startDate;
	}

	public String get_bidDate() {
		return _bidDate;
	}

	public void set_bidDate(String _bidDate) {
		this._bidDate = _bidDate;
	}

	public String get_paymentDate() {
		return _paymentDate;
	}

	public void set_paymentDate(String _paymentDate) {
		this._paymentDate = _paymentDate;
	}

	public String get_createdOn() {
		return _createdOn;
	}

	public void set_createdOn(String _createdOn) {
		this._createdOn = _createdOn;
	}

	public String get_modifiedOn() {
		return _modifiedOn;
	}

	public void set_modifiedOn(String _modifiedOn) {
		this._modifiedOn = _modifiedOn;
	}

	public String get_status() {
		return _status;
	}

	public void set_status(String _status) {
		this._status = _status;
	}


	

}
