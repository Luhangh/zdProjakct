package com.ludvk.adapter;

import java.util.List;

import android.R.integer;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ludvk.activity.R;
import com.ludvk.bean.BillsBean;
import com.ludvk.bean.NotesBean;

public class AccountingAdapter extends BaseAdapter {
	

	private Context  context ;
	
	private List<BillsBean> list;
	
	
	public AccountingAdapter(Context  context,List<BillsBean> list){
		
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
		
		ViewHoer hoder;
		
		hoder=new ViewHoer();
		
		if(convertView==null){
			
			convertView=LayoutInflater.from(context).inflate(R.layout.item_accounting, null);
			
			hoder.type_view=(ImageView)convertView.findViewById(R.id.type_view);
			
			hoder.text_account=(TextView)convertView.findViewById(R.id.text_account);
			
			hoder.text_into=(TextView)convertView.findViewById(R.id.text_into);
			
			convertView.setTag(hoder);
			
		}else{
		    hoder= (ViewHoer) convertView.getTag();
		 }
		
		BillsBean bean= list.get(position);
		if(bean.getState().equals("1")){		
			hoder.text_account.setText(bean.getNametype()+""+bean.getNumber());
		}else{
			hoder.text_into.setText(bean.getNametype()+""+bean.getNumber());
		}
		
		
		
		int i = 0;
		if(!bean.getImage().equals("")&&bean.getImage()!=null&&!bean.getImage().equals("null")){
			i=Integer.parseInt(bean.getImage());
		}
		/*switch (i) {
		case 0:
			hoder.type_view.setImageResource(R.drawable.type_big_1);
			break;
		case 1:
			
			hoder.type_view.setImageResource(R.drawable.type_big_2);
				
				break;
		case 2:
			
			hoder.type_view.setImageResource(R.drawable.type_big_3);
			
			break;
		case 3:
			
			hoder.type_view.setImageResource(R.drawable.type_big_4);
			
			break;
		case 4:
			
			hoder.type_view.setImageResource(R.drawable.type_big_5);
			
			break;
		case 5:
			
			hoder.type_view.setImageResource(R.drawable.type_big_6);
			
			break;
		case 6:
			
			hoder.type_view.setImageResource(R.drawable.type_big_7);
			
			break;
		case 7:
			
			hoder.type_view.setImageResource(R.drawable.type_big_8);
			
			break;
		case 8:
			
			hoder.type_view.setImageResource(R.drawable.type_big_9);
			
			break;
		case 9:
			
			hoder.type_view.setImageResource(R.drawable.type_big_10);
			
			break;
		case 10:
			
			hoder.type_view.setImageResource(R.drawable.type_big_11);
			
			break;
		case 11:
			
			hoder.type_view.setImageResource(R.drawable.type_big_12);
			
			break;
		case 12:
			
			hoder.type_view.setImageResource(R.drawable.type_big_13);
			
			break;
		case 13:
			
			hoder.type_view.setImageResource(R.drawable.type_big_14);
			
			break;
		case 14:
			
			hoder.type_view.setImageResource(R.drawable.type_big_15);
			
			break;
		case 15:
			
			hoder.type_view.setImageResource(R.drawable.type_big_16);
					
			break;
		case 16:
			
			hoder.type_view.setImageResource(R.drawable.type_big_17);
			
			break;
		case 17:
			
			hoder.type_view.setImageResource(R.drawable.type_big_18);
			
			break;
			
	     case 18:
	    	 
	    		hoder.type_view.setImageResource(R.drawable.type_big_19);
		
		     break;
		

		default:
			break;
		}*/
		
		hoder.type_view.setImageResource(i);
		
		return convertView;
	}
	
	
	
	class ViewHoer{
		  
		ImageView type_view;
		
		TextView text_account,text_into;
		
		
	}

}
