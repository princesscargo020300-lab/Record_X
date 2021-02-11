    package com.Recordx;

	import android.app.Activity;
	import android.content.Intent;
	import android.content.SharedPreferences;
	import android.os.Bundle;
	import android.view.View;
	import android.widget.Button;
	import android.widget.EditText;
	import android.widget.Toast;

	public class MainActivity extends Activity 
	{
	EditText user, pass;
    Button loginBtn;
    SharedPreferences pref;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);


		//main.xml id
        user = (EditText)findViewById(R.id.username);
        pass = (EditText)findViewById(R.id.password);
        loginBtn = (Button)findViewById(R.id.btnlogin);


		//sharedpreferences
        pref = getSharedPreferences("user_details",MODE_PRIVATE);
        intent = new Intent(MainActivity.this,Dashboard.class);
        if(pref.contains("username") && pref.contains("password")){
         startActivity(intent);
        }
        loginBtn.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					String username = user.getText().toString();
					String password = pass.getText().toString();
					if(username.equals("admin") && password.equals("admin666")){
						SharedPreferences.Editor editor = pref.edit();
						editor.putString("username",username);
						editor.putString("password",password);
						editor.commit();
						Toast.makeText(getApplicationContext(), "Welcome to Dashboard pannel",Toast.LENGTH_SHORT).show();
						startActivity(intent);
					}
					else 
					{
						//Toask
						Toast.makeText(getApplicationContext(),"Invalid Username or Password",Toast.LENGTH_SHORT).show();
					}
				}
			});

    }
}
