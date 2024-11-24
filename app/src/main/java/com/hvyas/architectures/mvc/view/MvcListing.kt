package com.hvyas.architectures.mvc.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import com.hvyas.architectures.common.ExpenseDb
import com.hvyas.architectures.common.theme.ArchitecturesTheme
import com.hvyas.architectures.common.theme.component.EditTextCompose
import com.hvyas.architectures.common.theme.component.Heading1
import com.hvyas.architectures.common.theme.component.Heading2
import com.hvyas.architectures.common.theme.component.TextTopBar
import com.hvyas.architectures.mvc.controller.MvcListingController
import com.hvyas.architectures.mvc.model.model.MvcExpanse
import com.hvyas.architectures.mvc.model.repository.MvcExpenseRepository

class MvcListing : ComponentActivity() {

    private val controller: MvcListingController by lazy {
        val dao = ExpenseDb.getExpenseDb(this).getMvcExpenseDao()
        val repository = MvcExpenseRepository(dao)
        MvcListingController(repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        WindowCompat.getInsetsController(window, window.decorView).apply {
            isAppearanceLightStatusBars = false
        }
        setContent {
            ArchitecturesTheme {
                MvcScreen()
            }
        }
    }

    @Composable
    private fun MvcScreen() {
        Scaffold(modifier = Modifier.fillMaxSize(), topBar = { CreateToolbar() }) { innerPadding ->
            MainContainer(modifier = Modifier.padding(innerPadding))
        }
    }

    @Composable
    fun MainContainer(modifier: Modifier = Modifier) {
        Column(
            modifier = modifier.fillMaxSize(),
        ) {
            var expenseList: List<MvcExpanse> by remember { mutableStateOf(listOf()) }

            CreateForm { expense ->
                controller.saveData(expense) { list ->
                    expenseList = list
                }
            }
            HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))
            CreateList(itemList = expenseList, modifier = Modifier.weight(1f)) { id ->
                controller.deleteItem(id) { list ->
                    expenseList = list
                }
            }
            LaunchedEffect(key1 = true) {
                controller.getData { list ->
                    expenseList = list
                }
            }
        }
    }

    @Composable
    private fun CreateToolbar() {
        TextTopBar(text = "Mvc Example") {
            onBackPressedDispatcher.onBackPressed()
        }
    }

    @Composable
    private fun CreateForm(modifier: Modifier = Modifier, onSubmit: (MvcExpanse) -> Unit) {
        var dateText by remember { mutableStateOf("") }
        var timeText by remember { mutableStateOf("") }
        var amount by remember { mutableStateOf("") }
        var remark by remember { mutableStateOf("") }

        Column(
            modifier = modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Heading1(text = "Expense Form")
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding()
            ) {
                EditTextCompose(label = "Date", value = dateText, modifier = Modifier.weight(1f)) {
                    dateText = it
                }
                Spacer(modifier = Modifier.width(12.dp))
                EditTextCompose(label = "Time", value = timeText, modifier = Modifier.weight(1f)) {
                    timeText = it
                }
            }

            EditTextCompose(label = "Amount", value = amount, modifier = Modifier.fillMaxWidth()) {
                amount = it
            }
            EditTextCompose(label = "Remark", value = remark, modifier = Modifier.fillMaxWidth()) {
                remark = it
            }
            Spacer(modifier = Modifier.height(4.dp))
            Button(onClick = {
                val expanse = MvcExpanse(0, dateText, timeText, amount.toDouble(), remark)
                dateText = ""
                timeText = ""
                amount = ""
                remark = ""
                onSubmit(expanse)
            }, modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(4.dp)) {
                Text(text = "SAVE EXPENSE")
            }
        }
    }

    @Composable
    private fun CreateList(modifier: Modifier = Modifier, itemList: List<MvcExpanse>, onDelete: (Int) -> Unit) {
        Column(modifier = modifier.padding(horizontal = 16.dp)) {
            Heading1(text = "Listing Form")
            LazyColumn {
                items(itemList) {
                    Spacer(modifier = Modifier.height(4.dp))
                    Card {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(8.dp), verticalAlignment = Alignment.CenterVertically
                        ) {

                            Column(modifier = Modifier.weight(1f)) {
                                Heading2(text = it.amount.toString())
                                Text(text = it.date + " " + it.time)
                                Text(text = it.message)
                            }

                            IconButton(onClick = { onDelete(it.id) }) {
                                Icon(imageVector = Icons.Filled.Delete, contentDescription = "Delete")
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(4.dp))
                }
            }
        }
    }


    @Preview(device = "spec:width=1080px,height=2340px,dpi=440", backgroundColor = 0xFFF8BBD0)
    @Composable
    private fun GreetingPreview() {
        ArchitecturesTheme {
            MvcScreen()
        }
    }
}
