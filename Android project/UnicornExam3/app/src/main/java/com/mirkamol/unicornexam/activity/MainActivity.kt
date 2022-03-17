
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.mirkamol.unicornexam.R
import com.wonmirzo.fragment.CategoryFragment
import com.wonmirzo.fragment.HomeFragment
import com.wonmirzo.fragment.SearchFragment

class MainActivity : AppCompatActivity() {
    private lateinit var bottomNavigationView: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        bottomNavigationView = findViewById(R.id.bottomNavigationView)

        val homeFragment = HomeFragment()
        val categoryFragment = CategoryFragment()
        val chatFragment = ChatFragment()
        val searchFragment = SearchFragment()

        setCurrentFragment(homeFragment)

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.navHome -> setCurrentFragment(homeFragment)
                R.id.navCategory -> setCurrentFragment(categoryFragment)
                R.id.navChat -> setCurrentFragment(chatFragment)
                R.id.navSearch -> setCurrentFragment(searchFragment)
            }
            true
        }
    }

    private fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, fragment)
            commit()
        }
}