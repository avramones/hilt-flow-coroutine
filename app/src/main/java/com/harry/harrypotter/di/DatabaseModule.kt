package com.harry.harrypotter.di

import android.content.Context
import androidx.room.Room
import com.harry.harrypotter.data.local.CharacterDao
import com.harry.harrypotter.data.local.CharacterDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {

    @Provides
    @Singleton
    fun provideCharacterDatabase(
        @ApplicationContext context: Context
    ): CharacterDataBase {
        return Room.databaseBuilder(
            context,
            CharacterDataBase::class.java,
            "database"
        ).build()
    }

    @Provides
    fun provideNoteDao(db: CharacterDataBase): CharacterDao? {
        return db.characterDao()
    }

}