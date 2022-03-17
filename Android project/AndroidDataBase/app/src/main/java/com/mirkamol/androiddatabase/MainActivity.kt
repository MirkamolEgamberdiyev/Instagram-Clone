import com.mirkamol.androiddatabase.R

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.mirkamol.androiddatabase.manager.RealmManager
import com.mirkamol.androiddatabase.model.Post
import io.realm.Realm

class MainActivity : AppCompatActivity() {
    lateinit var tv_size:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        initViews()
        
    }

    private fun initViews() {
         tv_size = findViewById<TextView>(R.id.tv_size)

        realmDatabase()
    }

    fun realmDatabase(){
        var post = Post(1, "PDP")
        
        RealmManager.instance!!.savePost(post)
        var posts = RealmManager.instance!!.loadPosts()
        tv_size.text = "Realm DB size is" + posts.size.toString()

    }
}