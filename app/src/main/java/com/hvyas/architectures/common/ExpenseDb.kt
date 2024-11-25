package com.hvyas.architectures.common

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.hvyas.architectures.mvc.model.dao.MvcExpenseDao
import com.hvyas.architectures.mvc.model.model.MvcExpanse
import com.hvyas.architectures.mvi.data.dao.MviExpenseDao
import com.hvyas.architectures.mvi.data.domain.MviExpense
import com.hvyas.architectures.mvvm.data.dao.MvvmExpenseDao
import com.hvyas.architectures.mvvm.data.model.MvvmExpense

@Database(entities = [MvcExpanse::class, MviExpense::class, MvvmExpense::class], version = 3)
abstract class ExpenseDb : RoomDatabase() {

    abstract fun getMvcExpenseDao(): MvcExpenseDao
    abstract fun getMviExpenseDao(): MviExpenseDao
    abstract fun getMvvmExpenseDao(): MvvmExpenseDao

    companion object {
        @Volatile
        private var instance: ExpenseDb? = null

        fun getExpenseDb(context: Context): ExpenseDb = instance ?: synchronized(this) {
            if (instance == null) {
                instance = Room.databaseBuilder(context.applicationContext, ExpenseDb::class.java, "Expense_db")
                    .fallbackToDestructiveMigration()
                    .build()
            }
            instance!!
        }
    }
}