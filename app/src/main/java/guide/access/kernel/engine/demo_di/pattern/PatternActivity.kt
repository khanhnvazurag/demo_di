package guide.access.kernel.engine.demo_di.pattern

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import guide.access.kernel.engine.demo_di.R
import guide.access.kernel.engine.demo_di.application.ApplicationDemo
import guide.access.kernel.engine.demo_di.databinding.ActivityPatternBinding
import guide.access.kernel.engine.demo_di.pattern.fragment.FragmentA
import guide.access.kernel.engine.demo_di.pattern.fragment.FragmentB
import guide.access.kernel.engine.demo_di.utils.MediaPlayerHelper

class PatternActivity : AppCompatActivity() {

    private lateinit var viewModel: UserViewModel
    private lateinit var binding: ActivityPatternBinding

    private var changeFragment = true

    //activity scope manager
    val mediaPlayerHelper: MediaPlayerHelper by lazy {
        MediaPlayerHelper(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityPatternBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViewModel()

        binding.btnNextFragment.setOnClickListener {
            changeFragment = !changeFragment
            if (changeFragment) {
                addFragmentA()
            } else {
                addFragmentB()
            }
        }
    }

    private fun initViewModel() {
        val container = (application as ApplicationDemo).container
        val factory = container.provideUserViewModelFactory()
        viewModel = ViewModelProvider(this, factory)[UserViewModel::class.java]
        viewModel.loadUser()

        viewModel.user.observe(this) { user ->
            binding.txtContent.text = "$user"
        }
    }

    private fun addFragmentA() {
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment, FragmentA.newInstance())
            .commit()
    }

    private fun addFragmentB() {
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment, FragmentB.newInstance())
            .commit()
    }
}