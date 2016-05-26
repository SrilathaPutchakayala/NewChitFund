package com.newchitfund.androidclient;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.google.android.gcm.GCMBaseIntentService;
import com.google.android.gcm.GCMRegistrar;

public class GCMIntentService extends GCMBaseIntentService {
	
	public GCMIntentService() {
		// Call extended class Constructor GCMBaseIntentService
		super(Login.SENDER_ID);
	}

	@Override
	protected void onError(Context context, String arg1) {
		// TODO Auto-generated method stub
	}

	@Override
	protected void onMessage(Context context, Intent messageIntent) {
		String message = messageIntent.getExtras().getString("message");//sucess
		Log.v(TAG,"onMessage===="+message);
		generateNotification(context, message);
	}

	@Override
	protected void onRegistered(Context context, String arg1) {
		GCMRegistrar.setRegisteredOnServer(context, true);
	}

	@Override
	protected void onUnregistered(Context context, String arg1) {
		GCMRegistrar.setRegisteredOnServer(context, false);
	}

	
	private static void generateNotification(Context context, String message) {
		int icon = R.drawable.app_icon;
		long when = System.currentTimeMillis();
		NotificationManager notificationManager = (NotificationManager) context
				.getSystemService(Context.NOTIFICATION_SERVICE);
		Notification notification = new Notification(icon, message, when);
		String title = context.getString(R.string.app_name);

		/*ActivityManager am = (ActivityManager) context.getSystemService(ACTIVITY_SERVICE);
		List<RunningTaskInfo> taskInfo = am.getRunningTasks(1);
		ComponentName componentInfo = taskInfo.get(0).topActivity;
		Log.d("CURRENT Activity ::" , taskInfo.get(0).topActivity.getClassName()+"   Package Name :  "+componentInfo.getPackageName());
		Intent notificationIntent;
		if(componentInfo.getClassName().contains("Launcher"))
		{
			notificationIntent = new Intent(context, Categories.class);
		}
		else
		{
			notificationIntent = new Intent(context, componentInfo.getClass());
		}*/
		
		Intent notificationIntent;
		notificationIntent = new Intent(context, ViewChits.class);
		notificationIntent.putExtra("NOTIFICATION", message);
		notificationIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
		
		PendingIntent intent =  PendingIntent.getActivity(context.getApplicationContext(), (int)(Math.random() * 100), notificationIntent,PendingIntent.FLAG_UPDATE_CURRENT);
		notification.setLatestEventInfo(context, title, message, intent);
		notification.flags |= Notification.FLAG_AUTO_CANCEL;
		notification.defaults |= Notification.DEFAULT_SOUND;
		notification.defaults |= Notification.DEFAULT_VIBRATE;
		notificationManager.notify((int)(Math.random() * 100), notification);
	}
}
