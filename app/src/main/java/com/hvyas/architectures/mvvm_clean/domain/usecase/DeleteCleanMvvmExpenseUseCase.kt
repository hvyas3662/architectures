package com.hvyas.architectures.mvvm_clean.domain.usecase

import com.hvyas.architectures.mvvm_clean.domain.repository.CleanMvvmExpenseRepository
import javax.inject.Inject

class DeleteCleanMvvmExpenseUseCase @Inject constructor(private val cleanMvvmExpenseRepository: CleanMvvmExpenseRepository) {
    suspend operator fun invoke(id: Int) = cleanMvvmExpenseRepository.deleteExpense(id)
}