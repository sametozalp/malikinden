package com.ozalp.malikinden.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.ozalp.malikinden.model.BaseModel
import com.ozalp.malikinden.model.Product
import com.ozalp.malikinden.util.Converter

@Database(
    entities = arrayOf(Product::class),
    version = 1,
)
@TypeConverters(Converter::class)
abstract class MalikindenDatabase: RoomDatabase() {

    abstract fun productDao(): ProductDao

    companion object {

        private val lock = Any()
        private var instance: MalikindenDatabase? = null

        operator fun invoke(context: Context) = instance ?: synchronized(lock) {
            instance ?: makeDatabase(context).also {
                instance = it
            }
        }

        private fun makeDatabase(context: Context): MalikindenDatabase {
            return Room.databaseBuilder(context.applicationContext,MalikindenDatabase::class.java,"database").build()
        }
    }
}