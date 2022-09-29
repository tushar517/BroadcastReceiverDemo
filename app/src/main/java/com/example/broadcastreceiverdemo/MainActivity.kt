package com.example.broadcastreceiverdemo

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    lateinit var receiver:MyReceiver
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        receiver=MyReceiver()
        IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED).also {
            it.addAction("airplaneMode")
            registerReceiver(receiver,it)
        }

        IntentFilter(Intent.ACTION_BATTERY_LOW).also {
            it.addAction("LowBattery")
            registerReceiver(receiver,it)
        }
    }

    override fun onStop() {
        unregisterReceiver(receiver)
        super.onStop()
    }
}