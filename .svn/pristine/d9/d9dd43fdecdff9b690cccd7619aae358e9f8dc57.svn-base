/********************************************************************************************
Project Name    :ChitFund
 *********************************************************************************************
Class Name      :Utils.java
Date            :30/05/14
Developer       :Srilatha
Description     :Reads the input stream bytes and copy that to output stream. 

 *********************************************************************************************/

package com.newchitfund.androidclient;

import java.io.InputStream;
import java.io.OutputStream;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class Utils {

	/**
	 * Check for Internet Connectivity
	 * @param context 
	 * @return - boolean value 
	 */
	public static boolean isInternetAvailable(Context context){
		ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		if (connectivity != null) 
		{
			NetworkInfo[] info = connectivity.getAllNetworkInfo();
			if (info != null) 
				for (int i = 0; i < info.length; i++) 
					if (info[i].getState() == NetworkInfo.State.CONNECTED)
					{
						return true;
					}

		}
		return false;
	}

	/**
	 * Reads the input stream bytes and copy that to output stream. 
	 * @param is-- InputStream bytes
	 * @param os-- OutputStream bytes
	 */
	public static void CopyStream(InputStream is, OutputStream os)
	{
		final int buffer_size=1024;
		try
		{
			byte[] bytes=new byte[buffer_size];
			for(;;)
			{
				int count=is.read(bytes, 0, buffer_size);
				if(count==-1)
					break;
				os.write(bytes, 0, count);
			}
		}
		catch(Exception ex){}
	}
}
