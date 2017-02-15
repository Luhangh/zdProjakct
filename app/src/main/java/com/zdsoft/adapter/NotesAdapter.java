package com.zdsoft.adapter;

import java.util.List;

import com.zdsoft.activity.R;
import com.zdsoft.bean.NotesBean;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class NotesAdapter extends BaseAdapter{
	
	private List<NotesBean> list;
	private  Context   context;
	
	public NotesAdapter(Context   context,List<NotesBean> list){
		this.context=context;
		this.list=list;
		
	}
	
	
	

	public List<NotesBean> getList() {
		return list;
	}




	public void setList(List<NotesBean> list) {
		this.list = list;
	}




	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		if(list!=null)
			return list.size();
		return 0;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		// TODO Auto-generated method stub
		
		final  ViewHoder hoder;
		if(arg1==null ){
			hoder=new ViewHoder();
			
			arg1=LayoutInflater.from(context).inflate(R.layout.notes_item, null);
			hoder.notes_content=(TextView)arg1.findViewById(R.id.notes_content);
			hoder.notes_titel=(TextView)arg1.findViewById(R.id.notes_titel);
			arg1.setTag(hoder);
			
		}else{
			hoder= (ViewHoder) arg1.getTag();
		}
		
		NotesBean bean=list.get(arg0);
		
		hoder.notes_content.setText(bean.getTimes()+bean.getContent());
		
		hoder.notes_titel.setText(bean.getTitel());
		
		
		return arg1;
	}
   
	 class ViewHoder{
		 
		 TextView notes_content,notes_titel;
		 
	 }
}
