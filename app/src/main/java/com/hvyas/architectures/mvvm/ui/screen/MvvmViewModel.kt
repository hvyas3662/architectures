package com.hvyas.architectures.mvvm.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hvyas.architectures.mvvm.data.model.MvvmExpense
import com.hvyas.architectures.mvvm.data.repository.MvvmExpenseRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MvvmViewModel @Inject constructor(private val mvvmExpenseRepository: MvvmExpenseRepository) : ViewModel() {

    private val _state: MutableStateFlow<List<MvvmExpense>> = MutableStateFlow(emptyList())
    val state = _state.asStateFlow()

    fun saveExpense(expense: MvvmExpense) {
        viewModelScope.launch(Dispatchers.IO) {
            mvvmExpenseRepository.insertExpense(expense)
        }
    }

    fun delete(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            mvvmExpenseRepository.deleteExpense(id)
        }
    }

    fun loadExpense() {
        viewModelScope.launch(Dispatchers.IO) {
            mvvmExpenseRepository.getAllData().collectLatest {
                _state.value = it
            }
        }
    }
}