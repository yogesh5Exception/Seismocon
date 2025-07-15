package com.fiveexceptions.seismocon.dashboard.home.mySeismocon

data class MySeismoconMonitoringUnitData(
    val name: String,
    val isSensorButtonVisible: Boolean = true,
    val isAboutButtonVisible: Boolean = true,
    val isDeleteButtonVisible: Boolean = true,
    val id: Int
)