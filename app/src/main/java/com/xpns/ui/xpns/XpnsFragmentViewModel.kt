package com.xpns.ui.xpns

import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.view.View
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import com.xpns.data.repository.XpnsRepository
import com.xpns.injection.scope.ActivityScope
import com.xpns.ui.base.BaseViewModel
import com.xpns.utils.Constants
import com.xpns.utils.DataWrapper
import java.text.SimpleDateFormat
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
        date.set(formatMMDDYYYY(Date()))
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
        date.set(formatMMDDYYYY(calendar.time))
    }

    // TODO refactor it to extension function
    fun formatMMDDYYYY(time: Date?): String? {
        val myFormat = "MM/dd/yy"
        val sdf = SimpleDateFormat(myFormat, Locale.US)
        return sdf.format(time)
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


