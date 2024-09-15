import android.app.DatePickerDialog
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.*

@Composable
fun DateButton(
    initialText: String,
    selectedDate: String,
    onDateSelected: (String) -> Unit
) {
    var dateText by remember { mutableStateOf(initialText) }

    // Календарь будет использовать текущую дату как начальную
    val calendar = Calendar.getInstance()
    val year = calendar.get(Calendar.YEAR)
    val month = calendar.get(Calendar.MONTH)
    val day = calendar.get(Calendar.DAY_OF_MONTH)

    // Обработчик выбора даты
    val datePickerDialog = DatePickerDialog(
        LocalContext.current,
        { _, selectedYear, selectedMonth, selectedDay ->
            // Форматируем дату для отображения на кнопке (DD.MM.YYYY)
            dateText = "$selectedDay.${selectedMonth + 1}.$selectedYear"

            // Преобразуем выбранную дату в формат ISO 8601 для API (YYYY-MM-DD)
            val isoDate = "$selectedYear-${(selectedMonth + 1).toString().padStart(2, '0')}-${selectedDay.toString().padStart(2, '0')}"

            // Передаем дату в правильном формате через callback
            onDateSelected(isoDate)
        }, year, month, day
    )

    // Кнопка для вызова DatePickerDialog
    Button(
        onClick = { datePickerDialog.show() },
        colors = ButtonDefaults.buttonColors(
            containerColor = if (dateText == selectedDate) Color.Gray else Color.LightGray
        ),
        modifier = Modifier
            .padding(horizontal = 4.dp),
        shape = RoundedCornerShape(4.dp)
    ) {
        Text(
            text = dateText,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold
        )
    }
}
