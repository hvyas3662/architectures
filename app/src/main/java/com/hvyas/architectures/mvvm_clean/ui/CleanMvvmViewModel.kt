package com.hvyas.architectures.mvvm_clean.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hvyas.architectures.mvvm_clean.domain.model.CleanMvvmExpense
import com.hvyas.architectures.mvvm_clean.domain.usecase.DeleteCleanMvvmExpenseUseCase
import com.hvyas.architectures.mvvm_clean.domain.usecase.GetCleanMvvmExpenseListUseCase
import com.hvyas.architectures.mvvm_clean.domain.usecase.InsertCleanMvvmExpenseUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CleanMvvmViewModel @Inject constructor(
    private val getCleanMvvmExpenseListUseCase: GetCleanMvvmExpenseListUseCase,
    private val insertCleanMvvmExpenseUseCase: InsertCleanMvvmExpenseUseCase,
    private val deleteCleanMvvmExpenseUseCase: DeleteCleanMvvmExpenseUseCase
) : ViewModel() {

    private val _state: MutableStateFlow<List<CleanMvvmExpense>> = MutableStateFlow(emptyList())
    val state = _state.asStateFlow()

    fun saveExpense(expense: CleanMvvmExpense) {
        viewModelScope.launch(Dispatchers.IO) {
            insertCleanMvvmExpenseUseCase(expense)
        }
    }

    fun delete(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            deleteCleanMvvmExpenseUseCase(id)
        }
    }

    fun loadExpense() {
        viewModelScope.launch(Dispatchers.IO) {
            getCleanMvvmExpenseListUseCase().collectLatest { _state.value = it }
        }
    }
}