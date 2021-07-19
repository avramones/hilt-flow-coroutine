package com.example.testing

import android.annotation.SuppressLint
import android.app.Activity
import android.app.DatePickerDialog
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

@SuppressLint("SetTextI18n")
fun showBetweenDatePicker(activity: Activity,
                          startDate: TextView,
                          endDate: TextView, between: Int) {

    val c = Calendar.getInstance()
    val currentYear = c.get(Calendar.YEAR)
    val currentMonth = c.get(Calendar.MONTH)
    val currentDay = c.get(Calendar.DAY_OF_MONTH)

    val datePicker = DatePickerDialog(activity, R.style.MyDatePickerStyle, { view, year, monthOfYear, dayOfMonth ->

        startDate.text = "%02d.%02d.%04d".format(dayOfMonth, monthOfYear + 1, year)
        endDate.text = "%02d.%02d.%04d".format(dayOfMonth, monthOfYear + 1, year + between)
    }, currentYear, currentMonth, currentDay)

    datePicker.show()
}

@SuppressLint("SimpleDateFormat")
fun Long.toStringDate() : String {
    val date = Date(this)
    val dateFormat = SimpleDateFormat("dd MM yyyy")
    return dateFormat.format(date)
}

