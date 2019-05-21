package com.example.tb;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

//创建SQLLite需要继承SQLiteOpenHelper类抽象类
public class mySQLite extends SQLiteOpenHelper{

    public static final String CREATE_GIRL = "create table Gril(_id integer primary key autoincrement,Name char(20),Age integer,Phone char(20))" ;
    private Context mContext;
//    /data/data/com.example.tb/databases
    /*
     * 构造方法参数说明
     * 第一个：传入上下文对象
     * 第二个：要创建的数据库名字
     * 第三个：油标工厂,传入油标对象，其实就是一个指针的功能。和ResultSet功能差不多，这个参数一般传入null
     * 第四个:数据库版本号，用于升级的时候调用。版本号必须大于1
     * 构造方法四个参数传入其实是给父类调用的。
     * */
    public mySQLite(Context context, String name, CursorFactory factory, int version) {
      super(context, name, factory, version);
      // TODO Auto-generated constructor stub
      mContext = context;
   }

    //数据库被创建的时候会调用这个方法  (onCreate) 在下面的语法中 直接创建了一个表格
    @SuppressLint("WrongConstant")
    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        /*db.execSQL(CREATE_BOOK);
        Toast.makeText(mContext,"Create Successded",0).show();*/
        db.execSQL(CREATE_GIRL);

        Toast.makeText(mContext,"Create Successded",0).show();
    }
    //数据库升级的时候调用
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
    }

}