package com.sergey.mememark.data.storage.sharedrefs

import android.content.ContentValues
import android.content.Context
import com.sergey.mememark.data.storage.IUserStorage
import android.database.sqlite.SQLiteDatabase
import com.sergey.mememark.data.storage.models.UserForStorage
import android.database.sqlite.SQLiteOpenHelper
class SharedPrefUserStorage (val context: Context, val factory: SQLiteDatabase.CursorFactory?):
    IUserStorage,
    SQLiteOpenHelper(context, "myAppBD", factory, 1){
    override fun onCreate(db: SQLiteDatabase?) {
        val query = "CREATE TABLE users (id INT PRIMARY KEY, login TEXT, email TEXT, pass TEXT)"
        db!!.execSQL(query);
    }
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS users")
        onCreate(db)
    }
    override fun save(saveparam: UserForStorage): Boolean {
        var rez: Long = 0
        val db = this.writableDatabase

        val values = ContentValues()
        values.put("login", saveparam.login)
        values.put("email", saveparam.email)
        values.put("pass", saveparam.pass)

        rez = db.insert("users", null, values)

        db.close()
        return if (rez == -1L) false else true
    }

    override fun get(login: String, pass: String): Boolean {
        val db = this.readableDatabase
        val result = db.rawQuery("SELECT * FROM users WHERE login = '$login' AND pass = '$pass'",null)
        return result.moveToFirst()
    }


}