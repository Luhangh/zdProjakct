package com.zdsoft.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class LoginActivity extends Activity  implements OnClickListener{
	
	private Button login_button,bottom_login_btn;
	
	private Intent intent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		  init();
		
	}
	
	private void init(){
		
		login_button=(Button)findViewById(R.id.login_button);
		bottom_login_btn=(Button)findViewById(R.id.bottom_login_btn);
		login_button.setOnClickListener(this);
		bottom_login_btn.setOnClickListener(this);
		
		
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		 switch (arg0.getId()) {
		case R.id.login_button :
			
			 intent=new  Intent(this,MainActivity.class);
			 startActivity(intent);
			
			break;
			
	  case R.id.bottom_login_btn:
		  
			 intent=new  Intent(this,MainActivity.class);
			 startActivity(intent);
			 
			break;
		default:
			break;
		}
		
		
	}
	
	

}
