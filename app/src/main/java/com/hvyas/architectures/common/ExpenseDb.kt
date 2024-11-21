package com.hvyas.architectures.common

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.hvyas.architectures.mvc.model.dao.MvcExpenseDao
import com.hvyas.architectures.mvc.model.model.MvcExpanse
import com.hvyas.architectures.mvi.data.dao.MviExpenseDao
import com.hvyas.architectures.mvi.data.domain.MviExpense

@Database(entities = [MvcExpanse::class, MviExpense::class], version = 2)
abstract class ExpenseDb : RoomDatabase() {

    abstract fun getMvcExpenseDao(): MvcExpenseDao
    abstract fun getMviExpenseDao(): MviExpenseDao

    companion object {
        @Volatile
        private var instance: ExpenseDb? = null

        fun getExpenseDb(context: Context): ExpenseDb = instance ?: synchronized(this) {
            if (instance == null) {
                instance = Room.databaseBuilder(context.applicationContext, ExpenseDb::class.java, "Expense_db")
                    .fallbackToDestructiveMigrationFrom()
                    .build()
            }
            instance!!
        }
    }
}