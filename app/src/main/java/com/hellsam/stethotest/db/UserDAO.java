package com.hellsam.stethotest.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.hellsam.stethotest.db.model.User;

/**
 * Created by binshenchen on 16/2/26.
 */
public class UserDAO {
    private static final String TABLE_NAME = "user";
    private static final String SQL_CREATE_TABLE = "create table " + TABLE_NAME + "(_id integer primary key autoincrement, name text, phone text, created_at text, updated_at text)";
    private static UserDAO instance;

    private UserDAO() {

    }

    public static void createTable(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE);
    }

    public static UserDAO getInstance() {
        if (instance == null) {
            synchronized (UserDAO.class) {
                if (instance == null) {
                    instance = new UserDAO();
                }
            }
        }
        return instance;
    }

    public void saveUser(String phone, String name) {
        long current = System.currentTimeMillis();
        ContentValues cv = new ContentValues();
        cv.put("name", name);
        cv.put("phone", phone);
        cv.put("created_at", current + "");
        cv.put("updated_at", current + "");
        long id = DBHelper.getInstance().getWritableDatabase().insert(TABLE_NAME, null, cv);
    }

    public User selectById(long id) {
        Cursor cursor = DBHelper.getInstance().getReadableDatabase().rawQuery("select *from " + TABLE_NAME + " where _id=?", new String[]{id + ""});
        if (cursor.moveToNext()) {
            User user = new User();
            user.setId(cursor.getInt(0));
            user.setName(cursor.getString(1));
            user.setPhone(cursor.getString(2));
            return user;
        }
        return null;
    }

}
