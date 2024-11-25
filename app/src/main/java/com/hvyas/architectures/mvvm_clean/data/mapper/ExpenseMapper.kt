package com.hvyas.architectures.mvvm_clean.data.mapper

import com.hvyas.architectures.mvvm_clean.data.dto.CleanMvvmExpenseDto
import com.hvyas.architectures.mvvm_clean.domain.model.CleanMvvmExpense

fun CleanMvvmExpense.toDto() = CleanMvvmExpenseDto(id, date, time, amount, message)

fun CleanMvvmExpenseDto.toModel() = CleanMvvmExpense(id, date, time, amount, message)