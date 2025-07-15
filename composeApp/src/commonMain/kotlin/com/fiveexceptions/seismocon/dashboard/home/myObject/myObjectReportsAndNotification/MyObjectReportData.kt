package com.fiveexceptions.seismocon.dashboard.home.myObject.myObjectReportsAndNotification

data class MyObjectReportData(
    val reportId: String,
    val type: String,
    val date: String,
    val isShowingDeleteButton: Boolean,
    val id: Int
)
