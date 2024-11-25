package com.hvyas.architectures.mvi_clean.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hvyas.architectures.mvi.data.domain.MviExpense
import kotlinx.coroutines.flow.Flow

@Dao
interface MviExpenseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(mviExpense: MviExpense): Long

    @Query("select * from MviExpense where 1 order by id desc")
    fun getAllExpense(): Flow<List<MviExpense>>

    @Query("Delete from MviExpense where id= :id")
    suspend fun deleteItem(id: Int): Int
}