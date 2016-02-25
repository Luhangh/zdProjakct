package com.zdsoft.fragment;

import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.zdsoft.activity.AddAccountActivity;
import com.zdsoft.activity.R;
import com.zdsoft.adapter.AccountingAdapter;
import com.zdsoft.bean.BillsBean;
import com.zdsoft.database.DatabaseHelper;
import com.zdsoft.database.DatabaseUtils;

public class TwoFragment extends Fragment implements OnClickListener{
	
	private ListView  accounting_list;
	
	private List<BillsBean>list;
	
	private AccountingAdapter adapter;
	
	private Button finish_btn;
	
	private DatabaseUtils databaseutils;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreateView(inflater, container, savedInstanceState);
		
	   View friendView = inflater.inflate(R.layout.activity_fragment_two, container,false);
	   
	   accounting_list  = (ListView)friendView.findViewById(R.id.accounting_list);
	   
	   finish_btn=(Button)friendView.findViewById(R.id.finish_btn);
	   
	   finish_btn.setOnClickListener(this);
		
	
		
		return friendView;
	}
	
	
	

	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		
		databaseutils=new DatabaseUtils(getActivity(),DatabaseHelper.BILLS , null, null);
		list=databaseutils.seclectBills();
		System.out.println("+++++++++++"+list.size());
		adapter=new AccountingAdapter(getActivity(), list);
		accounting_list.setAdapter(adapter);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.finish_btn:
			Intent intent=new Intent(getActivity(),AddAccountActivity.class);
			startActivity(intent);
			break;

		default:
			break;
		}
		
	}
	
	

}
