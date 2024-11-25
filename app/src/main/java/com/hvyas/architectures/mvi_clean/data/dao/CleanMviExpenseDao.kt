package com.hvyas.architectures.mvi_clean.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hvyas.architectures.mvi_clean.data.dto.CleanMviExpenseDto
import kotlinx.coroutines.flow.Flow

@Dao
interface CleanMviExpenseDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(cleanMviExpenseDto: CleanMviExpenseDto): Long

    @Query("select * from CleanMviExpense where 1 order by id desc")
    fun getAllExpense(): Flow<List<CleanMviExpenseDto>>

    @Query("Delete from CleanMviExpense where id= :id")
    suspend fun deleteItem(id: Int): Int
}