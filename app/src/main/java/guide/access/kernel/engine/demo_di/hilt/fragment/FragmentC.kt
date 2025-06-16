package guide.access.kernel.engine.demo_di.hilt.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import guide.access.kernel.engine.demo_di.databinding.FragmentABinding
import guide.access.kernel.engine.demo_di.hilt.Logger
import guide.access.kernel.engine.demo_di.utils.MediaPlayerHelper
import javax.annotation.Nullable
import javax.inject.Inject

@AndroidEntryPoint
class FragmentC : Fragment() {

    @Inject
    lateinit var mediaPlayer: MediaPlayerHelper

    private lateinit var binding: FragmentABinding

    private var logger: Logger? = null

    @Inject
    fun initLogger(@Nullable logger: Logger?) {
        this.logger = logger
    }

    fun track(event: String) {
        logger?.log(event)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        track("FragmentC")
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
        binding = FragmentABinding.inflate(inflater)
        // Inflate the layout for this fragment
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            FragmentC()
    }
}