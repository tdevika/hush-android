package com.devika.hush.ui.home.equities.stocks

import com.devika.hush.data.domain.SuspendUseCase
import com.devika.hush.data.model.Stock
import com.devika.hush.data.repository.HushRepository
import com.devika.hush.injection.scope.DefaultDispatcher
import javax.inject.Inject
import kotlinx.coroutines.CoroutineDispatcher

open class StocksUseCase @Inject constructor(
    private val hushRepository: HushRepository,
    @DefaultDispatcher defaultDispatcher: CoroutineDispatcher
) : SuspendUseCase<Any, List<Stock>>(defaultDispatcher) {

    public override suspend fun execute(parameters: Any): List<Stock> = hushRepository.getStocks()
}
