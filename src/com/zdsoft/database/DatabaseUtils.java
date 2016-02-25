package com.zdsoft.database;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.zdsoft.activity.R.drawable;
import com.zdsoft.bean.AccountBean;
import com.zdsoft.bean.BillsBean;
import com.zdsoft.bean.NotesBean;
public class DatabaseUtils {
	
public ContentValues  values;
	
	private  DatabaseHelper databaseheiper;
	 
    private SQLiteDatabase db;
    
    public Context context;
	
	public String  tabName;
    
    private String fields;
	
public DatabaseUtils(Context context,String tabName,ContentValues values,String fields){
		
		this.context=context;
		
		this.tabName=tabName;
		
		this.values=values;
		
		this.fields=fields;
		
		databaseheiper=new DatabaseHelper(context);
		
		db=databaseheiper.getWritableDatabase();
		
	}

  public  List<AccountBean>  getAccount(){
	  
	  Cursor cursors =db.query(tabName,null , null, null, null, null, null);
		List<AccountBean> list=new  ArrayList<AccountBean>();
		AccountBean accbean;
			while(cursors.moveToNext()){
				accbean=new AccountBean();					
				String name = cursors.getString(cursors.getColumnIndex("name"));
				String  balance= cursors.getString(cursors.getColumnIndex("balance"));
				String _id= cursors.getString(cursors.getColumnIndex("_id"));
				System.out.println("name++++++++++"+name);
				accbean.setName(name);
				accbean.setBalance(balance);
				accbean.set_id(_id);
				list.add(accbean);
			  }
			cursors.close();
	  
	return list;
	  
  }
  
   public long insertNotes(NotesBean bean){
	  
	    ContentValues values = new ContentValues();
	  
	    values.put(DatabaseHelper.NOTES_TITEL, bean.getTitel());
		 
		 values.put(DatabaseHelper.NOTES_CONTENT, bean.getContent());
		 
		 SimpleDateFormat    formatter    =   new    SimpleDateFormat    ("yyyy-MM-dd");       
		 Date    curDate    =   new    Date(System.currentTimeMillis());       
		 String    str    =    formatter.format(curDate);   
		 
		 values.put(DatabaseHelper.NOTES_TIMES,  str);	 
		 
		 long cursors = db.insert(tabName, null, values);
  
	 return cursors;
	  
  }
   
   public List<NotesBean> getNotes(){
	   Cursor cursors =db.query(tabName,null , null, null, null, null, "_id desc");
	   List<NotesBean> list=new  ArrayList<NotesBean>();
	   NotesBean accbean;
			while(cursors.moveToNext()){
				accbean=new NotesBean();					
				String titel = cursors.getString(cursors.getColumnIndex(DatabaseHelper.NOTES_TITEL));
				String  content= cursors.getString(cursors.getColumnIndex(DatabaseHelper.NOTES_CONTENT));	
				String  times= cursors.getString(cursors.getColumnIndex(DatabaseHelper.NOTES_TIMES));
				String _id=cursors.getString(cursors.getColumnIndex(DatabaseHelper._ID));
				
				accbean.setTitel(titel);
				accbean.setContent(content);
				accbean.setTimes(times);
				accbean.setId(_id);
				list.add(accbean);
			  }
			cursors.close();
	return list;
	   
   }
   
   public long insertBills(BillsBean bean){
	   
	   long cursors = 0;
	   
	   ContentValues values = new ContentValues();
	   
	   SimpleDateFormat    formatter    =   new    SimpleDateFormat    ("yyyy-MM-dd");       
		 Date    curDate    =   new    Date(System.currentTimeMillis());       
		 String    str    =    formatter.format(curDate);   
		 
		 double d1;
		 double d2;
	   
	   if(bean.getState().equals("1")){
		   
		   BillsBean billsbean=selectBills(str,bean.getNametype());
		   
		   if(billsbean!=null){
			   //以前的金额
			   d1=  Double.valueOf(billsbean.getNumber());
			   // 需要插入的金额
			   d2=Double.valueOf(bean.getNumber());
			   
			  // 得到总金额
			   
			   double newd=d1+d2;
			   
			   values.put(DatabaseHelper.BILLS_NUMBER, newd);
			   
			   db.update(tabName, values, "_id=?",new String[]{billsbean.get_id()});
			   
		   }else{
			   
			     values.put(DatabaseHelper.BILLS_NUMBER, bean.getNumber());
				 
				 values.put(DatabaseHelper.BILLS_STATE, bean.getState());
				 
				 values.put(DatabaseHelper.BILLS_TYPE, bean.getNametype());
				 
				 values.put(DatabaseHelper.BILLS_IMAGE, bean.getImage());
				 
				 values.put(DatabaseHelper.NOTES_TIMES,  str);	 
				 
				 cursors= db.insert(tabName, null, values);
			   
		   }
		   		   
	     }else{
	    	 
	    	 
	    	 
	    	 values.put(DatabaseHelper.BILLS_NUMBER, bean.getNumber());
			 
			 values.put(DatabaseHelper.BILLS_STATE, bean.getState());
			 
			 values.put(DatabaseHelper.BILLS_TYPE, bean.getNametype());
			 
			 values.put(DatabaseHelper.BILLS_IMAGE, bean.getImage());
			 
			 values.put(DatabaseHelper.NOTES_TIMES,  str);	 
			 
			 cursors= db.insert(tabName, null, values);
			 
	     }
	   
	    updateAccount(bean.getAccount_id(),bean.getState(), DatabaseHelper.ACCOUNT_TYPE,bean.getNumber()); 
			  
	return cursors;
	   
   }
   
