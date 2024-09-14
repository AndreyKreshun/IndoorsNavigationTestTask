package com.example.indoorsnavigation3

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SearchWithReverse() {
    var departure by remember { mutableStateOf("") }
    var arrival by remember { mutableStateOf("") }

    // Контейнер для размещения текстовых полей и кнопки для реверса
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        // Поле для ввода места отбытия с подсказкой
        Box(
            modifier = Modifier
                .weight(1f)
                .background(Color.LightGray)
                .padding(8.dp)
        ) {
            if (departure.isEmpty()) {
                Text(
                    text = "Москва", // Подсказка
                    color = Color.Gray
                )
            }
            BasicTextField(
                value = departure,
                onValueChange = { departure = it },
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text),
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )
        }

        // Кнопка для реверса
        IconButton(
            onClick = {
                // Обмен значений между местом отправления и прибытия
                val temp = departure
                departure = arrival
                arrival = temp
            },
            modifier = Modifier.padding(horizontal = 8.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_reverse), // Иконка реверса
                contentDescription = "Reverse",
                tint = Color.Black
            )
        }

        // Поле для ввода места прибытия с подсказкой
        Box(
            modifier = Modifier
                .weight(1f)
                .background(Color.LightGray)
                .padding(8.dp)
        ) {
            if (arrival.isEmpty()) {
                Text(
                    text = "Сергиев Посад", // Подсказка
                    color = Color.Gray
                )
            }
            BasicTextField(
                value = arrival,
                onValueChange = { arrival = it },
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text),
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSearchWithReverse() {
    SearchWithReverse()
}
