package com.ludvk.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

	public static final String DB_NAME = "ldm_family"; // DB name
	private Context mcontext;
	private DBHelper mDbHelper;
	private SQLiteDatabase db;

	public DBHelper(Context context) {
		super(context, DB_NAME, null, 11);
		this.mcontext = context;
	}

	public DBHelper(Context context, String name, CursorFactory factory, int version) {
		super(context, name, factory, version);

	}

	/**
	 * 创建
	 */
	@Override
	public void onCreate(SQLiteDatabase db) {
		String sql = "create table if not exists inorder(id integer primary key,time text,name text,"
				+ "sex text,phone text,qq text,workname text,"
			+ "city text,adress text,froms text,other text,info text)";
		db.execSQL(sql);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	}

	public DBHelper open() {
		if (null == mDbHelper) {
			mDbHelper = new DBHelper(mcontext);
		}
		db = mDbHelper.getWritableDatabase();
		return this;
	}

	public void close() {
		db.close();
		mDbHelper.close();
	}

	public long insert(String tableName, ContentValues values) {
		return db.insert(tableName, null, values);
	}

	public Cursor findList(String tableName, String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy, String limit) {
		return db.query(tableName, columns, selection, selectionArgs, groupBy, having, orderBy, limit);
	}

	public Cursor exeSqllist(String sql) {
		return db.rawQuery(sql, null);
	}
	public Cursor exeSql(String sql,String [] str) {
		return db.rawQuery(sql, str);
	}
}