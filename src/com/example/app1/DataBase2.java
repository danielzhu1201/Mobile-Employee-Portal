package com.example.app1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBase2 extends SQLiteOpenHelper {

    //���ݿ�����
    private static final String DB_NAME="noti.db";
    //������
    private static final String TBL_NAME="noti";
    //������SQL���
    private static final String CREATE_TBL="CREATE TABLE noti(_id INTEGER PRIMARY KEY AUTOINCREMENT, info TEXT)";
    //SQLiteDatabaseʵ��
    private SQLiteDatabase db;
     
    /*
     * ���췽��
     */
    DataBase2(Context c){
        super(c,DB_NAME,null,2);
    };
    /*
     * ������
     * @see android.database.sqlite.SQLiteOpenHelper#onCreate(android.database.sqlite.SQLiteDatabase)
     */
    public void onCreate(SQLiteDatabase db)
    {
        this.db=db;
        db.execSQL(CREATE_TBL);
    }
    /*
     * ���뷽��
     */
    public void insert(ContentValues values)
    {
        //���SQLiteDatabaseʵ��
        SQLiteDatabase db=getWritableDatabase();
        //����
        db.insert(TBL_NAME, null, values);
        //�ر�
        db.close();
    }
    /*
     * ��ѯ����
     */
    public Cursor query()
    {
        //���SQLiteDatabaseʵ��
        SQLiteDatabase db=getWritableDatabase();
        //��ѯ���Cursor
        Cursor c=db.query(TBL_NAME, null, null, null, null, null, null);
        return c;
    }
    /*
     * ɾ������
     */
    public void del(int id)
    {
        if(db==null)
        {
            //���SQLiteDatabaseʵ��
            db=getWritableDatabase();           
        }
        //ִ��ɾ��
        db.delete(TBL_NAME, "_id=?", new String[]{String.valueOf(id)});     
    }
    /*
     * �ر����ݿ�
     */
    public void colse()
    {
        if(db!=null)
        {
            db.close();
        }
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
         
    }
}