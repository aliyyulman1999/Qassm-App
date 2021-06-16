package org.d3if4070.qassmapp.fragment

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.getSystemService
import kotlinx.android.synthetic.main.fragment_alarm.*
import org.d3if4070.qassmapp.MyBroadcastReceiver
import org.d3if4070.qassmapp.R


class AlarmFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_alarm, container, false)

//        button.setOnClickListener {
//            var sec = editText.text.toString().toInt()
//            var i = Intent(applicationContext, MyBroadcastReceiver::class.java)
//            var pi = PendingIntent.getBroadcast(applicationContext,111,0)
//            var am : AlarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
//            am.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+ (sec*1000),pi)
//            Toast.makeText(applicationContext,"Alarm is set for $sec Seconds",Toast.LENGTH_LONG).show()
//        }
    }

}