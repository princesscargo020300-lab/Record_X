package com.Recordx;



import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.zip.Inflater; 

public class UpdateEmployee extends Activity implements View.OnClickListener { 

	DbHelper db; 


	EditText ID ,LASTNAME,FIRSTNAME,DATE,CURRENTADDRESS,PERMANENTADDRESS,HIGHESTDEGREES,DESIGNATIONS,CONTACTS; 
	Button buttonUpdate, buttonSearch; 

	String id; 
	String lname; 
	String fname; 
	String date; 
	String curaddress; 
	String peraddress; 
	String highdeg; 
	String designation; 
	String contact; 



	@Override 
	protected void onCreate(Bundle savedInstanceState) { 
		super.onCreate(savedInstanceState); 
        setContentView(R.layout.updateemployee); 

		ID = findViewById(R.id.id); 
		LASTNAME = findViewById(R.id.lname); 
		FIRSTNAME = findViewById(R.id.fname); 
	    DATE = findViewById(R.id.date); 
		CURRENTADDRESS = findViewById(R.id.currentaddress); 
	    PERMANENTADDRESS = findViewById(R.id.permanentaddress); 
		HIGHESTDEGREES = findViewById(R.id.highdeg); 
		DESIGNATIONS = findViewById(R.id.designations); 
	    CONTACTS = findViewById(R.id.contacts); 



		buttonUpdate = findViewById(R.id.update); 
		buttonSearch = findViewById(R.id.search); 
		buttonUpdate.setOnClickListener(this); 
		buttonSearch.setOnClickListener(this); 

		db=new DbHelper(this); 
	} 

	@Override 
	public void onClick(View v) { 

		switch (v.getId()){ 

			case R.id.update: 
				id=ID.getText().toString().trim(); 
				lname=LASTNAME.getText().toString(); 
				fname=FIRSTNAME.getText().toString(); 
				date=DATE.getText().toString();
				curaddress=CURRENTADDRESS.getText().toString(); 
				peraddress=PERMANENTADDRESS.getText().toString(); 
				highdeg=HIGHESTDEGREES.getText().toString();
				designation=DESIGNATIONS.getText().toString(); 
				contact=CONTACTS.getText().toString(); 

				ID.setText(""); 
				LASTNAME.setText(""); 
				FIRSTNAME.setText(""); 
				DATE.setText(""); 
				CURRENTADDRESS.setText(""); 
				PERMANENTADDRESS.setText(""); 
				HIGHESTDEGREES.setText(""); 
				DESIGNATIONS.setText(""); 
				CONTACTS.setText(""); 


				if(id.equals("") | lname.equals("") | fname.equals("") | date.equals("") | curaddress.equals("") | peraddress.equals("") | highdeg.equals("") | designation.equals("") | contact.equals("")){ 
					Toast.makeText(this, "Please fill all the fields", Toast.LENGTH_SHORT).show(); 
				}else { 
					long l= Long.parseLong(id); 
					db.updateemployee(l,lname,fname,date,curaddress,peraddress,highdeg,designation,contact); 

					Toast.makeText(this, "Updated successfully", Toast.LENGTH_SHORT).show(); 
				} 
                break; 
			case R.id.search: 
                id=ID.getText().toString().trim(); 
                if(id.equals("")){ 
					Toast.makeText(this, "Please Fill the Id", Toast.LENGTH_SHORT).show(); 
				}else { 
					try { 
						long l1= Long.parseLong(id); 
						lname=db.Lastname(l1); 
                        fname=db.Firstname(l1); 
						date=db.Date(l1); 
						curaddress=db.Currentaddress(l1); 
						peraddress=db.Permanentaddress(l1);
						highdeg=db.Highestdeg(l1); 
						designation=db.Designation(l1); 
						contact=db.Contact(l1);

						LASTNAME.setText(lname); 
						FIRSTNAME.setText(fname); 
						DATE.setText(date); 
						CURRENTADDRESS.setText(curaddress); 
						PERMANENTADDRESS.setText(peraddress);
						HIGHESTDEGREES.setText(highdeg); 
					    DESIGNATIONS.setText(designation); 
						CONTACTS.setText(contact);





						Toast.makeText(this, "Searched successfully", Toast.LENGTH_SHORT).show(); 

					} 
					catch (Exception e) 
                    { 
						Toast.makeText(this, "Id is not Available", Toast.LENGTH_SHORT).show(); 
						LASTNAME.setText(""); 
					    FIRSTNAME.setText(""); 
					    DATE.setText(""); 
					    CURRENTADDRESS.setText(""); 
					    PERMANENTADDRESS.setText(""); 
					    HIGHESTDEGREES.setText(""); 
					    DESIGNATIONS.setText(""); 
					    CONTACTS.setText(""); 
					}   
                } 
				break; 
		} 


	}


}





