package com.hvyas.architectures.mvi_clean.domain.usecase

import com.hvyas.architectures.mvi_clean.domain.model.CleanMviExpense
import com.hvyas.architectures.mvi_clean.domain.repository.CleanMviExpenseRepository
import javax.inject.Inject

class InsertCleanMviExpenseUseCase @Inject constructor(private val cleanMviExpenseRepository: CleanMviExpenseRepository) {
    suspend operator fun invoke(cleanMvvmExpense: CleanMviExpense) = cleanMviExpenseRepository.insertExpense(cleanMvvmExpense)
}