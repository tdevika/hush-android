package com.devika.hush.data.domain

import com.devika.hush.data.repository.HushRepository
import com.devika.hush.injection.scope.IoDispatcher
import com.devika.hush.utils.UseCase
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class EquitiesUseCase @Inject constructor(
    private val hushRepository: HushRepository,
    @IoDispatcher ioDispatcher: CoroutineDispatcher
) : UseCase<Unit, Unit>(ioDispatcher) {

    override suspend fun execute(parameters: Unit): Unit =  hushRepository.refreshCacheWithRemoteData()
}
