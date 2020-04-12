package com.devika.hush.ui.portfolio

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.devika.hush.data.model.Portfolio
import com.devika.hush.data.repository.HushRepository
import javax.inject.Inject


class PortfolioViewModel @Inject constructor(private val hushRepository: HushRepository) :
    ViewModel() {

    var portfolioData: LiveData<List<Portfolio>> = hushRepository.getPortfolio()
}