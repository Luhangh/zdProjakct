package com.ludvk.database;

import java.util.ArrayList;
import java.util.List;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.Contacts.Intents.Insert;

public class DatabaseHelper extends SQLiteOpenHelper{
	
	private static final String  ADD_ACCOUNT_TYPE= "create table account_type("+ "_id INTEGER PRIMARY KEY AUTOINCREMENT," 
	+ "name text,"+"balance text);"; 
	
	private static final String ADD_NOTES="create table notes ("+"_id INTEGER PRIMARY KEY AUTOINCREMENT,"
	
	+"times varchar(20),"+"title varchar(3999),"+"content varchar(3999));";
	
	private static final String sql = "create table  inorderse (id integer primary key,time text,name text,sex text,phone text,qq text,workname text,"
			+ "city text,adress text,froms text,other text,info text)";
	
	
	private static final String ADD_INPUT_ORDER = "create table inorder ("+ "id INTEGER PRIMARY KEY AUTOINCREMENT," 
			
  +"time text,"+ "name varchar(5),"+"sex varchar(2),"+"phone varchar(11),"+"qq varchar(20),"+"workname text,"+"city varchar(50),"+"adress varchar(100),"
			
+"froms text,"+"other text,"+"info text);";
	
	
	private static final String ADD_BILLS="create table bills ("+"_id INTEGER PRIMARY KEY AUTOINCREMENT,"
	
	+"image varchar(20),"+"times varchar(20),"+"number varchar(20),"+"nametype varchar(30),"+"state varchar(30));";
	 
	private static final String DB_NAME="lucky.db";
	
	public static final String ONAME="name";
	public static final String OPHONE="phone";
	public static final String OQQ="qq";
	public static final String OCITY="city";
	public static final String OADRESS="adress";
	public static final String OINFO="info";
	
	public static final String INPUT_ORDER ="inorder";
	public static final String ACCOUNT_TYPE="account_type"; 
	public static final String NOTES="notes";
	public static final String ACCOUNT_TYPE_BALANCE="balance";
	
	
	public static final String NOTES_TITEL="title";
	public static final String NOTES_CONTENT="content";
	public static final String NOTES_TIMES="times";
	
	public static final String BILLS="bills";
	public static final String BILLS_NUMBER="number";
	public static final String BILLS_TYPE="nametype";
	public static final String BILLS_STATE="state";
	
	public static final String _ID="_id";
	public static final String BILLS_IMAGE="image";
	

	public DatabaseHelper(Context context) {
		super(context, DB_NAME, null, 1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(ADD_INPUT_ORDER);
		db.execSQL(ADD_ACCOUNT_TYPE);
		db.execSQL(ADD_NOTES);
		db.execSQL(ADD_BILLS);
		ContentValues values = null;
		
		List<String> name=new  ArrayList<String >();
		name.add("现金");
		name.add("储蓄卡");
		name.add("信用卡");
		name.add("支付宝");
		
		List<String> acc=new  ArrayList<String >();
		acc.add("0");
		acc.add("0");
		acc.add("0");
		acc.add("0");
		for(int i=0;i<name.size();i++){
			 values= new ContentValues(); 
			 values.put("name", name.get(i));
			 values.put("balance", acc.get(i));
			 db.insert("account_type", null, values);
		}
	}
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
	}

	
}
