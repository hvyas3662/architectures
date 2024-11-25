package com.hvyas.architectures.mvvm.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "MvvmExpense")
data class MvvmExpense(@PrimaryKey(autoGenerate = true) val id: Int, val date: String, val time: String, val amount: Double, val message: String)