package com.example.fragmentsyt

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.fragmentsyt.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(), ViewPager.OnPageChangeListener {
    //we add a onPageChangeListener to change the highlighted
    //parts of the bottomnavdrawer bcs
    //its like changing the above fragment but not the buttons

    private lateinit var _binding: ActivityMainBinding

    private lateinit var mToolbar : Toolbar
    private lateinit var mDrawerLayout : DrawerLayout
    private lateinit var mDrawerToggle: ActionBarDrawerToggle
    private lateinit var mViewPager: ViewPager
    private lateinit var mBottomNavigationView: BottomNavigationView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        val view = _binding.root
        setContentView(view)

        mToolbar = _binding.toolbar
        mDrawerLayout = _binding.drawerLayout
        mDrawerToggle = ActionBarDrawerToggle(this, mDrawerLayout,mToolbar,R.string.drawer_open,R.string.drawer_close)
        mViewPager = _binding.viewPager
        mBottomNavigationView = _binding.bottomNavigationView
        setSupportActionBar(mToolbar)

        val navigationView = _binding.navigationView

        mBottomNavigationView.setOnItemSelectedListener {
            selectDrawerItem(it)
        }

        navigationView.setNavigationItemSelectedListener {
            selectDrawerItem(it)
            true
        }
        mDrawerLayout.addDrawerListener(mDrawerToggle)
        //viewpager
        var pagerAdapter = ImageFragmentPageAdapter(supportFragmentManager)
        mViewPager.adapter = pagerAdapter
        mViewPager.addOnPageChangeListener(this)
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


    private fun selectDrawerItem(item: MenuItem): Boolean{//we are going to divert viewPager implementation throught the drawerlayout
        when(item.itemId){
            R.id.firstFragmentItem-> mViewPager.currentItem = 0
            R.id.secondFragmentItem-> mViewPager.currentItem = 1
            R.id.thirdFagmentItem-> mViewPager.currentItem = 2
            else-> mViewPager.currentItem = 0
        }

        if(mDrawerLayout.isDrawerOpen(GravityCompat.START))
            mDrawerLayout.closeDrawer(GravityCompat.START)
        return true
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

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
    }

    override fun onPageSelected(position: Int) {
        //get current menuitem id
        val currentMenuItem = mBottomNavigationView.menu.getItem(position).itemId
        if(currentMenuItem != mBottomNavigationView.selectedItemId)
        {
                //if we changed fragments
                //pass that item to menu of bottom nav view which needs to be checked
                // and make the selected item after finding it false checked...this will overall change the highlights
            mBottomNavigationView.menu.getItem(position).isChecked = true
            mBottomNavigationView.menu.findItem(mBottomNavigationView.selectedItemId).isChecked = false
        }

    }//highlight of bottom nav graph is changed here

    override fun onPageScrollStateChanged(state: Int) {
    }
}