package com.example.fragmentsyt

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.fragmentsyt.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var _binding: ActivityMainBinding

    private lateinit var mToolbar : Toolbar
    private lateinit var mDrawerLayout : DrawerLayout
    private lateinit var mDrawerToggle: ActionBarDrawerToggle
    private lateinit var mViewPager: ViewPager



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        val view = _binding.root
        setContentView(view)

        mToolbar = _binding.toolbar
        mDrawerLayout = _binding.drawerLayout
        mDrawerToggle = ActionBarDrawerToggle(this, mDrawerLayout,mToolbar,R.string.drawer_open,R.string.drawer_close)
        mViewPager = _binding.viewPager
        setSupportActionBar(mToolbar)

        val navigationView = _binding.navigationView

        navigationView.setNavigationItemSelectedListener {
            selectDrawerItem(it)
            true
        }
        mDrawerLayout.addDrawerListener(mDrawerToggle)
        //viewpager
        var pagerAdapter = ImageFragmentPageAdapter(supportFragmentManager)
        mViewPager.adapter = pagerAdapter
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        mDrawerToggle.syncState()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        mDrawerToggle.onConfigurationChanged(newConfig)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.fragment_menu,menu)
        return true
    }


    private fun selectDrawerItem(item: MenuItem){//we are going to divert viewPager implementation throught the drawerlayout
        when(item.itemId){
            R.id.firstFragmentItem-> mViewPager.currentItem = 0
            R.id.secondFragmentItem-> mViewPager.currentItem = 1
            else-> mViewPager.currentItem = 0
        }

        mDrawerLayout.closeDrawer(GravityCompat.START)
        Log.d("Ana", "draewr layout")
        //closes the drawer
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (mDrawerToggle.onOptionsItemSelected(item)) true else super.onOptionsItemSelected(item)
    }

    private fun replaceFragment(fragment: Fragment?){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        if (fragment != null) {
            fragmentTransaction.replace(R.id.fragmentContainerView,fragment)
            Log.d("AnaF","replaceFragment")
        }
        fragmentTransaction.commit()
    }
}