package com.hush.ui.portfolio

import com.hush.data.repository.HushRepository
import com.hush.ui.base.BaseViewModel
import javax.inject.Inject

class PortfolioFragmentViewModel @Inject constructor(private val hushRepository: HushRepository) : BaseViewModel() {
//    var repositoriesLiveData = MutableLiveData<DataWrapper<String>>()
//    var amount: ObservableField<String> = ObservableField()
//    var note: ObservableField<String> = ObservableField()
//    var date: ObservableField<String> = ObservableField()
//    var category: ObservableField<String> = ObservableField()
//    private val calendar = Calendar.getInstance()
//    init {
//        date.set(DateUtils.formatDate(Date()))
//    }
//
//    fun onDatePickerEdittextClicked(context: View) {
//        DatePickerDialog(context.context, datePickerListener, calendar
//                .get(Calendar.YEAR), calendar.get(Calendar.MONTH),
//                calendar.get(Calendar.DAY_OF_MONTH)).show()
//    }
//
//    private var datePickerListener: OnDateSetListener = OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
//        calendar.set(Calendar.YEAR, year)
//        calendar.set(Calendar.MONTH, monthOfYear)
//        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
//        date.set(DateUtils.formatDate((calendar.time)))
//    }
//
//
//
//    fun onSubmitXpns() {
//        setErrorMessage(false, Constants.EMPTY_MESSAGE)
//        displayLoader(true)
//        hushRepository.saveExpens(amount.get()!!, category.get()!!,date.get()!!,note.get()!!,repositoriesLiveData)
//    }
//
//    override fun onCleared() {
//        hushRepository.dispose()
//        super.onCleared()
//    }
}


