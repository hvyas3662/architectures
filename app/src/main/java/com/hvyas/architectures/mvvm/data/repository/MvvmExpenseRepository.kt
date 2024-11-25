package com.hvyas.architectures.mvvm.data.repository

import com.hvyas.architectures.mvvm.data.dao.MvvmExpenseDao
import com.hvyas.architectures.mvvm.data.model.MvvmExpense
import javax.inject.Inject

class MvvmExpenseRepository @Inject constructor(private val mvvmExpenseDao: MvvmExpenseDao) {

    suspend fun insertExpense(mvvmExpense: MvvmExpense): Boolean = mvvmExpenseDao.insert(mvvmExpense) > 0

    fun getAllData() = mvvmExpenseDao.getAllExpense()

    suspend fun deleteExpense(id: Int) = mvvmExpenseDao.deleteItem(id) > 0
}