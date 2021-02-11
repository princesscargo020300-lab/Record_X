package com.Recordx;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;
import java.util.zip.Inflater;

public class About extends Activity
{
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);
		
		}
		
	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		MenuInflater Inflater =getMenuInflater();
		Inflater.inflate(R.menu.menu,menu);
		return true;

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		switch (item.getItemId()){

			case R.id.about:
				Intent Intent0=new Intent(this,About.class);
				this.startActivity(Intent0);
			    return true;


			


			case R.id.logout:
				Intent Intent2=new Intent(this,MainActivity.class);
				this.startActivity(Intent2);
				Toast.makeText(getApplicationContext(), "Log out Successfuly",Toast.LENGTH_SHORT).show();
				return true;

		}

		return super.onOptionsItemSelected(item);


	}


}

	



