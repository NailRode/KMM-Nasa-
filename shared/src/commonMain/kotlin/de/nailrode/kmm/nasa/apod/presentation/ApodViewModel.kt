package de.nailrode.kmm.nasa.apod.presentation

import com.rickclephas.kmm.viewmodel.KMMViewModel
import com.rickclephas.kmm.viewmodel.MutableStateFlow
import com.rickclephas.kmm.viewmodel.coroutineScope
import com.rickclephas.kmp.nativecoroutines.NativeCoroutinesState
import de.nailrode.kmm.nasa.apod.repository.Apod
import de.nailrode.kmm.nasa.apod.repository.ApodRepository
import kotlinx.coroutines.launch
import kotlinx.datetime.Clock
import kotlinx.datetime.DateTimeUnit
import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDate
import kotlinx.datetime.TimeZone
import kotlinx.datetime.minus
import kotlinx.datetime.plus
import kotlinx.datetime.toLocalDateTime

class ApodViewModel(private val repository: ApodRepository) : KMMViewModel() {

    private lateinit var endDate: LocalDate

    @NativeCoroutinesState
    val apods = MutableStateFlow<List<Apod>>(viewModelScope, emptyList())

    init {
        viewModelScope.coroutineScope.launch {
            val now: Instant = Clock.System.now()
            val today: LocalDate = now.toLocalDateTime(TimeZone.currentSystemDefault()).date
            val newEndDate = today.minus(20, DateTimeUnit.DAY)
            endDate = newEndDate

            apods.value = repository.getApods(today, newEndDate)
        }
    }

    fun loadMore() {
        viewModelScope.coroutineScope.launch {
            val newEndDate = endDate.minus(1, DateTimeUnit.DAY)
            apods.value = apods.value + repository.getApods(newEndDate, newEndDate.minus(20, DateTimeUnit.DAY))
            endDate = newEndDate.minus(20, DateTimeUnit.DAY)
        }
    }
}
