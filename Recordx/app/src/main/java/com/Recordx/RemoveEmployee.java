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

public class RemoveEmployee extends Activity implements View.OnClickListener { 

	DbHelper db; 


	EditText ID;
	Button DELETE; 

	String id; 


	@Override 
	protected void onCreate(Bundle savedInstanceState) { 
		super.onCreate(savedInstanceState); 
        setContentView(R.layout.removeemployee); 

		ID = findViewById(R.id.edit_id); 
		DELETE = findViewById(R.id.button_delete); 
		DELETE.setOnClickListener(this); 


		db=new DbHelper(this); 
	} 

	@Override 
	public void onClick(View v) { 

		switch (v.getId()){ 


			case R.id.button_delete: 
				id = ID.getText().toString(); 
				if(id.equals("")){ 
					Toast.makeText(this, "Plase fill the Id", Toast.LENGTH_SHORT).show(); 
				}else{ 
					long l = Long.parseLong(id); 
					db.deleteemployee(l); 
					ID.setText(""); 

					Toast.makeText(this, "deleted successfully", Toast.LENGTH_SHORT).show(); 

				}

		} 



	}

}





