package com.hvyas.architectures.mvi_clean.ui

import com.hvyas.architectures.common.LoadingType
import com.hvyas.architectures.mvi_clean.domain.model.CleanMviExpense

sealed class CleanMviUiState {
    data object Idle : CleanMviUiState()
    data class Loading(val loadingType: LoadingType) : CleanMviUiState()
    data class Success(val expenseList: List<CleanMviExpense>) : CleanMviUiState()
    data class SuccessMessage(val message: String) : CleanMviUiState()
    data class Error(val message: String) : CleanMviUiState()
}