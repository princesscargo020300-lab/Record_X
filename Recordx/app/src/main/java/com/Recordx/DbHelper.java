package com.Recordx;



import android.content.ContentValues; 
import android.content.Context; 
import android.database.Cursor; 
import android.database.sqlite.SQLiteDatabase; 
import android.database.sqlite.SQLiteOpenHelper; 

public class DbHelper extends SQLiteOpenHelper { 
    SQLiteDatabase db; 

	private static final String DATABASE_NAME="groupnine"; 
	private static final int DATABASE_VERSION=1; 

	private static final String TABLE_EMPLOYEE="recordx"; 

	private static final  String KEY_ID="id"; 
	private static final  String KEY_LASTNAME="lastname"; 
	private static final  String KEY_FIRSTNAME="firstname"; 
	private static final  String KEY_DATE="date"; 
	private static final  String KEY_CURRENTADDRESS="currentaddress"; 
	private static final  String KEY_PERMANENTADDRESS="permanentaddress"; 
	private static final  String KEY_HIGHESTDEGREE="highestdegree"; 
	private static final  String KEY_DESIGNATION="designation"; 
	private static final  String KEY_CONTACT="contact"; 

	public DbHelper(Context context) { 

		super(context, DATABASE_NAME, null,DATABASE_VERSION); 
	} 

	@Override 
	public void onCreate(SQLiteDatabase db){ 
		String Query_Table=" CREATE TABLE " +TABLE_EMPLOYEE+ "("  
			+KEY_ID+ " INTEGER PRIMARY KEY AUTOINCREMENT, "  
			+KEY_LASTNAME+ " TEXT, " +KEY_FIRSTNAME+ " TEXT, " +KEY_DATE+ " TEXT,"+KEY_CURRENTADDRESS+" TEXT,"+KEY_PERMANENTADDRESS+" TEXT,"+KEY_HIGHESTDEGREE+" TEXT,"+KEY_DESIGNATION+" TEXT,"+KEY_CONTACT+" TEXT);"; 
		db.execSQL(Query_Table); 
	} 

