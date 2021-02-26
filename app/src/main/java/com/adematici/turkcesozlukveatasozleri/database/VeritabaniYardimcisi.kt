package com.adematici.turkcesozlukveatasozleri.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class VeritabaniYardimcisi(context: Context): SQLiteOpenHelper(context,"gecmisArananKelimeler",null,1) {

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(
            "CREATE TABLE gecmis(kelime_id INTEGER PRIMARY KEY AUTOINCREMENT, kelime TEXT);"
        )
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS gecmis")
        db?.close()
    }

}