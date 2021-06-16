package org.d3if4070.qassmapp.fragment

import android.app.AlarmManager
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context.ALARM_SERVICE
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.getSystemService
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_note.*
import org.d3if4070.qassmapp.AlarmReceiver
import org.d3if4070.qassmapp.R
import org.d3if4070.qassmapp.databinding.ActivityMainBinding
import java.util.*

class HomeFragment : Fragment() {

//    private lateinit var binding : ActivityMainBinding
    private lateinit var picker : MaterialTimePicker
    private lateinit var calendar: Calendar
    private lateinit var alarmManager: AlarmManager
    private lateinit var pendingIntent:PendingIntent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
//
//        createNotificationChannel()
//
//        btn_selectTime.setOnClickListener {
//            showTimePicker()
//        }
//        btn_setAlarm.setOnClickListener {
//            setAlarm()
//        }
//        btn_cencelAlarm.setOnClickListener {
//            cancelAlarm()
//        }
//

    }

    private fun cancelAlarm() {
//        alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
//        val intent = Intent(this, AlarmReceiver::class.java)
//
//        pendingIntent = PendingIntent.getBroadcast(this,0,0)
//
//        alarmManager.cancel(pendingIntent)
//        Toast.makeText(this,"Alarm cancel",Toast.LENGTH_SHORT).show()

    }

    private fun setAlarm() {
//        alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
//        val intent = Intent(this, AlarmReceiver::class.java)
//
//        pendingIntent = PendingIntent.getBroadcast(this,0,0)
//
//        alarmManager.setRepeating(
//            AlarmManager.RTC_WAKEUP,calendar.timeInMillis,
//            AlarmManager.INTERVAL_DAY,pendingIntent
//        )
//
//        Toast.makeText(this,"Alarm set Successfully",Toast.LENGTH_SHORT).show()
    }

    private fun showTimePicker() {

        picker = MaterialTimePicker.Builder()
            .setTimeFormat(TimeFormat.CLOCK_12H)
            .setHour(12)
            .setMinute(0)
            .setTitleText("Select Alarm time")
            .build()

//        picker.show(supportFragmentManager,"qassmpreneur")

//        picker.addOnPositiveButtonClickListener {
//            if (picker.hour > 12){
//                selectedTime.text =
//                    String.format("%02d",picker.hour - 12) + " : " + String.format(
//                        "%02d",
//                        picker.minute
//                    ) + "PM"
//            } else{
//                String.format("%02d",picker.hour) + " : " + String.format(
//                    "%02d",
//                    picker.minute
//                ) + "AM"
//            }

            calendar = Calendar.getInstance()
            calendar[Calendar.HOUR_OF_DAY] = picker.hour
            calendar[Calendar.MINUTE] = picker.minute
            calendar[Calendar.SECOND] = 0
            calendar[Calendar.MILLISECOND] = 0
        }
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){

            val name : CharSequence = "qassmprneurReminderChannel"
            val description =  "Channel For Alarm Manager"
            val importance = NotificationManager.IMPORTANCE_HIGH
            val channel = NotificationChannel("qassmpreneur",name,importance)
            channel.description = description
//            val notificationManager = getSystemService(
//                NotificationManager::class.java
//            )
//            notificationManager.createNotificationChannel(channel)
//        }
    }

}