package com.hvyas.architectures.mvvm_clean.data.dto

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "CleanMvvmExpense")
data class CleanMvvmExpenseDto(@PrimaryKey(autoGenerate = true) val id: Int, val date: String, val time: String, val amount: Double, val message: String)