package com.example.broadcastreceiverdemo

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.core.text.PrecomputedTextCompat

class MyReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val intentType = intent.type
        val action = intent.action.toString()
        Log.i("MyAction",action)
        val isAirplaneMode = intent?.getBooleanExtra("state", false)
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.

        when(action){
            "android.intent.action.AIRPLANE_MODE"->{
                if (isAirplaneMode) {
                    Toast.makeText(context, "Airplane Mode on", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(context, "Airplane Mode off", Toast.LENGTH_LONG).show()

                }
            }

            "android.intent.action.BATTERY_LOW"->{
                Toast.makeText(context, "Battery is Low", Toast.LENGTH_LONG).show()
            }
        }
    }
}