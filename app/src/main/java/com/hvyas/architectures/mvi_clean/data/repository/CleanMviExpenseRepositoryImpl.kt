package com.hvyas.architectures.mvi_clean.data.repository


import com.hvyas.architectures.mvi_clean.data.dao.CleanMviExpenseDao
import com.hvyas.architectures.mvi_clean.data.mapper.toDto
import com.hvyas.architectures.mvi_clean.data.mapper.toModel
import com.hvyas.architectures.mvi_clean.domain.model.CleanMviExpense
import com.hvyas.architectures.mvi_clean.domain.repository.CleanMviExpenseRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CleanMviExpenseRepositoryImpl @Inject constructor(private val cleanMviExpenseDao: CleanMviExpenseDao) : CleanMviExpenseRepository {

    override suspend fun insertExpense(cleanMviExpense: CleanMviExpense): Boolean = cleanMviExpenseDao.insert(cleanMviExpense.toDto()) > 0

    override fun getAllData() = cleanMviExpenseDao.getAllExpense().map { list -> list.map { it.toModel() } }.flowOn(Dispatchers.IO)

    override suspend fun deleteExpense(id: Int) = cleanMviExpenseDao.deleteItem(id) > 0
}