package com.example.myapplication.view.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.R
import com.example.myapplication.view.fragment.DashboardFragment

class DashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dashboard_activity)
        loadDashboardFragment()
    }

    private fun loadDashboardFragment()
    {
        var dashboardFragment=DashboardFragment()
        var fragmentTransaction=supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.ll_dashboard_activity,dashboardFragment)
        fragmentTransaction.commit()

    }

}
