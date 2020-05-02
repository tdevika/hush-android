package com.devika.hush.ui.home.details

import com.devika.hush.data.domain.SuspendUseCase
import com.devika.hush.data.model.Portfolio
import com.devika.hush.data.repository.HushRepository
import com.devika.hush.injection.scope.DefaultDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class DetailsUseCase @Inject constructor(hushRepository: HushRepository, @DefaultDispatcher defaultDispatcher: CoroutineDispatcher) : SuspendUseCase<Unit , Portfolio>(defaultDispatcher)  {
    override suspend fun execute(parameters: Unit): Portfolio {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}