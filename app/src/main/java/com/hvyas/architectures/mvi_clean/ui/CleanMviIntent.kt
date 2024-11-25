package com.hvyas.architectures.mvi_clean.ui

import com.hvyas.architectures.mvi_clean.domain.model.CleanMviExpense


sealed class CleanMviIntent {
    data object LoadExpense : CleanMviIntent()
    class SaveExpense(val expense: CleanMviExpense) : CleanMviIntent()
    class DeleteExpense(val id: Int) : CleanMviIntent()
}