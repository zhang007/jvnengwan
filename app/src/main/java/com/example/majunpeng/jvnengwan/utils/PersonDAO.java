package com.example.majunpeng.jvnengwan.utils;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class PersonDAO {
	private Context context;
	private SQLiteDatabase db;

	public PersonDAO(Context context) {
		super();
		this.context = context;
		DBHelper helper = new DBHelper(context);
		db = helper.getWritableDatabase();
	}

	public long insert(String table, String nullColumnHack, ContentValues values) {

		return db.insert(table, nullColumnHack, values);

	}

	public int delete(String table, String whereClause, String[] whereArgs) {

		return db.delete(table, whereClause, whereArgs);
	}

	public int update(String table, ContentValues values, String whereClause,
			String[] whereArgs) {

		return db.update(table, values, whereClause, whereArgs);
	}

	public Cursor query(String table, String[] columns, String selection,
			String[] selectionArgs, String groupBy, String having,
			String orderBy) {

		return db.query(table, columns, selection, selectionArgs, groupBy, having,
				orderBy);
	}

}
