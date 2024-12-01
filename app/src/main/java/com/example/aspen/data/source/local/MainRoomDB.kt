package com.example.aspen.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.aspen.data.model.MainEntityModel

@Database(entities = [MainEntityModel::class], version = 1, exportSchema = false)
abstract class MainRoomDB : RoomDatabase() {
    abstract fun mainDao(): MainDao
}