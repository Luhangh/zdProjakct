package com.zdsoft.activity;

import com.zdsoft.database.DatabaseHelper;
import com.zdsoft.database.DatabaseUtils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class TransferAccountsActivity extends Activity implements OnClickListener{
	
	private TextView result_num;
     
	private Button btn_one, btn_two, btn_three, btn_four, btn_five, btn_six,
	    btn_seven, btn_eight, btn_nine, btn_ac, btn_zero, btn_spot, btn_ok, btn_del, btn_add;
	
	private boolean isClicked = false;

	private double input1 = 0, input2 = 0, result = 0;
	
	private static final int OUT=1;
	
	private static final int INTO=2;
	
	private RelativeLayout relative_out_btn,relative_into_btn;
	
	private TextView text_out,text_into;
	
	private Intent intent;
	
	private  Button back_btn;
	
	private String out_id="",into_id="";
	
	private DatabaseUtils database;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activty_transfer_accounts);
		
		init();
	}
	
	private void init(){
		result_num = (TextView) findViewById(R.id.result_num);

		btn_one = (Button) findViewById(R.id.btn_one);
		btn_one.setOnClickListener(this);

		btn_two = (Button) findViewById(R.id.btn_two);
		btn_two.setOnClickListener(this);

		btn_three = (Button) findViewById(R.id.btn_three);
		btn_three.setOnClickListener(this);

		btn_four = (Button) findViewById(R.id.btn_four);
		btn_four.setOnClickListener(this);

		btn_five = (Button) findViewById(R.id.btn_five);
		btn_five.setOnClickListener(this);

		btn_six = (Button) findViewById(R.id.btn_six);
		btn_six.setOnClickListener(this);

		btn_seven = (Button) findViewById(R.id.btn_seven);
		btn_seven.setOnClickListener(this);

		btn_eight = (Button) findViewById(R.id.btn_eight);
		btn_eight.setOnClickListener(this);

		btn_nine = (Button) findViewById(R.id.btn_nine);
		btn_nine.setOnClickListener(this);

		btn_ac = (Button) findViewById(R.id.btn_ac);
		btn_ac.setOnClickListener(this);

		btn_zero = (Button) findViewById(R.id.btn_zero);
		btn_zero.setOnClickListener(this);

		btn_spot = (Button) findViewById(R.id.btn_spot);
		btn_spot.setOnClickListener(this);

		btn_ok = (Button) findViewById(R.id.btn_ok);
		btn_ok.setOnClickListener(this);

		btn_del = (Button) findViewById(R.id.btn_del);
		btn_del.setOnClickListener(this);

		btn_add = (Button) findViewById(R.id.btn_add);
		btn_add.setOnClickListener(this);
		
		relative_out_btn= (RelativeLayout) findViewById(R.id.relative_out_btn);
		relative_out_btn.setOnClickListener(this);
		
		relative_into_btn= (RelativeLayout) findViewById(R.id.relative_into_btn);
		relative_into_btn.setOnClickListener(this);
		
		text_out= (TextView) findViewById(R.id.text_out);
		
		text_into= (TextView) findViewById(R.id.text_into);
		
		back_btn=(Button)findViewById(R.id.back_btn);
	    back_btn.setOnClickListener(this);
		
	}
	
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if(data==null){
			return;
		}
		switch (requestCode) {
		case OUT:
			String str_name = data.getStringExtra("name");
			out_id=data.getStringExtra("id");
			text_out.setText(str_name);
			break;
		case INTO:
			String str_names = data.getStringExtra("name");
	        into_id=data.getStringExtra("id");
			text_into.setText(str_names);
				break;

		default:
			break;
		}
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btn_one:
			if (isClicked) {
				result_num.setText(null);
				isClicked = false;
			}

			String str_1 = result_num.getText().toString();
			str_1 += "1";
			result_num.setText(str_1);
			break;
		case R.id.btn_two:
			if (isClicked) {
				result_num.setText(null);
				isClicked = false;
			}

			String str_2 = result_num.getText().toString();
			str_2 += "2";
			result_num.setText(str_2);

			break;
		case R.id.btn_three:
			if (isClicked) {
				result_num.setText(null);
				isClicked = false;
			}

			String str_3 = result_num.getText().toString();
			str_3 += "3";
			result_num.setText(str_3);

			break;
		case R.id.btn_four:
			if (isClicked) {
				result_num.setText(null);
				isClicked = false;
			}

			String str_4 = result_num.getText().toString();
			str_4 += "4";
			result_num.setText(str_4);

			break;
		case R.id.btn_five:
			if (isClicked) {
				result_num.setText(null);
				isClicked = false;
			}

			String str_5 = result_num.getText().toString();
			str_5 += "5";
			result_num.setText(str_5);

			break;
		case R.id.btn_six:
			if (isClicked) {
				result_num.setText(null);
				isClicked = false;
			}

			String str_6 = result_num.getText().toString();
			str_6 += "6";
			result_num.setText(str_6);

			break;
		case R.id.btn_seven:
			if (isClicked) {
				result_num.setText(null);
				isClicked = false;
			}

			String str_7 = result_num.getText().toString();
			str_7 += "7";
			result_num.setText(str_7);

			break;
		case R.id.btn_eight:
			if (isClicked) {
				result_num.setText(null);
				isClicked = false;
			}

			String str_8 = result_num.getText().toString();
			str_8 += "8";
			result_num.setText(str_8);

			break;
		case R.id.btn_nine:
			if (isClicked) {
				result_num.setText(null);
				isClicked = false;
			}

			String str_9 = result_num.getText().toString();
			str_9 += "9";
			result_num.setText(str_9);

			break;
		case R.id.btn_ac:
			result_num.setText(null);
			break;
		case R.id.btn_zero:
			String str_0 = result_num.getText().toString();
			str_0 += "0";
			result_num.setText(str_0);

			break;
		case R.id.btn_spot:
			if (isClicked) {
				result_num.setText(null);
				isClicked = false;
			}
			String str_point = result_num.getText().toString();
			str_point += ".";
			result_num.setText(str_point);
			break;
		case R.id.btn_ok:
			String myStringEqu = result_num.getText().toString();
			if (myStringEqu.equals(null) || myStringEqu.equals("")) {
				return;
			}
			input2 = Double.valueOf(myStringEqu);
			result_num.setText(null);
			result = input1 + input2;
			result_num.setText(Double.toString(result));
			isClicked = true;
			input1 = 0;
			input2 = 0;
			if(out_id.equals("")||into_id.equals("")){				
				return;
			}
			database=new DatabaseUtils(getApplicationContext(), DatabaseHelper.ACCOUNT_TYPE, null, null);
			long l=database.Intout(out_id, into_id, result_num.getText().toString());
			if(l>0){
				Toast.makeText(getApplicationContext(), "转账成功", 500).show();
				finish();
			}else{
				Toast.makeText(getApplicationContext(), "转账失败", 500).show();
			}
			break;
		case R.id.btn_add:
			if (result_num.getText().toString().equals(null)) {
				return;
			}
			input1 = Double.parseDouble(result_num.getText().toString());
			result_num.setText(null);
			isClicked = false;
			break;
		case R.id.btn_del:

			String str = result_num.getText().toString();
			try {
				result_num.setText(str.substring(0, str.length() - 1));

			} catch (Exception e) {
				result_num.setText("");
			}
			break;	
			
		case R.id.relative_out_btn:

			intent= new Intent(this, SelectAccountActivty.class);
			startActivityForResult(intent, OUT);
			break;	
			
		case R.id.relative_into_btn:

			intent= new Intent(this, SelectAccountActivty.class);
			startActivityForResult(intent, INTO);
			break;	
			
		case R.id.back_btn:
			finish();
			break;	

		default:
			break;
		}
	}
	
	
}
