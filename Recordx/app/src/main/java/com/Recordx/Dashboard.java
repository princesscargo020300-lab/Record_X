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
import android.widget.TextView;
import android.widget.Toast;
import com.Recordx.MainActivity;
import java.util.zip.Inflater;



public class Dashboard extends Activity 
{
	SharedPreferences prf;
	
	Button ADD,UPDATE,REMOVE,LIST;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);
		
		
		
		ADD = (Button)findViewById(R.id.add);
		ADD.setOnClickListener(new View.OnClickListener(){
			
			@Override
			public void onClick(View view)
			{
				
				Intent intent = new  Intent(getBaseContext(), AddEmployee.class);
                startActivity(intent);
            
				
			}
			
		});
		
		
		UPDATE = (Button)findViewById(R.id.update);
		UPDATE.setOnClickListener(new View.OnClickListener(){

				@Override
				public void onClick(View view)
				{

					Intent intent = new  Intent(getBaseContext(), UpdateEmployee.class);
					startActivity(intent);


				}

			});
		
		
		
		
		
		
		REMOVE = (Button)findViewById(R.id.remove);
		REMOVE.setOnClickListener(new View.OnClickListener(){

				@Override
				public void onClick(View view)
				{

					Intent intent = new  Intent(getBaseContext(), RemoveEmployee.class);
					startActivity(intent);


				}

			});
    
		
		LIST = (Button)findViewById(R.id.listemp);
		LIST.setOnClickListener(new View.OnClickListener(){

				@Override
				public void onClick(View view)
				{

					Intent intent = new  Intent(getBaseContext(), ListEmployee.class);
					startActivity(intent);


				}

			});
			
			
	
					
//MENU

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

			//about
			case R.id.about:
				Intent Intent0=new Intent(this,About.class);
				this.startActivity(Intent0);
			    return true;
			
				
			//logout
			case R.id.logout:
				prf = getSharedPreferences("user_details",MODE_PRIVATE);
				SharedPreferences.Editor editor = prf.edit();
				editor.clear();
				editor.commit();
				Intent Intent2=new Intent(this,MainActivity.class);
				this.startActivity(Intent2);
				Toast.makeText(getApplicationContext(), "Log out Successfuly",Toast.LENGTH_SHORT).show();
				return true;

		}

		return super.onOptionsItemSelected(item);


	}


}

	





