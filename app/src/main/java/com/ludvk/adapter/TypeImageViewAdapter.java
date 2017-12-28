package com.ludvk.adapter;

import com.ludvk.activity.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class TypeImageViewAdapter extends BaseAdapter{
	
	
	private Context context;
	
	public  Integer[] i;
	
	public  String[] arr;
	
	
	public TypeImageViewAdapter(Context context,Integer[] i,String[] arr){
		this.arr=arr;
		this.i=i;
		this.context=context;
		
	}
	
	
	

	public Integer[] getI() {
		return i;
	}




	public void setI(Integer[] i) {
		this.i = i;
	}




	public String[] getArr() {
		return arr;
	}




	public void setArr(String[] arr) {
		this.arr = arr;
	}




	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		if(i!=null)
		  return i.length;
		return 0;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return  i.length;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		  ViewHoder  viewhoder=null;
		  int path;
		  String name;
				  if(convertView==null){
					  convertView=LayoutInflater.from(context).inflate(R.layout.item_gridview, null);
					  viewhoder=new ViewHoder();
					  viewhoder. image_gridview=(ImageView)convertView.findViewById(R.id.image_gridview);
					  viewhoder.type_name=(TextView)convertView.findViewById(R.id.type_name);
					  convertView.setTag(viewhoder);
					  
				  }else{
					  viewhoder = (ViewHoder) convertView.getTag();
				  }
				  path=i[position];
				  System.out.println("+++++++++++"+path);
				  name=arr[position];
				  viewhoder. image_gridview.setImageResource(path);
				  viewhoder.type_name.setText(name);
				  
				  
		return convertView;
	}
	
	class ViewHoder{
		
		ImageView image_gridview; 
		TextView type_name;
		
	}

}
