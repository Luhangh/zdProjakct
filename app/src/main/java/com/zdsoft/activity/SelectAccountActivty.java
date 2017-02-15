package com.zdsoft.activity;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.zdsoft.adapter.SeclectAccountAdapter;
import com.zdsoft.bean.AccountBean;
import com.zdsoft.database.DatabaseHelper;
import com.zdsoft.database.DatabaseUtils;

public class SelectAccountActivty extends Activity {

	private ListView account_list;

	private SeclectAccountAdapter adapter;

	private List<AccountBean> list;

	private DatabaseUtils databaseutils;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_seclect_account);
		getWindow().setLayout(LayoutParams.FILL_PARENT,
				LayoutParams.FILL_PARENT);
		init();
	}

	private void init() {

		databaseutils = new DatabaseUtils(this, DatabaseHelper.ACCOUNT_TYPE,
				null, null);

		list = databaseutils.getAccount();


		account_list = (ListView) findViewById(R.id.account_list);

		adapter = new SeclectAccountAdapter(this, list);
		

		account_list.setAdapter(adapter);

		account_list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub

				AccountBean bean = list.get(position);
				
				Intent intent = new Intent();
				
				
				intent.putExtra("name", bean.getName());
				
				intent.putExtra("id",bean.get_id() );
				
				SelectAccountActivty.this.setResult(RESULT_OK, intent);
				
				SelectAccountActivty.this.finish();
			}
		});
	}
}
