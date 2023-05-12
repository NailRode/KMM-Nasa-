package de.nailrode.kmm.nasa.presentation

import de.nailrode.kmm.nasa.data.apod.ApodRepository

class ApodViewModel(repository: ApodRepository) : BaseViewModel() {

    val apod = repository.getApod()
}
