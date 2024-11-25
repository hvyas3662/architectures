package com.hvyas.architectures.mvvm_clean.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hvyas.architectures.mvvm_clean.data.dto.CleanMvvmExpenseDto
import kotlinx.coroutines.flow.Flow

@Dao
interface CleanMvvmExpenseDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(cleanMvvmExpense: CleanMvvmExpenseDto): Long

    @Query("select * from CleanMvvmExpense where 1 order by id desc")
    fun getAllExpense(): Flow<List<CleanMvvmExpenseDto>>

    @Query("Delete from CleanMvvmExpense where id= :id")
    suspend fun deleteItem(id: Int): Int
}