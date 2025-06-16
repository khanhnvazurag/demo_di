package guide.access.kernel.engine.demo_di.hilt.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import guide.access.kernel.engine.demo_di.databinding.FragmentBBinding
import guide.access.kernel.engine.demo_di.hilt.UserViewModelHiltFragment
import guide.access.kernel.engine.demo_di.utils.MediaPlayerHelper
import javax.inject.Inject

@AndroidEntryPoint
class FragmentD : Fragment() {

    private lateinit var binding: FragmentBBinding
    @Inject lateinit var mediaPlayer: MediaPlayerHelper

    private val viewModel: UserViewModelHiltFragment by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.track("FragmentD")
//        viewModel.loadUser()
        binding.btnStop.setOnClickListener {
            mediaPlayer.stop()
        }
        binding.btnStart.setOnClickListener {
            mediaPlayer.play()
        }
    }

    override fun onPause() {
        super.onPause()
        mediaPlayer.stop()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBBinding.inflate(inflater)
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = FragmentD()
    }
}