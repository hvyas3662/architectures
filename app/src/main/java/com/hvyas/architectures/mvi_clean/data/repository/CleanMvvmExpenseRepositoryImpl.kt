package com.hvyas.architectures.mvvm_clean.data.repository

import com.hvyas.architectures.mvvm_clean.data.dao.CleanMvvmExpenseDao
import com.hvyas.architectures.mvvm_clean.data.mapper.toDto
import com.hvyas.architectures.mvvm_clean.data.mapper.toModel
import com.hvyas.architectures.mvvm_clean.domain.model.CleanMvvmExpense
import com.hvyas.architectures.mvvm_clean.domain.repository.CleanMvvmExpenseRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CleanMvvmExpenseRepositoryImpl @Inject constructor(private val mvvmExpenseDao: CleanMvvmExpenseDao) : CleanMvvmExpenseRepository {

    override suspend fun insertExpense(mvvmExpense: CleanMvvmExpense): Boolean = mvvmExpenseDao.insert(mvvmExpense.toDto()) > 0

    override fun getAllData() = mvvmExpenseDao.getAllExpense().map { list -> list.map { it.toModel() } }.flowOn(Dispatchers.IO)

    override suspend fun deleteExpense(id: Int) = mvvmExpenseDao.deleteItem(id) > 0
}