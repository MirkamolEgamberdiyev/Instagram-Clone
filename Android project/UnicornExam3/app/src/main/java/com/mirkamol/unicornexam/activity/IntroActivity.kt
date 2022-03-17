
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.viewpager2.widget.ViewPager2
import com.mirkamol.unicornexam.R
import com.wonmirzo.adapter.IntroPageAdapter
import com.wonmirzo.listener.OnBottomPageListener
import com.wonmirzo.model.IntroItem

class IntroActivity : AppCompatActivity() {
    private lateinit var viewPager: ViewPager2
    private lateinit var tvSkip: TextView
    private lateinit var tvNext: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)
        initViews()

        if (PrefsManager(this).isSaved) {
            Intent(this, MainActivity::class.java).also {
                startActivity(it)
            }
        }
    }

    private fun initViews() {
        viewPager = findViewById(R.id.viewPager)
        tvSkip = findViewById(R.id.tvSkip)
        tvNext = findViewById(R.id.tvNext)

        refreshAdapter(getAllItems())
    }

    private fun refreshAdapter(items: ArrayList<IntroItem>) {
        val adapter = IntroPageAdapter(this, items, object : OnBottomPageListener {
            override fun onBottomReached(position: Int) {
                tvSkip.visibility = View.GONE

                tvNext.setOnClickListener {
                    PrefsManager(this@IntroActivity).isSaved = true
                    Intent(this@IntroActivity, MainActivity::class.java).also {
                        startActivity(it)
                    }
                }
            }
        })
        viewPager.adapter = adapter
    }

    private fun openHomePage() {
        Intent(this, MainActivity::class.java).also {
            startActivity(it)
        }
    }

    private fun getAllItems(): ArrayList<IntroItem> {
        val items = ArrayList<IntroItem>()

        items.add(
            IntroItem(
                R.drawable.ic_like,
                "Saved Listings",
                "Save your favorite listings to come back to them later."
            )
        )
        items.add(
            IntroItem(
                R.drawable.ic_instagram,
                "Add New Listings",
                "Add new listings directly from the app, including photo gallery and filters."
            )
        )
        items.add(
            IntroItem(
                R.drawable.ic_chat,
                "Chat",
                "Communicate with your customers and vendors in real-time."
            )
        )
        items.add(
            IntroItem(
                R.drawable.ic_notification,
                "Get Notified",
                "Stay on top of your game8 with real-time push notifications."
            )
        )

        return items

    }
}