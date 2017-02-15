package com.zdsoft.activity;
import com.zdsoft.bean.NotesBean;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class NotesInfoActivity extends Activity implements OnClickListener{
	
	private TextView  textview_notes_title , textview_notes_content;
	
	private Button  finish_btn;
	
	private Intent intent;
	
	private NotesBean bean;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_notes_info);
		
		init();
	}
   
	
	private void init(){
		
		intent=getIntent();
		
		bean=(NotesBean) intent.getSerializableExtra("date");
		
		textview_notes_title=(TextView)findViewById(R.id.textview_notes_title);
		
		textview_notes_content=(TextView)findViewById(R.id.textview_notes_content);
		
		textview_notes_title.setText(bean.getTitel());
		
		textview_notes_content.setText(bean.getContent());
		
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.finish_btn:
			finish();
			break;

		default:
			break;
		}
		
	}

}
