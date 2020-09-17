package com.localazy.quicknote

import android.content.Context
import android.content.Intent
import android.os.Build

fun Context.startFloatingService(command: String = "") {
    val intent = Intent(this, FloatingService::class.java)
    if (command.isNotBlank()) intent.putExtra(INTENT_COMMAND, command)
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        this.startForegroundService(intent)
    } else {
        this.startService(intent)
    }
}

