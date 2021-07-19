package com.example.fragmentsyt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.example.fragmentsyt.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var _binding: ActivityMainBinding
    private val binding
        get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        var navigationView = binding.navigationView

        navigationView.setNavigationItemSelectedListener {
            selectDrawerItem(it)
            true
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.fragment_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item?.itemId){
            R.id.firstFragmentItem ->{
                val fragment = FirstImageFragment.newInstance()
                replaceFragment(fragment)
                Log.d("Ana","Second Imag-Maine Act")
                true
            }
            R.id.secondFragmentItem ->{
                val fragment = SecondImageFragment.newInstance()
                replaceFragment(fragment)
                Log.d("Ana","Second Imag-Maine Act")
                true
            }

        else -> super.onOptionsItemSelected(item)
        }
    }

    private fun selectDrawerItem(item: MenuItem){
        var fragment: Fragment? = null
        Log.d("Ana","selectDraweerItembeingCalled")
        val fragmentClass = when(item.itemId){
            R.id.firstFragmentItem -> FirstImageFragment::class.java
            R.id.secondFragmentItem -> SecondImageFragment::class.java
            else-> FirstImageFragment::class.java
        }
        Log.d("Ana","fragmentClass called?\n"+fragmentClass)

        try{
            fragment = fragmentClass.newInstance() as Fragment
            Log.d("Ana", "Inside try"+fragment.toString())
        }catch (e: ClassCastException){
            e.printStackTrace()
            Log.d("Ana", "inside catch")
        }
        replaceFragment(fragment)
        val drawerLayout = binding.drawerLayout
            drawerLayout.closeDrawer(GravityCompat.START)
        Log.d("Ana", "draewr layout"+drawerLayout.toString())
        //closes the drawer
    }

    private fun replaceFragment(fragment: Fragment?){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        if (fragment != null) {
            fragmentTransaction.replace(R.id.fragmentContainerView,fragment)
        }
        fragmentTransaction.commit()
    }
}