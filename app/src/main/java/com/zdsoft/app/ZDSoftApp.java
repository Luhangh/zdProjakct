package com.zdsoft.app;

import com.zdsoft.database.DatabaseHelper;

import android.app.Application;

public class ZDSoftApp extends Application{
	
	
	private DatabaseHelper database;

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		database=new DatabaseHelper(this);
		database.getReadableDatabase();
		database.close();
		
	}
	
}
