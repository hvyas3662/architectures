package com.hvyas.architectures.mvc.controller

import com.hvyas.architectures.mvc.model.model.MvcExpanse
import com.hvyas.architectures.mvc.model.repository.MvcExpenseRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MvcListingController(private val repository: MvcExpenseRepository, private val scope: CoroutineScope = CoroutineScope(Dispatchers.Main)) {

    fun saveData(expanse: MvcExpanse, result: (List<MvcExpanse>) -> Unit) {
        scope.launch {
            withContext(Dispatchers.IO) {
                if (repository.insertExpense(expanse)) {
                    val list = repository.getAllData()
                    withContext(Dispatchers.Main) { result(list) }
                }
            }
        }
    }

    fun getData(result: (List<MvcExpanse>) -> Unit) {
        scope.launch {
            result(withContext(Dispatchers.IO) { repository.getAllData() })
        }
    }

    fun deleteItem(id: Int, result: (List<MvcExpanse>) -> Unit) {
        scope.launch {
            withContext(Dispatchers.IO) {
                if (repository.deleteExpense(id)) {
                    val list = repository.getAllData()
                    withContext(Dispatchers.Main) { result(list) }
                }
            }
        }
    }
}