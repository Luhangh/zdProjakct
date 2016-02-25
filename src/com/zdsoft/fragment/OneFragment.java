package com.zdsoft.fragment;

import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import com.zdsoft.activity.AddNotesActivity;
import com.zdsoft.activity.NotesInfoActivity;
import com.zdsoft.activity.R;
import com.zdsoft.adapter.NotesAdapter;
import com.zdsoft.bean.NotesBean;
import com.zdsoft.database.DatabaseHelper;
import com.zdsoft.database.DatabaseUtils;

public class OneFragment extends Fragment implements OnClickListener{
	
	private NotesAdapter adapter;
	
	private ListView read_list;
	
	private Button finish_btn;
	
    private DatabaseUtils databaseutils;
    
	private  List<NotesBean> list;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreateView(inflater, container, savedInstanceState);
		
		View friendView = inflater.inflate(R.layout.activity_fragment_one, container,false);
		
		finish_btn=(Button)friendView.findViewById(R.id.finish_btn);		
		finish_btn.setOnClickListener(this);
		read_list  = (ListView)friendView.findViewById(R.id.read_list);
		
		read_list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				NotesBean bean=list.get(position);
				Intent intent=new Intent(getActivity(),NotesInfoActivity.class);
				Bundle bundle = new Bundle();
				bundle.putSerializable("date",  bean);
				intent.putExtras(bundle);
				startActivity(intent);	
				
				
			}
		});
		
		return friendView;
		
	}
	    
	  
	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		databaseutils=new DatabaseUtils(getActivity(),DatabaseHelper.NOTES , null, null);
		list=databaseutils.getNotes();
		adapter=new NotesAdapter(getActivity(), list);
		read_list.setAdapter(adapter);
	}


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.finish_btn:
			Intent intent=new Intent(getActivity(),AddNotesActivity.class);
			startActivity(intent);
			break;

		default:
			break;
		}
		
	}
	
      

}
