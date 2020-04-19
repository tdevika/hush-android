package com.devika.hush.ui.home

import com.devika.hush.data.repository.HushRepository
import com.devika.hush.injection.scope.IoDispatcher
import com.devika.hush.utils.UseCase
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class HomeDataUseCase @Inject constructor(
    private val hushRepository: HushRepository,
    @IoDispatcher ioDispatcher: CoroutineDispatcher
) : UseCase<Unit, Unit>(ioDispatcher) {

    override suspend fun execute(parameters: Unit): Unit =  hushRepository.refreshCacheWithRemoteData()
}
