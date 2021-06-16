package org.d3if4070.qassmapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.d3if4070.qassmapp.fragment.AlarmFragment
import org.d3if4070.qassmapp.fragment.HomeFragment
import org.d3if4070.qassmapp.fragment.NoteFragment
import org.d3if4070.qassmapp.fragment.ProfilFragment

class MainActivity : AppCompatActivity() {
    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when(item.itemId){
            R.id.homeFragment -> {
                moveToFragment(HomeFragment())
                return@OnNavigationItemSelectedListener  true
            }

            R.id.noteFragment -> {
                moveToFragment(NoteFragment())
                return@OnNavigationItemSelectedListener  true
            }

            R.id.alarmFragment -> {
                moveToFragment(AlarmFragment())
                return@OnNavigationItemSelectedListener  true
            }

            R.id.profilFragment -> {
                moveToFragment(ProfilFragment())
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //mengaktifkan button navigasi
        val navView : BottomNavigationView = findViewById(R.id.nav_view)
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        moveToFragment(HomeFragment())
        //replaceFragment(NoteFragment.newInstance(),false)

    }

    //function fragment
    private fun moveToFragment(fragment: Fragment){
        val fragmentTrans = supportFragmentManager.beginTransaction()
        fragmentTrans.replace(R.id.fragment_container, fragment)
        fragmentTrans.commit()
    }

    fun replaceFragment(fragment:Fragment, istransition:Boolean){
        val fragmentTransition = supportFragmentManager.beginTransaction()

        if (istransition){
            fragmentTransition.setCustomAnimations(android.R.anim.slide_out_right,android.R.anim.slide_in_left)
        }
        fragmentTransition.add(R.id.fragment_container,fragment).addToBackStack(fragment.javaClass.simpleName).commit()
    }
    override fun onBackPressed() {
        super.onBackPressed()
        val fragments = supportFragmentManager.fragments
        if (fragments.size == 0){
            finish()
        }
    }
}