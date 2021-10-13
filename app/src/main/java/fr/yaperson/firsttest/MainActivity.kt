package fr.yaperson.firsttest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import fr.yaperson.firsttest.fragments.HomeFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // inject fragment in box (fragment_container)

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, HomeFragment(this))
        transaction.addToBackStack(null)
        transaction.commit()
    }
}