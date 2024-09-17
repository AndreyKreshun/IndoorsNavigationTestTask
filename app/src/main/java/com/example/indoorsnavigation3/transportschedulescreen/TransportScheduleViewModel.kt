package com.example.indoorsnavigation3.transportschedulescreen

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State
import com.example.indoorsnavigation3.R
import com.example.indoorsnavigation3.data.ThreadInfo
import com.example.indoorsnavigation3.data.Transport
import com.google.android.libraries.places.api.model.LocalDate
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONObject
import java.text.SimpleDateFormat
import java.time.format.DateTimeFormatter
import java.util.Calendar
import java.util.Date
import java.util.Locale

class TransportScheduleViewModel : ViewModel() {

    // Список для хранения данных рейсов
    private val _transportSchedule = mutableStateOf<List<Transport>>(emptyList())
    val transportSchedule: State<List<Transport>> = _transportSchedule

    var transportList = mutableStateOf(listOf<Transport>())
        private set

    private val client = OkHttpClient()

    val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    val isoFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.getDefault())
    // Функция для выполнения запроса к Yandex Schedule API
    suspend fun fetchTransportSchedule(from: String, to: String, date: String, transportType: String) {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val formattedDate = when (date) {
            "Сегодня" -> dateFormat.format(Date())
            "Завтра" -> {
                val calendar = Calendar.getInstance()
                calendar.add(Calendar.DATE, 1)
                dateFormat.format(calendar.time)
            }
            else -> date
        }

        val apiKey = "f7f75891-ffa0-4223-9f6c-996a09634602"
        val url = "https://api.rasp.yandex.net/v3.0/search/?from=$from&to=$to&date=$formattedDate&transport_types=$transportType&apikey=$apiKey&format=json&lang=ru_RU"

        val request = Request.Builder().url(url).build()

        withContext(Dispatchers.IO) {
            val response = client.newCall(request).execute()
            response.body?.use { responseBody ->
                val jsonObject = JSONObject(responseBody.string())
                val segments = jsonObject.getJSONArray("segments")

                val transportListData = mutableListOf<Transport>()
                for (i in 0 until segments.length()) {
                    val segment = segments.getJSONObject(i)
                    val thread = segment.getJSONObject("thread")

                    val transport = Transport(
                        transportType = transportType,
                        thread = ThreadInfo(
                            number = thread.getString("number"),
                            title = thread.getString("title")
                        ),
                        departure = segment.getString("departure"),
                        arrival = segment.getString("arrival"),
                        fromCode = segment.getString("departure_platform"),
                        toCode = segment.getString("arrival_platform")
                    )
                    transportListData.add(transport)
                }

                _transportSchedule.value = transportListData
            }
        }
    }

    var fromText = mutableStateOf("")
        private set
    var toText = mutableStateOf("")
        private set

    var selectedDate = mutableStateOf("Сегодня")
        private set
    var selectedTransport = mutableStateOf(R.drawable.any)
        private set

    // Состояние для списка расписаний транспорта
    var transportData = mutableStateOf<List<Transport>>(emptyList())
        private set

    // Обновление текстов
    fun updateFromText(newFromText: String) {
        fromText.value = newFromText
    }

    fun updateToText(newToText: String) {
        toText.value = newToText
    }

    fun reverseFromTo() {
        val temp = fromText.value
        fromText.value = toText.value
        toText.value = temp
    }

    fun updateSelectedDate(newDate: String) {
        selectedDate.value = newDate
    }

    fun updateSelectedTransport(newTransport: Int) {
        selectedTransport.value = newTransport
    }


}


