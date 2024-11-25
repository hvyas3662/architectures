package com.hvyas.architectures.mvvm_clean.domain.repository

import com.hvyas.architectures.mvvm_clean.data.dto.CleanMvvmExpense
import kotlinx.coroutines.flow.Flow

interface CleanMvvmExpenseRepository {

    suspend fun insertExpense(mvvmExpense: CleanMvvmExpense): Boolean

    fun getAllData(): Flow<List<CleanMvvmExpense>>

    suspend fun deleteExpense(id: Int): Boolean
}