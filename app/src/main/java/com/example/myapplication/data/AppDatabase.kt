package com.example.myapplication.data

import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import android.content.Context
import android.util.Log
import com.example.myapplication.data.response.ResponseDao
import com.example.myapplication.data.response.ResponseModel

@Database(entities = [ResponseModel::class],version = 2,exportSchema = false)
@TypeConverters(CustomTypeConverter::class)
abstract class AppDatabase:RoomDatabase() {
    abstract fun responseDao():ResponseDao
    companion object
    {
      private var INSTANCE:AppDatabase?=null
        fun getInstance(context:Context):AppDatabase
        {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java, "ResponseDb.db"
                ).addCallback(object : RoomDatabase.Callback(){
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                    }
                    override fun onOpen(db: SupportSQLiteDatabase) {
                        super.onOpen(db)
                    }
                })
                    .fallbackToDestructiveMigration().build()
            }
            return INSTANCE!!
        }
    }
}
