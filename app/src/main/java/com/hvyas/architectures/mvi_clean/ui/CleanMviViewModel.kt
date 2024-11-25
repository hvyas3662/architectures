package com.hvyas.architectures.mvi_clean.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hvyas.architectures.common.LoadingType
import com.hvyas.architectures.mvi_clean.domain.model.CleanMviExpense
import com.hvyas.architectures.mvi_clean.domain.usecase.DeleteCleanMviExpenseUseCase
import com.hvyas.architectures.mvi_clean.domain.usecase.GetCleanMviExpenseListUseCase
import com.hvyas.architectures.mvi_clean.domain.usecase.InsertCleanMviExpenseUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class CleanMviViewModel @Inject constructor(
    private val insertCleanMviExpenseUseCase: InsertCleanMviExpenseUseCase,
    private val deleteMviExpenseUseCase: DeleteCleanMviExpenseUseCase,
    private val getCleanMviExpenseListUseCase: GetCleanMviExpenseListUseCase
) : ViewModel() {

    private val _state: MutableStateFlow<CleanMviUiState> = MutableStateFlow(CleanMviUiState.Idle)
    val state = _state.asStateFlow()

    fun handleIntent(cleanMviIntent: CleanMviIntent) = viewModelScope.launch {
        when (cleanMviIntent) {
            is CleanMviIntent.LoadExpense -> loadExpense()
            is CleanMviIntent.SaveExpense -> insertExpense(cleanMviIntent.expense)
            is CleanMviIntent.DeleteExpense -> deleteExpense(cleanMviIntent.id)
        }
    }

    private suspend fun insertExpense(expense: CleanMviExpense) = withContext(Dispatchers.IO) {
        _state.value = CleanMviUiState.Loading(LoadingType.IN_DIALOG)
        try {
            insertCleanMviExpenseUseCase(expense)
            _state.value = CleanMviUiState.SuccessMessage("Expense inserted successfully")
        } catch (e: Exception) {
            _state.value = CleanMviUiState.Error(e.message.toString())
        }
    }

    private suspend fun deleteExpense(id: Int) = withContext(Dispatchers.IO) {
        _state.value = CleanMviUiState.Loading(LoadingType.IN_DIALOG)
        try {
            deleteMviExpenseUseCase(id)
            _state.value = CleanMviUiState.SuccessMessage("Expense deleted successfully")
        } catch (e: Exception) {
            _state.value = CleanMviUiState.Error(e.message.toString())
        }
    }

    private suspend fun loadExpense() {
        _state.value = CleanMviUiState.Loading(LoadingType.IN_UI)
        getCleanMviExpenseListUseCase().collectLatest { expenseList ->
            _state.value = CleanMviUiState.Success(expenseList)
        }
    }
}