package com.hvyas.architectures.mvvm_clean.data.repository

import com.hvyas.architectures.mvvm_clean.data.dao.CleanMvvmExpenseDao
import com.hvyas.architectures.mvvm_clean.data.dto.CleanMvvmExpense
import javax.inject.Inject

class CleanMvvmExpenseRepository @Inject constructor(private val mvvmExpenseDao: CleanMvvmExpenseDao) {

    suspend fun insertExpense(mvvmExpense: CleanMvvmExpense): Boolean = mvvmExpenseDao.insert(mvvmExpense) > 0

    fun getAllData() = mvvmExpenseDao.getAllExpense()

    suspend fun deleteExpense(id: Int) = mvvmExpenseDao.deleteItem(id) > 0
}