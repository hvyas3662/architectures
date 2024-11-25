package com.hvyas.architectures.mvvm_clean.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hvyas.architectures.mvvm_clean.data.dto.CleanMvvmExpense
import com.hvyas.architectures.mvvm_clean.data.repository.CleanMvvmExpenseRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CleanMvvmViewModel @Inject constructor(private val mvvmExpenseRepository: CleanMvvmExpenseRepositoryImpl) : ViewModel() {

    private val _state: MutableStateFlow<List<CleanMvvmExpense>> = MutableStateFlow(emptyList())
    val state = _state.asStateFlow()

    fun saveExpense(expense: CleanMvvmExpense) {
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