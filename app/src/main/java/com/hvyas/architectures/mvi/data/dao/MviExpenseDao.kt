package com.hvyas.architectures.mvi.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hvyas.architectures.mvi.data.domain.MviExpense

@Dao
interface MviExpenseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(mviExpense: MviExpense): Long

    @Query("select * from MviExpense where 1 order by id desc")
    suspend fun getAllExpense(): List<MviExpense>

    @Query("Delete from MviExpense where id= :id")
    suspend fun deleteItem(id: Int): Int
}