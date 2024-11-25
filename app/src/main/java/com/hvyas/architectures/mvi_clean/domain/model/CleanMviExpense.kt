package com.hvyas.architectures.mvi_clean.domain.model

data class CleanMviExpense(val id: Int, val date: String, val time: String, val amount: Double, val message: String)