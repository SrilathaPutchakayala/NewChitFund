/********************************************************************************************
Project Name    :NewChitFund
 *********************************************************************************************
Class Name      :CommonMethods.java
Date            :2/6/14
Developer       :Rajesh Kumar G
Description     :To display Alert box in this project

 *********************************************************************************************
 *********************************************************************************************
Change History:
Date          :
Developer     :
Change        :

 *********************************************************************************************/

package com.newchitfund.androidclient;

import android.app.AlertDialog;
import android.content.Context;


/**
 * Contains a method to display alert dialog to the user 
 * @author Rajesh G
 *
 */
public class CommonMethods {
	/**
	 * Represents an alert dialog,displays with given message and title to the user. 
	 * @param message --Display this value to the user.
	 * @param context --Context of the activity.
	 * @param title --Title of the alert dialog.
	 */
	public static void showErrorDialog(String message,Context context){
		AlertDialog.Builder dlgAlert = new AlertDialog.Builder(context);
		dlgAlert.setMessage(message);
		dlgAlert.setPositiveButton("OK", null);
		dlgAlert.setCancelable(true);
		dlgAlert.create().show();
	}

}