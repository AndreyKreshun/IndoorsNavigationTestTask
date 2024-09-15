/*
package com.example.indoorsnavigation3.search

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun SearchWithAutocomplete(
    text: String,
    onTextChanged: (String) -> Unit,
    suggestions: List<String>,
    onSuggestionSelected: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    Column {
        // Текстовое поле для ввода
        TextField(
            value = text,
            onValueChange = {
                onTextChanged(it)
                expanded = true
            },
            label = { Text("Введите город") }
        )

        // Выпадающий список с предложениями
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            suggestions.forEach { suggestion ->
                DropdownMenuItem(onClick = {
                    onSuggestionSelected(suggestion)
                    expanded = false
                }) {
                    Text(text = suggestion)
                }
            }
        }
    }
}


*/
