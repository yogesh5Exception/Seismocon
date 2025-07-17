package com.fiveexceptions.seismocon.core.commonComposables

import androidx.navigation.NavController

fun NavController.popSafeBack() {
    if (this.previousBackStackEntry != null) {
        this.popBackStack()
    }
}