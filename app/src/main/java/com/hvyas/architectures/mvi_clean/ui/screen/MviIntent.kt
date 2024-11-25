package com.hvyas.architectures.mvi_clean.ui.screen

import com.hvyas.architectures.mvi.data.domain.MviExpense

sealed class MviIntent {
    data object LoadExpense : MviIntent()
    class SaveExpense(val expense: MviExpense) : MviIntent()
    class DeleteExpense(val id: Int) : MviIntent()
}