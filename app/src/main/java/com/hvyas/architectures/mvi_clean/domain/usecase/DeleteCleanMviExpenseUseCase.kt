package com.hvyas.architectures.mvi_clean.domain.usecase

import com.hvyas.architectures.mvi_clean.domain.repository.CleanMviExpenseRepository
import javax.inject.Inject

class DeleteCleanMviExpenseUseCase @Inject constructor(private val cleanMviExpenseRepository: CleanMviExpenseRepository) {
    suspend operator fun invoke(id: Int) = cleanMviExpenseRepository.deleteExpense(id)
}