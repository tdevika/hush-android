package com.devika.hush.ui.home.details

import com.devika.hush.data.domain.SuspendUseCase
import com.devika.hush.data.model.StockDetails
import com.devika.hush.data.repository.HushRepository
import com.devika.hush.injection.scope.DefaultDispatcher
import javax.inject.Inject
import kotlinx.coroutines.CoroutineDispatcher

class DetailsUseCase @Inject constructor(private val hushRepository: HushRepository, @DefaultDispatcher defaultDispatcher: CoroutineDispatcher) :
    SuspendUseCase<String, StockDetails>(defaultDispatcher) {
    override suspend fun execute(parameters: String): StockDetails {
        return hushRepository.getStockDetails(parameters)
    }
}
