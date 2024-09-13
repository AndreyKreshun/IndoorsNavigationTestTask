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
    var departure by remember { mutableStateOf("Москва") }
    var arrival by remember { mutableStateOf("Сергиев Посад") }

    // Контейнер для размещения текстовых полей и кнопки для реверса
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        // Поле для ввода места отбытия
        BasicTextField(
            value = departure,
            onValueChange = { departure = it },
            modifier = Modifier
                .weight(1f)
                .background(Color.LightGray)
                .padding(8.dp),
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text),
            singleLine = true
        )

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
                painter = painterResource(id = R.drawable.ic_reverse), // Тут используйте свою иконку реверса
                contentDescription = "Reverse",
                tint = Color.Black
            )
        }

        // Поле для ввода места прибытия
        BasicTextField(
            value = arrival,
            onValueChange = { arrival = it },
            modifier = Modifier
                .weight(1f)
                .background(Color.LightGray)
                .padding(8.dp),
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text),
            singleLine = true
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSearchWithReverse() {
    SearchWithReverse()
}
