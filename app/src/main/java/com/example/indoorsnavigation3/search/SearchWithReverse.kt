package com.example.indoorsnavigation3.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.example.indoorsnavigation3.R
import com.example.indoorsnavigation3.transportschedulescreen.TransportScheduleViewModel

@Composable
fun SearchWithReverse(viewModel: TransportScheduleViewModel) {
    var departure by remember { viewModel.fromText }
    var arrival by remember { viewModel.toText }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        // Поле для ввода места отбытия с placeholder "Откуда"
        TextField(
            value = departure,
            onValueChange = { viewModel.updateFromText(it) },
            modifier = Modifier
                .weight(1f)
                .padding(8.dp),
            placeholder = { Text("Откуда") },
            singleLine = true
        )

        IconButton(
            onClick = {
                val temp = departure
                viewModel.updateFromText(arrival)
                viewModel.updateToText(temp)
            },
            modifier = Modifier.padding(horizontal = 8.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_reverse),
                contentDescription = "Reverse",
                tint = Color.Black
            )
        }

        // Поле для ввода места прибытия с placeholder "Куда"
        TextField(
            value = arrival,
            onValueChange = { viewModel.updateToText(it) },
            modifier = Modifier
                .weight(1f)
                .padding(8.dp),
            placeholder = { Text("Куда") },
            singleLine = true
        )
    }
}
