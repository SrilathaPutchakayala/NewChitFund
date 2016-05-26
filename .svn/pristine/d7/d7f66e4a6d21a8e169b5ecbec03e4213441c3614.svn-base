/*************************************************************** 

Project Name : EasyChit

 **************************************************************** 

Class Name : UserApproveStatus

 Date : 6 June 2014

 Developer : Deepthi

 Description : To List the payment status details of a member for a chit
 **************************************************************** 

Change History : 

Date : 

Developer : 

Change : 
 

 ****************************************************************/
package com.newchitfund.androidclient;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.newchitfund.businessobjects.Chit;
import com.newchitfund.businessobjects.Paymentmodel;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Payment extends Activity {

	ImageView btn_paymentBackBtn;
	TextView tv_selectMonth;
	TextView tv_paymentheading;
	TextView tv_errormsg;
	ListView lv_paymentList;
	Spinner spn_selectMonthSpinner;
	ImageView ivPaymentHomeBtn;

	boolean tv_click = false;

	private int mYear, mMonth;
	String monthName;
	String selected_monthYear = null;
	ArrayList<String> monthSpinnerList = new ArrayList<String>();
	ArrayAdapter<String> monthSpinnerAdapter;

	ArrayList<Paymentmodel> payment_data = new ArrayList<Paymentmodel>();
	Chit chitDetails = new Chit();
	String chitStartDate, chitSelectedYear, chitSelectedMonth;
	Integer chitNoofMonths, chitId;
	PaymentList_Adapter mAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.payment);

		ivPaymentHomeBtn = (ImageView) findViewById(R.id.paymentHomeBtn);
		btn_paymentBackBtn = (ImageView) findViewById(R.id.paymentBackBtn);
		tv_selectMonth = (TextView) findViewById(R.id.selectMonth);
		tv_paymentheading = (TextView) findViewById(R.id.paymentheading);
		lv_paymentList = (ListView) findViewById(R.id.paymentList);
		tv_errormsg = (TextView) findViewById(R.id.tv_errormsg);
		spn_selectMonthSpinner = (Spinner) findViewById(R.id.selectMonthSpinner);

		tv_selectMonth.setTypeface(Typeface.createFromAsset(getAssets(),
				"fonts/Roboto-Light.ttf"));
		tv_paymentheading.setTypeface(Typeface.createFromAsset(getAssets(),
				"fonts/Roboto-Light.ttf"));
		tv_errormsg.setTypeface(Typeface.createFromAsset(getAssets(),
				"fonts/Roboto-Light.ttf"));

		Bundle bundle = getIntent().getExtras();
		if (bundle != null) {
			chitDetails = (Chit) bundle.getSerializable("chit");
		}

		// Assign current Date and Time Values to Variables
		final Calendar c = Calendar.getInstance();
		mYear = c.get(Calendar.YEAR);
		mMonth = c.get(Calendar.MONTH);

		chitStartDate = chitDetails.get_startDate(); // 2014-05
		chitNoofMonths = Integer.parseInt(chitDetails.get_noOfMonths());
		chitId = Integer.parseInt(chitDetails.get_chitID());
		String[] startDateSplit = chitStartDate.split("-");

		monthName = getMonthName(mMonth + 1);
		String currentspinnervalue = monthName + " " + mYear;
		tv_selectMonth.setText(currentspinnervalue); // current month and
		// year

		/* An asynchronous task to get the payment details */
		//Log.v("chitid", "fsdfs--" + chitId);
		new PaymentList(chitId, mYear, (mMonth + 1)).execute();

		/** Defining the ArrayAdapter to set items to Spinner Widget */
		monthSpinnerAdapter = new ArrayAdapter<String>(Payment.this,
				android.R.layout.simple_spinner_item, monthSpinnerList);
		spn_selectMonthSpinner.setAdapter(monthSpinnerAdapter);
		monthSpinnerAdapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		monthSpinnerList.clear();
		int tempMonth = Integer.parseInt(startDateSplit[1]); // start month
		int tempYear = Integer.parseInt(startDateSplit[0]); // start year
		// Log.v("chitid", "fsdfs--" + tempMonth + "sdf---" + tempYear);
		monthSpinnerList.clear();
		for (int i = 0; i < chitNoofMonths; i++) {
			if (tempMonth >= 13) {
				tempMonth = 1;
				tempYear++;
			}
			String monthName = getMonthName(tempMonth);
			monthSpinnerList.add(monthName + " " + tempYear);
			tempMonth++;
		}
		monthSpinnerAdapter.notifyDataSetChanged();

		int spinnerPosition = monthSpinnerAdapter.getPosition(currentspinnervalue);		
		// set the default according to value
		spn_selectMonthSpinner.setSelection(spinnerPosition);

		tv_selectMonth.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				spn_selectMonthSpinner.performClick();

			}
		});

		// kills the current activity and top stack activity will be called
		btn_paymentBackBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
				overridePendingTransition(R.anim.fadein, R.anim.fadeout);
			}
		});

		// kills the current activity and top stack activity will be called
		tv_paymentheading.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				 finish();
				 overridePendingTransition(R.anim.fadein, R.anim.fadeout);
			}
		});

		ivPaymentHomeBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent menu = new Intent(Payment.this, Categories.class);
				menu.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK
						| Intent.FLAG_ACTIVITY_CLEAR_TASK);
				startActivity(menu);
				finish();
				overridePendingTransition(R.anim.fadein, R.anim.fadeout);
			}
		});

		/*
		 * set spinner value to textview and load paylist of selected month &
		 * year
		 */
		spn_selectMonthSpinner
				.setOnItemSelectedListener(new OnItemSelectedListener() {
					@Override
					public void onItemSelected(AdapterView<?> parent,
							View view, int position, long id) {
						if (tv_click) {
							selected_monthYear = spn_selectMonthSpinner
									.getSelectedItem().toString();
							String[] selectedMonthYear = selected_monthYear
									.split(" ");
							chitSelectedMonth = getMonthInt(selectedMonthYear[0]);
							chitSelectedYear = selectedMonthYear[1];
							Log.v("selectedmont", selected_monthYear);
							tv_selectMonth.setText(selected_monthYear);
							new PaymentList(chitId, chitSelectedYear,
									chitSelectedMonth).execute();
						}
						tv_click = true;
					}

					@Override
					public void onNothingSelected(AdapterView<?> parent) {
						// TODO Auto-generated method stub
					}
				});
	}

	/* Method to get monthname by passing number as parameter */
	private String getMonthName(int tempMonth) {
		String retVal = null;
		switch (tempMonth) {
		case 1:
			retVal = "January";
			break;
		case 2:
			retVal = "February";
			break;
		case 3:
			retVal = "March";
			break;
		case 4:
			retVal = "April";
			break;
		case 5:
			retVal = "May";
			break;
		case 6:
			retVal = "June";
			break;
		case 7:
			retVal = "July";
			break;
		case 8:
			retVal = "August";
			break;
		case 9:
			retVal = "September";
			break;
		case 10:
			retVal = "October";
			break;
		case 11:
			retVal = "November";
			break;
		case 12:
			retVal = "December";
			break;
		}

		return retVal;
	}
	
	/* Method to get month number by passing monthname as parameter */
	private String getMonthInt(String abc) {
		
		String retval = "0";
		
		/*Calendar cal = Calendar.getInstance();
		try {
			cal.setTime(new SimpleDateFormat("MMM").parse(abc));
			int monthInt = cal.get(Calendar.MONTH) + 1;
			retval = Integer.toString(monthInt);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/				
		
		if (abc.equals("January")) {
			retval = "01";
		} else if (abc.equals("February")) {
			retval = "02";
		} else if (abc.equals("March")) {
			retval = "03";
		} else if (abc.equals("April")) {
			retval = "04";
		} else if (abc.equals("May")) {
			retval = "05";
		} else if (abc.equals("June")) {
			retval = "06";
		} else if (abc.equals("July")) {
			retval = "07";
		} else if (abc.equals("August")) {
			retval = "08";
		} else if (abc.equals("September")) {
			retval = "09";
		} else if (abc.equals("October")) {
			retval = "10";
		} else if (abc.equals("November")) {
			retval = "11";
		} else if (abc.equals("December")) {
			retval = "12";
		}
		return retval;
	}

	/**
	 * Class Name : paymentList Purpose : To get data from service in background
	 * and show them in listview
	 */
	class PaymentList extends AsyncTask<Void, Void, Void> {
		private String Error = null;
		ProgressDialog pd;
		String res;
		String chitId, year, month;
		String mStatus, mMessage;
		Boolean checkNet;

		public PaymentList(Integer chitId, String year, String month) {
			// TODO Auto-generated constructor stub
			this.chitId = chitId.toString();
			this.year = year;
			this.month = month;
		}

		public PaymentList(Integer chitId, int mYear, int month) {
			// TODO Auto-generated constructor stub
			this.chitId = chitId.toString();
			this.year = String.valueOf(mYear);
			this.month = String.valueOf(month);
			chitSelectedMonth = this.month;
			chitSelectedYear = this.year;
		}

		@Override
		protected void onPreExecute() {

			pd = new ProgressDialog(Payment.this);
			pd.setIndeterminate(true);
			pd.setMessage("Loading payment details, Please wait..");
			pd.setCancelable(false);
			pd.show();
			super.onPreExecute();
		}

		@Override
		protected Void doInBackground(Void... params) {
			try {
				checkNet = Utils.isInternetAvailable(Payment.this);

				if (checkNet) {
					String URL = getResources().getString(R.string.URL);
					String adminID = getResources().getString(R.string.adminID);

					HttpClient client = new DefaultHttpClient();
					HttpPost post = new HttpPost(URL);
					MultipartEntity multiEntity = new MultipartEntity();

					//Log.v("id--month --year", this.chitId + "---" + this.month+ "--" + this.year);
					multiEntity.addPart("call", new StringBody("getPaymentStatusList"));
					multiEntity.addPart("adminID", new StringBody(adminID));
					multiEntity.addPart("chitID", new StringBody(this.chitId));
					multiEntity.addPart("month", new StringBody(this.month));
					multiEntity.addPart("year", new StringBody(this.year));
					post.setEntity(multiEntity);

					HttpResponse response = client.execute(post);
					res = EntityUtils.toString(response.getEntity());

					//Log.v("responce", "Response===" + res.toString());
					JSONObject json1 = new JSONObject(res);

					mStatus = json1.getString("Status");
					mMessage = json1.getString("Message");
				}

			} catch (Exception e) {
				Error = e.getMessage();
				e.printStackTrace();
			}
			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			if (pd.isShowing()) {
				if (!checkNet) {
					pd.dismiss();
					Toast.makeText(Payment.this,"Please check network connection",Toast.LENGTH_SHORT).show();
					return;
				}
				if (Error != null) {
					Toast.makeText(getApplicationContext(), Error,Toast.LENGTH_SHORT).show();
					Intent moveToViewChits = new Intent(Payment.this,ViewChits.class);
					startActivity(moveToViewChits);
					finish();
					overridePendingTransition(R.anim.fadein, R.anim.fadeout);
				} else if (mStatus.equalsIgnoreCase("Error")) {
					tv_errormsg.setText(mMessage);
					tv_errormsg.setVisibility(View.VISIBLE);
					lv_paymentList.setVisibility(View.INVISIBLE);
				} else {
					try {
						tv_errormsg.setVisibility(View.INVISIBLE);
						lv_paymentList.setVisibility(View.VISIBLE);
						payment_data.clear();
						JSONObject json = new JSONObject(res);
						JSONArray jsonArray = json.getJSONArray("Result");
						for (int i = 0; i < jsonArray.length(); i++) {
							JSONObject resultObj = jsonArray.getJSONObject(i);
							Paymentmodel payment = new Paymentmodel();

							payment.set_memberName(resultObj
									.getString("memberName"));
							payment.set_amount(resultObj.getString("amount"));
							payment.set_paymentStatus(resultObj
									.getString("paymentStatus"));
							payment.set_chitPaymentID(resultObj
									.getString("chitPaymentID"));
							payment.set_isOwner(resultObj.getString("isOwner"));

							payment_data.add(payment);

						}
					} catch (Exception e) {
						// TODO: handle exception
					}

					mAdapter = new PaymentList_Adapter(Payment.this,R.layout.paymentrow, payment_data);
					lv_paymentList.setAdapter(mAdapter);
					mAdapter.notifyDataSetChanged();

				}
				pd.dismiss();
			}
			super.onPostExecute(result);
		}
	}

	public class PaymentList_Adapter extends ArrayAdapter<Paymentmodel> {
		Activity activity;
		int layoutResourceId;
		Paymentmodel payment;
		ArrayList<Paymentmodel> data = new ArrayList<Paymentmodel>();

		public PaymentList_Adapter(Activity act, int layoutResourceId,
				ArrayList<Paymentmodel> data) {
			super(act, layoutResourceId, data);
			this.layoutResourceId = layoutResourceId;
			this.activity = act;
			this.data = data;
			notifyDataSetChanged();
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View row = convertView;
			PaymentHolder holder = null;

			if (row == null) {
				LayoutInflater inflater = LayoutInflater.from(activity);

				row = inflater.inflate(layoutResourceId, parent, false);
				holder = new PaymentHolder();
				holder.tv_paymentmemberandmonthname = (TextView) row.findViewById(R.id.paymentmemberandmonthname);
				holder.tv_payment_amount = (TextView) row.findViewById(R.id.payment_amount);
				holder.btn_paybutton = (ImageView) row.findViewById(R.id.paybutton);
				holder.btn_paidbutton = (ImageView) row.findViewById(R.id.paidbutton);
				row.setTag(holder);

			} else {
				holder = (PaymentHolder) row.getTag();
			}
			payment = data.get(position);
			if(payment.get_isOwner().equals("Yes")){
			holder.tv_paymentmemberandmonthname.setText(payment.get_memberName()+" (Owner)");
			}else{
				holder.tv_paymentmemberandmonthname.setText(payment.get_memberName());
			}
			Resources res = getResources();
			holder.tv_payment_amount.setText(res.getString(R.string.Rupee) + payment.get_amount());
			View rowdivider = (View) row.findViewById(R.id.rowdivider);
			if ((data.size() - 1) == position) {

				rowdivider.setVisibility(View.GONE);
			} else {
				rowdivider.setVisibility(View.VISIBLE);
			}

			if (payment.get_paymentStatus().equalsIgnoreCase("PENDING")) {
				holder.btn_paybutton.setVisibility(View.VISIBLE);
				holder.btn_paybutton.setTag(position);
				holder.btn_paidbutton.setVisibility(View.INVISIBLE);

			} else if (payment.get_paymentStatus().equalsIgnoreCase("CLEARED")) {
				holder.btn_paybutton.setVisibility(View.INVISIBLE);
				holder.btn_paidbutton.setVisibility(View.VISIBLE);
			}

			/*Pay button click to change payment status*/
			holder.btn_paybutton.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					final Integer paymentPosition = Integer.parseInt(v.getTag().toString());
									
					AlertDialog.Builder adb = new AlertDialog.Builder(
							Payment.this);
					adb.setTitle(null);
					adb.setMessage("Do you want to change the payment status of "+payment_data.get(paymentPosition).get_memberName() +"?");
					adb.setNegativeButton("No",
							new AlertDialog.OnClickListener() {
								@Override
								public void onClick(DialogInterface dialog,
										int which) {
									mAdapter.notifyDataSetChanged();
								}
							});
					adb.setPositiveButton("Yes",
							new AlertDialog.OnClickListener() {

								@Override
								public void onClick(DialogInterface dialog,
										int which) {
									new MakePaymentAsynTask(paymentPosition)
											.execute();
								}
							});
					adb.show();
				}
			});
			return row;

		}

		class PaymentHolder {
			ImageView btn_paybutton;
			ImageView btn_paidbutton;
			TextView tv_paymentmemberandmonthname;
			TextView tv_payment_amount;
		}

	}

	/**
	 * Class Name : MakePaymentAsynTask Purpose : Class to change payment status
	 * background
	 */
	class MakePaymentAsynTask extends AsyncTask<Void, Void, String> {
		ProgressDialog pd;

		String mStatus, mMessage;
		Integer chitPaymentPosition;
		Boolean checkNet;

		@Override
		protected void onPreExecute() {
			pd = new ProgressDialog(Payment.this);
			pd.setIndeterminate(true);
			pd.setMessage("Payment Status changing...");
			pd.setCancelable(false);
			pd.show();
			super.onPreExecute();
		}

		public MakePaymentAsynTask(Integer chitPaymentPosition) {
			// TODO Auto-generated method stub
			this.chitPaymentPosition = chitPaymentPosition;
			Log.v("chitpaymentId",""+ this.chitPaymentPosition);
		}

		@Override
		protected String doInBackground(Void... params) {

			try {
				checkNet = Utils.isInternetAvailable(Payment.this);
				String chitPaymentId = payment_data.get(this.chitPaymentPosition).get_chitPaymentID();

				if (checkNet) {
					String URL = getResources().getString(R.string.URL);

					HttpClient client = new DefaultHttpClient();
					HttpPost post = new HttpPost(URL);
					MultipartEntity multiEntity = new MultipartEntity();

					multiEntity.addPart("call", new StringBody(
							"approveChitPayment"));
					multiEntity.addPart("chitPaymentID", new StringBody(
							chitPaymentId));

					post.setEntity(multiEntity);
					HttpResponse response = client.execute(post);
					String res = EntityUtils.toString(response.getEntity());

					Log.v("responce", "Response===" + res);
					JSONObject json1 = new JSONObject(res);

					mStatus = json1.getString("Status");
					mMessage = json1.getString("Message");
				}

			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}

		@Override
		protected void onPostExecute(String result) {
			if (pd.isShowing()) {
				if (!checkNet) {
					pd.dismiss();
					Toast.makeText(Payment.this,
							"Please check network connection",
							Toast.LENGTH_SHORT).show();
					return;
				}
				if (mStatus.equalsIgnoreCase("success")) {
					Toast.makeText(getApplicationContext(),
							"Payment status changed successfully",
							Toast.LENGTH_LONG).show();

					payment_data.get(this.chitPaymentPosition).set_paymentStatus("CLEARED");
					//new PaymentList(chitId, chitSelectedYear, chitSelectedMonth).execute();
					mAdapter.notifyDataSetChanged();

				} else {
					Toast.makeText(getApplicationContext(), mMessage,
							Toast.LENGTH_LONG).show();
				}
				pd.dismiss();
			}
			super.onPostExecute(result);
		}
	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		
		finish();
		overridePendingTransition(R.anim.fadein, R.anim.fadeout);
	}

}
