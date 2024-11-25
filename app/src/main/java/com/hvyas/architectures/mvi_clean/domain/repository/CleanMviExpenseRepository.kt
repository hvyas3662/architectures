package com.hvyas.architectures.mvi_clean.domain.repository

import com.hvyas.architectures.mvi_clean.domain.model.CleanMviExpense
import kotlinx.coroutines.flow.Flow

interface CleanMviExpenseRepository {

    suspend fun insertExpense(cleanMviExpense: CleanMviExpense): Boolean

    fun getAllData(): Flow<List<CleanMviExpense>>

    suspend fun deleteExpense(id: Int): Boolean
}