package com.hvyas.architectures.mvi_clean.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hvyas.architectures.common.LoadingType
import com.hvyas.architectures.mvi.data.domain.MviExpense
import com.hvyas.architectures.mvi.data.repository.MviExpenseRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MviViewModel @Inject constructor(private val repository: MviExpenseRepository) : ViewModel() {

    private val _state: MutableStateFlow<MviUiState> = MutableStateFlow(MviUiState.Idle)
    val state = _state.asStateFlow()

    fun handleIntent(mviIntent: MviIntent) = viewModelScope.launch {
        when (mviIntent) {
            is MviIntent.LoadExpense -> loadExpense()
            is MviIntent.SaveExpense -> insertExpense(mviIntent.expense)
            is MviIntent.DeleteExpense -> deleteExpense(mviIntent.id)
        }
    }

    private suspend fun insertExpense(expense: MviExpense) = withContext(Dispatchers.IO) {
        _state.value = MviUiState.Loading(LoadingType.IN_DIALOG)
        try {
            repository.insertExpense(expense)
            _state.value = MviUiState.SuccessMessage("Expense inserted successfully")
        } catch (e: Exception) {
            _state.value = MviUiState.Error(e.message.toString())
        }
    }

    private suspend fun deleteExpense(id: Int) = withContext(Dispatchers.IO) {
        _state.value = MviUiState.Loading(LoadingType.IN_DIALOG)
        try {
            repository.deleteExpense(id)
            _state.value = MviUiState.SuccessMessage("Expense deleted successfully")
        } catch (e: Exception) {
            _state.value = MviUiState.Error(e.message.toString())
        }
    }

    private suspend fun loadExpense() {
        _state.value = MviUiState.Loading(LoadingType.IN_UI)
        repository.getAllData().collectLatest { expenseList ->
            _state.value = MviUiState.Success(expenseList)
        }
    }
}