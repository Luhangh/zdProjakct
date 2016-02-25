package com.zdsoft.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import com.zdsoft.adapter.TypeImageViewAdapter;
import com.zdsoft.bean.BillsBean;
import com.zdsoft.database.DatabaseHelper;
import com.zdsoft.database.DatabaseUtils;

public class AddAccountActivity extends Activity implements OnClickListener {

	private String[] arr = { "一般", "用餐", "零食", "交通", "充值", "购物", "娱乐", "住房",
			"约会", "网购", "日用品", "香烟" };

	private Integer[] i = { R.drawable.type_big_1, R.drawable.type_big_2,
			R.drawable.type_big_3, R.drawable.type_big_4,
			R.drawable.type_big_5, R.drawable.type_big_6,
			R.drawable.type_big_7, R.drawable.type_big_8,
			R.drawable.type_big_9, R.drawable.type_big_10,
			R.drawable.type_big_11, R.drawable.type_big_12 };
	
	private String[]  instarr={"工资","外快兼职","奖金","借入","零花钱","投资收入","礼物红包"};
	
	private  Integer[]  insti={R.drawable.type_big_13,R.drawable.type_big_14,R.drawable.type_big_15,
			R.drawable.type_big_16,R.drawable.type_big_17,R.drawable.type_big_18,R.drawable.type_big_19};

	private TypeImageViewAdapter adapter;

	private GridView view_tpye_image;

	private ImageView image_type;

	private TextView acc_type_name, result_text;

	private Button btn_one, btn_two, btn_three, btn_four, btn_five, btn_six,
			btn_seven, btn_eight

			, btn_nine, btn_ac, btn_zero, btn_spot, btn_ok, btn_del, btn_add,
			select_btn, pay_btn, income_btn;

	private boolean isClicked = false;

	private double input1 = 0, input2 = 0, result = 0;

	public static final int ACCOUNT = 1;

	private Resources resources;

	private Drawable btnDrawable;

	private boolean TYPE = true;
	
	private String state="1";
	
	private String nametype;
	
	private int image=0;
	
	private String id;
	
