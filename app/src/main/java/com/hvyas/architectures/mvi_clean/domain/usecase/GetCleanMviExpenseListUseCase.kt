package com.hvyas.architectures.mvi_clean.domain.usecase

import com.hvyas.architectures.mvi_clean.domain.model.CleanMviExpense
import com.hvyas.architectures.mvi_clean.domain.repository.CleanMviExpenseRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCleanMviExpenseListUseCase @Inject constructor(private val cleanMviExpenseRepository: CleanMviExpenseRepository) {
    operator fun invoke(): Flow<List<CleanMviExpense>> = cleanMviExpenseRepository.getAllData()
}