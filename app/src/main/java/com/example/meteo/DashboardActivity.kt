package com.example.meteo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class DashboardActivity : AppCompatActivity() {

    private val homeFragment = HomeFragment()
    private val forecastFragment = ForecastFragment()
    private val notificationsFragment = NotificationsFragment()
    private val settingsFragment = SettingsFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val bottomNavigation: BottomNavigationView = findViewById(R.id.bottom_navigation)

        // Load the default fragment
        loadFragment(homeFragment)

        bottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_home -> {
                    loadFragment(homeFragment)
                    true
                }
                R.id.navigation_forecast -> {
                    loadFragment(forecastFragment)
                    true
                }
                R.id.navigation_alerts -> {
                    loadFragment(notificationsFragment)
                    true
                }
                R.id.navigation_settings -> {
                    loadFragment(settingsFragment)
                    true
                }
                else -> false
            }
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, fragment)
            commit()
        }
    }
}
