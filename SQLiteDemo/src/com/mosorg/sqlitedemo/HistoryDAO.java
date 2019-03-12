/**
 * 
 */
package com.mosorg.sqlitedemo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * @author Administrator
 * Android数据库操作工具类
 *
 */
public class HistoryDAO {
	  private DBConnection dbc = null;
	  private SQLiteDatabase db = null;
	  private Context context;
	 
	  //数据库上下文
	  public HistoryDAO(Context context) {
	    this.context = context;
	  }
	  //打开数据库
	  public HistoryDAO open() {
	    dbc = new DBConnection(context);
	    db = dbc.getWritableDatabase();
	    return this;
	  }
	 
	  //关闭数据库
	  public void closeAll() {
	    db.close();
	    dbc.close();
	  }
	 
	//  // 增加
	//  public void add(Search_HistoryData data, String type) {
//	    open();
//	    ContentValues values = new ContentValues();
//	    values.put("content", data.getContent());
//	    values.put("type", data.getType());
//	    db.insert("history", null, values);
//	    closeAll();
	//  }
	 
	  // 增加
	  public void add(Search_HistoryData data, String tableName) {
	    open();
	    ContentValues values = new ContentValues();
	    values.put("content", data.getContent());
	    db.insert(tableName, null, values);
	    closeAll();
	  }
	 
	  // 增加 工具类的最后五个专用
	  public void addLawTool(Search_HistoryData data, String tableName) {
	    open();
	    ContentValues values = new ContentValues();
	    values.put("content", data.getContent());
	    values.put("_id", data.getId());
	    db.insert(tableName, null, values);
	    closeAll();
	  }
	 
	  // 全查询
	  public List getAll(String TableName) {
	    open();
	    List ar = new ArrayList();
	    Cursor c = db.rawQuery("select * from " + TableName, null);
	    while (c.moveToNext()) {
	      Map map = new HashMap();
	      map.put("_id", c.getInt(c.getColumnIndex("_id")));
	      map.put("content", c.getString(c.getColumnIndex("content")));
	      ar.add(map);
	    }
	    closeAll();
	    return ar;
	  }
	 
	  // 删除 根据id删除
	  public void delete(String tableName, int uid) {
	    open();
	    db.delete("history", "uid=" + uid, null);
	    closeAll();
	  }
	 
	  //清空表中所有数据
	  public void delete(String tableName) {
	    open();
	    db.delete(tableName, null, null);
	    closeAll();
	  }
	 
	  //判断是否存在
	  public boolean searchResult(String tableName, String key) {
	    open();
	    Boolean booleans =
	        db.rawQuery("select * from " + tableName + " where content = ?", new String[]{key}).moveToNext();
	    closeAll();
	    return booleans;
	  }
	 
	  //根据库查询表字段
	  public boolean searchResultToType(String content, String type) {
	    open();
	    Boolean booleans =
	        db.rawQuery("select * from history where content = ? and type = ?", new String[]{content, type}).moveToNext();
	    closeAll();
	    return booleans;
	  }
	 
	}
