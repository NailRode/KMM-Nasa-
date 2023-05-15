package de.nailrode.kmm.nasa.apod.presentation

import com.rickclephas.kmm.viewmodel.KMMViewModel
import com.rickclephas.kmm.viewmodel.MutableStateFlow
import com.rickclephas.kmm.viewmodel.coroutineScope
import com.rickclephas.kmp.nativecoroutines.NativeCoroutinesState
import de.nailrode.kmm.nasa.apod.repository.Apod
import de.nailrode.kmm.nasa.apod.repository.ApodRepository
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ApodViewModel(repository: ApodRepository) : KMMViewModel() {

    @NativeCoroutinesState
    private val _apod = MutableStateFlow<Apod?>(viewModelScope, null)
    val apod: StateFlow<Apod?> = _apod

    init {
        viewModelScope.coroutineScope.launch {
            _apod.value = repository.getApod()
        }
    }
}
