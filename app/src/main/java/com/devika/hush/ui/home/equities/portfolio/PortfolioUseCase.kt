package com.devika.hush.ui.home.equities.portfolio

import com.devika.hush.data.domain.SuspendUseCase
import com.devika.hush.data.model.Portfolio
import com.devika.hush.data.repository.HushRepository
import com.devika.hush.injection.scope.DefaultDispatcher
import javax.inject.Inject
import kotlinx.coroutines.CoroutineDispatcher

open class PortfolioUseCase @Inject constructor(
    private val hushRepository: HushRepository,
    @DefaultDispatcher defaultDispatcher: CoroutineDispatcher
) : SuspendUseCase<Any, List<Portfolio>>(defaultDispatcher) {
    public override suspend fun execute(parameters: Any) = hushRepository.getPortfolio()
}
