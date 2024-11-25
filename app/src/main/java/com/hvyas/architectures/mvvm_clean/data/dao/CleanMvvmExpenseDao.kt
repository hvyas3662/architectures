package com.hvyas.architectures.mvvm_clean.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hvyas.architectures.mvvm_clean.data.dto.CleanMvvmExpense
import kotlinx.coroutines.flow.Flow

@Dao
interface CleanMvvmExpenseDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(mvvmExpense: CleanMvvmExpense): Long

    @Query("select * from MvvmExpense where 1 order by id desc")
    fun getAllExpense(): Flow<List<CleanMvvmExpense>>

    @Query("Delete from MvvmExpense where id= :id")
    suspend fun deleteItem(id: Int): Int
}