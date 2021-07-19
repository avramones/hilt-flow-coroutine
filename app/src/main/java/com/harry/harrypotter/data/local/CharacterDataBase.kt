package com.harry.harrypotter.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.harry.harrypotter.model.Person

@Database(entities = [Person::class], version = 1)
abstract class CharacterDataBase : RoomDatabase() {
    abstract fun characterDao(): CharacterDao?
}