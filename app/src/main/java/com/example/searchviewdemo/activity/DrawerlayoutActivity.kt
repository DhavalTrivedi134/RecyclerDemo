package com.example.searchviewdemo.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.searchviewdemo.fragment.PeopleFragment
import com.example.searchviewdemo.fragment.SettingsFragment
import com.example.searchviewdemo.fragment.HomeFragment
import com.example.searchviewdemo.R
import com.google.android.material.navigation.NavigationView

class DrawerlayoutActivity : AppCompatActivity() {
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
    private lateinit var navigationView: NavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drawerlayout)

        drawerLayout = findViewById(R.id.drawerLayout)
        navigationView = findViewById(R.id.navigation_View)
        val mfragmentmanagar = supportFragmentManager
        val fragment1 = HomeFragment()
        val mfragmenttransaction = mfragmentmanagar.beginTransaction()
        mfragmenttransaction.addToBackStack(null)
        mfragmenttransaction.replace(R.id.framelayout,fragment1,"HomeFragment").commit()

        actionBarDrawerToggle = ActionBarDrawerToggle(this,drawerLayout,0,0)
        drawerLayout.addDrawerListener(actionBarDrawerToggle)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        actionBarDrawerToggle.syncState()

        navigationView.setNavigationItemSelectedListener { menuitem ->

            menuitem.isCheckable = true
            when(menuitem.itemId){
                R.id.home -> {
                    //Toast.makeText(this, "You selected home", Toast.LENGTH_SHORT).show()
                    val mfragmentmanagar = supportFragmentManager
                    val fragment1 = HomeFragment()
                    val mfragmenttransaction = mfragmentmanagar.beginTransaction()
                    //mfragmenttransaction.setCustomAnimations(R.anim.enter_from_right,R.anim.exit_to_right,R.anim.enter_from_right,R.anim.exit_to_right)
                    mfragmenttransaction.addToBackStack(null)
                    mfragmenttransaction.replace(R.id.framelayout,fragment1,"HomeFragment").commit()
                    drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }

                R.id.people ->{

                    //Toast.makeText(this,"You selected people",Toast.LENGTH_SHORT).show()
                    val mfragmentmanagar = supportFragmentManager
                    val fragment2 = PeopleFragment()
                    val mfragmenttransaction = mfragmentmanagar.beginTransaction()
                    mfragmenttransaction.addToBackStack(null)
                    mfragmenttransaction.replace(R.id.framelayout,fragment2,"PeopleFragment").commit()
                    drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }

                R.id.settings -> {
                    //Toast.makeText(this,"You selected Settings",Toast.LENGTH_SHORT).show()
                    val mfragmentmanagar = supportFragmentManager
                    val fragment3 = SettingsFragment()
                    val mfragmenttransaction = mfragmentmanagar.beginTransaction()
                    mfragmenttransaction.addToBackStack(null)
                    mfragmenttransaction.replace(R.id.framelayout,fragment3,"SettingsFragment").commit()
                    drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }

                else ->{
                    false
                }
            }

        }


    }

    override fun onSupportNavigateUp(): Boolean {
        drawerLayout.openDrawer(navigationView)
        return super.onSupportNavigateUp()
    }

/*    override fun onBackPressed() {
        if (this.drawerLayout.isDrawerOpen(GravityCompat.START)){
            this.drawerLayout.closeDrawer(GravityCompat.START)
        }
        else{
            onBackPressed()
        }
        super.onBackPressed()
    }*/

}