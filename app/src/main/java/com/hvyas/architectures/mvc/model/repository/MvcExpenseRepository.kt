package com.hvyas.architectures.mvc.model.repository

import com.hvyas.architectures.mvc.model.dao.MvcExpenseDao
import com.hvyas.architectures.mvc.model.model.MvcExpanse

class MvcExpenseRepository(private val mvcExpenseDao: MvcExpenseDao) {

    suspend fun insertExpense(expense: MvcExpanse): Boolean = mvcExpenseDao.insert(expense) > 0L

    suspend fun getAllData() = mvcExpenseDao.getAllExpense()

    suspend fun deleteExpense(id: Int): Boolean = mvcExpenseDao.deleteItem(id) > 0

}