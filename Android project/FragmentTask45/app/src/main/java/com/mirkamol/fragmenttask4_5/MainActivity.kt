import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.fragmenttask5.R
import com.example.fragmenttask5.adapter.ViewPagerAdapter
import com.example.fragmenttask5.fragment.FragmentPost
import com.example.fragmenttask5.fragment.FragmentUser
import com.google.android.material.tabs.TabLayout
import com.mirkamol.fragmenttask4_5.fragment.FragmentContact

class MainActivity : AppCompatActivity() {

    private lateinit var viewPagerAdapter: ViewPagerAdapter
    private lateinit var viewPager: ViewPager
    private lateinit var tabLayout: TabLayout
    private val titleList = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager = findViewById(R.id.viewpager)
        tabLayout = findViewById(R.id.tab_layout)
        viewPagerAdapter = ViewPagerAdapter(fragmentsList(),supportFragmentManager,titleList())
        viewPager.adapter = viewPagerAdapter

        tabLayout.setupWithViewPager(viewPager)

    }
    private fun fragmentsList(): ArrayList<Fragment>{
        return arrayListOf(
            FragmentContact(),
            FragmentUser(),
            FragmentPost()
        )
    }
    private fun titleList(): ArrayList<String> {
        titleList.add("Contact")
        titleList.add("User")
        titleList.add("Post")
        return titleList
    }
}