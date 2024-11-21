package com.hvyas.architectures.mvc.model.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "MvcExpanse")
data class MvcExpanse (@PrimaryKey(autoGenerate = true) val id:Int, val date:String, val time:String, val amount:Double, val message:String)