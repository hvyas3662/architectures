package com.hvyas.architectures.mvi_clean.ui

import com.hvyas.architectures.common.LoadingType
import com.hvyas.architectures.mvi.data.domain.MviExpense

sealed class MviUiState {
    data object Idle : MviUiState()
    data class Loading(val loadingType: LoadingType) : MviUiState()
    data class Success(val expenseList: List<MviExpense>) : MviUiState()
    data class SuccessMessage(val message: String) : MviUiState()
    data class Error(val message: String) : MviUiState()
}