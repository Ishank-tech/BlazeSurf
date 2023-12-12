package com.example.BlazeSurf.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.BlazeSurf.model.DownloadModel

@Dao
interface Dao {

    @Query("SELECT * FROM downloadsTable")
     suspend fun getAllDownloads(): List<DownloadModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsertDownload(download: DownloadModel)
}