package com.hvyas.architectures.mvi_clean.data.dto

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "CleanMviExpense")
data class CleanMviExpenseDto(@PrimaryKey(autoGenerate = true) val id: Int, val date: String, val time: String, val amount: Double, val message: String)