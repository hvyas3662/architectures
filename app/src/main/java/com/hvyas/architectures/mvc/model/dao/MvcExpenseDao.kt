package com.hvyas.architectures.mvc.model.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hvyas.architectures.mvc.model.model.MvcExpanse

@Dao
interface MvcExpenseDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(expanse: MvcExpanse): Long

    @Query("Select * from mvcExpanse where 1 order by id desc")
    suspend fun getAllExpense(): List<MvcExpanse>

    @Query("delete from mvcExpanse where id = :id")
    suspend fun deleteItem(id: Int): Int
}