package com.ludvk.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ludvk.activity.R;
import com.ludvk.bean.AccountBean;

public class SeclectAccountAdapter extends BaseAdapter{
	
	private Context context;
	
	private List<AccountBean> list;
	
	
	
	
	public SeclectAccountAdapter(Context context,List<AccountBean> list){
		
		this.context=context;
		 this.list=list;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		if(list!=null)
			return list.size();
		return 0;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHoder  hoder;
		if(convertView==null){
			hoder=new ViewHoder();
			convertView=LayoutInflater.from(context).inflate(R.layout.item_accoun, null);
			hoder.account_name=(TextView)convertView.findViewById(R.id.account_name);
			convertView.setTag(hoder);
			
		}else{
			hoder=(ViewHoder)convertView.getTag();
		}
		AccountBean bean=list.get(position);

		hoder.account_name.setText(bean.getName());
		return convertView;
	}
     
	class ViewHoder{
		
		TextView account_name;
	}
}
