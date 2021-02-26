package com.adematici.turkcesozlukveatasozleri.database

import android.content.ContentValues
import com.adematici.turkcesozlukveatasozleri.model.ArananKelimelerModel

class GecmisDao {

    fun kelimeEkle(vt: VeritabaniYardimcisi, kelime: String){
        val db = vt.writableDatabase
        val values = ContentValues()

        values.put("kelime",kelime)

        db.insertOrThrow("gecmis",null,values)
        db.close()
    }

    fun tumKelimeler(vt: VeritabaniYardimcisi): ArrayList<ArananKelimelerModel>{
        val kelimelerArrayList = ArrayList<ArananKelimelerModel>()
        val db = vt.writableDatabase
        val cursor = db.rawQuery("SELECT * FROM gecmis",null)

        while (cursor.moveToNext()){
            val kelime = ArananKelimelerModel(cursor.getInt(cursor.getColumnIndex("kelime_id")),
                cursor.getString(cursor.getColumnIndex("kelime")))
            kelimelerArrayList.add(kelime)
        }
        return kelimelerArrayList
    }

    fun kelimeSil(vt: VeritabaniYardimcisi,kelime_id: Int){
        val db = vt.writableDatabase
        db.delete("gecmis","kelime_id=?", arrayOf(kelime_id.toString()))
        db.close()
    }

    fun tumKelimeleriSil(vt: VeritabaniYardimcisi){
        val db = vt.writableDatabase
        db.delete("gecmis",null, null)
    }

}