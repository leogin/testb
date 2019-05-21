package com.example.tb;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public mySQLite myDatebaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDatebaseHelper = new mySQLite(this, "people.db", null, 1);
    }


    public void Create_Datebase(View v){
        /*
         * 如果数据库没有被创建，就创建并获取一个可写（其实也可以读）的数据库 如果数据库被创建，就直接获取一个可写（其实也可以读）的数据库
         * 路径data/data/database/people.db
         */
//        myDatebaseHelper = new mySQLite(this, "people.db", null, 1);
        myDatebaseHelper.getWritableDatabase();


    }

    //使用api添加数据
    public void Add_Data(View v){
        //拿到数据库对象
        SQLiteDatabase db = myDatebaseHelper.getWritableDatabase();
        //插入数据SQL语句
//        String sql="insert into Gril(Name,Age,Phone) values('xiaoming',22,'01005')";
////执行SQL语句
        String a = "cc";
        int c = 33;
        String b = "1231";
        String sql2="insert into Gril(Name,Age,Phone) values('"+a+"',"+c+",'"+b+"')";
//        db.execSQL(sql);
        db.execSQL(sql2);

//        db.close();
        /*
         * 将要添加的数据封装在ContentValues对象中
         * */
//        ContentValues values = new ContentValues();
//        values.put("Name", "JoyceChu");
//        values.put("Age", 18);
//        values.put("Phone", "1380013");
//        /*
//         * 第一个参数，表名
//         * 第二个参数，一般传入null
//         * 第三个参数，ContentValues对象
//         * 注意，db.insert("Gril", null, values);这条语句有返回值，如果返回-1表示插入数据失败
//         * 所以，我们可以通过返回值判断是否插入成功
//         * */
//        db.insert("Girl", null, values);
//        values.clear();
//        values.put("Name", "四叶草");
//        values.put("Age", 19);
//        values.put("Phone", "1380013");
//        db.insert("Girl", null, values);
//        values.clear();
//        values.put("Name", "朱主爱");
//        values.put("Age", 19);
//        values.put("Phone", "1380013");
//        db.insert("Girl", null, values);
//        values.clear();
//        values.put("Name", "新垣结衣");
//        values.put("Age", 19);
//        values.put("Phone", "1380013");
//        db.insert("Girl", null, values);
//        values.clear();
//        values.put("Name", "刘诗诗");
//        values.put("Age", 19);
//        values.put("Phone", "1380013");
//        db.insert("Girl", null, values);
//        values.clear();
//        values.put("Name", "金莎");
//        values.put("Age", 25);
//        values.put("Phone", "1380013");
//        db.insert("Girl", null, values);
//        values.clear();
//        values.put("Name", "林志玲");
//        values.put("Age", 25);
//        values.put("Phone", "1380013");
//        db.insert("Girl", null, values);
        Toast.makeText(MainActivity.this, "Add Successded", Toast.LENGTH_SHORT).show();

    }

    //删除数据
    public void Delete_Data(View v) {
        //拿到数据库对象
        SQLiteDatabase db = myDatebaseHelper.getWritableDatabase();
        //删除SQL语句
        int num = 3;
//        String sql = "delete from Gril where _id = 3";
        String sql = "delete from Gril where _id ="+num;
        //执行SQL语句
        db.execSQL(sql);
        Toast.makeText(MainActivity.this, "Delete Successded", Toast.LENGTH_SHORT).show();
    }



    //更新数据 修改数据
    public void Update_Data(View v){

        SQLiteDatabase db = myDatebaseHelper.getWritableDatabase();
        //修改SQL语句
        int num = 5;
//        String sql = "update Gril set Age = 16 where _id = 5";
        String sql = "update Gril set Age = 16 where _id ="+ num ;
//执行SQL
        db.execSQL(sql);
        Toast.makeText(MainActivity.this, "Update Successded", Toast.LENGTH_SHORT).show();
    }

    public void Search_Data(View v) {
        SQLiteDatabase db = myDatebaseHelper.getWritableDatabase();
//查询获得游标
        Cursor cursor = db.query ("Gril",null,null,null,null,null,null);

//判断游标是否为空
        if(cursor.moveToFirst()){
//            cursor.move(0);
////获得ID
//            int id = cursor.getInt(0);
////获得用户名
//            String name=cursor.getString(1);
////获得密码
//            String age=cursor.getString(2);
////输出用户信息 System.out.println(id+":"+sname+":"+snumber);
//            Toast.makeText(MainActivity.this, "Detail:"+id+"  "+name+"  "+age, Toast.LENGTH_SHORT).show();
////遍历游标
            for(int i=0;i<cursor.getCount();i++){
                cursor.move(i);
//获得ID
                int id = cursor.getInt(0);
//获得用户名
                String name=cursor.getString(1);
//获得密码
                String age=cursor.getString(2);
//输出用户信息 System.out.println(id+":"+sname+":"+snumber);
                Toast.makeText(MainActivity.this, "Detail:"+id+"  "+name+"  "+age, Toast.LENGTH_SHORT).show();
            }
        }
    }

    //    删除指定表
    public void Delete_Table(View v) {

        SQLiteDatabase db = myDatebaseHelper.getWritableDatabase();
        //删除表的SQL语句
        String sql ="DROP TABLE Gril";
//执行SQL
        db.execSQL(sql);
        Toast.makeText(MainActivity.this, "Delete Table Successded", Toast.LENGTH_SHORT).show();
    }



//    public void create(View view) {
//        db = SQLiteDatabase.openOrCreateDatabase("/data/data/com.example.tb/databases/stu.db", null);
//    }
//
//    public void createTable(View view){
//
//        //创建表SQL语句
//        String stu_table="create table usertable(_id integer primary key autoincrement,sname text,snumber text)";
//        //执行SQL语句
//        db.execSQL(stu_table);
//    }
//
//    public void insertData(View view){
//        String stu_sql="insert into stu_table(sname,snumber) values('xiaoming','01005')";
////执行SQL语句
//        db.execSQL(stu_sql);
//    }


}
