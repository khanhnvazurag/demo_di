package guide.access.kernel.engine.demo_di.pattern.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import guide.access.kernel.engine.demo_di.UserRepository
import guide.access.kernel.engine.demo_di.databinding.FragmentBBinding
import guide.access.kernel.engine.demo_di.hilt.Logger
import guide.access.kernel.engine.demo_di.pattern.PatternActivity
import guide.access.kernel.engine.demo_di.utils.MediaPlayerHelper
import javax.annotation.Nullable
import javax.inject.Inject


class FragmentB : Fragment() {

    private lateinit var binding: FragmentBBinding
    private var mediaPlayer: MediaPlayerHelper? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mediaPlayer = (activity as PatternActivity).mediaPlayerHelper

        binding.btnStop.setOnClickListener {
            mediaPlayer?.stop()
        }
        binding.btnStart.setOnClickListener {
            mediaPlayer?.play()
        }
    }
    override fun onPause() {
        super.onPause()
        mediaPlayer?.stop()
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
        fun newInstance() = FragmentB()
    }
}