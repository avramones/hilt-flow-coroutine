package com.harry.harrypotter.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.harry.harrypotter.model.Person

@Dao
interface CharacterDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(people: List<Person>?)

    @Query("SELECT * FROM characters WHERE house == :house")
    fun loadAllCharacters(house: String?): List<Person>?
}