   public long updateAccount(String account_id,String state,String tabNames,String number){
	   
	   // 根据ID  查找账户余额
	   
	   double  balance=seclectAccount( account_id,tabNames);
	   
	   
	   
	   ContentValues values = new ContentValues();
	   
	   if(state.equals("2")){
		   
		    
		   double newba= balance+ Double.valueOf(number);
		   
		   values.put(DatabaseHelper.ACCOUNT_TYPE_BALANCE, newba);
	   }else{
		   
          double newba= balance-Double.valueOf(number);
		   
		   values.put(DatabaseHelper.ACCOUNT_TYPE_BALANCE, newba);
	   }
	   
	   db.update(tabNames, values, "_id= ?", new String[]{account_id});
	   
	   
	return 0;
	   
   }  
   
   public double seclectAccount(String account_id,String tabNames){
	   String balance = "0";
	   Cursor cursor =db.query(tabNames, null, "_id=? " , new String[]{account_id}, null, null, null);
	   
	   while(cursor.moveToNext()){			
		   
		   balance= cursor.getString(cursor.getColumnIndex(DatabaseHelper.ACCOUNT_TYPE_BALANCE));
			
		  }  
	   double d=Double.valueOf(balance);
	return d ;
	   
   }
   
   public BillsBean selectBills(String times,String nametype){
	   
            String number = null;
            
            String id="";
            
            BillsBean bean = null;
           
	   Cursor cursor =db.query(tabName, null, "times=? and nametype=? " , new String[]{times,nametype}, null, null, null);
	   
     while(cursor.moveToNext()){			
		   
    	   bean=new BillsBean();
    	 
		   number= cursor.getString(cursor.getColumnIndex(DatabaseHelper.BILLS_NUMBER));
		   
		   id= cursor.getString(cursor.getColumnIndex(DatabaseHelper._ID));
		      
		   bean.set_id(id);
		   bean.setNumber(number);
		  }
	return bean;
     }
   public  List<BillsBean>  seclectBills(){
	   
	   BillsBean bean = null;
	   
	   List<BillsBean> list=new  ArrayList<BillsBean>();
	   
	   Cursor cursor =db.query(tabName, null, null , null, null, null, "_id desc");
	   
	     while(cursor.moveToNext()){			
			   
	    	   bean=new BillsBean();
	    	 
			  String  number= cursor.getString(cursor.getColumnIndex(DatabaseHelper.BILLS_NUMBER));
			   
			   String id= cursor.getString(cursor.getColumnIndex(DatabaseHelper._ID));
			   
			   String  image=cursor.getString(cursor.getColumnIndex(DatabaseHelper.BILLS_IMAGE));
			   
			   String state=cursor.getString(cursor.getColumnIndex(DatabaseHelper.BILLS_STATE));
			   
			   String type= cursor.getString(cursor.getColumnIndex(DatabaseHelper.BILLS_TYPE));
			      
			   bean.set_id(id);
			   bean.setNumber(number);
			   bean.setImage(image);
			   bean.setNametype(type);
			   bean.setState(state);
			   list.add(bean);
			   
			  }
	return list;
	   
   }
   public long Intout(String out_id,String into_id ,String num){
	   
	   Cursor cursor ;
	   
	   ContentValues values;
	   
	   String out_balance="",into_balance="",new_out_balance="",new_into_balane="";
	   
	   double out_d=0,into_d=0,new_out_d=0,new_into_d=0,number=0;
	   
	   number=Double.valueOf(num);
	   
	   cursor=db.query(tabName, null, "_id= ? " , new String[]{out_id}, null, null, null);
	   
	   while(cursor.moveToNext()){			
		      	 	   
		   out_balance= cursor.getString(cursor.getColumnIndex(DatabaseHelper.ACCOUNT_TYPE_BALANCE));
		   
		   out_d=Double.valueOf(out_balance);
		  }
	   cursor=db.query(tabName, null, "_id= ? " , new String[]{into_id}, null, null, null);
	   while(cursor.moveToNext()){			
  	 	   
		   into_balance= cursor.getString(cursor.getColumnIndex(DatabaseHelper.ACCOUNT_TYPE_BALANCE));
		   
		   into_d=Double.valueOf(into_balance);
		  }
	      
	   new_out_d=out_d-number;
	   
	   new_into_d=into_d+number;
	   
	   values= new ContentValues();
	   
	   values.put(DatabaseHelper.ACCOUNT_TYPE_BALANCE, new_out_d+"");
	   
	   long out= db.update(tabName, values, "_id=?",new String[]{out_id});
	   
	   values=new ContentValues();
	   
      values.put(DatabaseHelper.ACCOUNT_TYPE_BALANCE, new_into_d+"");
	   
	   long into=db.update(tabName, values, "_id=?",new String[]{into_id});
	   
	return out+into;
	   
   }
   
}