	@Override 
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) { 
		db.execSQL("DROP TABLE IF EXISTS"+TABLE_EMPLOYEE); 
		onCreate(db); 

	} 

	public long insertemployee(String laname, String faname, String dates,String curaddress,String peraddress,String highdeg,String designation,String contact) { 
		db=this.getWritableDatabase(); 
		ContentValues values=new ContentValues(); 
		values.put(KEY_LASTNAME,laname); 
		values.put(KEY_FIRSTNAME,faname); 
		values.put(KEY_DATE,dates); 
		values.put(KEY_CURRENTADDRESS,curaddress); 
		values.put(KEY_PERMANENTADDRESS,peraddress); 
		values.put(KEY_HIGHESTDEGREE,highdeg); 
		values.put(KEY_DESIGNATION,designation); 
		values.put(KEY_CONTACT,contact); 
		return db.insert(TABLE_EMPLOYEE,null,values); 
	} 

	public String getEmployee() { 
        db=this.getReadableDatabase(); 
		String[] columns=new String[] {KEY_ID,KEY_LASTNAME,KEY_FIRSTNAME,KEY_DATE,KEY_CURRENTADDRESS,KEY_PERMANENTADDRESS,KEY_HIGHESTDEGREE,KEY_DESIGNATION,KEY_CONTACT}; 
		Cursor cursor=db.query(TABLE_EMPLOYEE,columns,null,null,null,null,null); 

		int Id= cursor.getColumnIndex(KEY_ID); 
		int Lastname= cursor.getColumnIndex(KEY_LASTNAME); 
		int Firstname= cursor.getColumnIndex(KEY_FIRSTNAME); 
		int Date= cursor.getColumnIndex(KEY_DATE); 
		int Caddress= cursor.getColumnIndex(KEY_CURRENTADDRESS); 
		int Paddress= cursor.getColumnIndex(KEY_PERMANENTADDRESS); 
		int Highdeg= cursor.getColumnIndex(KEY_HIGHESTDEGREE); 
		int Designation= cursor.getColumnIndex(KEY_DESIGNATION); 
		int Contact= cursor.getColumnIndex(KEY_CONTACT); 
		String result=""; 

		for(cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()){ 
			result=result+ 
				"Id: "+cursor.getString(Id)+ "\n"+ 
				"LastName: " +cursor.getString(Lastname)+"\n"+ 
				"Firstname: " +cursor.getString(Firstname)+ "\n"+ 
				"Birthday: " +cursor.getString(Date)+"\n"+ 
				"Currentaddress: " +cursor.getString(Caddress)+ "\n"+ 
				"Permanentaddress: " +cursor.getString(Paddress)+ "\n"+ 
				"Highestdegree: " +cursor.getString(Highdeg)+"\n"+ 
				"Designation: " +cursor.getString(Designation)+ "\n"+ 
				"Contact: "+cursor.getString(Contact)+ "\n\n"; 
		} 
		db.close(); 
		return result; 
	} 

	public void deleteemployee(long l) { 
		db=this.getWritableDatabase(); 
		db.delete(TABLE_EMPLOYEE,KEY_ID+"="+l,null); 
	} 

	public void updateemployee(long l, String lname, String fname, String date,String curaddres,String peraddres,String highdeg,String designation,String contact) { 
		db=this.getWritableDatabase(); 
		ContentValues values=new ContentValues(); 
		values.put(KEY_LASTNAME,lname); 
		values.put(KEY_FIRSTNAME,fname); 
		values.put(KEY_DATE,date); 
		values.put(KEY_CURRENTADDRESS,curaddres); 
		values.put(KEY_PERMANENTADDRESS,peraddres); 
		values.put(KEY_HIGHESTDEGREE,highdeg); 
		values.put(KEY_DESIGNATION,designation); 
		values.put(KEY_CONTACT,contact);
		db.update(TABLE_EMPLOYEE,values,KEY_ID+"="+l,null); 
		db.close(); 
	} 

	public String Lastname(long l1) { 
		db=this.getReadableDatabase(); 
		String[] columns=new String[]{KEY_ID,KEY_LASTNAME,KEY_FIRSTNAME,KEY_DATE,KEY_CURRENTADDRESS,KEY_PERMANENTADDRESS,KEY_HIGHESTDEGREE,KEY_DESIGNATION,KEY_CONTACT}; 
		Cursor cursor=db.query(TABLE_EMPLOYEE,columns,KEY_ID+"="+l1,null,null,null,null); 
		if(cursor!=null){ 
			cursor.moveToFirst(); 
			String name=cursor.getString(1); 
			return name; 
		} 
		return null; 
	} 

	public String Firstname(long l1) { 
		db=this.getReadableDatabase(); 
		String[] columns=new String[]{KEY_ID,KEY_LASTNAME,KEY_FIRSTNAME,KEY_DATE,KEY_CURRENTADDRESS,KEY_PERMANENTADDRESS,KEY_HIGHESTDEGREE,KEY_DESIGNATION,KEY_CONTACT}; 
		Cursor cursor=db.query(TABLE_EMPLOYEE,columns,KEY_ID+"="+l1,null,null,null,null); 
		if(cursor!=null){ 
			cursor.moveToFirst(); 
			String name=cursor.getString(2); 
			return name; 
		} 
		return null; 
	} 
	public String Date(long l1) { 
		db=this.getReadableDatabase(); 
		String[] columns=new String[]{KEY_ID,KEY_LASTNAME,KEY_FIRSTNAME,KEY_DATE,KEY_CURRENTADDRESS,KEY_PERMANENTADDRESS,KEY_HIGHESTDEGREE,KEY_DESIGNATION,KEY_CONTACT}; 
		Cursor cursor=db.query(TABLE_EMPLOYEE,columns,KEY_ID+"="+l1,null,null,null,null); 
		if(cursor!=null){ 
			cursor.moveToFirst(); 
			String name=cursor.getString(3); 
			return name; 
		} 
		return null; 


	} 
	public String Currentaddress(long l1) { 
		db=this.getReadableDatabase(); 
		String[] columns=new String[]{KEY_ID,KEY_LASTNAME,KEY_FIRSTNAME,KEY_DATE,KEY_CURRENTADDRESS,KEY_PERMANENTADDRESS,KEY_HIGHESTDEGREE,KEY_DESIGNATION,KEY_CONTACT}; 
		Cursor cursor=db.query(TABLE_EMPLOYEE,columns,KEY_ID+"="+l1,null,null,null,null); 
		if(cursor!=null){ 
			cursor.moveToFirst(); 
			String name=cursor.getString(4); 
			return name; 
		} 
		return null; 


	} 
	public String Permanentaddress(long l1) { 
		db=this.getReadableDatabase(); 
		String[] columns=new String[]{KEY_ID,KEY_LASTNAME,KEY_FIRSTNAME,KEY_DATE,KEY_CURRENTADDRESS,KEY_PERMANENTADDRESS,KEY_HIGHESTDEGREE,KEY_DESIGNATION,KEY_CONTACT}; 
		Cursor cursor=db.query(TABLE_EMPLOYEE,columns,KEY_ID+"="+l1,null,null,null,null); 
		if(cursor!=null){ 
			cursor.moveToFirst(); 
			String name=cursor.getString(5); 
			return name; 
		} 
		return null; 


	} 
	public String Highestdeg(long l1) { 
		db=this.getReadableDatabase(); 
		String[] columns=new String[]{KEY_ID,KEY_LASTNAME,KEY_FIRSTNAME,KEY_DATE,KEY_CURRENTADDRESS,KEY_PERMANENTADDRESS,KEY_HIGHESTDEGREE,KEY_DESIGNATION,KEY_CONTACT}; 
		Cursor cursor=db.query(TABLE_EMPLOYEE,columns,KEY_ID+"="+l1,null,null,null,null); 
		if(cursor!=null){ 
			cursor.moveToFirst(); 
			String name=cursor.getString(6); 
			return name; 
		} 
		return null; 


	} 
	public String Designation(long l1) { 
		db=this.getReadableDatabase(); 
		String[] columns=new String[]{KEY_ID,KEY_LASTNAME,KEY_FIRSTNAME,KEY_DATE,KEY_CURRENTADDRESS,KEY_PERMANENTADDRESS,KEY_HIGHESTDEGREE,KEY_DESIGNATION,KEY_CONTACT}; 
		Cursor cursor=db.query(TABLE_EMPLOYEE,columns,KEY_ID+"="+l1,null,null,null,null); 
		if(cursor!=null){ 
			cursor.moveToFirst(); 
			String name=cursor.getString(7); 
			return name; 
		} 
		return null; 


	} 
	public String Contact(long l1) { 
		db=this.getReadableDatabase(); 
		String[] columns=new String[]{KEY_ID,KEY_LASTNAME,KEY_FIRSTNAME,KEY_DATE,KEY_CURRENTADDRESS,KEY_PERMANENTADDRESS,KEY_HIGHESTDEGREE,KEY_DESIGNATION,KEY_CONTACT}; 
		Cursor cursor=db.query(TABLE_EMPLOYEE,columns,KEY_ID+"="+l1,null,null,null,null); 
		if(cursor!=null){ 
			cursor.moveToFirst(); 
			String name=cursor.getString(8); 
			return name; 
		} 
		return null; 
	} 
} 


