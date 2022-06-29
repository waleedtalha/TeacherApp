package com.cwise.teacherappkotlin.activities

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.cwise.teacherappkotlin.AlarmListener
import com.cwise.teacherappkotlin.R
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import java.util.*

class NotificationActivity : AppCompatActivity() {
    //    private var binding: ActivityMainBinding? = null
    private lateinit var selectTime: Button
    private lateinit var setAlarm: Button
    private lateinit var cancelAlarm: Button
    private var picker: MaterialTimePicker? = null
    private var calendar: Calendar? = null
    private var alarmManager: AlarmManager? = null
    private var pendingIntent: PendingIntent? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)

        selectTime = findViewById(R.id.selectTime)
        setAlarm = findViewById(R.id.setAlarm)
        cancelAlarm = findViewById(R.id.cancelAlarm)
        createNotificationChannel()

        selectTime.setOnClickListener { showTimePicker() }
        setAlarm.setOnClickListener { setAlarm() }
        cancelAlarm.setOnClickListener { cancelAlarm() }
    }

    private fun cancelAlarm() {
        val intent = Intent(this, AlarmListener::class.java)
        pendingIntent = PendingIntent.getBroadcast(this, 0, intent, 0)
        if (alarmManager == null) {
            alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
        }
        alarmManager!!.cancel(pendingIntent)
        Toast.makeText(this, "Cancel Alarm", Toast.LENGTH_SHORT).show()
    }

    private fun setAlarm() {
        alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
        val intent = Intent(this, AlarmListener::class.java)
        pendingIntent = PendingIntent.getBroadcast(this, 0, intent, 0)
        alarmManager!!.setInexactRepeating(
            AlarmManager.RTC_WAKEUP, calendar!!.timeInMillis,
            AlarmManager.INTERVAL_DAY, pendingIntent
        )
        Toast.makeText(this, "Alarm Set", Toast.LENGTH_SHORT).show()
    }

    @SuppressLint("SetTextI18n")
    private fun showTimePicker() {
        picker = MaterialTimePicker.Builder()
            .setTimeFormat(TimeFormat.CLOCK_12H)
            .setHour(12)
            .setMinute(0)
            .setTitleText("Select Alart Time")
            .build()
        picker!!.show(supportFragmentManager, "wplayer")
        picker!!.addOnPositiveButtonClickListener(View.OnClickListener {
            if (picker!!.hour > 12) {
//                selectTime.text = String.format(
//                    "%02d",
//                    (picker!!.hour - 12).toString() + " : " + String.format(
//                        "%02d",
//                        picker!!.minute
//                    ) + " PM"
//                )
            } else {
                selectTime.text = picker!!.hour.toString() + " : " + picker!!.minute + " AM"
            }
            calendar = Calendar.getInstance()
            calendar!!.set(Calendar.HOUR_OF_DAY, picker!!.hour)
            calendar!!.set(Calendar.MINUTE, picker!!.minute)
            calendar!!.set(Calendar.SECOND, 0)
            calendar!!.set(Calendar.MILLISECOND, 0)
        })
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name: CharSequence = "wPlayerChannelName"
            val description = "Channel for alarm"
            val importance = NotificationManager.IMPORTANCE_HIGH
            val notificationChannel = NotificationChannel("wplayer", name, importance)
            notificationChannel.description = description
            val notificationManager = getSystemService(
                NotificationManager::class.java
            )
            notificationManager.createNotificationChannel(notificationChannel)
        }
    }
}