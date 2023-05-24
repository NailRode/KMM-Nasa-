package de.nailrode.kmm.nasa.ui.apods

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.push
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize
import de.nailrode.kmm.nasa.apod.repository.Apod
import de.nailrode.kmm.nasa.apod.repository.ApodRepository
import de.nailrode.kmm.nasa.util.coroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.datetime.Clock
import kotlinx.datetime.DateTimeUnit
import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDate
import kotlinx.datetime.TimeZone
import kotlinx.datetime.minus
import kotlinx.datetime.toLocalDateTime
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

interface ApodsComponent {
    val apods: StateFlow<List<Apod>>
    val isLoading: StateFlow<Boolean>
    val isError: StateFlow<Boolean>

    fun refresh()
    fun loadMore()
    fun onApodClicked(apodUrl: String)
}

class DefaultApodsComponent(componentContext: ComponentContext) :
    KoinComponent, ApodsComponent, ComponentContext by componentContext {

    private lateinit var endDate: LocalDate

    private val coroutineScope = coroutineScope()
    private val repository: ApodRepository by inject()
    private val navigation = StackNavigation<Config>()

    override var apods: MutableStateFlow<List<Apod>> = MutableStateFlow(emptyList())

    private val _isError = MutableStateFlow(false)
    override val isError: StateFlow<Boolean> = _isError

    private val _isLoading = MutableStateFlow(false)
    override val isLoading: StateFlow<Boolean> = _isLoading

    init {
        refresh()
    }

    override fun loadMore() {
        coroutineScope.launch {
            if (apods.value.isNotEmpty() && !isError.value && !isLoading.value) {
                _isLoading.value = true
                val newEndDate = endDate.minus(1, DateTimeUnit.DAY)
                val nextApods = repository.getApods(newEndDate, newEndDate.minus(20, DateTimeUnit.DAY))
                if (nextApods.isNotEmpty()) {
                    apods.value = apods.value + nextApods
                }
                endDate = newEndDate.minus(20, DateTimeUnit.DAY)
                _isLoading.value = false
            }
        }
    }

    override fun refresh() {
        coroutineScope.launch {
            _isLoading.value = true
            val now: Instant = Clock.System.now()
            val today: LocalDate = now.toLocalDateTime(TimeZone.currentSystemDefault()).date
            val newEndDate = today.minus(20, DateTimeUnit.DAY)
            endDate = newEndDate

            val currentApods = repository.getApods(today, newEndDate)

            if (currentApods.isNotEmpty()) {
                apods.value = currentApods
            } else {
                _isError.value = true
            }
            _isLoading.value = false
        }
    }

    override fun onApodClicked(apodUrl: String) {
        navigation.push(Config.ApodDetails(apodUrl))
    }

    @Parcelize
    private sealed class Config : Parcelable {
        data class ApodDetails(val url: String) : Config()
    }
}
