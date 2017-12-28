package com.ludvk.adapter;

import java.util.List;
import java.util.Map;

import com.ludvk.activity.R;
import com.ludvk.bean.custombean;
import com.ludvk.utils.StringUtils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class customadapter extends BaseAdapter{

	private List<custombean> devList;
	private custombean bean;
	private Context context;
	
	

	public customadapter(List<custombean> devList, Context context) {
		super();
		this.devList = devList;
		this.context = context;
	}

	@Override
	public int getCount() {
		return devList.size();
	}

	@Override
	public Object getItem(int position) {
		return devList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		final Holder holder ;
		if(convertView == null){
			holder = new Holder();
			convertView = LayoutInflater.from(context).inflate(R.layout.item_custom, null);
			holder.dev_name = (TextView) convertView.findViewById(R.id.dev_name);
			holder.dev_code = (TextView) convertView.findViewById(R.id.dev_code);
			holder.img_photo=(ImageView) convertView.findViewById(R.id.img_photo);
			convertView.setTag(holder);
		}else{
			
			holder = (Holder) convertView.getTag();
		}
	
		
		bean = devList.get(position);
		holder.dev_name.setText(StringUtils.object2String(bean.getName()));
		holder.dev_code.setText(StringUtils.object2String(bean.getAdress()));
		
		return convertView;
	}
	
	class Holder{
		TextView dev_name;
		TextView dev_code;
		ImageView img_photo;
	}

}
