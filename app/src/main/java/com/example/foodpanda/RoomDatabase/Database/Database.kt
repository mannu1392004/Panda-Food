package com.example.foodpanda.RoomDatabase.Database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.foodpanda.RoomDatabase.Dao.Cart_dao
import com.example.foodpanda.RoomDatabase.entity.Cart_entity


@Database(
    entities = [Cart_entity::class],
    version = 2
)
 abstract  class Database:RoomDatabase() {

     abstract val dao: Cart_dao

 }