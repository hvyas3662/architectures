package com.hvyas.architectures.mvi.data.domain

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("MviExpense")
data class MviExpense(@PrimaryKey(autoGenerate = true) val id: Int, val date: String, val time: String, val amount: Double, val message: String)