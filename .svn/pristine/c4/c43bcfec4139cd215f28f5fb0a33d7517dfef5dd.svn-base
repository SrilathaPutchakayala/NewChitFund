package com.newchitfund.androidclient;

import java.util.HashMap;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.provider.ContactsContract.CommonDataKinds.Email;
import android.util.Log;

public class SessionStorage {

	// Shared Preferences
	SharedPreferences pref;

	// Editor for Shared preferences
	Editor editor;

	// Context
	Context _context;

	// Shared pref mode
	int PRIVATE_MODE = 0;	

	final static public String ACCOUNT_PREFS_NAME = "prefs";

	// Constructor
	public SessionStorage(Context context){
		this._context = context;
		pref = _context.getSharedPreferences(ACCOUNT_PREFS_NAME, PRIVATE_MODE);
		editor = pref.edit();
	}

	public SessionStorage(Context context,String PreferenceName){
		this._context = context;
		pref = _context.getSharedPreferences(PreferenceName, PRIVATE_MODE);
		editor = pref.edit();
	}

	public void storeLoginDetails(HashMap<String, String> loginDetails) {
		// Save the access key for later
		SharedPreferences prefs = _context.getSharedPreferences(ACCOUNT_PREFS_NAME, 0);
		Editor edit = prefs.edit();
		
		edit.putString("MEMBER_ID",loginDetails.get("MEMBER_ID"));
		edit.putString("MEMBER_NAME",loginDetails.get("MEMBER_NAME"));
		edit.putString("MEMBER_EMAIL",loginDetails.get("MEMBER_EMAIL"));

		edit.putString("MEMBER_PROFILE_PIC",loginDetails.get("MEMBER_PROFILE_PIC"));
		edit.putString("MEMBER_PHONE",loginDetails.get("MEMBER_PHONE"));
		edit.putString("MEMBER_ADMIN_ID",loginDetails.get("MEMBER_ADMIN_ID"));
		edit.putString("MEMBER_ROLE",loginDetails.get("MEMBER_ROLE"));
		edit.putString("MEMBER_MEMBERSHIP",loginDetails.get("MEMBER_MEMBERSHIP"));
		edit.putString("MEMBER_CREATED_ON",loginDetails.get("MEMBER_CREATED_ON"));
		edit.commit();
	}

	/**
	 * This method will return user session values
	 * @return member data from session
	 */
	public HashMap<String, String> getLoginDetails() {
		
		HashMap<String, String> loggedInUserDetails = new HashMap<String, String>();
		SharedPreferences prefs = _context.getSharedPreferences(ACCOUNT_PREFS_NAME, 0);
		
		loggedInUserDetails.put("MEMBER_ID", prefs.getString("MEMBER_ID", null));
		loggedInUserDetails.put("MEMBER_NAME", prefs.getString("MEMBER_NAME", null));
		loggedInUserDetails.put("MEMBER_EMAIL", prefs.getString("MEMBER_EMAIL", null));
		loggedInUserDetails.put("MEMBER_PROFILE_PIC", prefs.getString("MEMBER_PROFILE_PIC", null));
		loggedInUserDetails.put("MEMBER_PHONE", prefs.getString("MEMBER_PHONE", null));
		loggedInUserDetails.put("MEMBER_ADMIN_ID", prefs.getString("MEMBER_ADMIN_ID", null));
		loggedInUserDetails.put("MEMBER_ROLE", prefs.getString("MEMBER_ROLE", null));
		loggedInUserDetails.put("MEMBER_MEMBERSHIP", prefs.getString("MEMBER_MEMBERSHIP", null));
		loggedInUserDetails.put("MEMBER_CREATED_ON", prefs.getString("MEMBER_CREATED_ON", null));
		
		return loggedInUserDetails;
	}
	
		
	/**
	 * Shows keeping the access keys returned from Trusted Authenticator in a local
	 * store, rather than storing user name & password, and re-authenticating each
	 * time (which is not to be done, ever).
	 *
	 * @return Array of [access_key, access_secret], or null if none stored
	 */



	/**
	 * Clears stored session variable values
	 */
	public void clearKeys() {
		Log.v("Inside Session Storage","Clear Keys===");
		SharedPreferences prefs = _context.getSharedPreferences(ACCOUNT_PREFS_NAME, 0);
		Editor edit = prefs.edit();
		edit.clear();
		edit.commit();
	
	}






}
