package com.hvyas.architectures.mvvm_clean.data.repository

import com.hvyas.architectures.mvvm_clean.data.dao.CleanMvvmExpenseDao
import com.hvyas.architectures.mvvm_clean.data.dto.CleanMvvmExpense
import com.hvyas.architectures.mvvm_clean.domain.repository.CleanMvvmExpenseRepository
import javax.inject.Inject

class CleanMvvmExpenseRepositoryImpl @Inject constructor(private val mvvmExpenseDao: CleanMvvmExpenseDao) : CleanMvvmExpenseRepository {

    override suspend fun insertExpense(mvvmExpense: CleanMvvmExpense): Boolean = mvvmExpenseDao.insert(mvvmExpense) > 0

    override fun getAllData() = mvvmExpenseDao.getAllExpense()

    override suspend fun deleteExpense(id: Int) = mvvmExpenseDao.deleteItem(id) > 0
}