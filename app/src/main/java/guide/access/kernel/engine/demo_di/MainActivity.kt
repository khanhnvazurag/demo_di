package guide.access.kernel.engine.demo_di

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import guide.access.kernel.engine.demo_di.databinding.ActivityMainBinding
import guide.access.kernel.engine.demo_di.hilt.HiltActivity
import guide.access.kernel.engine.demo_di.pattern.PatternActivity

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnHilt.setOnClickListener {
            startActivity(Intent(this, HiltActivity::class.java))
        }

        binding.btnFactory.setOnClickListener {
            startActivity(Intent(this, PatternActivity::class.java))
        }
    }
}