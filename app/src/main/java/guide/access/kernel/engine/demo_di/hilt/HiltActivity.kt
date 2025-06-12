package guide.access.kernel.engine.demo_di.hilt

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import guide.access.kernel.engine.demo_di.R
import guide.access.kernel.engine.demo_di.databinding.ActivityHiltBinding
import guide.access.kernel.engine.demo_di.hilt.fragment.FragmentC
import guide.access.kernel.engine.demo_di.hilt.fragment.FragmentD

@AndroidEntryPoint
class HiltActivity : AppCompatActivity() {

    private val viewModel: UserViewModelHilt by viewModels()
    private lateinit var binding: ActivityHiltBinding
    private var changeFragment = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityHiltBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViewModel()

        binding.btnNextFragment.setOnClickListener {
            changeFragment = !changeFragment
            if (changeFragment) {
                addFragmentC()
            } else {
                addFragmentD()
            }
        }
    }

    private fun initViewModel() {
        viewModel.loadUser()
        viewModel.user.observe(this) { user ->
            binding.txtContent.text = "$user"
        }

    }

    private fun addFragmentC() {
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment, FragmentC.newInstance())
            .commit()
    }

    private fun addFragmentD() {
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment, FragmentD.newInstance())
            .commit()
    }
}