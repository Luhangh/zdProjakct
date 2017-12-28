package com.ludvk.activity;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ludvk.bean.NotesBean;
import com.ludvk.database.DatabaseHelper;
import com.ludvk.database.DatabaseUtils;
import com.ludvk.utils.StringUtil;

public class AddNotesActivity extends Activity implements OnClickListener{
	
	private EditText notes_title,notes_content;
	
	private Button finish_btn,notes_black,notes_time;
	
	private NotesBean bean;
	
	private DatabaseUtils database;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_notes);
		init();
	}
    
	private void init(){
		
		notes_title=(EditText)findViewById(R.id.notes_title);
		
		notes_content=(EditText)findViewById(R.id.notes_content);
		
		finish_btn=(Button)findViewById(R.id.finish_btn);
		finish_btn.setOnClickListener(this);
		
		notes_black=(Button)findViewById(R.id.notes_black);
		notes_black.setOnClickListener(this);
		
		notes_time=(Button)findViewById(R.id.notes_time);
		notes_time.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.finish_btn:
			bean=new NotesBean();
			if(StringUtil.isBlank(notes_title.getText().toString().trim())){
				Toast.makeText(getApplicationContext(), "请输入标题!", Toast.LENGTH_SHORT).show();
				return;
			}
			if(StringUtil.isBlank(notes_content.getText().toString().trim())){
				Toast.makeText(getApplicationContext(), "请输入内容!",  Toast.LENGTH_SHORT).show();
				return;
			}
			bean.setTitel(notes_title.getText().toString().trim());
			bean.setContent(notes_content.getText().toString().trim());
			database=new DatabaseUtils(getApplicationContext(), DatabaseHelper.NOTES, null, null);
			database.insertNotes(bean);
			finish();
			
			break;
		case R.id.notes_black:
			
			notes_content.setText(null);
					
					break;
		case R.id.notes_time:
			SimpleDateFormat    formatter    =   new    SimpleDateFormat    ("yyyy年MM月dd日");

			Date    curDate    =   new    Date(System.currentTimeMillis());     
			String    str    =    formatter.format(curDate);      
			String content=notes_content.getText().toString();
			notes_content.setText(content+""+str);
			break;

		default:
			break;
		}
		
	}
	
}
