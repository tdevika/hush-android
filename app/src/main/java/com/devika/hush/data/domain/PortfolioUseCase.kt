package com.devika.hush.data.domain

import androidx.lifecycle.LiveData
import com.devika.hush.data.model.Portfolio
import com.devika.hush.data.repository.HushRepository
import com.devika.hush.injection.scope.DefaultDispatcher
import com.devika.hush.utils.UseCase
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

open class PortfolioUseCase @Inject constructor(
    private val hushRepository: HushRepository,
    @DefaultDispatcher defaultDispatcher: CoroutineDispatcher
) : UseCase<Unit, LiveData<List<Portfolio>>>(defaultDispatcher) {

    override suspend fun execute(parameters: Unit): LiveData<List<Portfolio>> = hushRepository.getPortfolio()
}
