package com.Recordx;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;
import java.util.Calendar; 

public class AddEmployee extends Activity implements View.OnClickListener { 

	DbHelper db; 

	EditText LASTNAME ,FIRSTNNAME ,DATE,CURRENTADDRESS,PERMANENTADDRESS,HIGHESTDEGREE,DESIGNATION,CONTACT; 
	Button buttonInsert, buttonView, buttonDelete,buttonUpdate, buttonSearch; 

	String id; 
	String lname; 
	String fname; 
	String date; 
	String currentaddress; 
	String permanentaddress;
	String highestdegree; 
	String designation; 
	String contact; 



	DatePickerDialog DATEPICKER;

	@Override 
	protected void onCreate(Bundle savedInstanceState) { 
		super.onCreate(savedInstanceState); 
        setContentView(R.layout.addemployee); 


		LASTNAME= findViewById(R.id.lname); 
		FIRSTNNAME = findViewById(R.id.fname); 
		DATE = findViewById(R.id.date); 
		CURRENTADDRESS = findViewById(R.id.caddress); 
		PERMANENTADDRESS = findViewById(R.id.paddress); 
		HIGHESTDEGREE = findViewById(R.id.highestdegree); 
		DESIGNATION = findViewById(R.id.designation); 
		CONTACT = findViewById(R.id.contact); 


		//Date
		final Calendar calendar = Calendar.getInstance();
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		int month = calendar.get(Calendar.MONTH);
		int year = calendar.get(Calendar.YEAR);


		DATEPICKER = new DatePickerDialog(AddEmployee.this,
			new DatePickerDialog.OnDateSetListener() {
				@Override
				public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
					DATE.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
				}
			}, year, month, day);
		DATEPICKER.show();





		buttonInsert = findViewById(R.id.button_add); 
		buttonInsert.setOnClickListener(this); 
		db=new DbHelper(this); 
	} 

	@Override 
	public void onClick(View v) { 

		switch (v.getId()){ 

			case R.id.button_add: 
				lname=LASTNAME.getText().toString(); 
				fname=FIRSTNNAME.getText().toString(); 
				date=DATE.getText().toString(); 
				currentaddress=CURRENTADDRESS.getText().toString(); 
				permanentaddress=PERMANENTADDRESS.getText().toString(); 
				highestdegree=HIGHESTDEGREE.getText().toString(); 
				designation=DESIGNATION.getText().toString(); 
				contact=CONTACT.getText().toString(); 



				if(lname.equals("") | fname.equals("") | date.equals("") | currentaddress.equals("")  | permanentaddress.equals("") | highestdegree.equals("") | designation.equals("") | contact.equals("")){ 
					Toast.makeText(this, "Please fill the Fields", Toast.LENGTH_SHORT).show(); 
                }else { 
					db.insertemployee(lname,fname,date,currentaddress,permanentaddress,highestdegree,designation,contact); 
					LASTNAME.setText(""); 
					FIRSTNNAME.setText(""); 
					DATE.setText(""); 
					CURRENTADDRESS.setText(""); 
					PERMANENTADDRESS.setText(""); 
					HIGHESTDEGREE.setText(""); 
					DESIGNATION.setText(""); 
					CONTACT.setText(""); 
					Toast.makeText(this, "Insert successfully", Toast.LENGTH_SHORT).show(); 
				} 
				break; 



		} 
	}
} 


