package com.devika.hush.data.domain

import com.devika.hush.data.repository.HushRepository
import com.devika.hush.injection.scope.IoDispatcher
import javax.inject.Inject
import kotlinx.coroutines.CoroutineDispatcher

class RefreshCacheUseCase @Inject constructor(
    private val hushRepository: HushRepository,
    @IoDispatcher ioDispatcher: CoroutineDispatcher
) : SuspendUseCase<Unit, Unit>(ioDispatcher) {
    public override suspend fun execute(parameters: Unit) =
        (hushRepository.refreshCacheWithRemoteData())
}
