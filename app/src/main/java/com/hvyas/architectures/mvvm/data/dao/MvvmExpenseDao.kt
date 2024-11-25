package com.hvyas.architectures.mvvm.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hvyas.architectures.mvvm.data.model.MvvmExpense
import kotlinx.coroutines.flow.Flow

@Dao
interface MvvmExpenseDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(mvvmExpense: MvvmExpense): Long

    @Query("select * from MvvmExpense where 1 order by id desc")
    fun getAllExpense(): Flow<List<MvvmExpense>>

    @Query("Delete from MvvmExpense where id= :id")
    suspend fun deleteItem(id: Int): Int
}