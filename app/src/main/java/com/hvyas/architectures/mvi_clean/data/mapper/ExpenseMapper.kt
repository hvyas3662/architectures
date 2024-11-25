package com.hvyas.architectures.mvi_clean.data.mapper

import com.hvyas.architectures.mvi_clean.data.dto.CleanMviExpenseDto
import com.hvyas.architectures.mvi_clean.domain.model.CleanMviExpense

fun CleanMviExpense.toDto() = CleanMviExpenseDto(id, date, time, amount, message)

fun CleanMviExpenseDto.toModel() = CleanMviExpense(id, date, time, amount, message)