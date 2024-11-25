package com.hvyas.architectures.mvvm_clean.domain.usecase

import com.hvyas.architectures.mvvm_clean.domain.model.CleanMvvmExpense
import com.hvyas.architectures.mvvm_clean.domain.repository.CleanMvvmExpenseRepository
import javax.inject.Inject

class InsertCleanMvvmExpenseUseCase @Inject constructor(private val cleanMvvmExpenseRepository: CleanMvvmExpenseRepository) {
    suspend operator fun invoke(cleanMvvmExpense: CleanMvvmExpense) = cleanMvvmExpenseRepository.insertExpense(cleanMvvmExpense)
}