package com.xpns.ui.xpns

import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.view.View
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import com.xpns.data.repository.XpnsRepository
import com.xpns.ui.base.BaseViewModel
import com.xpns.utils.Constants
import com.xpns.utils.DataWrapper
import com.xpns.utils.DateUtils
import java.util.*
import javax.inject.Inject

class XpnsFragmentViewModel @Inject constructor(private val xpnsRepository: XpnsRepository) : BaseViewModel() {
    var repositoriesLiveData = MutableLiveData<DataWrapper<String>>()
    var amount: ObservableField<String> = ObservableField()
    var note: ObservableField<String> = ObservableField()
    var date: ObservableField<String> = ObservableField()
    var category: ObservableField<String> = ObservableField()
    private val calendar = Calendar.getInstance()
    init {
        date.set(DateUtils.formatDate(Date()))
    }

    fun onDatePickerEdittextClicked(context: View) {
        DatePickerDialog(context.context, datePickerListener, calendar
                .get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)).show()
    }

    private var datePickerListener: OnDateSetListener = OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
        calendar.set(Calendar.YEAR, year)
        calendar.set(Calendar.MONTH, monthOfYear)
        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
        date.set(DateUtils.formatDate((calendar.time)))
    }



    fun onSubmitXpns() {
        setErrorMessage(false, Constants.EMPTY_MESSAGE)
        displayLoader(true)
        xpnsRepository.saveExpens(amount.get()!!, category.get()!!,date.get()!!,note.get()!!,repositoriesLiveData)
    }

    override fun onCleared() {
        xpnsRepository.dispose()
        super.onCleared()
    }
}


