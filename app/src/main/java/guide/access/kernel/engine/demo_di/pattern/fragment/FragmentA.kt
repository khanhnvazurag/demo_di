package guide.access.kernel.engine.demo_di.pattern.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import guide.access.kernel.engine.demo_di.databinding.FragmentABinding
import guide.access.kernel.engine.demo_di.pattern.PatternActivity
import guide.access.kernel.engine.demo_di.utils.MediaPlayerHelper


class FragmentA : Fragment() {

    private lateinit var binding: FragmentABinding
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
            FragmentA()
    }
}