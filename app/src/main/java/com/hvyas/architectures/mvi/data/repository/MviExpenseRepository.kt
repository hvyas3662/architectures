package com.hvyas.architectures.mvi.data.repository

import com.hvyas.architectures.mvi.data.dao.MviExpenseDao
import com.hvyas.architectures.mvi.data.domain.MviExpense
import javax.inject.Inject

class MviExpenseRepository @Inject constructor(private val mviExpenseDao: MviExpenseDao) {

    suspend fun insertExpense(mviExpense: MviExpense): Boolean = mviExpenseDao.insert(mviExpense) > 0

     fun getAllData() = mviExpenseDao.getAllExpense()

    suspend fun deleteExpense(id: Int) = mviExpenseDao.deleteItem(id) > 0
}