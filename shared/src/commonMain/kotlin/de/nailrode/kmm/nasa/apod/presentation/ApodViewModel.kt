package de.nailrode.kmm.nasa.apod.presentation

import com.rickclephas.kmm.viewmodel.KMMViewModel
import com.rickclephas.kmm.viewmodel.MutableStateFlow
import com.rickclephas.kmm.viewmodel.coroutineScope
import com.rickclephas.kmp.nativecoroutines.NativeCoroutinesState
import de.nailrode.kmm.nasa.apod.repository.Apod
import de.nailrode.kmm.nasa.apod.repository.ApodRepository
import kotlinx.coroutines.launch

class ApodViewModel(private val repository: ApodRepository) : KMMViewModel() {

    @NativeCoroutinesState
    val apod = MutableStateFlow<Apod?>(viewModelScope, null)

    init {
        viewModelScope.coroutineScope.launch {
            apod.value = repository.getApod()
        }
    }
}
