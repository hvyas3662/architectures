package com.hvyas.architectures.mvvm_clean.domain.usecase

import com.hvyas.architectures.mvvm_clean.domain.model.CleanMvvmExpense
import com.hvyas.architectures.mvvm_clean.domain.repository.CleanMvvmExpenseRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCleanMvvmExpenseListUseCase @Inject constructor(private val cleanMvvmExpenseRepository: CleanMvvmExpenseRepository) {
    operator fun invoke(): Flow<List<CleanMvvmExpense>> = cleanMvvmExpenseRepository.getAllData()
}