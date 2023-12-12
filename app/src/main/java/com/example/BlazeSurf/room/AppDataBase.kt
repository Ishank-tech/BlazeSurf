package com.example.BlazeSurf.room

import android.content.Context
import androidx.room.*
import com.example.BlazeSurf.model.DownloadModel

@Database(entities = [DownloadModel::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun channelDao(): Dao
    companion object{
        @Volatile
        private  var instance: AppDatabase? = null
        private  val LOCK=Any()
        operator  fun invoke(context: Context)= instance?: synchronized(LOCK){
            instance?:createDatabase(context).also {it->
                instance=it
            }
        }
        private  fun  createDatabase(context: Context)= Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "downloads.db"
        ).allowMainThreadQueries().build()
    }
}