	private DatabaseUtils database;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_account);
		init();

	}

	private void init() {

		resources = AddAccountActivity.this.getResources();

		view_tpye_image = (GridView) findViewById(R.id.view_tpye_image);

		image_type = (ImageView) findViewById(R.id.image_type);

		acc_type_name = (TextView) findViewById(R.id.acc_type_name);

		result_text = (TextView) findViewById(R.id.result_text);

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

		select_btn = (Button) findViewById(R.id.select_btn);
		select_btn.setOnClickListener(this);

		pay_btn = (Button) findViewById(R.id.pay_btn);
		pay_btn.setOnClickListener(this);

		income_btn = (Button) findViewById(R.id.income_btn);
		income_btn.setOnClickListener(this);

		adapter = new TypeImageViewAdapter(this, i, arr);

		view_tpye_image.setAdapter(adapter);

		view_tpye_image.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				
				if(TYPE){
					//image=position+"";
					nametype=arr[position];
					image=i[position];
					
					acc_type_name.setText(arr[position]);

					image_type.setImageResource(i[position]);
				}else{
					image=insti[position];
					
                    nametype=instarr[position];
					
					acc_type_name.setText(instarr[position]);

					image_type.setImageResource(insti[position]);
				}
				 

			}
		});
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btn_one:
			if (isClicked) {
				result_text.setText(null);
				isClicked = false;
			}

			String str_1 = result_text.getText().toString();
			str_1 += "1";
			result_text.setText(str_1);
			break;
		case R.id.btn_two:
			if (isClicked) {
				result_text.setText(null);
				isClicked = false;
			}

			String str_2 = result_text.getText().toString();
			str_2 += "2";
			result_text.setText(str_2);
			break;
		case R.id.btn_three:
			if (isClicked) {
				result_text.setText(null);
				isClicked = false;
			}
			String str_3 = result_text.getText().toString();
			str_3 += "3";
			result_text.setText(str_3);

			break;
		case R.id.btn_four:
			if (isClicked) {
				result_text.setText(null);
				isClicked = false;
			}
			String str_4 = result_text.getText().toString();
			str_4 += "4";
			result_text.setText(str_4);

			break;
		case R.id.btn_five:
			if (isClicked) {
				result_text.setText(null);
				isClicked = false;
			}

			String str_5 = result_text.getText().toString();
			str_5 += "5";
			result_text.setText(str_5);

			break;
		case R.id.btn_six:
			if (isClicked) {
				result_text.setText(null);
				isClicked = false;
			}

			String str_6 = result_text.getText().toString();
			str_6 += "6";
			result_text.setText(str_6);

			break;
		case R.id.btn_seven:
			if (isClicked) {
				result_text.setText(null);
				isClicked = false;
			}

			String str_7 = result_text.getText().toString();
			str_7 += "7";
			result_text.setText(str_7);

			break;
		case R.id.btn_eight:
			if (isClicked) {
				result_text.setText(null);
				isClicked = false;
			}

			String str_8 = result_text.getText().toString();
			str_8 += "8";
			result_text.setText(str_8);

			break;
		case R.id.btn_nine:
			if (isClicked) {
				result_text.setText(null);
				isClicked = false;
			}

			String str_9 = result_text.getText().toString();
			str_9 += "9";
			result_text.setText(str_9);

			break;
		case R.id.btn_ac:
			result_text.setText(null);
			break;
		case R.id.btn_zero:
			String str_0 = result_text.getText().toString();
			str_0 += "0";
			result_text.setText(str_0);

			break;
		case R.id.btn_spot:
			if (isClicked) {
				result_text.setText(null);
				isClicked = false;
			}
			String str_point = result_text.getText().toString();
			str_point += ".";
			result_text.setText(str_point);
			break;
		case R.id.btn_ok:
			String myStringEqu = result_text.getText().toString();
			if (myStringEqu.equals(null) || myStringEqu.equals("")) {
				return;
			}
			input2 = Double.valueOf(myStringEqu);
			result_text.setText(null);
			result = input1 + input2;
			result_text.setText(Double.toString(result));
			
			isClicked = true;
			input1 = 0;
			input2 = 0;
			BillsBean bean=new BillsBean();
			//计算结果
			bean.setNumber(result_text.getText().toString());
			
			if(id==null||id.equals("")){
				
				// 账户id
				bean.setAccount_id("1");
			}else{
				//账户id
				bean.setAccount_id(id);
			}
			
			if(nametype==null){
				nametype=acc_type_name.getText().toString();
				
			}
			bean.setNametype(nametype);
			
			// 支出或收入类型
			bean.setState(state);

			bean.setImage(image+"");
			
			database=new DatabaseUtils(getApplicationContext(), DatabaseHelper.BILLS, null, null);
			database.insertBills(bean);
			break;
		case R.id.btn_add:
			if (result_text.getText().toString().equals(null)||result_text.getText().toString().equals("")) {
				return;
			}
			input1 = Double.parseDouble(result_text.getText().toString());
			result_text.setText(null);
			isClicked = false;
			break;
		case R.id.btn_del:

			String str = result_text.getText().toString();
			try {
				result_text.setText(str.substring(0, str.length() - 1));

			} catch (Exception e) {
				result_text.setText("");
			}
			break;

		case R.id.select_btn:
			
			Intent intent = new Intent(this, SelectAccountActivty.class);
			startActivityForResult(intent, ACCOUNT);
			
			break;

		case R.id.pay_btn:

			if (!TYPE) {
				btnDrawable = resources.getDrawable(R.drawable.open);
				pay_btn.setBackgroundDrawable(btnDrawable);
				pay_btn.setTextColor(this.getResources()
						.getColor(R.color.white));

				btnDrawable = resources
						.getDrawable(R.drawable.secrecy_no_activate);
				income_btn.setBackgroundDrawable(btnDrawable);
				income_btn.setTextColor(this.getResources().getColor(
						R.color.grey));
				TYPE = true;
				state="1";
				adapter.setArr(arr);
				adapter.setI(i);
				adapter.notifyDataSetChanged();
				
				acc_type_name.setText("一般");

				image_type.setImageResource(R.drawable.type_big_1);
			}

			break;

		case R.id.income_btn:

			if (TYPE) {
				System.out.println("+++++++++++++++");
				btnDrawable = resources.getDrawable(R.drawable.secrecy);
				income_btn.setBackgroundDrawable(btnDrawable);
				income_btn.setTextColor(this.getResources().getColor(
						R.color.white));

				btnDrawable = resources
						.getDrawable(R.drawable.open_on_activate);
				pay_btn.setBackgroundDrawable(btnDrawable);
				pay_btn.setTextColor(this.getResources().getColor(R.color.grey));

				TYPE = false;
				state="2";			
				adapter.setArr(instarr);
				adapter.setI(insti);
				adapter.notifyDataSetChanged();
				
				acc_type_name.setText("工资");

				image_type.setImageResource(R.drawable.type_big_13);
			}

			break;

		default:
			break;
		}

	}
	
	
	

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		

		if (data == null) {
			return;
		}
		
		switch (requestCode) {
		case ACCOUNT:
			String str_name = data.getStringExtra("name");
			id=data.getStringExtra("id");
			select_btn.setText(str_name);
			break;	
			
		default:
			break;
		}

	}

}
