package com.hellsam.stethotest.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.hellsam.stethotest.App;


/**
 * Created by binshenchen on 16/2/29.
 */
public class DBHelper extends SQLiteOpenHelper {
    private static DBHelper instence;

    public static final String DATABASE_NAME = "hellsam.db";

    private static int DATABASE_VERSION = 1;

    private final Context context;

    private DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    public static DBHelper getInstance() {
        if (instence == null) {
            synchronized (DBHelper.class) {
                if (instence == null) {
                    instence = new DBHelper(App.getContext());
                }
            }
        }
        return instence;
    }

    /**
     * 数据库第一次被创建时被调用（不在构造函数中发生，是在调用getWritableDatabase或getReadableDatabase时被调用时）
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        UserDAO.getInstance().createTable(db);
    }

    /**
     * 数据库的版本号表明要升级时被调用
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
