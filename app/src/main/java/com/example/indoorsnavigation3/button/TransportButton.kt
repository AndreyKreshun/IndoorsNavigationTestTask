package com.example.indoorsnavigation.button

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/*@Composable
fun TransportButton(text: String, selectedTransport: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = if (text == selectedTransport) Color.Gray else Color.LightGray
        ),
        modifier = Modifier
            //.weight(1f)
            .padding(horizontal = 4.dp),
        shape = RoundedCornerShape(4.dp)
    ) {
        Text(text = text, fontSize = 14.sp)
    }
}*/
@Composable
fun TransportButton(
    iconResId: Int, // Идентификатор ресурса иконки
    selectedTransport: Int, // Идентификатор выбранной иконки (или типа транспорта)
    onClick: () -> Unit,
    modifier: Modifier = Modifier // Добавили модификатор как параметр
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = if (iconResId == selectedTransport) Color.Gray else Color.LightGray
        ),
        modifier = modifier.padding(horizontal = 2.dp), // Уменьшили отступы
        shape = RoundedCornerShape(4.dp)
    ) {
        Icon(
            painter = painterResource(id = iconResId), // Отображение иконки
            contentDescription = null, // Если описание иконки не нужно
            tint = Color.Black, // Цвет иконки
            modifier = Modifier.size(20.dp) // Уменьшили размер иконки
        )
    }
}