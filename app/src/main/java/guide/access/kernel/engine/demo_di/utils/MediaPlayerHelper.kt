package guide.access.kernel.engine.demo_di.utils

import android.content.Context
import android.media.AudioManager
import android.media.MediaPlayer
import dagger.hilt.android.qualifiers.ActivityContext
import guide.access.kernel.engine.demo_di.R
import javax.inject.Inject

class MediaPlayerHelper@Inject constructor(
    @ActivityContext private val context: Context) {
    private var mediaPlayer: MediaPlayer? = null
    private val audioManager =
        context.getSystemService(Context.AUDIO_SERVICE) as AudioManager


    fun initSound() {
        release()
        mediaPlayer = MediaPlayer.create(context, R.raw.cat)?.apply {
            isLooping = true
        }
    }

    fun play() {
        if (mediaPlayer == null) {
            initSound()
        }
        mediaPlayer?.apply {
            if (!isPlaying) start()
        }
    }

    fun pause() {
        mediaPlayer?.apply {
            if (isPlaying) pause()
        }
    }

    fun stop() {
        mediaPlayer?.apply {
            stop()
            release()
        }
        mediaPlayer = null
    }

    fun setVolume(volumePercent: Int) {
        val max = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC)
        val volume = (volumePercent / 100.0 * max).toInt().coerceIn(0, max)
        audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, volume, 0)
    }

    fun release() {
        mediaPlayer?.release()
        mediaPlayer = null
    }
}