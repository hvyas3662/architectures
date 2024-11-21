package com.hvyas.architectures.mvi.data.repository

import com.hvyas.architectures.mvi.data.dao.MviExpenseDao
import com.hvyas.architectures.mvi.data.domain.MviExpense

class MviExpenseRepository(private val mviExpenseDao: MviExpenseDao) {

    suspend fun insertExpense(mviExpense: MviExpense): Boolean = mviExpenseDao.insert(mviExpense) > 0

    suspend fun getAllData() = mviExpenseDao.getAllExpense()

    suspend fun deleteExpense(id: Int) = mviExpenseDao.deleteItem(id) > 0
}