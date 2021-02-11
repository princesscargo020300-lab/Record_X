package com.Recordx;


import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;
import java.util.zip.Inflater; 

public class ListEmployee extends Activity { 




	@Override 
    protected void onCreate(Bundle savedInstanceState) { 
        super.onCreate(savedInstanceState); 
		setContentView(R.layout.listemployee); 

		TextView textView = findViewById(R.id.view_data); 

		DbHelper db = new DbHelper(this); 

		String data = db.getEmployee(); 
		textView.setText(data); 
		textView.setMovementMethod(new ScrollingMovementMethod()); 


	}


}




