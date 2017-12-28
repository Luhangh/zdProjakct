package com.ludvk.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.ludvk.adapter.customadapter;
import com.ludvk.bean.custombean;

import java.util.List;

public class custominfoActivity extends Activity implements OnClickListener{
	
	private custombean bean;
	private customadapter adapter;
	private List<custombean> devList;
	private ListView listview;
	private TextView back;
	private TextView cent;
	private TextView right;
	private Intent intent;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.custominfo);
		init();
	}
    
	private void init(){
		
		listview =(ListView) findViewById(R.id.list_custom);
		back =(TextView) findViewById(R.id.backCard);
		cent =(TextView) findViewById(R.id.text_cent);
		cent.setText("列表");
		back.setOnClickListener(this);
		right =(TextView) findViewById(R.id.sm);
		intent =getIntent();
		devList =intent.getParcelableArrayListExtra("custom");
		adapter =new customadapter(devList, custominfoActivity.this);
		listview.setAdapter(adapter);
		listview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				// TODO Auto-generated method stub
				Toast.makeText(custominfoActivity.this, "", Toast.LENGTH_SHORT).show();
			}
		});
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
	
		case R.id.backCard:
			
				finish();	
					break;
		case R.id.text_cent:
			
			
			break;
		case R.id.sm:
			
			
			break;


		default:
			break;
		}
		
	}
}
