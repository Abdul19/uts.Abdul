package com.stmik.utsabdul

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.stmik.utsabdul.Fragment.HomeFragment
import com.stmik.utsabdul.Fragment.ProfileFragment
import com.stmik.utsabdul.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    companion object{
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    val fragmentHome: Fragment = HomeFragment()
    val fragmentProfile: Fragment = ProfileFragment()
    val fm: FragmentManager = supportFragmentManager
    var active: Fragment = fragmentHome

    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var menu: Menu
    private lateinit var menuItem: MenuItem


    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val motorList = listOf<Motor>(
            Motor(
                R.drawable.vixion,
                nameMotor = "Vixion",
                descMotor = "Yamaha V-Ixion adalah merek sepeda motor bertipe sport"
            ),
            Motor(
                R.drawable.aerox,
                nameMotor = "Aerox",
                descMotor = "Aerox Connected digerakkan oleh mesin 155 cc"
            ),
            Motor(
                R.drawable.xsr,
                nameMotor = "XSR",
                descMotor = "Yamaha XSR 155 tersedia dalam pilihan mesin Petrol di Indonesia"
            ),
            Motor(
                R.drawable.nmax,
                nameMotor = "NMAX",
                descMotor = "Pesaing terdekat Yamaha Nmax adalah Freego Connected"
            ),
            Motor(
                R.drawable.mxking,
                nameMotor = "MX KING",
                descMotor = "Yamaha MX King, ini ditenagai dua pilihan mesin Petrol berkapasitas 150 cc"
            ),
            Motor(
                R.drawable.cb200x,
                nameMotor = "CB 200X",
                descMotor = "Honda CB200X menggunakan mesin PGM-Fi 184 cc"
            ),
            Motor(
                R.drawable.cbr250rr,
                nameMotor = "CBR 250R",
                descMotor = "Honda CBR250RR, ini ditenagai dua pilihan mesin Petrol berkapasitas 249.7 cc"
            ),
            Motor(
                R.drawable.r15,
                nameMotor = "R15",
                descMotor = "R15 Connected digerakkan oleh mesin 155.09 cc"
            ),
            Motor(
                R.drawable.supra,
                nameMotor = "SUPRA GTR 150",
                descMotor = "Supra GTR 150 digerakkan oleh mesin 149.16 cc"
            ),
            Motor(
                R.drawable.gb350,
                nameMotor = "GB350",
                descMotor = "menggunakan mesin 1-silinder berkapasitas 349 cc"
            )
        )
        val recyclerView = findViewById<RecyclerView>(R.id.rv_motor)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = MotorAdapter(this, motorList){

            val intent = Intent (this, DetailMotor::class.java)
            intent.putExtra(INTENT_PARCELABLE, it)
            startActivity(intent)

        }

        bottomNavigation()
    }




    private fun bottomNavigation() {
        fm.beginTransaction().add(R.id.container, fragmentHome).show(fragmentHome).commit()
        fm.beginTransaction().add(R.id.container, fragmentProfile).hide(fragmentProfile).commit()

        bottomNavigationView = binding.navView
        menu = bottomNavigationView.menu
        menuItem = menu.getItem(0)
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
        when (item.itemId){
            R.id.navigation_home -> {
                callFragment(0, fragmentHome)
            }
            R.id.navigation_profile -> {
                callFragment(1, fragmentProfile)
            }
        }
            false
        }

    }

    private fun callFragment(index: Int, fragment: Fragment) {
        menuItem = menu.getItem(index)
        menuItem.isChecked = true
        fm.beginTransaction().hide(active).show(fragment).commit()
        active = fragment

    }
}