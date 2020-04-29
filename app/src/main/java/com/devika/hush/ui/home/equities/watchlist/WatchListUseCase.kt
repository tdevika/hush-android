package com.devika.hush.ui.home.equities.watchlist

import com.devika.hush.data.domain.SuspendUseCase
import com.devika.hush.data.model.DetailWatchList
import com.devika.hush.data.repository.HushRepository
import com.devika.hush.injection.scope.DefaultDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class WatchListUseCase @Inject constructor(
    private val hushRepository: HushRepository,
    @DefaultDispatcher defaultDispatcher: CoroutineDispatcher
) :
    SuspendUseCase<Unit, List<DetailWatchList>>(defaultDispatcher) {
    override suspend fun execute(parameters: Unit): List<DetailWatchList> =
        hushRepository.getWatchList()
}
